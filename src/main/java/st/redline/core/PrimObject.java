package st.redline.core;

import st.redline.classloader.SmalltalkClassLoader;

public class PrimObject {

    private static final String DEFAULT_IMPORTED_PACKAGE = "st.redline.core";
    private PrimObject selfClass;

    public PrimObject reference(String name) {
        System.out.println("** reference " + name);
        return resolveObject(name);
    }

    public PrimObject resolveObject(String name) {
        System.out.println("** resolveObject " + name);
        return findObject(importFor(name));
    }

    protected PrimObject findObject(String name) {
        return classLoader().findObject(name);
    }

    protected String importFor(String name) {
        if (selfClass != null)
            return selfClass.importFor(name);
        if (!name.startsWith(DEFAULT_IMPORTED_PACKAGE))
            return DEFAULT_IMPORTED_PACKAGE + '.' + name;
        return null;
    }

    protected SmalltalkClassLoader classLoader() {
        return (SmalltalkClassLoader) getClass().getClassLoader();
    }

    protected PrimObject sendMessages(PrimObject receiver, Context context) {
        System.out.println("** sendMessages(" + receiver + "," + context + ")");
        return receiver;
    }

    public PrimObject perform(PrimObject arg1, String selector) {
        System.out.println("** perform(" + arg1 + "," + selector + ") " + this);
        return perform0(selector, arg1);
    }

    protected PrimObject perform0(String selector, PrimObject... arguments) {
        return perform0(selfClass, selector, arguments);
    }

    protected PrimObject perform0(PrimObject foundInClass, String selector, PrimObject... arguments) {
//        PrimObject cls = foundInClass;
//        while (!cls.includesSelector(selector))
//            cls = cls.superclass();
//        return apply(cls.methodFor(selector), cls, selector, arguments);
        return null;
    }
}
