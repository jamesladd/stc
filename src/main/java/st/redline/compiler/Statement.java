/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

class Statement {

    private final Stack<Message> messages = new Stack<>();

    void newMessage() {
        messages.push(new Message());
    }

    boolean isAnswer() {
        return false;
    }

    void markAsAnswer() {
        throw new RuntimeException("Marking non-answer statement as answer!");
    }

    void addToMessage(TerminalNode node) {
        currentMessage().addObject(node);
    }

    Message message() {
        return currentMessage();
    }

    private Message currentMessage() {
        return messages.peek();
    }
}
