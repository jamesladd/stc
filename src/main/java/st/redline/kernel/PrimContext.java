/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import st.redline.Smalltalk;

public class PrimContext {

    private final Smalltalk smalltalk;

    public PrimContext(Smalltalk smalltalk) {
        this.smalltalk = smalltalk;
    }

    public Smalltalk smalltalk() {
        return smalltalk;
    }

    public void initTemporaries(int count) {
    }

    public PrimObject temporaryAt(int index) {
        PrimObject object = new PrimObject();
        object.javaValue("temporary");
        return object;
    }
}
