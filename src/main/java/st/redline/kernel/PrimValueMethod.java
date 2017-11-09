/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrimValueMethod extends PrimMethod {

    private static Log LOG = LogFactory.getLog(PrimValueMethod.class);

    PrimValueMethod() {
        this.javaValue("PrimValue");
        this.function((method, receiver, context) -> {
            if (LOG.isTraceEnabled())
                LOG.trace("evaluating block value");
            return receiver.function().apply(receiver, receiver, new PrimContext(receiver, this, "value", null));
        });
    }
}
