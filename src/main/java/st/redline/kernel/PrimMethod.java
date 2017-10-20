/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

public class PrimMethod extends PrimObject {

    private TriFunction<PrimObject, PrimObject, PrimContext, PrimObject> function;

    public PrimMethod() {
        this.javaValue("PrimMethod");
    }

    public PrimObject apply(PrimObject receiver, PrimContext context) {
        return function.apply(this, receiver, context);
    }

    public PrimObject function(TriFunction<PrimObject, PrimObject, PrimContext,PrimObject> function) {
        this.function = function;
        return this;
    }
}
