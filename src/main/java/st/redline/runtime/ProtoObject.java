package st.redline.runtime;

public class ProtoObject {

    protected ProtoObject sendMessages(ProtoObject receiver, Context context) {
        System.out.println("sendMessages(" + receiver + "," + context + ")");
        return receiver;
    }
}
