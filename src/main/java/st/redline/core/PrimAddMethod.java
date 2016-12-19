package st.redline.core;

public class PrimAddMethod extends PrimObject {

    protected PrimObject invoke(PrimObject receiver, PrimContext context) {
        System.out.println("PrimAddMethod invoke");
        String selector = selector(context);
        PrimObject method = method(context);
        if (!(method instanceof PrimMethod)) {
            method = new PrimMethod((LambdaBlock) method.javaValue());
        }
        ((PrimClass) receiver).addMethod(selector, method);
        return receiver;
    }

    private String selector(PrimContext context) {
        return String.valueOf(context.argumentJavaValueAt(0));
    }

    private PrimObject method(PrimContext context) {
        return context.argumentAt(1);
    }
}
