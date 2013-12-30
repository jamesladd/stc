package st.redline.compiler;

import org.antlr.v4.runtime.misc.NotNull;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import st.redline.classloader.Source;

import java.util.Stack;

public class SmalltalkGeneratingVisitor extends SmalltalkBaseVisitor<Void> implements SmalltalkVisitor<Void> {

    private final Stack<SmalltalkVisitor<Void>> visitors = new Stack<SmalltalkVisitor<Void>>();
    private final Source source;
    private byte[] classBytes = null;

    public SmalltalkGeneratingVisitor(Source source) {
        this.source = source;
        makeClassGeneratorCurrentVisitor();
    }

    private void makeClassGeneratorCurrentVisitor() {
        visitors.push(new ClassGeneratorVisitor());
    }

    public Void visitScript(@NotNull SmalltalkParser.ScriptContext ctx) {
        currentVisitor().visitScript(ctx);
        return null;
    }

    private SmalltalkVisitor<Void> currentVisitor() {
        return visitors.peek();
    }

    private void log(String output) {
        System.out.println(output);
        System.out.flush();
    }

    private String className() {
        return source.className();
    }

    private String sourceFileExtension() {
        return source.fileExtension();
    }

    private String fullClassName() {
        return source.fullClassName();
    }

    private String superclassName() {
        return "st/redline/runtime/ProtoObject";
    }

    public byte[] generatedClassBytes() {
        return classBytes;
    }

    // ------------------------------

    private class ClassGeneratorVisitor extends SmalltalkBaseVisitor<Void> implements SmalltalkVisitor<Void>, Opcodes {

        private final ClassWriter cw;
        private MethodVisitor mv;

        public ClassGeneratorVisitor() {
            cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        }

        public Void visitScript(SmalltalkParser.ScriptContext ctx) {
            openJavaClass();
            openSendMessagesMethod();
            ctx.sequence().accept(currentVisitor());
            closeSendMessagesMethod();
            closeJavaClass();
            return null;
        }

        private void closeSendMessagesMethod() {
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        private void openSendMessagesMethod() {
            mv = cw.visitMethod(ACC_PROTECTED, "sendMessages", "(L" + superclassName() + ";)L" + superclassName() + ";", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(ARETURN);
        }

        private void openJavaClass() {
            cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, fullClassName(), null, superclassName(), null);
            cw.visitSource(className() + sourceFileExtension(), null);
            makeJavaClassInitializer();
        }

        private void closeJavaClass() {
            cw.visitEnd();
            classBytes = cw.toByteArray();
        }

        private void makeJavaClassInitializer() {
            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(0, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, superclassName(), "<init>", "()V");

            // invoke sendMessages to send all messages embodied in the compiled script.
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, fullClassName(), "sendMessages", "(L" + superclassName() + ";)L" + superclassName() + ";");
            mv.visitInsn(POP);

            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        public Void visitSequence(SmalltalkParser.SequenceContext ctx) {
            SmalltalkParser.TempsContext temps = ctx.temps();
            if (temps != null)
                temps.accept(currentVisitor());
            SmalltalkParser.StatementsContext statements = ctx.statements();
            if (statements != null)
                statements.accept(currentVisitor());
            return null;
        }

        public Void visitTemps(@NotNull SmalltalkParser.TempsContext ctx) {
            log("visitTemps");
            return null;
        }

        public Void visitStatementExpressions(@NotNull SmalltalkParser.StatementExpressionsContext ctx) {
            log("visitStatementExpressions");
            return null;
        }

        public Void visitStatementExpressionsAnswer(@NotNull SmalltalkParser.StatementExpressionsAnswerContext ctx) {
            log("visitStatementExpressionsAnswer");
            return null;
        }

        public Void visitStatementAnswer(@NotNull SmalltalkParser.StatementAnswerContext ctx) {
            log("visitStatementAnswer");
            return null;
        }
    }
}
