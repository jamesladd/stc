/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.classloader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.*;
import java.util.jar.*;

import static java.util.Collections.emptyMap;
import static st.redline.classloader.SmalltalkSourceFile.*;

public class SmalltalkSourceFinder implements SourceFinder {

    private static Log LOG = LogFactory.getLog(SmalltalkSourceFinder.class);

    private final SourceFactory sourceFactory;
    private final String[] classPaths;
    private final Map<String, Map<String, Source>> sourceCache;

    public SmalltalkSourceFinder(SourceFactory sourceFactory, String[] classPaths) {
        this.sourceFactory = sourceFactory;
        this.classPaths = classPaths;
        this.sourceCache = new HashMap<>();
    }

    protected boolean isTraceEnabled(Log log) {
        return log.isTraceEnabled();
    }

    public Source find(String name) {
        if (isTraceEnabled(LOG))
            LOG.trace(name);
        String packageName = toPackageName(name);
        if (notInSourceCache(packageName))
            cacheSources(packageName);
        String className = toClassName(name);
        return findInCache(name, packageName, className);
    }

    private void cacheSources(String packageName) {
        // Cache Smalltalk sources found in <packageName> along classPath.
        if (isTraceEnabled(LOG))
            LOG.trace(packageName);
        List<Source> sources = findIn(packageName);
        for (Source source : sources) {
            if (notInSourceCache(packageName))
                sourceCache.put(packageName, new HashMap<>());
            sourceCache.get(packageName).put(source.className(), source);
        }
    }

    private boolean notInSourceCache(String packageName) {
        return !sourceCache.containsKey(packageName);
    }

    private Source findInCache(String fullname, String packageName, String className) {
        return sourceCache.getOrDefault(packageName, emptyMap())
                          .getOrDefault(className, new SourceNotFound(fullname));
    }

    public List<Source> findIn(String packageName) {
        return findInPath(packageName);
    }

    private List<Source> findInPath(String path) {
        String packagePath = path.replace(".", SEPARATOR);
        List<Source> sources = new ArrayList<>();
        for (String classPath : classPaths)
            sources.addAll(findInPath(packagePath, classPath));
        return sources;
    }

    private List<Source> findInPath(String packagePath, String classPath) {
        if (isJar(classPath))
            return findSourceInInJar(packagePath, classPath);
        else
            return findSourceInFile(packagePath, classPath);
    }

    @SuppressWarnings("unchecked")
    private List<Source> findSourceInFile(String packagePath, String classPath) {
        File folder = new File(classPath + SEPARATOR + packagePath);
        if (!folder.isDirectory())
            return Collections.EMPTY_LIST;
        List<Source> sources = new ArrayList<>();
        File[] files = folder.listFiles();
        if (files != null)
            for (File file : files)
                if (file.isFile() && file.getName().endsWith(SOURCE_EXTENSION))
                    sources.add(sourceFile(packagePath + SEPARATOR + file.getName(), file, classPath));
        return sources;
    }

    private List<Source> findSourceInInJar(String packagePath, String classPath) {
        List<Source> sources = new ArrayList<>();
        JarFile jarFile = tryCreateJarFile(classPath);
        for (Enumeration em1 = jarFile.entries(); em1.hasMoreElements();) {
            String entry = em1.nextElement().toString();
            int lastSlash = entry.lastIndexOf('/');
            int pathLength = packagePath.length();
            if (entry.startsWith(packagePath) && pathLength == lastSlash && entry.endsWith(SOURCE_EXTENSION))
                sources.add(sourceFactory.createFromJar(entry, classPath));
        }
        return sources;
    }

    private JarFile tryCreateJarFile(String classPath) {
        try {
            return createJarFile(classPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JarFile createJarFile(String classPath) throws IOException {
        return new JarFile(classPath);
    }

    private boolean isJar(String classPath) {
        return classPath.endsWith(".jar") || classPath.endsWith(".JAR");
    }

    private Source sourceFile(String filename, File file, String classpath) {
        return sourceFactory.createFromFile(filename, file, classpath);
    }

    private String toFilename(String name) {
        return name.replaceAll("\\.", File.separator) + SOURCE_EXTENSION;
    }

    private String toPackageName(String name) {
        int index = name.lastIndexOf(".");
        if (index == -1)
            return "";
        return name.substring(0, index);
    }

    private String toClassName(String name) {
        int index = name.lastIndexOf(".");
        if (index == -1)
            return name;
        return name.substring(index + 1);
    }

    public class SourceNotFound implements Source {

        private final String name;

        SourceNotFound(String name) {
            this.name = name;
        }

        public boolean exists() {
            return false;
        }

        public boolean hasContent() {
            return false;
        }

        public String contents() {
            return "";
        }

        public String className() {
            return toClassName(name);
        }

        public String fullClassName() {
            return name;
        }

        public String fileExtension() {
            return "";
        }

        public String packageName() {
            return toPackageName(name);
        }

        public String classpath() {
            return "";
        }

        @Override
        public int countOfLinesAddedByPreprocessor() {
            return 0;
        }
    }
}
