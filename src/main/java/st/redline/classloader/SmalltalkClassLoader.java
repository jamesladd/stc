package st.redline.classloader;

import st.redline.compiler.Compiler;

public class SmalltalkClassLoader extends ClassLoader {

    private final SourceFinder sourceFinder;

    public SmalltalkClassLoader(ClassLoader classLoader, SourceFinder sourceFinder) {
        super(classLoader);
        this.sourceFinder = sourceFinder;
    }

    public Class findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null)
            return super.findClass(name);
        return defineClass(null, classData, 0, classData.length);
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
