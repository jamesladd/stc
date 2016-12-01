package st.redline.core;

public class PrimContext {

    private final PrimObject receiver;
    private final PrimObject lookupClass;
    private final String selector;
    private final PrimObject[] arguments;
    private PrimObject[] temporaries;

    public PrimContext(PrimObject receiver) {
        this(receiver, null, null, null);
    }

    public PrimContext(PrimObject receiver, PrimObject lookupClass, String selector, PrimObject[] arguments) {
        this.receiver = receiver;
        this.lookupClass = lookupClass;
        this.selector = selector;
        this.arguments = arguments;
    }

    public String selector() {
        return selector;
    }

    public PrimObject[] arguments() {
        return arguments;
    }

    public void initTemporaries(int count) {
        temporaries = new PrimObject[count];
    }

    public PrimObject[] selectorAndArguments() {
        System.out.println("selectorAndArguments: " + selector);
        PrimObject selectorObject = new PrimObject();
        selectorObject.javaValue(selector);
        PrimObject[] selectorAndArguments = new PrimObject[arguments.length + 1];
        selectorAndArguments[0] = selectorObject;
        System.arraycopy(arguments, 0, selectorAndArguments, 1, arguments.length);
        return selectorAndArguments;
    }
}
