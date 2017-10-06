/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

import static st.redline.compiler.Trace.isTraceEnabled;
import static st.redline.compiler.Trace.trace;

class Message {

    private static Log LOG = LogFactory.getLog(Message.class);

    private boolean receiverRequired = true;
    private TerminalNode receiver;
    private StringBuilder selector = new StringBuilder();
    private List<TerminalNode> arguments = new ArrayList<>();

    TerminalNode receiver() {
        return receiver;
    }

    String selector() {
        return selector.toString();
    }

    List<TerminalNode> arguments() {
        return arguments;
    }

    void addObject(TerminalNode node) {
        if (receiverRequired())
            addReceiver(node);
        else
            addArgument(node);
    }

    private void addArgument(TerminalNode node) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(node));
        arguments.add(node);
    }

    private void addReceiver(TerminalNode node) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(node));
        receiver = node;
        receiverRequired = false;
    }

    private boolean receiverRequired() {
        return receiverRequired;
    }
}
