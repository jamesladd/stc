package st.redline.core;

import st.redline.classloader.SmalltalkClassLoader;

import static st.redline.core.PrimDoesNotUnderstand.PRIM_DOES_NOT_UNDERSTAND;

public class PrimObject {

    private static final String DEFAULT_IMPORTED_PACKAGE = "st.redline.core";
    private PrimObject selfClass;
    private Object javaValue;

    public String toString() {
        if (javaValue != null)
            return javaValue.toString();
        return super.toString();
    }

    public void javaValue(Object object) {
        javaValue = object;
    }

    public void selfClass(PrimObject primClass) {
        selfClass = primClass;
    }

    public PrimObject reference(String name) {
        System.out.println("** reference " + name);
        return resolveObject(name);
    }

    public PrimObject resolveObject(String name) {
        System.out.println("** resolveObject " + name);
        return findObject(importFor(name));
    }

    public PrimObject smalltalkString(Object value) {
        return instanceOfWith("String", value);
    }

    public PrimObject smalltalkSymbol(Object value) {
        return instanceOfWith("Symbol", value);

//        String symbol = (String) javaValue;
//        SmalltalkClassLoader smalltalkClassLoader = classLoader();
//        if (smalltalkClassLoader.isInternedSymbol(symbol))
//            return smalltalkClassLoader.internedSymbolAt(symbol);
//        PrimObject symbolObject = instanceOfWith("Symbol", symbol);
//        smalltalkClassLoader.internSymbolAtPut(symbol, symbolObject);
//        return symbolObject;
    }

    protected PrimObject instanceOfWith(String type, Object value) {
        PrimObject instance = instanceOf(type);
        instance.javaValue(value);
        return instance;
    }

    protected PrimObject instanceOf(String type) {
        return isBootstrapping() ? new PrimObject() : resolveObject(type).perform("new");
    }

    protected boolean isBootstrapping() {
        return classLoader().isBootstrapping();
    }

    protected PrimObject findObject(String name) {
        return classLoader().findObject(name);
    }

    protected String importFor(String name) {
        if (selfClass != null)
            return selfClass.importFor(name);
        if (!name.startsWith(DEFAULT_IMPORTED_PACKAGE))
            return DEFAULT_IMPORTED_PACKAGE + '.' + name;
        return null;
    }

    protected SmalltalkClassLoader classLoader() {
        return (SmalltalkClassLoader) getClass().getClassLoader();
    }

    protected PrimObject sendMessages(PrimObject receiver, PrimContext context) {
        System.out.println("** sendMessages(" + receiver + "," + context + ")");
        return receiver;
    }

    public PrimObject perform(String selector) {
        System.out.println("** perform(" + selector + ") " + this);
        return perform0(selector);
    }

    public PrimObject perform(PrimObject arg1, String selector) {
        System.out.println("** perform(" + arg1 + "," + selector + ") " + this);
        return perform0(selector, arg1);
    }

    public PrimObject perform(PrimObject arg1, PrimObject arg2, String selector) {
        System.out.println("** perform(" + arg1 + "," + arg2 + "," + selector + ") " + this);
        return perform0(selector, arg1, arg2);
    }

    public PrimObject perform(PrimObject arg1, PrimObject arg2, PrimObject arg3, String selector) {
        System.out.println("** perform(" + arg1 + "," + arg2 + "," + arg3 + "," + selector + ") " + this);
        return perform0(selector, arg1, arg2);
    }

    public PrimObject perform(PrimObject arg1, PrimObject arg2, PrimObject arg3, PrimObject arg4, String selector) {
        System.out.println("** perform(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + "," + selector + ") " + this);
        return perform0(selector, arg1, arg2);
    }

    public PrimObject perform(PrimObject arg1, PrimObject arg2, PrimObject arg3, PrimObject arg4, PrimObject arg5, String selector) {
        System.out.println("** perform(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + "," + arg5 + "," + selector + ") " + this);
        return perform0(selector, arg1, arg2);
    }

    protected PrimObject perform0(String selector, PrimObject ... arguments) {
        return perform0(selfClass, selector, arguments);
    }

    protected PrimObject perform0(PrimObject foundInClass, String selector, PrimObject ... arguments) {
        PrimObject cls = foundInClass;
        while (!cls.includesSelector(selector))
            cls = cls.superclass();
        return apply(cls.methodFor(selector), cls, selector, arguments);
    }

    protected PrimObject apply(PrimObject method, PrimObject foundInClass, String selector, PrimObject ... arguments) {
        System.out.println("** apply: #" + selector + " to " + this + " found in " + foundInClass);
        return method.invoke(this, new PrimContext(this, foundInClass, selector, arguments));
    }

    protected PrimObject invoke(PrimObject receiver, PrimContext context) {
        return this;
    }

    protected PrimObject methodFor(String selector) {
        return PRIM_DOES_NOT_UNDERSTAND;
    }

    protected PrimObject superclass() {
        throw new IllegalStateException("This receiver should not have received this message.");
    }

    protected boolean includesSelector(String selector) {
        return true;
    }
}
