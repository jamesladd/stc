package st.redline;

import st.redline.kernel.PrimBlockAnswer;
import st.redline.kernel.PrimContext;
import st.redline.kernel.PrimObject;

public class Foo {

    public PrimObject test(PrimObject receiver, PrimContext context) {
        try {
            return someThrowingMethod();
        } catch (PrimBlockAnswer pba) {
            return pba.answer();
        }
    }

    private PrimObject someThrowingMethod() throws PrimBlockAnswer {
        return null;
    }
}
