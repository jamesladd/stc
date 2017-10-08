package st.redline.classloader;

import st.redline.kernel.PrimObject;
import st.redline.Smalltalk;

public interface Script {

    PrimObject sendMessages(Smalltalk smalltalk);
}
