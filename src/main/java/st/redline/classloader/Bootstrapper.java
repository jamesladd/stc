package st.redline.classloader;

import st.redline.core.*;

public class Bootstrapper {

    public void bootstrap(SmalltalkClassLoader smalltalkClassLoader) {
        smalltalkClassLoader.cacheObject("st.redline.core.PrimObject", new PrimObject());
    }
}
