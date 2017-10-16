/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import java.util.HashMap;
import java.util.Map;

public class PrimClass extends PrimObject {

    private Map<String, PrimObject> methods = new HashMap<>();
    private PrimObject superclass;

    private final boolean isMeta;

    PrimClass(String name, boolean isMeta) {
        this.javaValue(name);
        this.isMeta = isMeta;
    }

    public PrimObject superclass() {
        return superclass;
    }

    public void superclass(PrimObject superclass) {
        this.superclass = superclass;
    }

    public boolean hasSelector(String selector) {
        return methods.containsKey(selector);
    }

    public PrimObject methodAt(String selector) {
        return methods.get(selector);
    }
}
