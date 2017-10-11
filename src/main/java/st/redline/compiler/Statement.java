/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import java.util.Stack;
import java.util.Vector;

abstract class Statement {

    private final Stack<Message> messages = new Stack<>();

    void newMessage() {
        messages.push(new Message(false));
    }

    void newMessageTail() {
        messages.push(new Message(true));
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
}
