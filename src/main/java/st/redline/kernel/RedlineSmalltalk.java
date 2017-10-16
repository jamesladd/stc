package st.redline.kernel;

import st.redline.Smalltalk;
import st.redline.classloader.Script;
import st.redline.classloader.SmalltalkClassLoader;

import java.util.HashMap;
import java.util.Map;

import static edu.emory.mathcs.backport.java.util.Collections.emptyMap;

public class RedlineSmalltalk extends PrimObject implements Smalltalk {

    private Map<String, PrimObject> classes = new HashMap<>();
    private Map<String, Map<String, Map<String, String>>> imports = new HashMap<>();

    public RedlineSmalltalk() {
        this.javaValue("RedlineSmalltalk");
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
    public PrimObject resolveFor(String reference, String className, String packageName) {
        String fullPath = importFor(packageName, className, reference);
        if (fullPath == null)
            throw new RuntimeException("Import for '" + reference + "' not found in " + packageName + "." + className);

        if (classes.containsKey(fullPath))
            return classes.get(fullPath);

        tryCompileClass(fullPath);

        if (!classes.containsKey(fullPath))
            throw new RuntimeException("Compilation of class '" + fullPath + "' did not result in a Smalltalk class.");

        return classes.get(fullPath);
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
        Map<String, Map<String, String>> thePackage = imports.getOrDefault(packageName, emptyMap());
        Map<String, String> theClass = thePackage.getOrDefault(className, emptyMap());
        return theClass.getOrDefault(reference, null);
    }
}
