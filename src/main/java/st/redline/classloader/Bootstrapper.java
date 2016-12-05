package st.redline.classloader;

import st.redline.core.*;

import static st.redline.core.PrimNil.PRIM_NIL;

public class Bootstrapper {

    public void bootstrap(SmalltalkClassLoader classLoader) {
        setContextClassLoader(classLoader);
        classLoader.beginBootstrapping();
        createPrimClass(classLoader);
        createKernelObjectsHierarchy(classLoader);
        loadKernelObjects(classLoader);
        classLoader.endBootstrapping();
    }

    private void createKernelObjectsHierarchy(SmalltalkClassLoader classLoader) {
        PrimObject primClass = classLoader.cachedObject("st.redline.core.PrimClass");
        PrimClass object = createKernelObject("Object", primClass, primClass);
        PrimClass behavior = createKernelObject("Behavior", primClass, object);
        PrimClass classDescription = createKernelObject("ClassDescription", primClass, behavior);
        PrimClass klass = createKernelObject("Class", primClass, classDescription);
        PrimClass metaclass = createKernelObject("Metaclass", primClass, classDescription);
        PrimClass undefinedObject = createKernelObject("UndefinedObject", primClass, object);
        PrimClass collection = createKernelObject("Collection", primClass, object);
        PrimClass sequenceableCollection = createKernelObject("SequenceableCollection", primClass, collection);
        PrimClass arrayedCollection = createKernelObject("ArrayedCollection", primClass, sequenceableCollection);
        PrimClass string = createKernelObject("String", primClass, arrayedCollection);
        PrimClass symbol = createKernelObject("Symbol", primClass, string);

        object.selfClass().superclass(klass);

        classLoader.cacheObject("st.redline.core.Object", object);
        classLoader.cacheObject("st.redline.core.Behavior", behavior);
        classLoader.cacheObject("st.redline.core.ClassDescription", classDescription);
        classLoader.cacheObject("st.redline.core.Class", klass);
        classLoader.cacheObject("st.redline.core.Metaclass", metaclass);
        classLoader.cacheObject("st.redline.core.UndefinedObject", undefinedObject);
        classLoader.cacheObject("st.redline.core.Collection", collection);
        classLoader.cacheObject("st.redline.core.SequenceableCollection", sequenceableCollection);
        classLoader.cacheObject("st.redline.core.ArrayedCollection", arrayedCollection);
        classLoader.cacheObject("st.redline.core.String", string);
        classLoader.cacheObject("st.redline.core.Symbol", symbol);
    }

    private PrimClass createKernelObject(String name, PrimObject baseClass, PrimObject superclass) {
        PrimClass primMeta = new PrimClass(name,true);
        primMeta.superclass(superclass);
        primMeta.selfClass((PrimClass) baseClass);
        PrimClass primClass = new PrimClass(name);
        primClass.superclass(baseClass);
        primClass.selfClass(primMeta);
        return primClass;
    }

    private void setContextClassLoader(SmalltalkClassLoader classLoader) {
        Thread.currentThread().setContextClassLoader(classLoader);
    }

    private void loadKernelObjects(SmalltalkClassLoader classLoader) {
        loadObject(classLoader, "st.redline.core.Object");
        loadObject(classLoader, "st.redline.core.Behavior");
        loadObject(classLoader, "st.redline.core.ClassDescription");
        loadObject(classLoader, "st.redline.core.Class");
        loadObject(classLoader, "st.redline.core.Metaclass");
        loadObject(classLoader, "st.redline.core.UndefinedObject");
        loadObject(classLoader, "st.redline.core.Collection");
        loadObject(classLoader, "st.redline.core.SequenceableCollection");
        loadObject(classLoader, "st.redline.core.ArrayedCollection");
        loadObject(classLoader, "st.redline.core.String");
        loadObject(classLoader, "st.redline.core.Symbol");
    }

    private void createPrimClass(SmalltalkClassLoader classLoader) {
        PrimSubclass subclassMethod = new PrimSubclass();
        PrimClass primMeta = new PrimClass("PrimClass",true);
        primMeta.superclass(PRIM_NIL);
        primMeta.selfClass(PRIM_NIL);
        primMeta.addMethod("subclass:", subclassMethod);
        PrimClass primClass = new PrimClass("PrimClass");
        primClass.superclass(PRIM_NIL);
        primClass.selfClass(primMeta);
        primClass.addMethod("subclass:", subclassMethod);
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
