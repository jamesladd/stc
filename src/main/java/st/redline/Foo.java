package st.redline;

import st.redline.kernel.PrimContext;
import st.redline.kernel.PrimMethod;
import st.redline.kernel.PrimObject;

public class Foo {

    public PrimObject test(PrimObject receiver, PrimContext context) {
        System.out.println("inside smalltalk method");
        return null;
    }
}
