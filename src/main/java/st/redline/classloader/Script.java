package st.redline.classloader;

import st.redline.kernel.PrimObject;
import st.redline.kernel.Smalltalk;

public interface Script {

    PrimObject sendMessages(Smalltalk smalltalk);
}
