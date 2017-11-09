/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrimMethod extends PrimObject {

    private static Log LOG = LogFactory.getLog(PrimMethod.class);

    protected TriFunction<PrimObject, PrimObject, PrimContext, PrimObject> function;

    public PrimMethod() {
        this.javaValue("PrimMethod");
    }

    public PrimObject apply(PrimObject receiver, PrimContext context) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " applying lambda");
        return function.apply(receiver, receiver, context);
    }

    public TriFunction<PrimObject, PrimObject, PrimContext, PrimObject> function() {
        return function;
    }

    public PrimObject function(TriFunction<PrimObject, PrimObject, PrimContext, PrimObject> function) {
        this.function = function;
        return this;
    }
}
