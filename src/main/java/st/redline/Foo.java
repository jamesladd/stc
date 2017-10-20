package st.redline;

import st.redline.kernel.PrimContext;
import st.redline.kernel.PrimMethod;
import st.redline.kernel.PrimObject;

public class Foo {

    public PrimObject test(PrimObject receiver, PrimContext context) {
        new PrimMethod().function((m, r, c) -> { return r; });
        return null;
    }
}
