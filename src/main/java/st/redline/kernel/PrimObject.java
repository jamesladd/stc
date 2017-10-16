/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.kernel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrimObject {

    private static final String DNU = "doesNotUnderstand:";
    private static Log LOG = LogFactory.getLog(PrimObject.class);

    private Object javaValue;
    private PrimObject clazz = this;

    public void javaValue(Object object) {
        this.javaValue = object;
    }

    public Object javaValue() {
        return javaValue;
    }

    public String toString() {
        return String.valueOf(javaValue);
    }

    //
    // dispatch - lookup and dispatch method - start search for method in class of the receiver.
    //

    private PrimObject dispatch(PrimObject clazz, String selector, PrimObject ... arguments) {
        PrimObject searchClass = clazz;
        while (!searchClass.hasSelector(selector))
            searchClass = searchClass.superclass();
        return invoke(searchClass.methodAt(selector), selector, arguments);
    }

    private PrimObject invoke(PrimObject method, String selector, PrimObject[] arguments) {
        return method.apply(this, new PrimContext(this, method, selector, arguments));
    }

    //
    // Methods that should be overridden in a subclass - otherwise all
    // dispatches will result in a doesNotUnderstand:.
    //

    public PrimObject clazz() {
        return clazz;
    }

    public PrimObject superclass() {
        return this;
    }

    public boolean hasSelector(String selector) {
        return true;
    }

    public PrimObject apply(PrimObject receiver, PrimContext context) {
        // If we get here and the selector is 'doesNotUnderstand:' we throw an exception.
        // when the subclasses are present this will be handled by Smalltalk.
        if (DNU.equals(context.selector()))
            throw new RuntimeException(receiver + " " + DNU + " " + context.argumentAt(0) + ".");
        return receiver.perform(context.method(), DNU);
    }

    public PrimObject methodAt(String selector) {
        PrimObject dnuMethod = new PrimObject();
        dnuMethod.javaValue(selector);
        return dnuMethod;
    }

    //
    // self perform - start search for method in class of the receiver.
    //

    public PrimObject perform(String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector);
        return dispatch(clazz(), selector);
    }

    public PrimObject perform(PrimObject arg1, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1);
        return dispatch(clazz(), selector, arg1);
    }

    public PrimObject perform(PrimObject arg1, PrimObject arg2, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1 + " " + arg2);
        return dispatch(clazz(), selector, arg1, arg2);
    }

    public PrimObject perform(PrimObject arg1, PrimObject arg2, PrimObject arg3, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1 + " " + arg2 + " " + arg3);
        return dispatch(clazz(), selector, arg1, arg2, arg3);
    }

    public PrimObject perform(PrimObject arg1, PrimObject arg2, PrimObject arg3, PrimObject arg4, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1 + " " + arg2 + " " + arg3 + " " + arg4);
        return dispatch(clazz(), selector, arg1, arg2, arg3, arg4);
    }

    public PrimObject perform(PrimObject arg1, PrimObject arg2, PrimObject arg3, PrimObject arg4, PrimObject arg5, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1 + " " + arg2 + " " + arg3 + " " + arg4 + " " + arg5);
        return dispatch(clazz(), selector, arg1, arg2, arg3, arg4, arg5);
    }

    //
    // super perform - start search for method in superclass of the class of receiver.
    //
    
    public PrimObject superPerform(String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector);
        return dispatch(clazz().superclass(), selector);
    }

    public PrimObject superPerform(PrimObject arg1, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1);
        return dispatch(clazz().superclass(), selector, arg1);
    }

    public PrimObject superPerform(PrimObject arg1, PrimObject arg2, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1 + " " + arg2);
        return dispatch(clazz().superclass(), selector, arg1, arg2);
    }

    public PrimObject superPerform(PrimObject arg1, PrimObject arg2, PrimObject arg3, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1 + " " + arg2 + " " + arg3);
        return dispatch(clazz().superclass(), selector, arg1, arg2, arg3);
    }

    public PrimObject superPerform(PrimObject arg1, PrimObject arg2, PrimObject arg3, PrimObject arg4, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1 + " " + arg2 + " " + arg3 + " " + arg4);
        return dispatch(clazz().superclass(), selector, arg1, arg2, arg3, arg4);
    }

    public PrimObject superPerform(PrimObject arg1, PrimObject arg2, PrimObject arg3, PrimObject arg4, PrimObject arg5, String selector) {
        if (LOG.isTraceEnabled())
            LOG.trace(this + " " + selector + " " + arg1 + " " + arg2 + " " + arg3 + " " + arg4 + " " + arg5);
        return dispatch(clazz().superclass(), selector, arg1, arg2, arg3, arg4, arg5);
    }
}
