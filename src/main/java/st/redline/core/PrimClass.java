package st.redline.core;

import java.util.*;

public class PrimClass extends PrimObject {

    private PrimObject superclass;
    private Map<String, PrimObject> methods = new HashMap<String, PrimObject>();

    public boolean includesSelector(String selector) {
        return methods.containsKey(selector);
    }

    public PrimObject methodFor(String selector) {
        return methods.get(selector);
    }

    public void superclass(PrimObject superclass) {
        this.superclass = superclass;
    }

    protected PrimObject superclass() {
        return superclass;
    }
}
