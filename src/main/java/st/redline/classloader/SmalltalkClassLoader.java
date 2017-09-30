/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.classloader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import st.redline.compiler.Compiler;

public class SmalltalkClassLoader extends ClassLoader {

    private static Log LOG = LogFactory.getLog(SmalltalkClassLoader.class);

    private final SourceFinder sourceFinder;

    public SmalltalkClassLoader(ClassLoader classLoader, SourceFinder sourceFinder) {
        super(classLoader);
        this.sourceFinder = sourceFinder;
    }

    protected boolean isTraceEnabled(Log log) {
        return log.isTraceEnabled();
    }

    public Class findClass(String name) throws ClassNotFoundException {
        if (isTraceEnabled(LOG))
            LOG.trace(name);
        Class cls = cachedClass(name);
        if (cls != null)
            return cls;
        byte[] classData = loadClassData(name);
        if (classData == null)
            return super.findClass(name);
        cls = defineClass(null, classData, 0, classData.length);
//        saveClass(classData, name);
//        cacheClass(cls, name);
        return cls;
    }

    public Class loadScript(String name) throws ClassNotFoundException {
        return loadClass(name);
    }

    private Class cachedClass(String name) {
        return null;
    }

    private byte[] loadClassData(String name) {
        return compile(findSource(name));
    }

    private Source findSource(String name) {
        Source source = sourceFinder.find(name);
        if (source.exists())
            return source;
        return null;
    }

    private byte[] compile(Source source) {
        return compiler(source).compile();
    }

    private Compiler compiler(Source source) {
        return new Compiler(source);
    }
}
