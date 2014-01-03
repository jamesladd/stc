package st.redline.classloader;

import st.redline.compiler.Compiler;
import st.redline.core.ProtoObject;

import java.util.HashMap;

public class SmalltalkClassLoader extends ClassLoader {

    private final SourceFinder sourceFinder;
    private final HashMap<String, Class> classCache;
    private final HashMap<String, ProtoObject> objectCache;

    public SmalltalkClassLoader(ClassLoader classLoader, SourceFinder sourceFinder) {
        super(classLoader);
        this.sourceFinder = sourceFinder;
        this.classCache = new HashMap<String, Class>();
        this.objectCache = new HashMap<String, ProtoObject>();

        // initialize Object cache with ProtoObject instance.
        objectCache.put("st.redline.core.ProtoObject", new ProtoObject());
    }

    public ProtoObject findObject(String name) {
        ProtoObject cls = cachedObject(name);
        if (cls != null)
            return cls;
        try {
            findClass(name);
            cls = cachedObject(name);
            if (cls != null)
                return cls;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
        throw new ObjectNotFoundException("Object '" + name + "' was not found.");
    }

    private ProtoObject cachedObject(String name) {
        System.out.println("** cachedObject " + name);
        return objectCache.get(name);
    }

    public Class findClass(String name) throws ClassNotFoundException {
        System.out.println("** findClass " + name);
        Class cls = cachedClass(name);
        if (cls != null)
            return cls;
        byte[] classData = loadClassData(name);
        if (classData == null)
            return super.findClass(name);
        cls = defineClass(null, classData, 0, classData.length);
        cacheClass(cls, name);
        return cls;
    }

    private void cacheClass(Class cls, String name) {
        classCache.put(name, cls);
    }

    private Class cachedClass(String name) {
        return classCache.get(name);
    }

    private byte[] loadClassData(String name) {
        return compile(findSource(name));
    }

    private Source findSource(String name) {
        return sourceFinder.find(name);
    }

    private byte[] compile(Source source) {
        return compiler(source).compile();
    }

    private Compiler compiler(Source source) {
        return new Compiler(source);
    }
}
