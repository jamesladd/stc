/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.classloader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.*;
import java.util.jar.*;

import static st.redline.classloader.SmalltalkSourceFile.*;

public class SmalltalkSourceFinder implements SourceFinder {

    private static Log LOG = LogFactory.getLog(SmalltalkSourceFinder.class);

    private final SourceFactory sourceFactory;
    private final String[] classPaths;

    public SmalltalkSourceFinder(SourceFactory sourceFactory, String[] classPaths) {
        this.sourceFactory = sourceFactory;
        this.classPaths = classPaths;
    }

    public Source find(String name) {
        LOG.info(name);
        String filename = toFilename(name);
        File file = new File(filename);
        if (file.exists())
            return sourceFile(filename, file, "");
        String packageName = toPackageName(name);
        List<Source> sources = findIn(packageName, filename);
        if (!sources.isEmpty())
            return sources.get(0);
        return new SourceNotFound(name);
    }

    public List<Source> findIn(String packageName, String filename) {
        return findInPath(packageName, filename);
    }

    private List<Source> findInPath(String path, String filename) {
        String packagePath = path.replace(".", SEPARATOR);
        List<Source> sources = new ArrayList<>();
        for (String classPath : classPaths) {
            sources.addAll(findInPath(packagePath, classPath, filename));
            // Short circuit search if we are finding with filename != null.
            if (filename != null && !sources.isEmpty())
                return sources;
        }
        return sources;
    }

    private List<Source> findInPath(String packagePath, String classPath, String filename) {
        if (isJar(classPath)) {
            return findSourceInInJar(packagePath, classPath, filename);
        } else
            return findSourceInFile(packagePath, classPath, filename);
    }

    @SuppressWarnings("unchecked")
    private List<Source> findSourceInFile(String packagePath, String classPath, String filename) {
        File folder = new File(classPath + SEPARATOR + packagePath);
        if (!folder.isDirectory())
            return Collections.EMPTY_LIST;
        List<Source> sources = new ArrayList<>();
        File[] files = folder.listFiles();
        if (files != null)
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(SOURCE_EXTENSION))
                    // Short circuit search if we are finding with filename != null.
                    if (filename == null)
                        sources.add(sourceFile(packagePath + SEPARATOR + file.getName(), file, classPath));
                    else if (file.getName().endsWith(filename)) {
                        sources.add(sourceFile(packagePath + SEPARATOR + file.getName(), file, classPath));
                        return sources;
                    }
            }
        return sources;
    }

    private List<Source> findSourceInInJar(String packagePath, String classPath, String filename) {
        List<Source> sources = new ArrayList<>();
        JarFile jarFile = tryCreateJarFile(classPath);
        for (Enumeration em1 = jarFile.entries(); em1.hasMoreElements();) {
            String entry = em1.nextElement().toString();
            int lastSlash = entry.lastIndexOf('/');
            int pathLength = packagePath.length();
            if (entry.startsWith(packagePath) && pathLength == lastSlash && entry.endsWith(".st")) {
                // Short circuit search if we are finding with filename != null.
                if (entry.equals(filename)) {
                    sources.add(sourceFactory.createFromJar(entry, classPath));
                    return sources;
                } else if (filename == null)
                    sources.add(sourceFactory.createFromJar(entry, classPath));
            }
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

    public String toPackageName(String name) {
        int index = name.lastIndexOf(".");
        if (index == -1)
            return "";
        return name.substring(0, index);
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
            int index = name.lastIndexOf(".");
            if (index == -1)
                return name;
            return name.substring(index + 1);
        }

        public String fullClassName() {
            return name;
        }

        public String fileExtension() {
            return "";
        }

        public String packageName() {
            int index = name.lastIndexOf(".");
            if (index == -1)
                return "";
            return name.substring(0, index);
        }

        public String classpath() {
            return "";
        }

        @Override
        public int firstLineNumber() {
            return 0;
        }
    }
}
