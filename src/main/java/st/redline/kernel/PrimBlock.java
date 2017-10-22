/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

public class PrimBlock extends PrimMethod {

    public PrimBlock() {
        this.javaValue("PrimBlock");
    }

    public PrimObject apply(PrimObject receiver, PrimContext context) {
        throw new RuntimeException("Can't apply a block, must send value[:] message.");
    }

    public TriFunction<PrimObject, PrimObject, PrimContext, PrimObject> function() {
        return function;
    }

    public boolean hasSelector(String selector) {
        return "value".equals(selector);
    }

    public PrimObject methodAt(String selector) {
        if ("value".equals(selector))
            return new PrimValueMethod();
        return super.methodAt(selector);
    }
}
