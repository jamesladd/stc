package st.redline.core;

public class PrimSubclass extends PrimObject {

    protected PrimObject invoke(PrimObject receiver, PrimContext context) {
        System.out.println("PrimSubclass invoke");
        return this;
    }
}
