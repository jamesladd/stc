/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

public class PrimMethod extends PrimObject {

    protected TriFunction<PrimObject, PrimObject, PrimContext, PrimObject> function;

    public PrimMethod() {
        this.javaValue("PrimMethod");
    }

    public PrimObject apply(PrimObject receiver, PrimContext context) {
        System.out.println("PrimMethod '" + this + "' apply");
        return function.apply(receiver, receiver, context);
    }

    public TriFunction<PrimObject, PrimObject, PrimContext, PrimObject> function() {
        return function;
    }

    public PrimObject function(TriFunction<PrimObject, PrimObject, PrimContext, PrimObject> function) {
        this.function = function;
        return this;
    }
}
