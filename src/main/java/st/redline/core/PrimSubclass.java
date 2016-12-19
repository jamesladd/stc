package st.redline.core;

public class PrimSubclass extends PrimObject {

    public static final PrimObject PRIM_SUBCLASS = new PrimSubclass();

    protected PrimObject invoke(PrimObject receiver, PrimContext context) {
        System.out.println("PrimSubclass invoke");
        String subclassName = subclassName(context);
        PrimObject subclass = receiver.resolveObject(subclassName);
        if (subclass != null)
            return subclass;
        throw new RuntimeException("PrimSubclass should be overridden by now.");
    }

    private String subclassName(PrimContext context) {
        return String.valueOf(context.argumentJavaValueAt(0));
    }
}
