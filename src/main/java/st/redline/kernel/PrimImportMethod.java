/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import st.redline.Smalltalk;

public class PrimImportMethod extends PrimMethod {

    PrimImportMethod() {
        this.javaValue("PrimImport");
        this.function((method, receiver, context) -> {
            if (!(receiver instanceof Smalltalk))
                throw new RuntimeException("Primitive import not sent to expected receiver.");
            return ((Smalltalk) receiver).imports(String.valueOf(context.argumentAt(0).javaValue()));
        });
    }
}
