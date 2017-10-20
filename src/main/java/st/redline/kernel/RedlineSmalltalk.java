/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import st.redline.Smalltalk;
import st.redline.classloader.Script;
import st.redline.classloader.SmalltalkClassLoader;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static st.redline.compiler.Trace.isTraceEnabled;

public class RedlineSmalltalk extends PrimObject implements Smalltalk {

    private static Log LOG = LogFactory.getLog(RedlineSmalltalk.class);

    private Map<String, PrimObject> classes = new HashMap<>();
    private Map<String, Map<String, Map<String, String>>> imports = new HashMap<>();
    private String currentPackage;

    public RedlineSmalltalk() {
        this.javaValue("RedlineSmalltalk");
        bootstrap();
    }

    private void bootstrap() {
        PrimObject primObject = new PrimObject();
        primObject.javaValue("PrimObject");
        classes.put("st.redline.kernel.PrimObject", primObject);
        classes.put("st.redline.kernel.Smalltalk", this);
    }

    @Override
    public PrimObject createString(String value) {
        // TODO.JCL - When Smalltalk String is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue(value);
        return object;
    }

    @Override
    public PrimObject createSymbol(String value) {
        // TODO.JCL - When Smalltalk Symbol is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue(value);
        return object;
    }

    @Override
    public PrimObject createInteger(String value) {
        // TODO.JCL - When Smalltalk Symbol is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue(Integer.valueOf(value));
        return object;
    }

    @Override
    public PrimObject createCharacter(String value) {
        // TODO.JCL - When Smalltalk Symbol is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue(value.charAt(0));
        return object;
    }

    @Override
    public PrimObject booleanSingleton(String value) {
        // TODO.JCL - When Smalltalk Symbol is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue(Boolean.valueOf(value));
        return object;
    }

    @Override
    public PrimObject nilSingleton(String value) {
        // TODO.JCL - When Smalltalk Symbol is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue("nil");
        return object;
    }

    @Override @SuppressWarnings("unchecked")
    public PrimObject resolve(String reference, String className, String packageName) {
        if (isTraceEnabled(LOG))
            LOG.trace(reference + " for " + className + " in " + packageName);
        String fullPath = importFor(packageName, className, reference);
        if (fullPath == null)
            if (reference.equals("PrimObject"))
                return classes.get("st.redline.kernel.PrimObject");
            else if (reference.equals("Smalltalk"))
                return classes.get("st.redline.kernel.Smalltalk");
            else
                throw new RuntimeException("Import for '" + reference + "' not found in " + packageName + "." + className);

        if (classes.containsKey(fullPath))
            return classes.get(fullPath);

        tryCompileClass(fullPath);

        if (!classes.containsKey(fullPath))
            throw new RuntimeException("Compilation of class '" + fullPath + "' did not result in a Smalltalk class.");

        return classes.get(fullPath);
    }

    @Override
    public PrimObject currentPackage(String javaString) {
        currentPackage = javaString;
        return this;
    }

    @Override
    public String currentPackage() {
        return currentPackage;
    }

    @Override
    public Smalltalk register(PrimObject newClass, String className) {
        if (isTraceEnabled(LOG))
            LOG.trace(className + " in " + currentPackage());
        String fullClassName = currentPackage() + "." + className;
        classes.put(fullClassName, newClass);
        addImport(currentPackage(), className, fullClassName);
        return this;
    }


    private void tryCompileClass(String path) {
        try {
            Class cls = tryLoadScript(path);
            Script script = newInstance(cls);
            script.sendMessages(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Script newInstance(Class cls) throws IllegalAccessException, InstantiationException {
        return (Script) cls.newInstance();
    }

    private Class tryLoadScript(String fullClassName) throws ClassNotFoundException {
        return classLoader().loadScript(fullClassName);
    }

    private SmalltalkClassLoader classLoader() {
        return (SmalltalkClassLoader) Thread.currentThread().getContextClassLoader();
    }

    @SuppressWarnings("unchecked")
    private String importFor(String packageName, String className, String reference) {
        Map emptyMap = emptyMap();
        // TODO.JCL remove this conditional when importing is implemented.
        if (reference.equals("Object"))
            return "st.redline.kernel.Object";
        Map<String, Map<String, String>> thePackage = imports.getOrDefault(packageName, emptyMap);
        Map<String, String> theClass = thePackage.getOrDefault(className, emptyMap);
        return theClass.getOrDefault(reference, null);
    }

    private void addImport(String packageName, String className, String fullClassName) {
        if (isTraceEnabled(LOG))
            LOG.trace(className + " in " + packageName + " as " + fullClassName);
        Map<String, Map<String, String>> packageMap = imports.computeIfAbsent(packageName, k -> new HashMap<>());
        Map<String, String> classMap = packageMap.computeIfAbsent(className, k -> new HashMap<>());
        if (!classMap.containsKey(fullClassName))
            classMap.put(className, fullClassName);
        else
            throw new RuntimeException("Attempt to add import twice for: " + className);
    }
}
