/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import st.redline.classloader.Source;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static st.redline.compiler.SmalltalkParser.*;
import static st.redline.compiler.Trace.isTraceEnabled;
import static st.redline.compiler.Trace.trace;

class SmalltalkGeneratingVisitor extends SmalltalkBaseVisitor<Void> implements SmalltalkVisitor<Void> {

    private static Log LOG = LogFactory.getLog(SmalltalkGeneratingVisitor.class);

    private final Stack<SmalltalkVisitor<Void>> visitors = new Stack<>();
    private final Stack<Statement> statements = new Stack<>();
    private final Source source;
    private final Stack<Emitter> emitters = new Stack<>();
    private Map<String, EmitterNode> temporaries = new HashMap<>();
    private Map<String, EmitterNode> arguments = new HashMap<>();
    private Map<String, EmitterNode> instanceVariables = new HashMap<>();
    private Map<String, EmitterNode> classVariables = new HashMap<>();
    private Statement lastStatementEmitted;
    private boolean isCascade;
    private boolean subclassKeywordSeen;
    private boolean addMethodSeen;
    private boolean captureInstanceVariableNames;
    private boolean captureClassVariableNames;
    private int blockId = 0;

    SmalltalkGeneratingVisitor(Source source, Emitter emitter) {
        this.source = source;
        this.emitters.push(emitter);
        visitors.push(this);
    }

    private SmalltalkVisitor<Void> visitor() {
        return visitors.peek();
    }

    @Override
    public byte[] generatedBytes() { return currentEmitter().generatedBytes(); };

    @Override
    public Void visitScript(SmalltalkParser.ScriptContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(source.fullClassName());
        currentEmitter().openClass(source);
        visitor().visitChildren(ctx);
        currentEmitter().closeClass(requiresReturn());
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
        isCascade = false;
        subclassKeywordSeen = false;
        addMethodSeen = false;
        captureInstanceVariableNames = false;
        captureClassVariableNames = false;
        newStatementMessage();
        return visitChildren(ctx);
    }

    @Override
    public Void visitCascade(SmalltalkParser.CascadeContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace("visit");
        isCascade = true;
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
        addToStatement(EmitterNode.create(STRING, ctx.STRING()));
        if (captureInstanceVariableNames)
            captureInstanceVariables(ctx);
        else if (captureClassVariableNames)
            captureClassVariables(ctx);
        return visitChildren(ctx);
    }

    private void captureInstanceVariables(StringContext ctx) {
        captureInstanceVariableNames = false;
        instanceVariables = new HashMap<>();
        splitAndMap(ctx.STRING(), instanceVariables);
    }

    private void captureClassVariables(StringContext ctx) {
        captureClassVariableNames = false;
        classVariables = new HashMap<>();
        splitAndMap(ctx.STRING(), classVariables);
    }

    @Override
    public Void visitBareSymbol(SmalltalkParser.BareSymbolContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.IDENTIFIER(), ctx.BINARY_SELECTOR(), ctx.KEYWORD(), ctx.PIPE()));
        Object node = firstNotNull(ctx.IDENTIFIER(), ctx.BINARY_SELECTOR(), ctx.KEYWORD(), ctx.PIPE());
        addToStatement(EmitterNode.create(HASH, node));
        return visitChildren(ctx);
    }

    @Override
    public Void visitStInteger(SmalltalkParser.StIntegerContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.DIGIT()));
        if (ctx.MINUS() != null) {
            ctx.DIGIT().add(0, ctx.MINUS());
        }
        addToStatement(EmitterNode.create(DIGIT, ctx.DIGIT()));
        return visitChildren(ctx);
    }

    @Override
    public Void visitCharConstant(SmalltalkParser.CharConstantContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.CHARACTER_CONSTANT()));
        addToStatement(EmitterNode.create(CHARACTER_CONSTANT, ctx.CHARACTER_CONSTANT()));
        return visitChildren(ctx);
    }

    @Override
    public Void visitPseudoVariable(SmalltalkParser.PseudoVariableContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.RESERVED_WORD()));
        addToStatement(EmitterNode.create(RESERVED_WORD, ctx.RESERVED_WORD()));
        return visitChildren(ctx);
    }

    @Override
    public Void visitKeywordPair(SmalltalkParser.KeywordPairContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.KEYWORD()));
        String keyword = ctx.KEYWORD().getText();
        if ("subclass:".equals(keyword))
            subclassKeywordSeen = true;
        captureInstanceVariableNames = subclassKeywordSeen && "instanceVariableNames:".equals(keyword);
        captureClassVariableNames = subclassKeywordSeen && "classVariableNames:".equals(keyword);
        addMethodSeen = "atSelector:put:".equals(keyword);
        if (isCascade)
            newStatementMessageTail();
        addToStatement(EmitterNode.create(KEYWORD, ctx.KEYWORD()));
        return visitChildren(ctx);
    }

    @Override
    public Void visitUnaryMessage(SmalltalkParser.UnaryMessageContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace("visit");
        newStatementMessageTail();
        return visitChildren(ctx);
    }

    @Override
    public Void visitBinaryMessage(SmalltalkParser.BinaryMessageContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.BINARY_SELECTOR()));
        newStatementMessageTail();
        addToStatement(EmitterNode.create(BINARY_SELECTOR, ctx.BINARY_SELECTOR()));
        return visitChildren(ctx);
    }

    @Override
    public Void visitUnarySelector(SmalltalkParser.UnarySelectorContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.IDENTIFIER()));
        addToStatement(EmitterNode.create(IDENTIFIER, ctx.IDENTIFIER()));
        return visitChildren(ctx);
    }

    @Override
    public Void visitVariable(SmalltalkParser.VariableContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.IDENTIFIER()));
        String value = ctx.IDENTIFIER().getText();
        if (isTemporary(value))
            addToStatement(EmitterNode.createTemporary(ctx.IDENTIFIER(), temporaryAt(value)));
        else if (isArgument(value))
            addToStatement(EmitterNode.createArgument(ctx.IDENTIFIER(), argumentAt(value)));
        else if (isInstanceVariable(value))
            addToStatement(EmitterNode.createInstanceVariable(ctx.IDENTIFIER(), instanceVariableAt(value)));
        else if (isClassVariable(value))
            addToStatement(EmitterNode.createClassVariable(ctx.IDENTIFIER(), instanceVariableAt(value)));
        else
            addToStatement(EmitterNode.createReference(ctx.IDENTIFIER()));
        return visitChildren(ctx);
    }

    @Override
    public Void visitAssignment(SmalltalkParser.AssignmentContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.ASSIGNMENT()));
        markStatementAsAssignment();
        return visitChildren(ctx);
    }

    @Override
    public Void visitTemps(SmalltalkParser.TempsContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.IDENTIFIER()));
        temporaries = new HashMap<>();
        int index = 0;
        for (TerminalNode node : ctx.IDENTIFIER())
            temporaries.put(node.getText(), EmitterNode.create(IDENTIFIER, node, index++));
        emitInitTemporaries(index);
        return visitChildren(ctx);
    }

    @Override
    public Void visitBlock(SmalltalkParser.BlockContext ctx) {
        if (isTraceEnabled(LOG))
            LOG.trace(trace(ctx.BLOCK_START()));
        int blockId = this.blockId++;
        pushBlockEmitter();
        currentEmitter().openBlock(blockId, addMethodSeen);
        visitChildren(ctx);
        String blockAnswerName = currentEmitter().closeBlock(blockId);
        if (isTraceEnabled(LOG))
            LOG.trace(blockAnswerName);
        popBlockEmitter();
        if (!addMethodSeen) {
            if (blockAnswerName != null)
                markMessageAsHavingBlockWithAnswer(blockAnswerName);
            addToStatement(EmitterNode.createBlock(ctx.BLOCK_START(), blockId));
        } else
            addToStatement(EmitterNode.createMethod(ctx.BLOCK_START(), blockId));
        addMethodSeen = false;
        return null;
    }

    private boolean isTemporary(String identifier) {
        return temporaries.containsKey(identifier);
    }

    private boolean isArgument(String identifier) {
        return arguments.containsKey(identifier);
    }

    private boolean isInstanceVariable(String identifier) {
        return instanceVariables.containsKey(identifier);
    }

    private boolean isClassVariable(String identifier) {
        return classVariables.containsKey(identifier);
    }

    private EmitterNode temporaryAt(String identifier) {
        return temporaries.get(identifier);
    }

    private EmitterNode argumentAt(String identifier) {
        return arguments.get(identifier);
    }

    private EmitterNode instanceVariableAt(String identifier) {
        return instanceVariables.get(identifier);
    }

    private Object firstNotNull(Object ... objects) {
        for (Object object : objects)
            if (object != null)
                return object;
        throw new RuntimeException("Non-Null object expected.");
    }

    private void pushBlockEmitter() {
        emitters.push(currentEmitter().blockEmitter());
    }

    private void popBlockEmitter() {
        emitters.pop();
    }

    private Emitter currentEmitter() {
        return emitters.peek();
    }

    private void addToStatement(EmitterNode node) {
        currentStatement().addToMessage(node);
    }

    private void markMessageAsHavingBlockWithAnswer(String blockAnswerName) {
        currentStatement().markMessageAsBlockWithAnswer(blockAnswerName);
    }

    private void markStatementAsAnswer() {
        currentStatement().markAsAnswer();
    }

    private void markStatementAsAssignment() {
        currentStatement().markAsAssignment();
    }

    private void newStatementMessage() {
        currentStatement().newMessage();
    }

    private void newStatementMessageTail() {
        currentStatement().newMessageTail(isCascade);
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
        currentEmitter().emit(statement);
    }

    private void emitInitTemporaries(int index) {
        currentEmitter().emitInitTemporaries(index);
    }

    private boolean requiresReturn() {
        return lastStatementEmitted != null && !lastStatementEmitted.containsAnswer();
    }

    private void splitAndMap(TerminalNode node, Map<String, EmitterNode> map) {
        int index = 0;
        String[] values = splitVariables(node.getText());
        for (String value : values)
            map.put(value, EmitterNode.create(IDENTIFIER, node, index++));
    }

    private String[] splitVariables(String text) {
        if (text.length() == 2)
            return new String[0];
        return text.substring(1, text.length() - 1).split(" ");
    }
}
