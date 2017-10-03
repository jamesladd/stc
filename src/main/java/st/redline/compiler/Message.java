/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

class Message {

    private Receiver receiver;
    private Selector selector;
    private Arguments arguments;

    public Message receiver(Receiver receiver) {
        this.receiver = receiver;
        return this;
    }

    public Receiver receiver() {
        return receiver;
    }

    public Message selector(Selector selector) {
        this.selector = selector;
        return this;
    }

    public Selector selector() {
        return selector;
    }

    public Message arguments(Arguments arguments) {
        this.arguments = arguments;
        return this;
    }

    public Arguments arguments() {
        return arguments;
    }
}
