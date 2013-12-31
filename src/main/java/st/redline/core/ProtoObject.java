package st.redline.core;

import st.redline.classloader.SmalltalkClassLoader;

public class ProtoObject {

    private static final String DEFAULT_IMPORTED_PACKAGE = "st.redline.core";
    private ProtoObject selfClass;

    public ProtoObject variableAt(String name) {
        System.out.println("variableAt " + name);
        return resolveObject(name);
    }

    public ProtoObject resolveObject(String name) {
        System.out.println("resolveObject " + name);
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
        System.out.println("sendMessages(" + receiver + "," + context + ")");
        return receiver;
    }
}
