/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

public class PrimObject {

    private Object javaValue;

    public PrimObject javaValue(Object object) {
        this.javaValue = object;
        return this;
    }

    public String toString() {
        return String.valueOf(javaValue);
    }
}
