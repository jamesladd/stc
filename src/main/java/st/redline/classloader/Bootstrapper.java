package st.redline.classloader;

import st.redline.core.*;

import static st.redline.core.PrimNil.PRIM_NIL;

public class Bootstrapper {

    public void bootstrap(SmalltalkClassLoader classLoader) {
        classLoader.beginBootstrapping();
        createPrimClass(classLoader);
        loadKernelObjects(classLoader);
        classLoader.endBootstrapping();
    }

    private void loadKernelObjects(SmalltalkClassLoader classLoader) {
        loadObject(classLoader, "st.redline.core.Object");
    }

    private void createPrimClass(SmalltalkClassLoader classLoader) {
        PrimClass primMeta = new PrimClass(true);
        primMeta.superclass(PRIM_NIL);
        primMeta.selfClass(PRIM_NIL);
        primMeta.addMethod("subclass:", new PrimSubclass());
        PrimClass primClass = new PrimClass();
        primClass.selfClass(primMeta);
        classLoader.cacheObject("st.redline.core.PrimClass", primClass);
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
