package st.redline.kernel;

public class PrimSubclassMethod extends PrimMethod {

    PrimSubclassMethod() {
        this.javaValue("Method PrimSubclass");
        this.function((receiver, context) -> {
            return receiver;
        });
    }
}
