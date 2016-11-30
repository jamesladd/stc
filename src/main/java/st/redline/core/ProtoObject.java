package st.redline.core;

import st.redline.classloader.SmalltalkClassLoader;

public class ProtoObject {

    private static final String DEFAULT_IMPORTED_PACKAGE = "st.redline.core";
    private ProtoObject selfClass;

    public ProtoObject reference(String name) {
        System.out.println("** reference " + name);
        return resolveObject(name);
    }

    public ProtoObject resolveObject(String name) {
        System.out.println("** resolveObject " + name);
        return findObject(importFor(name));
    }

    protected ProtoObject findObject(String name) {
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

    protected ProtoObject sendMessages(ProtoObject receiver, Context context) {
        System.out.println("** sendMessages(" + receiver + "," + context + ")");
        return receiver;
    }

    public ProtoObject perform(ProtoObject arg1, String selector) {
        System.out.println("** perform(" + arg1 + "," + selector + ") " + this);
        return perform0(selector, arg1);
    }

    protected ProtoObject perform0(String selector, ProtoObject... arguments) {
        return perform0(selfClass, selector, arguments);
    }

    protected ProtoObject perform0(ProtoObject foundInClass, String selector, ProtoObject... arguments) {
//        ProtoObject cls = foundInClass;
//        while (!cls.includesSelector(selector))
//            cls = cls.superclass();
//        return apply(cls.methodFor(selector), cls, selector, arguments);
        return null;
    }
}
