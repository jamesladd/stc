/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

public class PrimValueMethod extends PrimMethod {

    PrimValueMethod() {
        this.javaValue("PrimValue");
        this.function((method, receiver, context) -> {
            return receiver.function().apply(receiver, receiver, new PrimContext(receiver, this, "value", null));
        });
    }
}
