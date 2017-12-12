/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import st.redline.Smalltalk;

public class PrimPackageInMethod extends PrimMethod {

    PrimPackageInMethod() {
        this.javaValue("PrimPackageIn");
        this.function((method, receiver, context) -> {
            if (!(receiver instanceof Smalltalk))
                throw new RuntimeException("Primitive package not sent to expected receiver.");
            return ((Smalltalk) receiver).currentPackageForIs(String.valueOf(context.argumentAt(0).javaValue()), String.valueOf(context.argumentAt(1).javaValue()));
        });
    }
}
