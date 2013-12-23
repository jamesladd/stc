// Generated from Smalltalk.g4 by ANTLR 4.1
package st.redline.compiler;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmalltalkParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PIPE=1, PERIOD=2, CARROT=3, COLON=4, SEMI_COLON=5, ASSIGNMENT=6, MINUS=7, 
		HASH=8, DOLLAR=9, EXP=10, HEX=11, LITARR_START=12, CLOSE_PAREN=13, OPEN_PAREN=14, 
		DYNDICT_START=15, DYNARR_END=16, DYNARR_START=17, BLOCK_START=18, BLOCK_END=19, 
		LT=20, GT=21, RESERVED_WORD=22, DIGIT=23, DIGITS=24, HEXDIGIT=25, BINARY_SELECTOR=26, 
		IDENTIFIER=27, KEYWORD=28, BLOCK_PARAM=29, CHARACTER_CONSTANT=30, SEPARATOR=31, 
		STRING=32, COMMENT=33;
	public static final String[] tokenNames = {
		"<INVALID>", "'|'", "'.'", "'^'", "':'", "';'", "':='", "'-'", "'#'", 
		"'$'", "'e'", "'16r'", "'#('", "')'", "'('", "'#{'", "'}'", "'{'", "'['", 
		"']'", "'<'", "'>'", "RESERVED_WORD", "DIGIT", "DIGITS", "HEXDIGIT", "BINARY_SELECTOR", 
		"IDENTIFIER", "KEYWORD", "BLOCK_PARAM", "CHARACTER_CONSTANT", "SEPARATOR", 
		"STRING", "COMMENT"
	};
	public static final int
		RULE_script = 0, RULE_sequence = 1, RULE_ws = 2, RULE_temps = 3, RULE_statements = 4, 
		RULE_answer = 5, RULE_expression = 6, RULE_expressions = 7, RULE_expressionList = 8, 
		RULE_cascade = 9, RULE_message = 10, RULE_assignment = 11, RULE_variable = 12, 
		RULE_binarySend = 13, RULE_unarySend = 14, RULE_keywordSend = 15, RULE_keywordMessage = 16, 
		RULE_keywordPair = 17, RULE_operand = 18, RULE_subexpression = 19, RULE_literal = 20, 
		RULE_runtimeLiteral = 21, RULE_block = 22, RULE_blockParamList = 23, RULE_dynamicDictionary = 24, 
		RULE_dynamicArray = 25, RULE_parsetimeLiteral = 26, RULE_number = 27, 
		RULE_numberExp = 28, RULE_charConstant = 29, RULE_hex = 30, RULE_stInteger = 31, 
		RULE_stFloat = 32, RULE_pseudoVariable = 33, RULE_string = 34, RULE_symbol = 35, 
		RULE_primitive = 36, RULE_bareSymbol = 37, RULE_literalArray = 38, RULE_literalArrayRest = 39, 
		RULE_bareLiteralArray = 40, RULE_parseTimeLiteral = 41, RULE_unaryTail = 42, 
		RULE_unaryMessage = 43, RULE_unarySelector = 44, RULE_keywords = 45, RULE_reference = 46, 
		RULE_binaryTail = 47, RULE_binaryMessage = 48;
	public static final String[] ruleNames = {
		"script", "sequence", "ws", "temps", "statements", "answer", "expression", 
		"expressions", "expressionList", "cascade", "message", "assignment", "variable", 
		"binarySend", "unarySend", "keywordSend", "keywordMessage", "keywordPair", 
		"operand", "subexpression", "literal", "runtimeLiteral", "block", "blockParamList", 
		"dynamicDictionary", "dynamicArray", "parsetimeLiteral", "number", "numberExp", 
		"charConstant", "hex", "stInteger", "stFloat", "pseudoVariable", "string", 
		"symbol", "primitive", "bareSymbol", "literalArray", "literalArrayRest", 
		"bareLiteralArray", "parseTimeLiteral", "unaryTail", "unaryMessage", "unarySelector", 
		"keywords", "reference", "binaryTail", "binaryMessage"
	};

	@Override
	public String getGrammarFileName() { return "Smalltalk.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public SmalltalkParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ScriptContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SmalltalkParser.EOF, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); sequence();
			setState(99); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SequenceContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TempsContext temps() {
			return getRuleContext(TempsContext.class,0);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); ws();
			setState(103);
			_la = _input.LA(1);
			if (_la==PIPE) {
				{
				setState(102); temps();
				}
			}

			setState(105); ws();
			setState(107);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(106); statements();
				}
				break;
			}
			setState(109); ws();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WsContext extends ParserRuleContext {
		public TerminalNode SEPARATOR(int i) {
			return getToken(SmalltalkParser.SEPARATOR, i);
		}
		public TerminalNode COMMENT(int i) {
			return getToken(SmalltalkParser.COMMENT, i);
		}
		public List<TerminalNode> SEPARATOR() { return getTokens(SmalltalkParser.SEPARATOR); }
		public List<TerminalNode> COMMENT() { return getTokens(SmalltalkParser.COMMENT); }
		public WsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ws; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitWs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WsContext ws() throws RecognitionException {
		WsContext _localctx = new WsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ws);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(111);
					_la = _input.LA(1);
					if ( !(_la==SEPARATOR || _la==COMMENT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TempsContext extends ParserRuleContext {
		public List<TerminalNode> PIPE() { return getTokens(SmalltalkParser.PIPE); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SmalltalkParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(SmalltalkParser.IDENTIFIER); }
		public TerminalNode PIPE(int i) {
			return getToken(SmalltalkParser.PIPE, i);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public TempsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temps; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitTemps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TempsContext temps() throws RecognitionException {
		TempsContext _localctx = new TempsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_temps);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(PIPE);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(118); ws();
					setState(119); match(IDENTIFIER);
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(126); ws();
			setState(127); match(PIPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public AnswerContext answer() {
			return getRuleContext(AnswerContext.class,0);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public TerminalNode PERIOD() { return getToken(SmalltalkParser.PERIOD, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statements);
		int _la;
		try {
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129); answer();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130); expressions();
				setState(131); ws();
				setState(132); match(PERIOD);
				setState(133); ws();
				setState(134); answer();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136); expressions();
				setState(138);
				_la = _input.LA(1);
				if (_la==PERIOD) {
					{
					setState(137); match(PERIOD);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnswerContext extends ParserRuleContext {
		public TerminalNode CARROT() { return getToken(SmalltalkParser.CARROT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public TerminalNode PERIOD() { return getToken(SmalltalkParser.PERIOD, 0); }
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); match(CARROT);
			setState(143); ws();
			setState(144); expression();
			setState(145); ws();
			setState(147);
			_la = _input.LA(1);
			if (_la==PERIOD) {
				{
				setState(146); match(PERIOD);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public BinarySendContext binarySend() {
			return getRuleContext(BinarySendContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public KeywordSendContext keywordSend() {
			return getRuleContext(KeywordSendContext.class,0);
		}
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public CascadeContext cascade() {
			return getRuleContext(CascadeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expression);
		try {
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149); assignment();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150); cascade();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151); keywordSend();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(152); binarySend();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(153); primitive();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionsContext extends ParserRuleContext {
		public List<ExpressionListContext> expressionList() {
			return getRuleContexts(ExpressionListContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionListContext expressionList(int i) {
			return getRuleContext(ExpressionListContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expressions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156); expression();
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(157); expressionList();
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public TerminalNode PERIOD() { return getToken(SmalltalkParser.PERIOD, 0); }
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expressionList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); ws();
			setState(164); match(PERIOD);
			setState(165); ws();
			setState(166); expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CascadeContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON(int i) {
			return getToken(SmalltalkParser.SEMI_COLON, i);
		}
		public List<TerminalNode> SEMI_COLON() { return getTokens(SmalltalkParser.SEMI_COLON); }
		public List<MessageContext> message() {
			return getRuleContexts(MessageContext.class);
		}
		public BinarySendContext binarySend() {
			return getRuleContext(BinarySendContext.class,0);
		}
		public KeywordSendContext keywordSend() {
			return getRuleContext(KeywordSendContext.class,0);
		}
		public MessageContext message(int i) {
			return getRuleContext(MessageContext.class,i);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public CascadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cascade; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitCascade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CascadeContext cascade() throws RecognitionException {
		CascadeContext _localctx = new CascadeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cascade);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168); ws();
			setState(171);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(169); keywordSend();
				}
				break;

			case 2:
				{
				setState(170); binarySend();
				}
				break;
			}
			setState(179); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(173); ws();
					setState(174); match(SEMI_COLON);
					setState(175); ws();
					setState(176); message();
					setState(177); ws();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(181); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageContext extends ParserRuleContext {
		public BinaryMessageContext binaryMessage() {
			return getRuleContext(BinaryMessageContext.class,0);
		}
		public KeywordMessageContext keywordMessage() {
			return getRuleContext(KeywordMessageContext.class,0);
		}
		public UnaryMessageContext unaryMessage() {
			return getRuleContext(UnaryMessageContext.class,0);
		}
		public MessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageContext message() throws RecognitionException {
		MessageContext _localctx = new MessageContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_message);
		try {
			setState(186);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183); binaryMessage();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184); unaryMessage();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(185); keywordMessage();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(SmalltalkParser.ASSIGNMENT, 0); }
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); variable();
			setState(189); ws();
			setState(190); match(ASSIGNMENT);
			setState(191); ws();
			setState(192); expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SmalltalkParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinarySendContext extends ParserRuleContext {
		public BinaryTailContext binaryTail() {
			return getRuleContext(BinaryTailContext.class,0);
		}
		public UnarySendContext unarySend() {
			return getRuleContext(UnarySendContext.class,0);
		}
		public BinarySendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binarySend; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitBinarySend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinarySendContext binarySend() throws RecognitionException {
		BinarySendContext _localctx = new BinarySendContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_binarySend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); unarySend();
			setState(198);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(197); binaryTail();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnarySendContext extends ParserRuleContext {
		public UnaryTailContext unaryTail() {
			return getRuleContext(UnaryTailContext.class,0);
		}
		public WsContext ws() {
			return getRuleContext(WsContext.class,0);
		}
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public UnarySendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unarySend; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitUnarySend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnarySendContext unarySend() throws RecognitionException {
		UnarySendContext _localctx = new UnarySendContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unarySend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); operand();
			setState(201); ws();
			setState(203);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(202); unaryTail();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordSendContext extends ParserRuleContext {
		public KeywordMessageContext keywordMessage() {
			return getRuleContext(KeywordMessageContext.class,0);
		}
		public BinarySendContext binarySend() {
			return getRuleContext(BinarySendContext.class,0);
		}
		public KeywordSendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordSend; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitKeywordSend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordSendContext keywordSend() throws RecognitionException {
		KeywordSendContext _localctx = new KeywordSendContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_keywordSend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205); binarySend();
			setState(206); keywordMessage();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordMessageContext extends ParserRuleContext {
		public List<KeywordPairContext> keywordPair() {
			return getRuleContexts(KeywordPairContext.class);
		}
		public KeywordPairContext keywordPair(int i) {
			return getRuleContext(KeywordPairContext.class,i);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public KeywordMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordMessage; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitKeywordMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordMessageContext keywordMessage() throws RecognitionException {
		KeywordMessageContext _localctx = new KeywordMessageContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_keywordMessage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208); ws();
			setState(212); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(209); keywordPair();
				setState(210); ws();
				}
				}
				setState(214); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KEYWORD );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordPairContext extends ParserRuleContext {
		public BinarySendContext binarySend() {
			return getRuleContext(BinarySendContext.class,0);
		}
		public TerminalNode KEYWORD() { return getToken(SmalltalkParser.KEYWORD, 0); }
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public KeywordPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordPair; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitKeywordPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordPairContext keywordPair() throws RecognitionException {
		KeywordPairContext _localctx = new KeywordPairContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_keywordPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); match(KEYWORD);
			setState(217); ws();
			setState(218); binarySend();
			setState(219); ws();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandContext extends ParserRuleContext {
		public SubexpressionContext subexpression() {
			return getRuleContext(SubexpressionContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_operand);
		try {
			setState(224);
			switch (_input.LA(1)) {
			case MINUS:
			case HASH:
			case HEX:
			case LITARR_START:
			case DYNDICT_START:
			case DYNARR_START:
			case BLOCK_START:
			case RESERVED_WORD:
			case DIGITS:
			case CHARACTER_CONSTANT:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(221); literal();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(222); reference();
				}
				break;
			case OPEN_PAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(223); subexpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubexpressionContext extends ParserRuleContext {
		public TerminalNode CLOSE_PAREN() { return getToken(SmalltalkParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(SmalltalkParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public SubexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subexpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitSubexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubexpressionContext subexpression() throws RecognitionException {
		SubexpressionContext _localctx = new SubexpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_subexpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); match(OPEN_PAREN);
			setState(227); ws();
			setState(228); expression();
			setState(229); ws();
			setState(230); match(CLOSE_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public RuntimeLiteralContext runtimeLiteral() {
			return getRuleContext(RuntimeLiteralContext.class,0);
		}
		public ParsetimeLiteralContext parsetimeLiteral() {
			return getRuleContext(ParsetimeLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literal);
		try {
			setState(234);
			switch (_input.LA(1)) {
			case DYNDICT_START:
			case DYNARR_START:
			case BLOCK_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(232); runtimeLiteral();
				}
				break;
			case MINUS:
			case HASH:
			case HEX:
			case LITARR_START:
			case RESERVED_WORD:
			case DIGITS:
			case CHARACTER_CONSTANT:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(233); parsetimeLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuntimeLiteralContext extends ParserRuleContext {
		public DynamicArrayContext dynamicArray() {
			return getRuleContext(DynamicArrayContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DynamicDictionaryContext dynamicDictionary() {
			return getRuleContext(DynamicDictionaryContext.class,0);
		}
		public RuntimeLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_runtimeLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitRuntimeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuntimeLiteralContext runtimeLiteral() throws RecognitionException {
		RuntimeLiteralContext _localctx = new RuntimeLiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_runtimeLiteral);
		try {
			setState(239);
			switch (_input.LA(1)) {
			case DYNDICT_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(236); dynamicDictionary();
				}
				break;
			case DYNARR_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(237); dynamicArray();
				}
				break;
			case BLOCK_START:
				enterOuterAlt(_localctx, 3);
				{
				setState(238); block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public BlockParamListContext blockParamList() {
			return getRuleContext(BlockParamListContext.class,0);
		}
		public WsContext ws() {
			return getRuleContext(WsContext.class,0);
		}
		public TerminalNode BLOCK_END() { return getToken(SmalltalkParser.BLOCK_END, 0); }
		public TerminalNode BLOCK_START() { return getToken(SmalltalkParser.BLOCK_START, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241); match(BLOCK_START);
			setState(243);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(242); blockParamList();
				}
				break;
			}
			setState(246);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(245); sequence();
				}
				break;
			}
			setState(248); ws();
			setState(249); match(BLOCK_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockParamListContext extends ParserRuleContext {
		public TerminalNode PIPE() { return getToken(SmalltalkParser.PIPE, 0); }
		public List<TerminalNode> BLOCK_PARAM() { return getTokens(SmalltalkParser.BLOCK_PARAM); }
		public TerminalNode BLOCK_PARAM(int i) {
			return getToken(SmalltalkParser.BLOCK_PARAM, i);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public BlockParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockParamList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitBlockParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockParamListContext blockParamList() throws RecognitionException {
		BlockParamListContext _localctx = new BlockParamListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_blockParamList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(254); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(251); ws();
					setState(252); match(BLOCK_PARAM);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(256); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(258); ws();
			setState(260);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(259); match(PIPE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DynamicDictionaryContext extends ParserRuleContext {
		public TerminalNode DYNARR_END() { return getToken(SmalltalkParser.DYNARR_END, 0); }
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public TerminalNode DYNDICT_START() { return getToken(SmalltalkParser.DYNDICT_START, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public DynamicDictionaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dynamicDictionary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitDynamicDictionary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DynamicDictionaryContext dynamicDictionary() throws RecognitionException {
		DynamicDictionaryContext _localctx = new DynamicDictionaryContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_dynamicDictionary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(DYNDICT_START);
			setState(263); ws();
			setState(265);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(264); expressions();
				}
				break;
			}
			setState(267); ws();
			setState(268); match(DYNARR_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DynamicArrayContext extends ParserRuleContext {
		public TerminalNode DYNARR_END() { return getToken(SmalltalkParser.DYNARR_END, 0); }
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode DYNARR_START() { return getToken(SmalltalkParser.DYNARR_START, 0); }
		public DynamicArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dynamicArray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitDynamicArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DynamicArrayContext dynamicArray() throws RecognitionException {
		DynamicArrayContext _localctx = new DynamicArrayContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_dynamicArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); match(DYNARR_START);
			setState(271); ws();
			setState(273);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(272); expressions();
				}
				break;
			}
			setState(275); ws();
			setState(276); match(DYNARR_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParsetimeLiteralContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public PseudoVariableContext pseudoVariable() {
			return getRuleContext(PseudoVariableContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public CharConstantContext charConstant() {
			return getRuleContext(CharConstantContext.class,0);
		}
		public LiteralArrayContext literalArray() {
			return getRuleContext(LiteralArrayContext.class,0);
		}
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public ParsetimeLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parsetimeLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitParsetimeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParsetimeLiteralContext parsetimeLiteral() throws RecognitionException {
		ParsetimeLiteralContext _localctx = new ParsetimeLiteralContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_parsetimeLiteral);
		try {
			setState(284);
			switch (_input.LA(1)) {
			case RESERVED_WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(278); pseudoVariable();
				}
				break;
			case MINUS:
			case HEX:
			case DIGITS:
				enterOuterAlt(_localctx, 2);
				{
				setState(279); number();
				}
				break;
			case CHARACTER_CONSTANT:
				enterOuterAlt(_localctx, 3);
				{
				setState(280); charConstant();
				}
				break;
			case LITARR_START:
				enterOuterAlt(_localctx, 4);
				{
				setState(281); literalArray();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(282); string();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 6);
				{
				setState(283); symbol();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public StIntegerContext stInteger() {
			return getRuleContext(StIntegerContext.class,0);
		}
		public NumberExpContext numberExp() {
			return getRuleContext(NumberExpContext.class,0);
		}
		public HexContext hex() {
			return getRuleContext(HexContext.class,0);
		}
		public StFloatContext stFloat() {
			return getRuleContext(StFloatContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_number);
		try {
			setState(290);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286); numberExp();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287); hex();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(288); stFloat();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(289); stInteger();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberExpContext extends ParserRuleContext {
		public StIntegerContext stInteger(int i) {
			return getRuleContext(StIntegerContext.class,i);
		}
		public List<StIntegerContext> stInteger() {
			return getRuleContexts(StIntegerContext.class);
		}
		public TerminalNode EXP() { return getToken(SmalltalkParser.EXP, 0); }
		public StFloatContext stFloat() {
			return getRuleContext(StFloatContext.class,0);
		}
		public NumberExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitNumberExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberExpContext numberExp() throws RecognitionException {
		NumberExpContext _localctx = new NumberExpContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_numberExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(292); stFloat();
				}
				break;

			case 2:
				{
				setState(293); stInteger();
				}
				break;
			}
			setState(296); match(EXP);
			setState(297); stInteger();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CharConstantContext extends ParserRuleContext {
		public TerminalNode CHARACTER_CONSTANT() { return getToken(SmalltalkParser.CHARACTER_CONSTANT, 0); }
		public CharConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charConstant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitCharConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharConstantContext charConstant() throws RecognitionException {
		CharConstantContext _localctx = new CharConstantContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_charConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299); match(CHARACTER_CONSTANT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HexContext extends ParserRuleContext {
		public List<TerminalNode> HEXDIGIT() { return getTokens(SmalltalkParser.HEXDIGIT); }
		public TerminalNode HEXDIGIT(int i) {
			return getToken(SmalltalkParser.HEXDIGIT, i);
		}
		public TerminalNode MINUS() { return getToken(SmalltalkParser.MINUS, 0); }
		public TerminalNode HEX() { return getToken(SmalltalkParser.HEX, 0); }
		public HexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitHex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HexContext hex() throws RecognitionException {
		HexContext _localctx = new HexContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_hex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(301); match(MINUS);
				}
			}

			setState(304); match(HEX);
			setState(306); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(305); match(HEXDIGIT);
				}
				}
				setState(308); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HEXDIGIT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StIntegerContext extends ParserRuleContext {
		public TerminalNode DIGITS() { return getToken(SmalltalkParser.DIGITS, 0); }
		public TerminalNode MINUS() { return getToken(SmalltalkParser.MINUS, 0); }
		public StIntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stInteger; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitStInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StIntegerContext stInteger() throws RecognitionException {
		StIntegerContext _localctx = new StIntegerContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_stInteger);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(310); match(MINUS);
				}
			}

			setState(313); match(DIGITS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StFloatContext extends ParserRuleContext {
		public List<TerminalNode> DIGITS() { return getTokens(SmalltalkParser.DIGITS); }
		public TerminalNode DIGITS(int i) {
			return getToken(SmalltalkParser.DIGITS, i);
		}
		public TerminalNode MINUS() { return getToken(SmalltalkParser.MINUS, 0); }
		public TerminalNode PERIOD() { return getToken(SmalltalkParser.PERIOD, 0); }
		public StFloatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stFloat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitStFloat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StFloatContext stFloat() throws RecognitionException {
		StFloatContext _localctx = new StFloatContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_stFloat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(315); match(MINUS);
				}
			}

			setState(318); match(DIGITS);
			setState(319); match(PERIOD);
			setState(320); match(DIGITS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PseudoVariableContext extends ParserRuleContext {
		public TerminalNode RESERVED_WORD() { return getToken(SmalltalkParser.RESERVED_WORD, 0); }
		public PseudoVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pseudoVariable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitPseudoVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PseudoVariableContext pseudoVariable() throws RecognitionException {
		PseudoVariableContext _localctx = new PseudoVariableContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_pseudoVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322); match(RESERVED_WORD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SmalltalkParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SymbolContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(SmalltalkParser.HASH, 0); }
		public BareSymbolContext bareSymbol() {
			return getRuleContext(BareSymbolContext.class,0);
		}
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_symbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); match(HASH);
			setState(327); bareSymbol();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveContext extends ParserRuleContext {
		public TerminalNode DIGITS() { return getToken(SmalltalkParser.DIGITS, 0); }
		public TerminalNode KEYWORD() { return getToken(SmalltalkParser.KEYWORD, 0); }
		public TerminalNode LT() { return getToken(SmalltalkParser.LT, 0); }
		public TerminalNode GT() { return getToken(SmalltalkParser.GT, 0); }
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_primitive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329); match(LT);
			setState(330); ws();
			setState(331); match(KEYWORD);
			setState(332); ws();
			setState(333); match(DIGITS);
			setState(334); ws();
			setState(335); match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BareSymbolContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public List<TerminalNode> KEYWORD() { return getTokens(SmalltalkParser.KEYWORD); }
		public TerminalNode IDENTIFIER() { return getToken(SmalltalkParser.IDENTIFIER, 0); }
		public TerminalNode BINARY_SELECTOR() { return getToken(SmalltalkParser.BINARY_SELECTOR, 0); }
		public TerminalNode KEYWORD(int i) {
			return getToken(SmalltalkParser.KEYWORD, i);
		}
		public BareSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bareSymbol; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitBareSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BareSymbolContext bareSymbol() throws RecognitionException {
		BareSymbolContext _localctx = new BareSymbolContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_bareSymbol);
		int _la;
		try {
			int _alt;
			setState(344);
			switch (_input.LA(1)) {
			case BINARY_SELECTOR:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				_la = _input.LA(1);
				if ( !(_la==BINARY_SELECTOR || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case KEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(339); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(338); match(KEYWORD);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(341); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(343); string();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralArrayContext extends ParserRuleContext {
		public TerminalNode LITARR_START() { return getToken(SmalltalkParser.LITARR_START, 0); }
		public LiteralArrayRestContext literalArrayRest() {
			return getRuleContext(LiteralArrayRestContext.class,0);
		}
		public LiteralArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalArray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitLiteralArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralArrayContext literalArray() throws RecognitionException {
		LiteralArrayContext _localctx = new LiteralArrayContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_literalArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346); match(LITARR_START);
			setState(347); literalArrayRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralArrayRestContext extends ParserRuleContext {
		public TerminalNode CLOSE_PAREN() { return getToken(SmalltalkParser.CLOSE_PAREN, 0); }
		public List<BareLiteralArrayContext> bareLiteralArray() {
			return getRuleContexts(BareLiteralArrayContext.class);
		}
		public BareLiteralArrayContext bareLiteralArray(int i) {
			return getRuleContext(BareLiteralArrayContext.class,i);
		}
		public List<BareSymbolContext> bareSymbol() {
			return getRuleContexts(BareSymbolContext.class);
		}
		public BareSymbolContext bareSymbol(int i) {
			return getRuleContext(BareSymbolContext.class,i);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public ParsetimeLiteralContext parsetimeLiteral(int i) {
			return getRuleContext(ParsetimeLiteralContext.class,i);
		}
		public List<ParsetimeLiteralContext> parsetimeLiteral() {
			return getRuleContexts(ParsetimeLiteralContext.class);
		}
		public LiteralArrayRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalArrayRest; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitLiteralArrayRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralArrayRestContext literalArrayRest() throws RecognitionException {
		LiteralArrayRestContext _localctx = new LiteralArrayRestContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_literalArrayRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349); ws();
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << HASH) | (1L << HEX) | (1L << LITARR_START) | (1L << OPEN_PAREN) | (1L << RESERVED_WORD) | (1L << DIGITS) | (1L << BINARY_SELECTOR) | (1L << IDENTIFIER) | (1L << KEYWORD) | (1L << CHARACTER_CONSTANT) | (1L << STRING))) != 0)) {
				{
				{
				setState(353);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(350); parsetimeLiteral();
					}
					break;

				case 2:
					{
					setState(351); bareLiteralArray();
					}
					break;

				case 3:
					{
					setState(352); bareSymbol();
					}
					break;
				}
				setState(355); ws();
				}
				}
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(362); match(CLOSE_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BareLiteralArrayContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(SmalltalkParser.OPEN_PAREN, 0); }
		public LiteralArrayRestContext literalArrayRest() {
			return getRuleContext(LiteralArrayRestContext.class,0);
		}
		public BareLiteralArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bareLiteralArray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitBareLiteralArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BareLiteralArrayContext bareLiteralArray() throws RecognitionException {
		BareLiteralArrayContext _localctx = new BareLiteralArrayContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_bareLiteralArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364); match(OPEN_PAREN);
			setState(365); literalArrayRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParseTimeLiteralContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public PseudoVariableContext pseudoVariable() {
			return getRuleContext(PseudoVariableContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public LiteralArrayContext literalArray() {
			return getRuleContext(LiteralArrayContext.class,0);
		}
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public ParseTimeLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseTimeLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitParseTimeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseTimeLiteralContext parseTimeLiteral() throws RecognitionException {
		ParseTimeLiteralContext _localctx = new ParseTimeLiteralContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_parseTimeLiteral);
		try {
			setState(372);
			switch (_input.LA(1)) {
			case RESERVED_WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(367); pseudoVariable();
				}
				break;
			case MINUS:
			case HEX:
			case DIGITS:
				enterOuterAlt(_localctx, 2);
				{
				setState(368); number();
				}
				break;
			case LITARR_START:
				enterOuterAlt(_localctx, 3);
				{
				setState(369); literalArray();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(370); string();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 5);
				{
				setState(371); symbol();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryTailContext extends ParserRuleContext {
		public UnaryTailContext unaryTail() {
			return getRuleContext(UnaryTailContext.class,0);
		}
		public UnaryMessageContext unaryMessage() {
			return getRuleContext(UnaryMessageContext.class,0);
		}
		public WsContext ws() {
			return getRuleContext(WsContext.class,0);
		}
		public UnaryTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryTail; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitUnaryTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryTailContext unaryTail() throws RecognitionException {
		UnaryTailContext _localctx = new UnaryTailContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_unaryTail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374); unaryMessage();
			setState(375); ws();
			setState(377);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(376); unaryTail();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryMessageContext extends ParserRuleContext {
		public UnarySelectorContext unarySelector() {
			return getRuleContext(UnarySelectorContext.class,0);
		}
		public WsContext ws() {
			return getRuleContext(WsContext.class,0);
		}
		public UnaryMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryMessage; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitUnaryMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryMessageContext unaryMessage() throws RecognitionException {
		UnaryMessageContext _localctx = new UnaryMessageContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_unaryMessage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379); ws();
			setState(380); unarySelector();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnarySelectorContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SmalltalkParser.IDENTIFIER, 0); }
		public UnarySelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unarySelector; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitUnarySelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnarySelectorContext unarySelector() throws RecognitionException {
		UnarySelectorContext _localctx = new UnarySelectorContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_unarySelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordsContext extends ParserRuleContext {
		public List<TerminalNode> KEYWORD() { return getTokens(SmalltalkParser.KEYWORD); }
		public TerminalNode KEYWORD(int i) {
			return getToken(SmalltalkParser.KEYWORD, i);
		}
		public KeywordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywords; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitKeywords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordsContext keywords() throws RecognitionException {
		KeywordsContext _localctx = new KeywordsContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(384); match(KEYWORD);
				}
				}
				setState(387); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KEYWORD );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389); variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryTailContext extends ParserRuleContext {
		public BinaryMessageContext binaryMessage() {
			return getRuleContext(BinaryMessageContext.class,0);
		}
		public BinaryTailContext binaryTail() {
			return getRuleContext(BinaryTailContext.class,0);
		}
		public BinaryTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryTail; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitBinaryTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryTailContext binaryTail() throws RecognitionException {
		BinaryTailContext _localctx = new BinaryTailContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_binaryTail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391); binaryMessage();
			setState(393);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(392); binaryTail();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryMessageContext extends ParserRuleContext {
		public TerminalNode BINARY_SELECTOR() { return getToken(SmalltalkParser.BINARY_SELECTOR, 0); }
		public UnarySendContext unarySend() {
			return getRuleContext(UnarySendContext.class,0);
		}
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public BinaryMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryMessage; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitBinaryMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryMessageContext binaryMessage() throws RecognitionException {
		BinaryMessageContext _localctx = new BinaryMessageContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_binaryMessage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395); ws();
			setState(396); match(BINARY_SELECTOR);
			setState(397); ws();
			setState(400);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(398); unarySend();
				}
				break;

			case 2:
				{
				setState(399); operand();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3#\u0195\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3\3\3"+
		"\3\5\3j\n\3\3\3\3\3\5\3n\n\3\3\3\3\3\3\4\7\4s\n\4\f\4\16\4v\13\4\3\5\3"+
		"\5\3\5\3\5\7\5|\n\5\f\5\16\5\177\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u008d\n\6\5\6\u008f\n\6\3\7\3\7\3\7\3\7\3\7\5\7\u0096"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u009d\n\b\3\t\3\t\7\t\u00a1\n\t\f\t\16\t"+
		"\u00a4\13\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u00ae\n\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\6\13\u00b6\n\13\r\13\16\13\u00b7\3\f\3\f\3\f\5"+
		"\f\u00bd\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\5\17\u00c9\n"+
		"\17\3\20\3\20\3\20\5\20\u00ce\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\6\22\u00d7\n\22\r\22\16\22\u00d8\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\5\24\u00e3\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\5\26\u00ed"+
		"\n\26\3\27\3\27\3\27\5\27\u00f2\n\27\3\30\3\30\5\30\u00f6\n\30\3\30\5"+
		"\30\u00f9\n\30\3\30\3\30\3\30\3\31\3\31\3\31\6\31\u0101\n\31\r\31\16\31"+
		"\u0102\3\31\3\31\5\31\u0107\n\31\3\32\3\32\3\32\5\32\u010c\n\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\5\33\u0114\n\33\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u011f\n\34\3\35\3\35\3\35\3\35\5\35\u0125\n\35\3"+
		"\36\3\36\5\36\u0129\n\36\3\36\3\36\3\36\3\37\3\37\3 \5 \u0131\n \3 \3"+
		" \6 \u0135\n \r \16 \u0136\3!\5!\u013a\n!\3!\3!\3\"\5\"\u013f\n\"\3\""+
		"\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\6\'"+
		"\u0156\n\'\r\'\16\'\u0157\3\'\5\'\u015b\n\'\3(\3(\3(\3)\3)\3)\3)\5)\u0164"+
		"\n)\3)\3)\7)\u0168\n)\f)\16)\u016b\13)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3+\5"+
		"+\u0177\n+\3,\3,\3,\5,\u017c\n,\3-\3-\3-\3.\3.\3/\6/\u0184\n/\r/\16/\u0185"+
		"\3\60\3\60\3\61\3\61\5\61\u018c\n\61\3\62\3\62\3\62\3\62\3\62\5\62\u0193"+
		"\n\62\3\62\2\63\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`b\2\4\4\2!!##\3\2\34\35\u019d\2d\3\2\2\2\4"+
		"g\3\2\2\2\6t\3\2\2\2\bw\3\2\2\2\n\u008e\3\2\2\2\f\u0090\3\2\2\2\16\u009c"+
		"\3\2\2\2\20\u009e\3\2\2\2\22\u00a5\3\2\2\2\24\u00aa\3\2\2\2\26\u00bc\3"+
		"\2\2\2\30\u00be\3\2\2\2\32\u00c4\3\2\2\2\34\u00c6\3\2\2\2\36\u00ca\3\2"+
		"\2\2 \u00cf\3\2\2\2\"\u00d2\3\2\2\2$\u00da\3\2\2\2&\u00e2\3\2\2\2(\u00e4"+
		"\3\2\2\2*\u00ec\3\2\2\2,\u00f1\3\2\2\2.\u00f3\3\2\2\2\60\u0100\3\2\2\2"+
		"\62\u0108\3\2\2\2\64\u0110\3\2\2\2\66\u011e\3\2\2\28\u0124\3\2\2\2:\u0128"+
		"\3\2\2\2<\u012d\3\2\2\2>\u0130\3\2\2\2@\u0139\3\2\2\2B\u013e\3\2\2\2D"+
		"\u0144\3\2\2\2F\u0146\3\2\2\2H\u0148\3\2\2\2J\u014b\3\2\2\2L\u015a\3\2"+
		"\2\2N\u015c\3\2\2\2P\u015f\3\2\2\2R\u016e\3\2\2\2T\u0176\3\2\2\2V\u0178"+
		"\3\2\2\2X\u017d\3\2\2\2Z\u0180\3\2\2\2\\\u0183\3\2\2\2^\u0187\3\2\2\2"+
		"`\u0189\3\2\2\2b\u018d\3\2\2\2de\5\4\3\2ef\7\2\2\3f\3\3\2\2\2gi\5\6\4"+
		"\2hj\5\b\5\2ih\3\2\2\2ij\3\2\2\2jk\3\2\2\2km\5\6\4\2ln\5\n\6\2ml\3\2\2"+
		"\2mn\3\2\2\2no\3\2\2\2op\5\6\4\2p\5\3\2\2\2qs\t\2\2\2rq\3\2\2\2sv\3\2"+
		"\2\2tr\3\2\2\2tu\3\2\2\2u\7\3\2\2\2vt\3\2\2\2w}\7\3\2\2xy\5\6\4\2yz\7"+
		"\35\2\2z|\3\2\2\2{x\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3"+
		"\2\2\2\177}\3\2\2\2\u0080\u0081\5\6\4\2\u0081\u0082\7\3\2\2\u0082\t\3"+
		"\2\2\2\u0083\u008f\5\f\7\2\u0084\u0085\5\20\t\2\u0085\u0086\5\6\4\2\u0086"+
		"\u0087\7\4\2\2\u0087\u0088\5\6\4\2\u0088\u0089\5\f\7\2\u0089\u008f\3\2"+
		"\2\2\u008a\u008c\5\20\t\2\u008b\u008d\7\4\2\2\u008c\u008b\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u0083\3\2\2\2\u008e\u0084\3\2"+
		"\2\2\u008e\u008a\3\2\2\2\u008f\13\3\2\2\2\u0090\u0091\7\5\2\2\u0091\u0092"+
		"\5\6\4\2\u0092\u0093\5\16\b\2\u0093\u0095\5\6\4\2\u0094\u0096\7\4\2\2"+
		"\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\r\3\2\2\2\u0097\u009d\5"+
		"\30\r\2\u0098\u009d\5\24\13\2\u0099\u009d\5 \21\2\u009a\u009d\5\34\17"+
		"\2\u009b\u009d\5J&\2\u009c\u0097\3\2\2\2\u009c\u0098\3\2\2\2\u009c\u0099"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d\17\3\2\2\2\u009e"+
		"\u00a2\5\16\b\2\u009f\u00a1\5\22\n\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3"+
		"\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\21\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a5\u00a6\5\6\4\2\u00a6\u00a7\7\4\2\2\u00a7\u00a8\5\6"+
		"\4\2\u00a8\u00a9\5\16\b\2\u00a9\23\3\2\2\2\u00aa\u00ad\5\6\4\2\u00ab\u00ae"+
		"\5 \21\2\u00ac\u00ae\5\34\17\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2"+
		"\u00ae\u00b5\3\2\2\2\u00af\u00b0\5\6\4\2\u00b0\u00b1\7\7\2\2\u00b1\u00b2"+
		"\5\6\4\2\u00b2\u00b3\5\26\f\2\u00b3\u00b4\5\6\4\2\u00b4\u00b6\3\2\2\2"+
		"\u00b5\u00af\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\25\3\2\2\2\u00b9\u00bd\5b\62\2\u00ba\u00bd\5X-\2\u00bb"+
		"\u00bd\5\"\22\2\u00bc\u00b9\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3"+
		"\2\2\2\u00bd\27\3\2\2\2\u00be\u00bf\5\32\16\2\u00bf\u00c0\5\6\4\2\u00c0"+
		"\u00c1\7\b\2\2\u00c1\u00c2\5\6\4\2\u00c2\u00c3\5\16\b\2\u00c3\31\3\2\2"+
		"\2\u00c4\u00c5\7\35\2\2\u00c5\33\3\2\2\2\u00c6\u00c8\5\36\20\2\u00c7\u00c9"+
		"\5`\61\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\35\3\2\2\2\u00ca"+
		"\u00cb\5&\24\2\u00cb\u00cd\5\6\4\2\u00cc\u00ce\5V,\2\u00cd\u00cc\3\2\2"+
		"\2\u00cd\u00ce\3\2\2\2\u00ce\37\3\2\2\2\u00cf\u00d0\5\34\17\2\u00d0\u00d1"+
		"\5\"\22\2\u00d1!\3\2\2\2\u00d2\u00d6\5\6\4\2\u00d3\u00d4\5$\23\2\u00d4"+
		"\u00d5\5\6\4\2\u00d5\u00d7\3\2\2\2\u00d6\u00d3\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9#\3\2\2\2\u00da\u00db"+
		"\7\36\2\2\u00db\u00dc\5\6\4\2\u00dc\u00dd\5\34\17\2\u00dd\u00de\5\6\4"+
		"\2\u00de%\3\2\2\2\u00df\u00e3\5*\26\2\u00e0\u00e3\5^\60\2\u00e1\u00e3"+
		"\5(\25\2\u00e2\u00df\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3"+
		"\'\3\2\2\2\u00e4\u00e5\7\20\2\2\u00e5\u00e6\5\6\4\2\u00e6\u00e7\5\16\b"+
		"\2\u00e7\u00e8\5\6\4\2\u00e8\u00e9\7\17\2\2\u00e9)\3\2\2\2\u00ea\u00ed"+
		"\5,\27\2\u00eb\u00ed\5\66\34\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2"+
		"\u00ed+\3\2\2\2\u00ee\u00f2\5\62\32\2\u00ef\u00f2\5\64\33\2\u00f0\u00f2"+
		"\5.\30\2\u00f1\u00ee\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2"+
		"-\3\2\2\2\u00f3\u00f5\7\24\2\2\u00f4\u00f6\5\60\31\2\u00f5\u00f4\3\2\2"+
		"\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f9\5\4\3\2\u00f8\u00f7"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\5\6\4\2\u00fb"+
		"\u00fc\7\25\2\2\u00fc/\3\2\2\2\u00fd\u00fe\5\6\4\2\u00fe\u00ff\7\37\2"+
		"\2\u00ff\u0101\3\2\2\2\u0100\u00fd\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0100"+
		"\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\5\6\4\2\u0105"+
		"\u0107\7\3\2\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107\61\3\2\2"+
		"\2\u0108\u0109\7\21\2\2\u0109\u010b\5\6\4\2\u010a\u010c\5\20\t\2\u010b"+
		"\u010a\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\5\6"+
		"\4\2\u010e\u010f\7\22\2\2\u010f\63\3\2\2\2\u0110\u0111\7\23\2\2\u0111"+
		"\u0113\5\6\4\2\u0112\u0114\5\20\t\2\u0113\u0112\3\2\2\2\u0113\u0114\3"+
		"\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\5\6\4\2\u0116\u0117\7\22\2\2\u0117"+
		"\65\3\2\2\2\u0118\u011f\5D#\2\u0119\u011f\58\35\2\u011a\u011f\5<\37\2"+
		"\u011b\u011f\5N(\2\u011c\u011f\5F$\2\u011d\u011f\5H%\2\u011e\u0118\3\2"+
		"\2\2\u011e\u0119\3\2\2\2\u011e\u011a\3\2\2\2\u011e\u011b\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011e\u011d\3\2\2\2\u011f\67\3\2\2\2\u0120\u0125\5:\36"+
		"\2\u0121\u0125\5> \2\u0122\u0125\5B\"\2\u0123\u0125\5@!\2\u0124\u0120"+
		"\3\2\2\2\u0124\u0121\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0123\3\2\2\2\u0125"+
		"9\3\2\2\2\u0126\u0129\5B\"\2\u0127\u0129\5@!\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7\f\2\2\u012b\u012c\5@"+
		"!\2\u012c;\3\2\2\2\u012d\u012e\7 \2\2\u012e=\3\2\2\2\u012f\u0131\7\t\2"+
		"\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134"+
		"\7\r\2\2\u0133\u0135\7\33\2\2\u0134\u0133\3\2\2\2\u0135\u0136\3\2\2\2"+
		"\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137?\3\2\2\2\u0138\u013a\7"+
		"\t\2\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013c\7\32\2\2\u013cA\3\2\2\2\u013d\u013f\7\t\2\2\u013e\u013d\3\2\2\2"+
		"\u013e\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\7\32\2\2\u0141\u0142"+
		"\7\4\2\2\u0142\u0143\7\32\2\2\u0143C\3\2\2\2\u0144\u0145\7\30\2\2\u0145"+
		"E\3\2\2\2\u0146\u0147\7\"\2\2\u0147G\3\2\2\2\u0148\u0149\7\n\2\2\u0149"+
		"\u014a\5L\'\2\u014aI\3\2\2\2\u014b\u014c\7\26\2\2\u014c\u014d\5\6\4\2"+
		"\u014d\u014e\7\36\2\2\u014e\u014f\5\6\4\2\u014f\u0150\7\32\2\2\u0150\u0151"+
		"\5\6\4\2\u0151\u0152\7\27\2\2\u0152K\3\2\2\2\u0153\u015b\t\3\2\2\u0154"+
		"\u0156\7\36\2\2\u0155\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0155\3"+
		"\2\2\2\u0157\u0158\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u015b\5F$\2\u015a"+
		"\u0153\3\2\2\2\u015a\u0155\3\2\2\2\u015a\u0159\3\2\2\2\u015bM\3\2\2\2"+
		"\u015c\u015d\7\16\2\2\u015d\u015e\5P)\2\u015eO\3\2\2\2\u015f\u0169\5\6"+
		"\4\2\u0160\u0164\5\66\34\2\u0161\u0164\5R*\2\u0162\u0164\5L\'\2\u0163"+
		"\u0160\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0162\3\2\2\2\u0164\u0165\3\2"+
		"\2\2\u0165\u0166\5\6\4\2\u0166\u0168\3\2\2\2\u0167\u0163\3\2\2\2\u0168"+
		"\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016c\3\2"+
		"\2\2\u016b\u0169\3\2\2\2\u016c\u016d\7\17\2\2\u016dQ\3\2\2\2\u016e\u016f"+
		"\7\20\2\2\u016f\u0170\5P)\2\u0170S\3\2\2\2\u0171\u0177\5D#\2\u0172\u0177"+
		"\58\35\2\u0173\u0177\5N(\2\u0174\u0177\5F$\2\u0175\u0177\5H%\2\u0176\u0171"+
		"\3\2\2\2\u0176\u0172\3\2\2\2\u0176\u0173\3\2\2\2\u0176\u0174\3\2\2\2\u0176"+
		"\u0175\3\2\2\2\u0177U\3\2\2\2\u0178\u0179\5X-\2\u0179\u017b\5\6\4\2\u017a"+
		"\u017c\5V,\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017cW\3\2\2\2\u017d"+
		"\u017e\5\6\4\2\u017e\u017f\5Z.\2\u017fY\3\2\2\2\u0180\u0181\7\35\2\2\u0181"+
		"[\3\2\2\2\u0182\u0184\7\36\2\2\u0183\u0182\3\2\2\2\u0184\u0185\3\2\2\2"+
		"\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186]\3\2\2\2\u0187\u0188\5"+
		"\32\16\2\u0188_\3\2\2\2\u0189\u018b\5b\62\2\u018a\u018c\5`\61\2\u018b"+
		"\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018ca\3\2\2\2\u018d\u018e\5\6\4\2"+
		"\u018e\u018f\7\34\2\2\u018f\u0192\5\6\4\2\u0190\u0193\5\36\20\2\u0191"+
		"\u0193\5&\24\2\u0192\u0190\3\2\2\2\u0192\u0191\3\2\2\2\u0193c\3\2\2\2"+
		"*imt}\u008c\u008e\u0095\u009c\u00a2\u00ad\u00b7\u00bc\u00c8\u00cd\u00d8"+
		"\u00e2\u00ec\u00f1\u00f5\u00f8\u0102\u0106\u010b\u0113\u011e\u0124\u0128"+
		"\u0130\u0136\u0139\u013e\u0157\u015a\u0163\u0169\u0176\u017b\u0185\u018b"+
		"\u0192";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}