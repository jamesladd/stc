/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import st.redline.RedlineSmalltalk;
import st.redline.Smalltalk;

public class PrimObject {

    void foo() {
        bar(new RedlineSmalltalk());
    }

    private void bar(Smalltalk smalltalk) {
        smalltalk.createString("hello");
    }
}
