package st.redline;

import st.redline.kernel.PrimObject;

public class RedlineSmalltalk implements Smalltalk {
    @Override
    public PrimObject createString(String javaString) {
        return new PrimObject();
    }
}
