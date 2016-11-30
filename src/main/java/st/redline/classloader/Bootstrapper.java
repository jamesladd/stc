package st.redline.classloader;

import st.redline.core.*;

public class Bootstrapper {

    public void bootstrap(SmalltalkClassLoader classLoader) {
        setupPrimObject(classLoader);
        loadProtoObject(classLoader);
    }

    private void setupPrimObject(SmalltalkClassLoader classLoader) {
        PrimObject primObject = new PrimObject();
        PrimClass primClass = new PrimClass();
        primObject.selfClass(primClass);
        classLoader.cacheObject("st.redline.core.PrimObject", primObject);
    }

    private void loadProtoObject(ClassLoader classLoader) {
        try {
            // Loading and instantiating the class causes the 'sendMessages' java method
            // to be called which executes all the message sends of the Smalltalk source.
            classLoader.loadClass("st.redline.core.ProtoObject").newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
