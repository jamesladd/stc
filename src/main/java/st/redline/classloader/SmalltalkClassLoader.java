package st.redline.classloader;

import st.redline.compiler.Compiler;
import st.redline.core.PrimObject;

import java.util.HashMap;

public class SmalltalkClassLoader extends ClassLoader {

    private final SourceFinder sourceFinder;
    private final HashMap<String, Class> classCache;
    private final HashMap<String, PrimObject> objectCache;
    private boolean bootstrapping;

    public SmalltalkClassLoader(ClassLoader classLoader, SourceFinder sourceFinder, Bootstrapper bootstrapper) {
        super(classLoader);
        this.sourceFinder = sourceFinder;
        this.classCache = new HashMap<String, Class>();
        this.objectCache = new HashMap<String, PrimObject>();

        // initialize Object cache with bootstrapped objects.
        bootstrapper.bootstrap(this);
    }

    public PrimObject findObject(String name) {
        PrimObject cls = cachedObject(name);
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

    private PrimObject cachedObject(String name) {
        System.out.println("** cachedObject " + name);
        return objectCache.get(name);
    }

    public void cacheObject(String name, PrimObject object) {
        System.out.println("** cacheObject " + object + " as " + name);
        objectCache.put(name, object);
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
        System.out.println("** cacheClass " + cls + " as " + name);
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

    public void beginBootstrapping() {
        bootstrapping = true;
    }

    public void endBootstrapping() {
        bootstrapping = false;
    }

    public boolean isBootstrapping() {
        return bootstrapping;
    }
}
