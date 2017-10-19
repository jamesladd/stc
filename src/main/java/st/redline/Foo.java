package st.redline;

import st.redline.kernel.PrimMethod;

public class Foo {

    public void test() {
        new PrimMethod().function((receiver, context) -> { return receiver; });
    }
}
