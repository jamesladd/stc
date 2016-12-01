package st.redline.classloader;

import st.redline.core.*;

import static st.redline.core.PrimNil.PRIM_NIL;

public class Bootstrapper {

    public void bootstrap(SmalltalkClassLoader classLoader) {
        classLoader.beginBootstrapping();
        createPrimObject(classLoader);
        loadProtoObject(classLoader);
        classLoader.endBootstrapping();
    }

    private void createPrimObject(SmalltalkClassLoader classLoader) {
        PrimObject primObject = new PrimObject();
        PrimClass primClass = new PrimClass();
        primClass.superclass(PRIM_NIL);
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
