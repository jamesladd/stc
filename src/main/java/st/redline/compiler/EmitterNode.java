package st.redline.compiler;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

import static st.redline.compiler.SmalltalkParser.HASH;

class EmitterNode {

    static final int SYNTHETIC_TEMPORARY = 100;
    static final int SYNTHETIC_ARGUMENT = 101;
    static final int SYNTHETIC_INSTANCE_VARIABLE = 102;
    static final int SYNTHETIC_CLASS_VARIABLE = 103;
    static final int SYNTHETIC_REFERENCE = 104;
    static final int SYNTHETIC_BLOCK_CREATE = 105;
    static final int SYNTHETIC_METHOD_CREATE = 106;

    private final int type;
    private final boolean isList;
    private final int index;
    private TerminalNode node;
    private List<TerminalNode> nodes;

    EmitterNode(int type, TerminalNode node, int index) {
        this.type = type;
        this.node = node;
        this.isList = false;
        this.index = index;
    }

    EmitterNode(int type, List<TerminalNode> nodes, int index) {
        this.type = type;
        this.nodes = nodes;
        this.isList = true;
        this.index = index;
    }

    String text() {
        if (node != null)
            return node.getText();
        String text = "";
        for (TerminalNode node : nodes)
            text = text + node.getText();
        return text;
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

    int index() {
        return index;
    }

    static EmitterNode create(int type, Object node) {
        return create(type, node, 0);
    }

    @SuppressWarnings("unchecked")
    static EmitterNode create(int type, Object node, int index) {
        return node instanceof List ? new EmitterNode(type, (List<TerminalNode>) node, index) : new EmitterNode(type, (TerminalNode) node, index);
    }

    static EmitterNode createTemporary(TerminalNode identifier, EmitterNode declaration) {
        return new EmitterNode(SYNTHETIC_TEMPORARY, identifier, declaration.index);
    }

    static EmitterNode createArgument(TerminalNode identifier, EmitterNode declaration) {
        return new EmitterNode(SYNTHETIC_ARGUMENT, identifier, declaration.index);
    }

    static EmitterNode createInstanceVariable(TerminalNode identifier, EmitterNode declaration) {
        return new EmitterNode(SYNTHETIC_INSTANCE_VARIABLE, identifier, declaration.index);
    }

    static EmitterNode createClassVariable(TerminalNode identifier, EmitterNode declaration) {
        return new EmitterNode(SYNTHETIC_CLASS_VARIABLE, identifier, declaration.index);
    }

    static EmitterNode createReference(TerminalNode identifier) {
        return new EmitterNode(SYNTHETIC_REFERENCE, identifier, 0);
    }

    static EmitterNode createBlock(TerminalNode identifier, int blockId) {
        return new EmitterNode(SYNTHETIC_BLOCK_CREATE, identifier, blockId);
    }

    static EmitterNode createMethod(TerminalNode identifier, int blockId) {
        return new EmitterNode(SYNTHETIC_METHOD_CREATE, identifier, blockId);
    }
}
