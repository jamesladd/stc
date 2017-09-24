// Generated from Smalltalk.g4 by ANTLR 4.7
package st.redline.compiler;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitSequence(SmalltalkParser.SequenceContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitWs(SmalltalkParser.WsContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitTemps(SmalltalkParser.TempsContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitStatementAnswer(SmalltalkParser.StatementAnswerContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitStatementExpressionsAnswer(SmalltalkParser.StatementExpressionsAnswerContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitStatementExpressions(SmalltalkParser.StatementExpressionsContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitAnswer(SmalltalkParser.AnswerContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitExpression(SmalltalkParser.ExpressionContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitExpressions(SmalltalkParser.ExpressionsContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitExpressionList(SmalltalkParser.ExpressionListContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitCascade(SmalltalkParser.CascadeContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitMessage(SmalltalkParser.MessageContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitAssignment(SmalltalkParser.AssignmentContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitVariable(SmalltalkParser.VariableContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBinarySend(SmalltalkParser.BinarySendContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitUnarySend(SmalltalkParser.UnarySendContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitKeywordSend(SmalltalkParser.KeywordSendContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitKeywordMessage(SmalltalkParser.KeywordMessageContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitKeywordPair(SmalltalkParser.KeywordPairContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitOperand(SmalltalkParser.OperandContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitSubexpression(SmalltalkParser.SubexpressionContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitLiteral(SmalltalkParser.LiteralContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitRuntimeLiteral(SmalltalkParser.RuntimeLiteralContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBlock(SmalltalkParser.BlockContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBlockParamList(SmalltalkParser.BlockParamListContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitDynamicDictionary(SmalltalkParser.DynamicDictionaryContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitDynamicArray(SmalltalkParser.DynamicArrayContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitParsetimeLiteral(SmalltalkParser.ParsetimeLiteralContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitNumber(SmalltalkParser.NumberContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitNumberExp(SmalltalkParser.NumberExpContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitCharConstant(SmalltalkParser.CharConstantContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitHex(SmalltalkParser.HexContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitStInteger(SmalltalkParser.StIntegerContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitStFloat(SmalltalkParser.StFloatContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitPseudoVariable(SmalltalkParser.PseudoVariableContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitString(SmalltalkParser.StringContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitSymbol(SmalltalkParser.SymbolContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitPrimitive(SmalltalkParser.PrimitiveContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBareSymbol(SmalltalkParser.BareSymbolContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitLiteralArray(SmalltalkParser.LiteralArrayContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitLiteralArrayRest(SmalltalkParser.LiteralArrayRestContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBareLiteralArray(SmalltalkParser.BareLiteralArrayContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitUnaryTail(SmalltalkParser.UnaryTailContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitUnaryMessage(SmalltalkParser.UnaryMessageContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitUnarySelector(SmalltalkParser.UnarySelectorContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitKeywords(SmalltalkParser.KeywordsContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitReference(SmalltalkParser.ReferenceContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBinaryTail(SmalltalkParser.BinaryTailContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}

	@Override
	public T visitBinaryMessage(SmalltalkParser.BinaryMessageContext ctx) {
		LOG.info("visit");
		return visitChildren(ctx);
	}
}