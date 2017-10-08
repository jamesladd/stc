package st.redline;

import st.redline.kernel.PrimObject;

public class RedlineSmalltalk implements Smalltalk {

    @Override
    public PrimObject createString(String javaString) {
        // TODO.JCL - When Smalltalk String is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue(javaString);
        return object;
    }
}
