package st.redline.compiler;

import org.antlr.v4.runtime.tree.ParseTree;

public class Generator {

    private final ParseTree tree;
    private final SmalltalkVisitor visitor;

    public Generator(ParseTree tree) {
        this.tree = tree;
        this.visitor = new SmalltalkGeneratingVisitor(this);
    }

    public byte[] generate() {
        visitor.visit(tree);
        return new byte[0];
    }
}
