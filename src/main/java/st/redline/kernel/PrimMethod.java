package st.redline.kernel;

import java.util.function.BiFunction;

public class PrimMethod extends PrimObject {

    private BiFunction<PrimObject, PrimContext, PrimObject> function;

    public PrimObject apply(PrimObject receiver, PrimContext context) {
        return function.apply(receiver, context);
    }

    public void function(BiFunction<PrimObject, PrimContext, PrimObject> function) {
        this.function = function;
    }
}
