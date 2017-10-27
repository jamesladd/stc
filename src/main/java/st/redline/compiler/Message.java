/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static st.redline.compiler.SmalltalkParser.BINARY_SELECTOR;
import static st.redline.compiler.SmalltalkParser.KEYWORD;
import static st.redline.compiler.Trace.isTraceEnabled;
import static st.redline.compiler.Trace.trace;

class Message {

    private static Log LOG = LogFactory.getLog(Message.class);

    private final boolean isTail;
    private final boolean isCascade;
    private boolean isAssignment;
    private boolean receiverRequired = true;
    private boolean selectorRequired = false;
    private boolean argumentRequired = false;
    private EmitterNode receiver;
    private List<EmitterNode> selectors = new ArrayList<>();
    private List<EmitterNode> arguments = new ArrayList<>();
    private Stack<String> blockAnswerNames = new Stack<>();

    Message(boolean isTail, boolean isCascade) {
        this.receiverRequired = !isTail;
        this.isTail = isTail;
        this.isCascade = isCascade;
        this.selectorRequired = isTail || isCascade;
        if (isCascade && !isTail)
            throw new RuntimeException("Invalid Message state, setting cascade for a non-tail message");
    }

    EmitterNode receiver() {
        return receiver;
    }

    List<EmitterNode> selectors() {
        return selectors;
    }

    List<EmitterNode> arguments() {
        return arguments;
    }

    boolean isTail() {
        return isTail;
    }

    boolean isCascade() {
        return isCascade;
    }

    boolean isAssignment() {
        return isAssignment;
    }

    boolean hasBlockAnswer() {
        return !blockAnswerNames.empty();
    }

    Stack<String> blockAnswerNames() {
        return blockAnswerNames;
    }

    void addObject(EmitterNode node) {
        if (isReceiverRequired())
            addReceiver(node);
        else if (isSelectorRequired())
            addSelector(node);
        else if (isArgumentRequired())
            addArgument(node);
        else
            throw new RuntimeException("Invalid Message state.");
    }

    private void addReceiver(EmitterNode node) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(node));
        receiver = node;
        receiverRequired = false;
        selectorRequired = true;
    }

    private void addSelector(EmitterNode node) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(node));
        selectors.add(node);
        selectorRequired = false;
        argumentRequired = (node.type() == KEYWORD || node.type() == BINARY_SELECTOR);
    }

    private void addArgument(EmitterNode node) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(node));
        arguments.add(node);
        argumentRequired = false;
        selectorRequired = true;
    }

    private boolean isReceiverRequired() {
        return receiverRequired;
    }

    private boolean isSelectorRequired() {
        return selectorRequired;
    }

    private boolean isArgumentRequired() {
        return argumentRequired;
    }

    void markAsAssignment() {
        isAssignment = true;
    }

    void markAsBlockWithAnswer(String blockAnswerName) {
        this.blockAnswerNames.push(blockAnswerName);
    }
}
