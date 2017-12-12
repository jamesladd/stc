/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

public class PrimClassMethod extends PrimMethod {

    PrimClassMethod() {
        this.javaValue("PrimClass");
        this.function((method, receiver, context) -> {
            return receiver.clazz();
        });
    }
}
