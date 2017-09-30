/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import st.redline.classloader.Source;

import java.util.Stack;

class SmalltalkGeneratingVisitor extends SmalltalkBaseVisitor<Void> implements SmalltalkVisitor<Void> {

    private static Log LOG = LogFactory.getLog(SmalltalkGeneratingVisitor.class);

    private final Stack<SmalltalkVisitor<Void>> visitors = new Stack<>();
    private final Source source;
    private final Emitter emitter;

    SmalltalkGeneratingVisitor(Source source, Emitter emitter) {
        this.source = source;
        this.emitter = emitter;
        visitors.push(this);
    }

    private SmalltalkVisitor<Void> visitor() {
        return visitors.peek();
    }

    @Override
    public byte[] generatedBytes() { return emitter.generatedBytes(); };

    @Override
    public Void visitScript(SmalltalkParser.ScriptContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace("visit");
        emitter.openClass(source);
        visitor().visitChildren(ctx);
        emitter.closeClass();
        return null;
    }
}
