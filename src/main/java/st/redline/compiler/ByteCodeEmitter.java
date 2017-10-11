/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import st.redline.classloader.Source;

import java.math.BigDecimal;
import java.util.List;

import static st.redline.compiler.SmalltalkParser.*;

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
    private final String SEND_MESSAGES_SIG = "(Lst/redline/Smalltalk;)Lst/redline/kernel/PrimObject;";

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
        makeJavaClassInitializer();
        openSendMessagesMethod();
    }

    private void openSendMessagesMethod() {
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
        closeSendMessagesMethod(returnRequired);
        cw.visitEnd();
        classBytes = cw.toByteArray();
    }

    @Override
    public void emit(Statement statement) {
        if (isTraceEnabled(LOG))
            LOG.trace(statement);
        emit(statement.message());
        if (statement.containsAnswer())
            mv.visitInsn(ARETURN);
    }

    private void emit(Message message) {
        // Before each Message we pop the top value off the stack, as it may
        // be the value left from a previous message send.
        emitPop();
        // Items are emitted in the order required by the PrimObject.perform method.
        // That is receiver, arguments and then selector.
        emitReceiver(message.receiver());
        emitArguments(message.arguments());
        emitSelector(message.selectors());
        if (message.selectors().size() != 0)
            emitPerform(message.arguments().size());
    }

    private void emitReceiver(EmitterNode receiver) {
        int type = receiver.type();
        if (!receiver.isList())
            emitObject(type, receiver.value());
        else
            emitObject(type, receiver.values());
    }

    private void emitObject(int type, TerminalNode node) {
        visitLine(mv, node.getSymbol().getLine());
        switch (type) {
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
            default:
                throw new RuntimeException("Unknown Emitter Type: " + type);
        }
    }

    private void emitObject(int type, List<TerminalNode> nodes) {
        visitLine(mv, nodes.get(0).getSymbol().getLine());
        switch (type) {
            case HASH:
                emitCreateSymbol(concatText(nodes));
                break;
            case DIGIT:
                emitCreateInteger(concatText(nodes));
                break;
            default:
                throw new RuntimeException("Unknown Emitter Type: " + type);
        }
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
                emitObject(node.type(), node.value());
            else
                emitObject(node.type(), node.values());
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

    private void emitPop() {
        mv.visitInsn(POP);
    }

    private void emitPushReceiver() {
        mv.visitVarInsn(ALOAD, 0);
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

    private String removeLeadingChar(String text) {
        return text.substring(1, text.length());
    }

    private String removeSingleQuotes(String text) {
        return text.substring(1, text.length() - 1);
    }

    private void pushSmalltalk() {
        mv.visitVarInsn(ALOAD, 1);
    }

    private void closeSendMessagesMethod(boolean returnRequired) {
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
}
