/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import st.redline.Smalltalk;

public class PrimContext {

    private static Smalltalk SMALLTALK;

    private final PrimObject receiver;
    private final PrimObject method;
    private final String selector;
    private final PrimObject[] arguments;
    private PrimObject blockAnswer;

    private PrimObject[] temporaries;

    public PrimContext(Smalltalk smalltalk) {
        SMALLTALK = smalltalk;
        this.receiver = null;
        this.method = null;
        this.selector = null;
        this.arguments = null;
    }

    public PrimContext(PrimObject receiver, PrimObject method, String selector) {
        this.receiver = receiver;
        this.method = method;
        this.selector = selector;
        this.arguments = new PrimObject[0];
    }

    public PrimContext(PrimObject receiver, PrimObject method, String selector, PrimObject[] arguments) {
        this.receiver = receiver;
        this.method = method;
        this.selector = selector;
        this.arguments = arguments;
    }

    public Smalltalk smalltalk() {
        return SMALLTALK;
    }

    public String selector() {
        return selector;
    }

    public PrimObject method() {
        return method;
    }

    public void initTemporaries(int count) {
        temporaries = new PrimObject[count];
        // TODO.JCL - initialize with Nil.
        for (int index = 0; index < count; index++) {
            temporaries[index] = new PrimObject();
            temporaries[index].javaValue("TODO:JCL - nil - " + index);
        }
    }

    public PrimObject temporaryAt(int index) {
        if (index < temporaries.length)
            return temporaries[index];
        throw new RuntimeException("Temporaries index " + index + " out of bounds " + temporaries.length);
    }

    public PrimObject temporaryAtPut(int index, PrimObject object) {
        if (index < temporaries.length) {
            temporaries[index] = object;
            return object;
        }
        throw new RuntimeException("Temporaries index " + index + " out of bounds " + temporaries.length);
    }

    public PrimObject argumentAt(int index) {
        if (index < arguments.length)
            return arguments[index];
        throw new RuntimeException("Arguments index " + index + " out of bounds " + arguments.length);
    }

    public void blockAnswer(PrimObject answer) {
        this.blockAnswer = answer;
    }

    public PrimObject blockAnswer() {
        return blockAnswer;
    }
}
