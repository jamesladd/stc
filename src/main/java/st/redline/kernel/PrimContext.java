/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import st.redline.Smalltalk;

public class PrimContext {

    private final Smalltalk smalltalk;
    private PrimObject[] temporaries;

    public PrimContext(Smalltalk smalltalk) {
        this.smalltalk = smalltalk;
    }

    public Smalltalk smalltalk() {
        return smalltalk;
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
}
