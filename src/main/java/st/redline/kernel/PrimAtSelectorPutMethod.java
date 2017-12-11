/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

public class PrimAtSelectorPutMethod extends PrimMethod {

    PrimAtSelectorPutMethod() {
        this.javaValue("Method PrimAtSelectorPut");
        this.function((method, receiver, context) -> {
            String selector = String.valueOf(context.argumentAt(0).javaValue());
            PrimMethod methodBlock = (PrimMethod) context.argumentAt(1);
            PrimClass clazz = (PrimClass) receiver.clazz();
            clazz.methodAtPut(selector, methodBlock);
            return receiver;
        });
    }
}
