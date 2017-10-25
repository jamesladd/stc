/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import java.util.Stack;
import java.util.Vector;

abstract class Statement {

    private final Stack<Message> messages = new Stack<>();
    private boolean hasBlockAnswer = false;
    private String blockAnswerName;

    void newMessage() {
        messages.push(new Message(false, false));
    }

    void newMessageTail(boolean isCascade) {
        messages.push(new Message(true, isCascade));
    }

    boolean hasBlockAnswer() {
        return hasBlockAnswer;
    }

    String blockAnswerName() {
        return blockAnswerName;
    }

    boolean containsAnswer() {
        return false;
    }

    void markAsAnswer() {
        throw new RuntimeException("Marking non-answer statement as answer!");
    }

    void addToMessage(EmitterNode node) {
        currentMessage().addObject(node);
    }

    Vector<Message> messages() {
        return messages;
    }

    private Message currentMessage() {
        return messages.peek();
    }

    void markAsAssignment() {
        currentMessage().markAsAssignment();
    }

    void markAsBlockWithAnswer(String blockAnswerName) {
        this.blockAnswerName = blockAnswerName;
        this.hasBlockAnswer = true;
    }
}
