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
        byte[] classData = loadClassData(name);
        if (classData == null)
            return super.findClass(name);
        return defineClass(null, classData, 0, classData.length);
    }

    public Class loadScript(String name) throws ClassNotFoundException {
        return loadClass(name);
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

    public Class defineBlockClass(String name, byte[] classData, int i, int length) {
        return defineClass(name, classData, i, length);
    }
}
