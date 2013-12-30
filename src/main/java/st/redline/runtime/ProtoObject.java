package st.redline.runtime;

public class ProtoObject {

    protected ProtoObject sendMessages(ProtoObject receiver) {
        System.out.println("sendMessages(" + receiver + ")");
        return receiver;
    }
}
