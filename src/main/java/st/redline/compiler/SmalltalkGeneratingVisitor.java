/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import st.redline.classloader.Source;

import java.util.Stack;

import static st.redline.compiler.Trace.isTraceEnabled;
import static st.redline.compiler.Trace.trace;

class SmalltalkGeneratingVisitor extends SmalltalkBaseVisitor<Void> implements SmalltalkVisitor<Void> {

    private static Log LOG = LogFactory.getLog(SmalltalkGeneratingVisitor.class);

    private final Stack<SmalltalkVisitor<Void>> visitors = new Stack<>();
    private final Stack<Statement> statements = new Stack<>();
    private final Source source;
    private final Emitter emitter;
    private Statement lastStatementEmitted;

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
            LOG.trace(source.fullClassName());
        emitter.openClass(source);
        visitor().visitChildren(ctx);
        emitter.closeClass(requiresReturn());
        if (!statements.empty())
            throw new RuntimeException("Not all statements emitted");
        return null;
    }

    @Override
    public Void visitStatementAnswer(SmalltalkParser.StatementAnswerContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace("visit");
        newStatement(new AnswerStatement());
        visitChildren(ctx);
        emitStatement();
        return null;
    }

    @Override
    public Void visitStatementExpressionsAnswer(SmalltalkParser.StatementExpressionsAnswerContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace("visit");
        newStatement(new ExpressionAnswerStatement());
        visitChildren(ctx);
        emitStatement();
        return null;
    }

    @Override
    public Void visitStatementExpressions(SmalltalkParser.StatementExpressionsContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace("visit");
        newStatement(new ExpressionsStatement());
        visitChildren(ctx);
        emitStatement();
        return null;
    }

    @Override
    public Void visitExpression(SmalltalkParser.ExpressionContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace("visit");
        newStatementMessage();
        return visitChildren(ctx);
    }

    @Override
    public Void visitAnswer(SmalltalkParser.AnswerContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.CARROT()));
        markStatementAsAnswer();
        return visitChildren(ctx);
    }

    @Override
    public Void visitString(SmalltalkParser.StringContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.STRING()));
        addToStatement(ctx.STRING());
        return visitChildren(ctx);
    }

    private void addToStatement(TerminalNode node) {
        currentStatement().addToMessage(node);
    }

    private void markStatementAsAnswer() {
        currentStatement().markAsAnswer();
    }

    private void newStatementMessage() {
        currentStatement().newMessage();
    }

    private void newStatement(Statement statement) {
        statements.push(statement);
    }

    private Statement currentStatement() {
        return statements.peek();
    }

    private void emitStatement() {
        Statement statement = statements.pop();
        lastStatementEmitted = statement;
        emitter.emit(statement);
    }

    private boolean requiresReturn() {
        return lastStatementEmitted != null && !lastStatementEmitted.isAnswer();
    }
}
