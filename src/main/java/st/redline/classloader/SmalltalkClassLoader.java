package st.redline.classloader;

import st.redline.compiler.Compiler;

import java.util.HashMap;

public class SmalltalkClassLoader extends ClassLoader {

    private final SourceFinder sourceFinder;
    private final HashMap<String, Class> cache;

    public SmalltalkClassLoader(ClassLoader classLoader, SourceFinder sourceFinder) {
        super(classLoader);
        this.sourceFinder = sourceFinder;
        this.cache = new HashMap<String, Class>();
    }

    public Class findClass(String name) throws ClassNotFoundException {
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
        cache.put(name, cls);
    }

    private Class cachedClass(String name) {
        return cache.get(name);
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
