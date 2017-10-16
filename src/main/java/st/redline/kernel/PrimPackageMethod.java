package st.redline.kernel;

import st.redline.Smalltalk;

public class PrimPackageMethod extends PrimMethod {

    PrimPackageMethod() {
        this.javaValue("Method PrimPackage");
        this.function((receiver, context) -> {
            if (!(receiver instanceof Smalltalk))
                throw new RuntimeException("Primitive package not sent to expected receiver.");
            return ((Smalltalk) receiver).currentPackage(String.valueOf(context.argumentAt(0).javaValue()));
        });
    }
}
