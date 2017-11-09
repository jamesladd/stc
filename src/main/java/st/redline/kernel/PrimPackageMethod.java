/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import st.redline.Smalltalk;

public class PrimPackageMethod extends PrimMethod {

    PrimPackageMethod() {
        this.javaValue("PrimPackage");
        this.function((method, receiver, context) -> {
            if (!(receiver instanceof Smalltalk))
                throw new RuntimeException("Primitive package not sent to expected receiver.");
            return ((Smalltalk) receiver).currentPackage(String.valueOf(context.argumentAt(0).javaValue()));
        });
    }
}
