package st.redline.runtime;

public class Context {

    private final ProtoObject receiver;
    private ProtoObject[] temporaries;

    public Context(ProtoObject receiver) {
        this.receiver = receiver;
    }

    public void initTemporaries(int count) {
        temporaries = new ProtoObject[count];
    }
}
