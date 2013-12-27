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

    public Void visitSequence(@NotNull SmalltalkParser.SequenceContext ctx) {
        currentVisitor().visitSequence(ctx);
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

        public ClassGeneratorVisitor() {
            cw = new ClassWriter(0);
        }

        public Void visitScript(SmalltalkParser.ScriptContext ctx) {
            openJavaClass();
            ctx.sequence().accept(currentVisitor());
            closeJavaClass();
            return null;
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
            mv.visitInsn(RETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "L" + fullClassName() + ";", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        public Void visitSequence(SmalltalkParser.SequenceContext ctx) {
            return null;
        }
    }
}
