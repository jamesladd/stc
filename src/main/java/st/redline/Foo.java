package st.redline;

import st.redline.kernel.PrimBlockAnswer;
import st.redline.kernel.PrimContext;
import st.redline.kernel.PrimObject;

public class Foo {

    public PrimObject test(PrimObject receiver, PrimContext context) {
        PrimObject value = null;
        try {
            System.out.println("before call");
            value = someThrowingMethod();
            System.out.println("after call");
            System.out.println("after call value: " + value);
        } catch (PrimBlockAnswer pba) {
            System.out.println("caught");
            value = pba.answer();
            System.out.println("caught value: " + value);
        }
        return value;
    }

    private PrimObject someThrowingMethod() {
        return null;
    }
}
