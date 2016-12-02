package st.redline.classloader;

import st.redline.core.*;

import static st.redline.core.PrimNil.PRIM_NIL;

public class Bootstrapper {

    public void bootstrap(SmalltalkClassLoader classLoader) {
        classLoader.beginBootstrapping();
        createPrimObject(classLoader);
        loadKernelObjects(classLoader);
        classLoader.endBootstrapping();
    }

    private void loadKernelObjects(SmalltalkClassLoader classLoader) {
        loadObject(classLoader, "st.redline.core.ProtoObject");
    }

    private void createPrimObject(SmalltalkClassLoader classLoader) {
        PrimClass primClass = new PrimClass();
        primClass.superclass(PRIM_NIL);
        primClass.selfClass(PRIM_NIL);
        PrimObject primObject = new PrimClass();
        primObject.selfClass(primClass);
        classLoader.cacheObject("st.redline.core.PrimObject", primObject);
    }

    private void loadObject(ClassLoader classLoader, String name) {
        try {
            // Loading and instantiating the class causes the 'sendMessages' java method
            // to be called which executes all the message sends of the Smalltalk source.
            classLoader.loadClass(name).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
