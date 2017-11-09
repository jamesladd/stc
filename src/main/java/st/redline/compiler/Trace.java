/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.logging.Log;

import java.util.List;

public class Trace {

    public static boolean isTraceEnabled(Log log) {
        return log.isTraceEnabled();
    }

    @SuppressWarnings("unchecked")
    static String trace(Object ... nodes) {
        for (Object node : nodes)
            if (node instanceof EmitterNode)
                return traceNode((EmitterNode) node);
            else if (node instanceof TerminalNode)
                return traceNode((TerminalNode) node);
            else if (node instanceof List)
                return traceNodes((List<TerminalNode>) node);
        return "!Unknown TerminalNode.";
    }

    private static String traceNodes(List<TerminalNode> nodes) {
        String trace = "L" + nodes.get(0).getSymbol().getLine() + " ";
        for (TerminalNode node : nodes)
            trace = trace + node.getSymbol().getText();
        return trace;
    }

    private static String traceNode(EmitterNode node) {
        if (!node.isList())
            return traceNode(node.value());
        return trace(node.values());
    }

    private static String traceNode(TerminalNode node) {
        return "" + node.getSymbol().getLine() + ":" + (1 + node.getSymbol().getCharPositionInLine()) + " " + node.getSymbol().getText();
    }
}
