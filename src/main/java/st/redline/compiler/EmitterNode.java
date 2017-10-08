package st.redline.compiler;

import org.antlr.v4.runtime.tree.TerminalNode;

class EmitterNode {

    private final int type;
    private final TerminalNode node;

    EmitterNode(int type, TerminalNode node) {
        this.type = type;
        this.node = node;
    }

    int type() {
        return type;
    }

    TerminalNode value() {
        return node;
    }
}
