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

class ByteCodeEmitter implements Emitter, Opcodes {

    private static Log LOG = LogFactory.getLog(ByteCodeEmitter.class);

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

        // Currently: sendMessages outputs 'sendMessages' to console.
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("sendMessages");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//        mv.visitVarInsn(ALOAD, 1);
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
        mv.visitMaxs(1, 1);
        mv.visitEnd();
        cw.visitEnd();
        classBytes = cw.toByteArray();
    }

    @Override
    public void emit(Statement statement) {
        if (isTraceEnabled(LOG))
            LOG.trace(statement);
        emit(statement.message());
        if (statement.isAnswer())
            mv.visitInsn(ARETURN);
    }

    private void emit(Message message) {
        emitReceiver(message.receiver());
        emitArguments(message.arguments());
        emitSelector(message.selector());
    }

    private void emitReceiver(TerminalNode receiver) {
        visitLine(mv, receiver.getSymbol().getLine());

        // WARNING: This is currently hard coded to call createString.
        pushSmalltalk();
        mv.visitLdcInsn("hello");
        mv.visitMethodInsn(INVOKEINTERFACE, "st/redline/Smalltalk", "createString", "(Ljava/lang/String;)Lst/redline/kernel/PrimObject;", true);
    }

    private void pushSmalltalk() {
        mv.visitVarInsn(ALOAD, 1);
    }

    private void emitSelector(String selector) {
    }

    private void emitArguments(List<TerminalNode> arguments) {
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
