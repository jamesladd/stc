// Generated from Smalltalk.g4 by ANTLR 4.7
package st.redline.compiler;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static st.redline.compiler.Trace.isTraceEnabled;
import static st.redline.compiler.Trace.trace;

/**
 * This class provides an empty implementation of {@link SmalltalkVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class SmalltalkBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SmalltalkVisitor<T> {

	private static Log LOG = LogFactory.getLog(SmalltalkBaseVisitor.class);

	public byte[] generatedBytes() { return null; };

	@Override
	public T visitScript(SmalltalkParser.ScriptContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitSequence(SmalltalkParser.SequenceContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitWs(SmalltalkParser.WsContext ctx) {
//		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitTemps(SmalltalkParser.TempsContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitStatementAnswer(SmalltalkParser.StatementAnswerContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitStatementExpressionsAnswer(SmalltalkParser.StatementExpressionsAnswerContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitStatementExpressions(SmalltalkParser.StatementExpressionsContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitAnswer(SmalltalkParser.AnswerContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace(trace(ctx.CARROT()));
		return visitChildren(ctx);
	}

	@Override
	public T visitExpression(SmalltalkParser.ExpressionContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitExpressions(SmalltalkParser.ExpressionsContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitExpressionList(SmalltalkParser.ExpressionListContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitCascade(SmalltalkParser.CascadeContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitMessage(SmalltalkParser.MessageContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitAssignment(SmalltalkParser.AssignmentContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitVariable(SmalltalkParser.VariableContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace(trace(ctx.IDENTIFIER()));
		return visitChildren(ctx);
	}

	@Override
	public T visitBinarySend(SmalltalkParser.BinarySendContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitUnarySend(SmalltalkParser.UnarySendContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitKeywordSend(SmalltalkParser.KeywordSendContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitKeywordMessage(SmalltalkParser.KeywordMessageContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitKeywordPair(SmalltalkParser.KeywordPairContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace(trace(ctx.KEYWORD()));
		return visitChildren(ctx);
	}

	@Override
	public T visitOperand(SmalltalkParser.OperandContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitSubexpression(SmalltalkParser.SubexpressionContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitLiteral(SmalltalkParser.LiteralContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitRuntimeLiteral(SmalltalkParser.RuntimeLiteralContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBlock(SmalltalkParser.BlockContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace(trace(ctx.BLOCK_START()));
		return visitChildren(ctx);
	}

	@Override
	public T visitBlockParamList(SmalltalkParser.BlockParamListContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitDynamicDictionary(SmalltalkParser.DynamicDictionaryContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitDynamicArray(SmalltalkParser.DynamicArrayContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitParsetimeLiteral(SmalltalkParser.ParsetimeLiteralContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitNumber(SmalltalkParser.NumberContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitNumberExp(SmalltalkParser.NumberExpContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitCharConstant(SmalltalkParser.CharConstantContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace(trace(ctx.CHARACTER_CONSTANT()));
		return visitChildren(ctx);
	}

	@Override
	public T visitHex(SmalltalkParser.HexContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitStInteger(SmalltalkParser.StIntegerContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitStFloat(SmalltalkParser.StFloatContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitPseudoVariable(SmalltalkParser.PseudoVariableContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace(trace(ctx.RESERVED_WORD()));
		return visitChildren(ctx);
	}

	@Override
	public T visitString(SmalltalkParser.StringContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace(trace(ctx.STRING()));
		return visitChildren(ctx);
	}

	@Override
	public T visitSymbol(SmalltalkParser.SymbolContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace(ctx.HASH());
		return visitChildren(ctx);
	}

	@Override
	public T visitPrimitive(SmalltalkParser.PrimitiveContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBareSymbol(SmalltalkParser.BareSymbolContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace(trace(ctx.IDENTIFIER(), ctx.BINARY_SELECTOR(), ctx.KEYWORD(), ctx.PIPE()));
		return visitChildren(ctx);
	}

	@Override
	public T visitLiteralArray(SmalltalkParser.LiteralArrayContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitLiteralArrayRest(SmalltalkParser.LiteralArrayRestContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBareLiteralArray(SmalltalkParser.BareLiteralArrayContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitUnaryTail(SmalltalkParser.UnaryTailContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitUnaryMessage(SmalltalkParser.UnaryMessageContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitUnarySelector(SmalltalkParser.UnarySelectorContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace(trace(ctx.IDENTIFIER()));
		return visitChildren(ctx);
	}

	@Override
	public T visitKeywords(SmalltalkParser.KeywordsContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitReference(SmalltalkParser.ReferenceContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBinaryTail(SmalltalkParser.BinaryTailContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBinaryMessage(SmalltalkParser.BinaryMessageContext ctx) {
		if (isTraceEnabled(LOG))
			LOG.trace(trace(ctx.BINARY_SELECTOR()));
		return visitChildren(ctx);
	}
}