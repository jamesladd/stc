package st.redline.classloader;

import st.redline.core.*;

public class Bootstrapper {

    public void bootstrap(SmalltalkClassLoader smalltalkClassLoader) {
        smalltalkClassLoader.cacheObject("st.redline.core.PrimObject", new PrimObject());
        loadProtoObject(smalltalkClassLoader);
    }

    private void loadProtoObject(ClassLoader classLoader) {
        try {
            // Loading the class causes the 'sendMessages' java method to be called
            // which executes all the message sends of the Smalltalk source.
            classLoader.loadClass("st.redline.core.ProtoObject").newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
