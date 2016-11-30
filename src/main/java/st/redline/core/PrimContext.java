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

    public void initTemporaries(int count) {
        temporaries = new PrimObject[count];
    }
}
