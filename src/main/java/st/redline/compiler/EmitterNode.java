package st.redline.compiler;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

import static st.redline.compiler.SmalltalkParser.HASH;

class EmitterNode {

    private final int type;
    private final boolean isList;
    private TerminalNode node;
    private List<TerminalNode> nodes;

    EmitterNode(int type, TerminalNode node) {
        this.type = type;
        this.node = node;
        this.isList = false;
    }

    EmitterNode(int type, List<TerminalNode> nodes) {
        this.type = type;
        this.nodes = nodes;
        this.isList = true;
    }

    boolean isList() {
        return isList;
    }

    int type() {
        return type;
    }

    TerminalNode value() {
        return node;
    }

    List<TerminalNode> values() {
        return nodes;
    }

    @SuppressWarnings("unchecked")
    static EmitterNode create(int type, Object node) {
        return node instanceof List ? new EmitterNode(type, (List<TerminalNode>) node) : new EmitterNode(type, (TerminalNode) node);
    }
}
