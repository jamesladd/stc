package st.redline.core;

public class Context {

    private final PrimObject receiver;
    private PrimObject[] temporaries;

    public Context(PrimObject receiver) {
        this.receiver = receiver;
    }

    public void initTemporaries(int count) {
        temporaries = new PrimObject[count];
    }
}
