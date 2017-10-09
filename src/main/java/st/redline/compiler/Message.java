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
    private EmitterNode receiver;
    private List<EmitterNode> selector = new ArrayList<>();
    private List<EmitterNode> arguments = new ArrayList<>();

    EmitterNode receiver() {
        return receiver;
    }

    String selector() {
        return selector.toString();
    }

    List<EmitterNode> arguments() {
        return arguments;
    }

    void addObject(EmitterNode node) {
        if (isReceiverRequired())
            addReceiver(node);
        else
            addArgument(node);
    }

    private void addArgument(EmitterNode node) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(node));
        arguments.add(node);
    }

    private void addReceiver(EmitterNode node) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(node));
        receiver = node;
        receiverRequired = false;
    }

    private boolean isReceiverRequired() {
        return receiverRequired;
    }
}
