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

        // Create Kernel Objects and Classes we need to start Runtime.
        PrimObject primClass = classLoader.cachedObject("st.redline.core.PrimClass");
        PrimClass object = createKernelObject("Object", primClass);
        PrimClass behavior = createKernelObject("Behavior", object);
        PrimClass classDescription = createKernelObject("ClassDescription", behavior);
        PrimClass klass = createKernelObject("Class", classDescription);
        PrimClass metaclass = createKernelObject("Metaclass", classDescription);
        PrimClass undefinedObject = createKernelObject("UndefinedObject", object);
        PrimClass booleanObject = createKernelObject("Boolean", object);
        PrimClass trueObject = createKernelObject("True", booleanObject);
        PrimClass falseObject = createKernelObject("False", booleanObject);
        PrimClass collection = createKernelObject("Collection", object);
        PrimClass sequenceableCollection = createKernelObject("SequenceableCollection", collection);
        PrimClass arrayedCollection = createKernelObject("ArrayedCollection", sequenceableCollection);
        PrimClass string = createKernelObject("String", arrayedCollection);
        PrimClass symbol = createKernelObject("Symbol", string);

        // Initialise special Smalltalk circular hierarchy.
        object.selfClass().superclass(klass);

        // Fixup class metaclass references.
        object.selfClass().selfClass(metaclass);
        behavior.selfClass().selfClass(metaclass);
        classDescription.selfClass().selfClass(metaclass);
        klass.selfClass().selfClass(metaclass);
        metaclass.selfClass().selfClass(metaclass);
        undefinedObject.selfClass().selfClass(metaclass);
        booleanObject.selfClass().selfClass(metaclass);
        collection.selfClass().selfClass(metaclass);
        sequenceableCollection.selfClass().selfClass(metaclass);
        arrayedCollection.selfClass().selfClass(metaclass);
        string.selfClass().selfClass(metaclass);
        symbol.selfClass().selfClass(metaclass);

        // Add basicAddSelector:withMethod: to Behaviour
        behavior.selfClass().addMethod("basicAddSelector:withMethod:", new PrimAddMethod());

        // Create special instances, referred to with pseudo variables.
        PrimObject nil = new PrimObject();
        nil.selfClass(undefinedObject);
        classLoader.nilInstance(nil);

        PrimObject trueInstance = new PrimObject();
        trueInstance.selfClass(trueObject);
        classLoader.trueInstance(trueInstance);

        PrimObject falseInstance = new PrimObject();
        falseInstance.selfClass(falseObject);
        classLoader.falseInstance(falseInstance);

        // Load the hierarchy and attached their methods.
        classLoader.cacheObject("st.redline.core.Object", object);
        classLoader.cacheObject("st.redline.core.Behavior", behavior);
        classLoader.cacheObject("st.redline.core.ClassDescription", classDescription);
        classLoader.cacheObject("st.redline.core.Class", klass);
        classLoader.cacheObject("st.redline.core.Metaclass", metaclass);
        classLoader.cacheObject("st.redline.core.UndefinedObject", undefinedObject);
        classLoader.cacheObject("st.redline.core.Boolean", booleanObject);
        classLoader.cacheObject("st.redline.core.True", trueObject);
        classLoader.cacheObject("st.redline.core.False", falseObject);
        classLoader.cacheObject("st.redline.core.Collection", collection);
        classLoader.cacheObject("st.redline.core.SequenceableCollection", sequenceableCollection);
        classLoader.cacheObject("st.redline.core.ArrayedCollection", arrayedCollection);
        classLoader.cacheObject("st.redline.core.String", string);
        classLoader.cacheObject("st.redline.core.Symbol", symbol);
    }

    private PrimClass createKernelObject(String name, PrimObject superclass) {
        PrimClass primMeta = new PrimClass(name,true);
        primMeta.superclass(superclass.selfClass());
        PrimClass primClass = new PrimClass(name);
        primClass.superclass(superclass);
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
        loadObject(classLoader, "st.redline.core.Boolean");
        loadObject(classLoader, "st.redline.core.True");
        loadObject(classLoader, "st.redline.core.False");
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
