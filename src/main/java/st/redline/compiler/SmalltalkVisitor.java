// Generated from Smalltalk.g4 by ANTLR 4.7
package st.redline.compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SmalltalkParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SmalltalkVisitor<T> extends ParseTreeVisitor<T> {

	byte[] generatedClassBytes();

	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(SmalltalkParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(SmalltalkParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#ws}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWs(SmalltalkParser.WsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#temps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemps(SmalltalkParser.TempsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementAnswer}
	 * labeled alternative in {@link SmalltalkParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementAnswer(SmalltalkParser.StatementAnswerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExpressionsAnswer}
	 * labeled alternative in {@link SmalltalkParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionsAnswer(SmalltalkParser.StatementExpressionsAnswerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExpressions}
	 * labeled alternative in {@link SmalltalkParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressions(SmalltalkParser.StatementExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(SmalltalkParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SmalltalkParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(SmalltalkParser.ExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(SmalltalkParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#cascade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCascade(SmalltalkParser.CascadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage(SmalltalkParser.MessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SmalltalkParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(SmalltalkParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#binarySend}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinarySend(SmalltalkParser.BinarySendContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#unarySend}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnarySend(SmalltalkParser.UnarySendContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#keywordSend}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordSend(SmalltalkParser.KeywordSendContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#keywordMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordMessage(SmalltalkParser.KeywordMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#keywordPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordPair(SmalltalkParser.KeywordPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(SmalltalkParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#subexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubexpression(SmalltalkParser.SubexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SmalltalkParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#runtimeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuntimeLiteral(SmalltalkParser.RuntimeLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SmalltalkParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#blockParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockParamList(SmalltalkParser.BlockParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#dynamicDictionary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicDictionary(SmalltalkParser.DynamicDictionaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#dynamicArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicArray(SmalltalkParser.DynamicArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#parsetimeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParsetimeLiteral(SmalltalkParser.ParsetimeLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(SmalltalkParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#numberExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExp(SmalltalkParser.NumberExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#charConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharConstant(SmalltalkParser.CharConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#hex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHex(SmalltalkParser.HexContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#stInteger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStInteger(SmalltalkParser.StIntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#stFloat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStFloat(SmalltalkParser.StFloatContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#pseudoVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPseudoVariable(SmalltalkParser.PseudoVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(SmalltalkParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(SmalltalkParser.SymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive(SmalltalkParser.PrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#bareSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBareSymbol(SmalltalkParser.BareSymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#literalArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralArray(SmalltalkParser.LiteralArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#literalArrayRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralArrayRest(SmalltalkParser.LiteralArrayRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#bareLiteralArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBareLiteralArray(SmalltalkParser.BareLiteralArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#unaryTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryTail(SmalltalkParser.UnaryTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#unaryMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMessage(SmalltalkParser.UnaryMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#unarySelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnarySelector(SmalltalkParser.UnarySelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#keywords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywords(SmalltalkParser.KeywordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(SmalltalkParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#binaryTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryTail(SmalltalkParser.BinaryTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#binaryMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryMessage(SmalltalkParser.BinaryMessageContext ctx);
}