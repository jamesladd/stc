/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrimObject {

    private static Log LOG = LogFactory.getLog(PrimObject.class);

    private Object javaValue;

    public PrimObject javaValue(Object object) {
        this.javaValue = object;
        return this;
    }

    public String toString() {
        return String.valueOf(javaValue);
    }

    public PrimObject perform(PrimObject arg1, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1);
        return this;
    }

    public PrimObject perform(PrimObject arg1, PrimObject arg2, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1 + " " + arg2);
        return this;
    }
}
