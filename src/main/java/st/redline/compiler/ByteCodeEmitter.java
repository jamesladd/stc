/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.objectweb.asm.*;
import st.redline.classloader.Source;

import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;

import static st.redline.compiler.EmitterNode.SYNTHETIC_BLOCK_CREATE;
import static st.redline.compiler.EmitterNode.SYNTHETIC_REFERENCE;
import static st.redline.compiler.EmitterNode.SYNTHETIC_TEMPORARY;
import static st.redline.compiler.SmalltalkParser.*;
import static st.redline.compiler.Trace.trace;

class ByteCodeEmitter implements Emitter, Opcodes {

    private static Log LOG = LogFactory.getLog(ByteCodeEmitter.class);
    private static final String[] SIGNATURES = {
            "(Ljava/lang/String;)Lst/redline/kernel/PrimObject;",
            "(Lst/redline/kernel/PrimObject;Ljava/lang/String;)Lst/redline/kernel/PrimObject;",
            "(Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Ljava/lang/String;)Lst/redline/kernel/PrimObject;",
            "(Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Ljava/lang/String;)Lst/redline/kernel/PrimObject;",
            "(Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Ljava/lang/String;)Lst/redline/kernel/PrimObject;",
            "(Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Ljava/lang/String;)Lst/redline/kernel/PrimObject;"
    };
    private static final int BYTECODE_VERSION;
    static {
        int compareTo18 = new BigDecimal(System.getProperty("java.specification.version")).compareTo(new BigDecimal("1.8"));
        if (compareTo18 >= 0) {
            BYTECODE_VERSION = V1_8;
        } else {
            throw new RuntimeException("Java 1.8 or above required.");
        }
    }
    private final String SEND_MESSAGES_SIG = "(Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimContext;)Lst/redline/kernel/PrimObject;";

    private final ClassWriter cw;
    private MethodVisitor mv;
    private byte[] classBytes;
    private Source source;
    private boolean sendToSuper = false;

    ByteCodeEmitter() {
        cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
    }

    protected boolean isTraceEnabled(Log log) {
        return log.isTraceEnabled();
    }

    @Override
    public byte[] generatedBytes() {
        return classBytes;
    }

    @Override
    public void openClass(Source source) {
        this.source = source;
        if (isTraceEnabled(LOG))
            LOG.trace(source.fullClassName());
        cw.visit(BYTECODE_VERSION, ACC_PUBLIC + ACC_SUPER, source.fullClassName(), null, superclassName(), new String[] {"st/redline/classloader/Script"});
        cw.visitSource(source.className() + source.fileExtension(), null);
        // Add support for the Lambda's we typically create to support blocks.
        cw.visitInnerClass("java/lang/invoke/MethodHandles$Lookup", "java/lang/invoke/MethodHandles", "Lookup", ACC_PUBLIC + ACC_FINAL + ACC_STATIC);

        makeJavaClassInitializer();
        makePublicSendMessagesMethod();
        openPrivateSendMessagesMethod();
    }

    private void makePublicSendMessagesMethod() {
        // This method takes the public call to sendMessage with arg of Smalltalk instance
        // and calls the private sendMessages instance with instances of PrimObject and PrimContext
        // - Smalltalk instance is put into the context.
        mv = cw.visitMethod(ACC_PUBLIC, "sendMessages", "(Lst/redline/Smalltalk;)Lst/redline/kernel/PrimObject;", null, null);
        mv.visitVarInsn(ALOAD, 0);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitTypeInsn(CHECKCAST, "st/redline/kernel/PrimObject");
        mv.visitTypeInsn(NEW, "st/redline/kernel/PrimContext");
        mv.visitInsn(DUP);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKESPECIAL, "st/redline/kernel/PrimContext", "<init>", "(Lst/redline/Smalltalk;)V", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, source.fullClassName(), "sendMessages", SEND_MESSAGES_SIG, false);
        mv.visitInsn(ARETURN);
        mv.visitMaxs(5, 2);
        mv.visitEnd();
    }

    private void openPrivateSendMessagesMethod() {
        if (isTraceEnabled(LOG))
            LOG.trace("");
        mv = cw.visitMethod(ACC_PUBLIC, "sendMessages", SEND_MESSAGES_SIG, null, null);
        mv.visitCode();

        // Add value to top of stack - see emit(Message)
        mv.visitVarInsn(ALOAD, 1);
    }

    private String superclassName() {
        return "java/lang/Object";
    }

    private void makeJavaClassInitializer() {
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();

        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(1, l0);

        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, superclassName(), "<init>", "()V", false);

        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    @Override
    public void closeClass(boolean returnRequired) {
        if (isTraceEnabled(LOG))
            LOG.trace(source.fullClassName());
        closePrivateSendMessagesMethod(returnRequired);

        MethodVisitor mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC + ACC_SYNTHETIC, "block0", "(Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimContext;)Lst/redline/kernel/PrimObject;", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 1);
        mv.visitInsn(ARETURN);
        mv.visitMaxs(1, 3);
        mv.visitEnd();

        cw.visitEnd();
        classBytes = cw.toByteArray();
    }

    @Override
    public void emit(Statement statement) {
        if (isTraceEnabled(LOG))
            LOG.trace(statement);
        if (statement.isBlock())
            emitBlock(statement);
        else
            emitNonBlock(statement);
    }

    private void emitBlock(Statement statement) {
        if (isTraceEnabled(LOG))
            LOG.trace(statement);
//        emit(statement.messages());
//        if (statement.containsAnswer())
//            mv.visitInsn(ARETURN);
    }

    private void emitNonBlock(Statement statement) {
        if (isTraceEnabled(LOG))
            LOG.trace(statement);
        emit(statement.messages());
        if (statement.containsAnswer())
            mv.visitInsn(ARETURN);
    }

    public void emitInitTemporaries(int index) {
        pushContext();
        pushIntConst(index);
        mv.visitMethodInsn(INVOKEVIRTUAL, "st/redline/kernel/PrimContext", "initTemporaries", "(I)V", false);
    }

    private void emit(Vector<Message> messages) {
        int index = 0;
        int size = messages.size();
        while (index < size)
            if (messages.get(index).isAssignment())
                index = emitAssignment(index, messages);
            else
                emit(messages.get(index++));
    }

    private int emitAssignment(int index, Vector<Message> messages) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(messages.get(index).receiver()));
        EmitterNode receiver = messages.get(index).receiver();
        if (receiver.type() != SYNTHETIC_TEMPORARY)
            throw new RuntimeException("Attempt to assign to non-temporary.");
        if ((messages.size() - index) < 2)
            throw new RuntimeException("Missing assignment expression to temporary.");
        TerminalNode node = receiver.value();
        visitLine(mv, node.getSymbol().getLine());
        pushContext();
        pushIntConst(receiver.index());
        pushIntConst(receiver.index());
        index++;
        // Emit first part of right hand side of assignment.
        emit(messages.get(index));
        index++;
        // Emit rest of the right hand side of assignment.
        while (messages.get(index).isTail())
            emit(messages.get(index++));
        // Do assignment here.
        mv.visitMethodInsn(INVOKEVIRTUAL, "st/redline/kernel/PrimContext", "temporaryAtPut", "(ILst/redline/kernel/PrimObject;)Lst/redline/kernel/PrimObject;", false);
        return index;
    }

    private void emit(Message message) {
        // Before each Message we pop the top value off the stack, as it may
        // be the value left from a previous message send.
        // UNLESS the message is a messageTail in which case we leave it.
        if (!message.isTail()) {
            emitPop();
            emitReceiver(message.receiver());
        } else if (message.isCascade())
            emitDup();

        emitArguments(message.arguments());
        emitSelector(message.selectors());
        if (message.selectors().size() != 0)
            emitPerform(message.arguments().size());

        if (message.isTail() && message.isCascade())
            emitPop();
    }

    private void emitReceiver(EmitterNode receiver) {
        if (!receiver.isList())
            emitObject(receiver, receiver.value());
        else
            emitObject(receiver, receiver.values());
    }

    private void emitObject(EmitterNode emitterNode, TerminalNode node) {
        visitLine(mv, node.getSymbol().getLine());
        switch (emitterNode.type()) {
            case STRING:
                emitCreateString(removeSingleQuotes(node.getText()));
                break;
            case HASH:
                emitCreateSymbol(node.getText());
                break;
            case CHARACTER_CONSTANT:
                emitCreateCharacter(removeLeadingChar(node.getText()));
                break;
            case RESERVED_WORD:
                emitPseudoVariable(node.getText());
                break;
            case SYNTHETIC_TEMPORARY:
                emitTemporaryGet(node, emitterNode.index());
                break;
            case SYNTHETIC_REFERENCE:
                emitResolveReference(node.getText());
                break;
            case SYNTHETIC_BLOCK_CREATE:
                emitResolveBlock(node, emitterNode);
                break;
            default:
                throw new RuntimeException("Unknown Emitter Type: " + emitterNode.type());
        }
    }

    private void emitObject(EmitterNode emitterNode, List<TerminalNode> nodes) {
        visitLine(mv, nodes.get(0).getSymbol().getLine());
        switch (emitterNode.type()) {
            case HASH:
                emitCreateSymbol(concatText(nodes));
                break;
            case DIGIT:
                emitCreateInteger(concatText(nodes));
                break;
            default:
                throw new RuntimeException("Unknown Emitter Type: " + emitterNode.type());
        }
    }

    private void emitResolveBlock(TerminalNode node, EmitterNode emitterNode) {
        if (isTraceEnabled(LOG))
            LOG.trace("resolveBlock: " + emitterNode.index());
        String blockName = makeBlockName(emitterNode.index());
        visitLine(mv, node.getSymbol().getLine());
        mv.visitTypeInsn(NEW, "st/redline/kernel/PrimMethod");
        mv.visitInsn(DUP);
        mv.visitMethodInsn(INVOKESPECIAL, "st/redline/kernel/PrimMethod", "<init>", "()V", false);
        mv.visitInvokeDynamicInsn("apply", "()Lst/redline/kernel/TriFunction;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;"), new Object[]{Type.getType("(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"), new Handle(Opcodes.H_INVOKESTATIC, source.fullClassName(), blockName, "(Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimContext;)Lst/redline/kernel/PrimObject;"), Type.getType("(Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimObject;Lst/redline/kernel/PrimContext;)Lst/redline/kernel/PrimObject;")});
        mv.visitMethodInsn(INVOKEVIRTUAL, "st/redline/kernel/PrimMethod", "function", "(Lst/redline/kernel/TriFunction;)Lst/redline/kernel/PrimObject;", false);
    }

    private String makeBlockName(int index) {
        return "block" + index;
    }

    private void emitResolveReference(String value) {
        if (isTraceEnabled(LOG))
            LOG.trace("resolve: " + value + " for: " + source.className() + " in: " + source.packageName());
        emitSmalltalkCall("resolve", value, source.className(), source.packageName());
    }

    private void emitSelector(List<EmitterNode> selectors) {
        if (selectors.isEmpty())
            return;
        TerminalNode firstSelector = selectors.get(0).value();
        visitLine(mv, firstSelector.getSymbol().getLine());
        String selector = "";
        for (EmitterNode node : selectors)
            selector = selector + node.text();
        mv.visitLdcInsn(selector);
    }

    private void emitPerform(int argumentCount) {
        String method = sendToSuper ? "superPerform" : "perform";
        sendToSuper = false;
        mv.visitMethodInsn(INVOKEVIRTUAL, "st/redline/kernel/PrimObject", method, SIGNATURES[argumentCount], false);
    }

    private void emitArguments(List<EmitterNode> arguments) {
        if (arguments.isEmpty())
            return;
        for (EmitterNode node : arguments)
            if (node.value() != null)
                emitObject(node, node.value());
            else
                emitObject(node, node.values());
    }

    private String concatText(List<TerminalNode> nodes) {
        String text = "";
        for (TerminalNode node : nodes)
            text = text + node.getText();
        return text;
    }

    private void emitPseudoVariable(String value) {
        switch (value) {
            case "self":
                emitPushReceiver();
                break;
            case "true":
            case "false":
                emitSmalltalkCall("booleanSingleton", value);
                break;
            case "nil":
                emitSmalltalkCall("nilSingleton", value);
                break;
            case "super":
                sendToSuper = true;
                break;
            default:
                throw new RuntimeException("Unhandled Pseudo Variable: " + value);
        }
    }

    private void emitTemporaryGet(TerminalNode node, int index) {
        visitLine(mv, node.getSymbol().getLine());
        pushContext();
        pushIntConst(index);
        mv.visitMethodInsn(INVOKEVIRTUAL, "st/redline/kernel/PrimContext", "temporaryAt", "(I)Lst/redline/kernel/PrimObject;", false);
    }

    private void emitDup() {
        mv.visitInsn(DUP);
    }

    private void emitPop() {
        mv.visitInsn(POP);
    }

    private void emitPushReceiver() {
        mv.visitVarInsn(ALOAD, 1);
    }

    private void pushContext() {
        mv.visitVarInsn(ALOAD, 2);
    }

    private void emitCreateCharacter(String value) {
        emitSmalltalkCall("createCharacter", value);
    }

    private void emitCreateInteger(String value) {
        emitSmalltalkCall("createInteger", value);
    }

    private void emitCreateSymbol(String value) {
        emitSmalltalkCall("createSymbol", value);
    }

    private void emitCreateString(String value) {
        emitSmalltalkCall("createString", value);
    }

    private void emitSmalltalkCall(String method, String value) {
        pushSmalltalk();
        mv.visitLdcInsn(value);
        mv.visitMethodInsn(INVOKEINTERFACE, "st/redline/Smalltalk", method, "(Ljava/lang/String;)Lst/redline/kernel/PrimObject;", true);
    }

    private void emitSmalltalkCall(String method, String value1, String value2, String value3) {
        pushSmalltalk();
        mv.visitLdcInsn(value1);
        mv.visitLdcInsn(value2);
        mv.visitLdcInsn(value3);
        mv.visitMethodInsn(INVOKEINTERFACE, "st/redline/Smalltalk", method, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lst/redline/kernel/PrimObject;", true);
    }

    private String removeLeadingChar(String text) {
        return text.substring(1, text.length());
    }

    private String removeSingleQuotes(String text) {
        return text.substring(1, text.length() - 1);
    }

    private void pushSmalltalk() {
        pushContext();
        mv.visitMethodInsn(INVOKEVIRTUAL, "st/redline/kernel/PrimContext", "smalltalk", "()Lst/redline/Smalltalk;", false);
    }

    private void closePrivateSendMessagesMethod(boolean returnRequired) {
        if (isTraceEnabled(LOG))
            LOG.trace("");
        if (returnRequired)
            mv.visitInsn(ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    private void visitLine(MethodVisitor mv, int line) {
        // We adjust the line number as the pre-processor may have prepended source lines.
        int adjustedSourceLine = line - source.countOfLinesAddedByPreprocessor();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(adjustedSourceLine, l0);
    }

    private void pushIntConst(int value) {
        switch (value) {
            case 0: mv.visitInsn(ICONST_0); break;
            case 1: mv.visitInsn(ICONST_1); break;
            case 2: mv.visitInsn(ICONST_2); break;
            case 3: mv.visitInsn(ICONST_3); break;
            case 4: mv.visitInsn(ICONST_4); break;
            case 5: mv.visitInsn(ICONST_5); break;
            default:
                if (value > 5 && value < 128)
                    mv.visitIntInsn(BIPUSH, value);
                else // SIPUSH not supported yet.
                    throw new IllegalStateException("Push of integer value " + value + " not yet supported.");
        }
    }
}
