package st.redline.compiler;

import org.antlr.v4.runtime.misc.NotNull;

public class SmalltalkGeneratingVisitor extends SmalltalkBaseVisitor<Object> implements SmalltalkVisitor<Object> {

    private final Generator generator;

    public SmalltalkGeneratingVisitor(Generator generator) {
        this.generator = generator;
    }

    public Object visitScript(@NotNull SmalltalkParser.ScriptContext ctx) {
        log("visitScript");
        return super.visitScript(ctx);
    }

    private void log(String output) {
        System.out.println(output);
        System.out.flush();
    }
}
