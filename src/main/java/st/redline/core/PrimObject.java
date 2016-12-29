package st.redline.core;

import st.redline.classloader.SmalltalkClassLoader;

import static st.redline.core.PrimDoesNotUnderstand.PRIM_DOES_NOT_UNDERSTAND;
import static st.redline.core.PrimSubclass.PRIM_SUBCLASS;

public class PrimObject {

    private static final String DEFAULT_IMPORTED_PACKAGE = "st.redline.core";

    private PrimObject selfClass;
    private Object javaValue;

    public String toString() {
        if (javaValue != null)
            return javaValue.toString();
        if (selfClass != null && selfClass != this)
            return selfClass.toString();
        return super.toString();
    }

    public void javaValue(Object object) {
        javaValue = object;
    }

    public Object javaValue() {
        return javaValue;
    }

    public void selfClass(PrimObject primObject) {
        selfClass = primObject;
    }

    public PrimObject selfClass() {
        return selfClass;
    }

    public PrimObject referenceNil() {
        System.out.println("** referenceNil");
        return classLoader().nilInstance();
    }

    public PrimObject referenceTrue() {
        System.out.println("** referenceTrue");
        return classLoader().trueInstance();
    }

    public PrimObject referenceFalse() {
        System.out.println("** referenceFalse");
        return classLoader().falseInstance();
    }

    public PrimObject reference(String name) {
        System.out.println("** reference " + name);
        return resolveObject(name);
    }

    public PrimObject resolveObject(String name) {
        System.out.println("** resolveObject " + name);
        return findObject(importFor(name));
    }

    public PrimObject smalltalkBlock(Object value) {
        System.out.println("** smalltalkBlock " + value);
        return instanceOfWith("BlockClosure", value);
    }

    public PrimObject smalltalkMethod(Object value) {
        System.out.println("** smalltalkMethod " + value);
        return instanceOfWith("CompiledMethod", value);
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
        if (selfClass != null && selfClass.isMeta())
            return selfClass.importFor(name);
        if (!name.startsWith(DEFAULT_IMPORTED_PACKAGE))
            return DEFAULT_IMPORTED_PACKAGE + '.' + name;
        return null;
    }

    protected SmalltalkClassLoader classLoader() {
        return (SmalltalkClassLoader) Thread.currentThread().getContextClassLoader();
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
        System.out.println("** apply: #" + selector + " found in " + foundInClass + " to " + this);
        PrimObject result = method.invoke(this, new PrimContext(this, foundInClass, selector, arguments));
        System.out.println("** result: " + String.valueOf(result));
        return result; //method.invoke(this, new PrimContext(this, foundInClass, selector, arguments));
    }

    protected PrimObject invoke(PrimObject receiver, PrimContext context) {
        return this;
    }

    protected PrimObject methodFor(String selector) {
        if ("subclass:".equals(selector))
            return PRIM_SUBCLASS;
        return PRIM_DOES_NOT_UNDERSTAND;
    }

    protected PrimObject superclass() {
        throw new IllegalStateException("This receiver should not have received this message.");
    }

    protected boolean includesSelector(String selector) {
        return true;
    }

    public boolean isMeta() {
        return false;
    }

    public PrimObject primitiveNew() {
        PrimObject object = new PrimObject();
        object.selfClass(this);
        return object;
    }
}
