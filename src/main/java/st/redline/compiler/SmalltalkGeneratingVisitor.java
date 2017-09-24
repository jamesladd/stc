/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.objectweb.asm.*;
import st.redline.classloader.Source;

class SmalltalkGeneratingVisitor extends SmalltalkBaseVisitor<Void> implements SmalltalkVisitor<Void>, Opcodes {

    private static Log LOG = LogFactory.getLog(SmalltalkGeneratingVisitor.class);

    private final Source source;

    SmalltalkGeneratingVisitor(Source source) {
        this.source = source;
    }

    @Override
    public Void visitScript(SmalltalkParser.ScriptContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitSequence(SmalltalkParser.SequenceContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitWs(SmalltalkParser.WsContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitTemps(SmalltalkParser.TempsContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitStatementAnswer(SmalltalkParser.StatementAnswerContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitStatementExpressionsAnswer(SmalltalkParser.StatementExpressionsAnswerContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitStatementExpressions(SmalltalkParser.StatementExpressionsContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitAnswer(SmalltalkParser.AnswerContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitExpression(SmalltalkParser.ExpressionContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitExpressions(SmalltalkParser.ExpressionsContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitExpressionList(SmalltalkParser.ExpressionListContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitCascade(SmalltalkParser.CascadeContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitMessage(SmalltalkParser.MessageContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitAssignment(SmalltalkParser.AssignmentContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitVariable(SmalltalkParser.VariableContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitBinarySend(SmalltalkParser.BinarySendContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitUnarySend(SmalltalkParser.UnarySendContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitKeywordSend(SmalltalkParser.KeywordSendContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitKeywordMessage(SmalltalkParser.KeywordMessageContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitKeywordPair(SmalltalkParser.KeywordPairContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitOperand(SmalltalkParser.OperandContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitSubexpression(SmalltalkParser.SubexpressionContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitLiteral(SmalltalkParser.LiteralContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitRuntimeLiteral(SmalltalkParser.RuntimeLiteralContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitBlock(SmalltalkParser.BlockContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitBlockParamList(SmalltalkParser.BlockParamListContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitDynamicDictionary(SmalltalkParser.DynamicDictionaryContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitDynamicArray(SmalltalkParser.DynamicArrayContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitParsetimeLiteral(SmalltalkParser.ParsetimeLiteralContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitNumber(SmalltalkParser.NumberContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitNumberExp(SmalltalkParser.NumberExpContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitCharConstant(SmalltalkParser.CharConstantContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitHex(SmalltalkParser.HexContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitStInteger(SmalltalkParser.StIntegerContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitStFloat(SmalltalkParser.StFloatContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitPseudoVariable(SmalltalkParser.PseudoVariableContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitString(SmalltalkParser.StringContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitSymbol(SmalltalkParser.SymbolContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitPrimitive(SmalltalkParser.PrimitiveContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitBareSymbol(SmalltalkParser.BareSymbolContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitLiteralArray(SmalltalkParser.LiteralArrayContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitLiteralArrayRest(SmalltalkParser.LiteralArrayRestContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitBareLiteralArray(SmalltalkParser.BareLiteralArrayContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitUnaryTail(SmalltalkParser.UnaryTailContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitUnaryMessage(SmalltalkParser.UnaryMessageContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitUnarySelector(SmalltalkParser.UnarySelectorContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitKeywords(SmalltalkParser.KeywordsContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitReference(SmalltalkParser.ReferenceContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitBinaryTail(SmalltalkParser.BinaryTailContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }

    @Override
    public Void visitBinaryMessage(SmalltalkParser.BinaryMessageContext ctx) {
        LOG.info("visit");
        return visitChildren(ctx);
    }
}
