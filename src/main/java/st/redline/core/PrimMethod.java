package st.redline.core;

public class PrimMethod extends PrimObject {

    public PrimMethod(LambdaBlock lambdaBlock) {
        this.javaValue(lambdaBlock);
    }

    public String toString() {
        return "(PrimMethod) " + javaValue().toString();
    }

    protected PrimObject invoke(PrimObject receiver, PrimContext context) {
        System.out.println("PrimMethod invoke");
        return ((LambdaBlock) javaValue()).apply(receiver, context);
    }
}
