package st.redline.runtime;

public class ProtoObject {

    protected ProtoObject sendMessages(ProtoObject receiver, Context context) {
        System.out.println("sendMessages(" + receiver + "," + context + ")");
        return receiver;
    }

    public ProtoObject variableAt(String name) {
        System.out.println("variableAt " + name);
        return null;
    }
}
