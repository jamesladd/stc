// Generated from Smalltalk.g4 by ANTLR 4.7
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
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEPARATOR=1, STRING=2, COMMENT=3, BLOCK_START=4, BLOCK_END=5, CLOSE_PAREN=6, 
		OPEN_PAREN=7, PIPE=8, PERIOD=9, SEMI_COLON=10, BINARY_SELECTOR=11, LT=12, 
		GT=13, MINUS=14, RESERVED_WORD=15, IDENTIFIER=16, CARROT=17, COLON=18, 
		ASSIGNMENT=19, HASH=20, DOLLAR=21, EXP=22, HEX=23, LITARR_START=24, DYNDICT_START=25, 
		DYNARR_END=26, DYNARR_START=27, DIGIT=28, HEXDIGIT=29, KEYWORD=30, BLOCK_PARAM=31, 
		CHARACTER_CONSTANT=32;
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
		RULE_bareLiteralArray = 40, RULE_unaryTail = 41, RULE_unaryMessage = 42, 
		RULE_unarySelector = 43, RULE_keywords = 44, RULE_reference = 45, RULE_binaryTail = 46, 
		RULE_binaryMessage = 47;
	public static final String[] ruleNames = {
		"script", "sequence", "ws", "temps", "statements", "answer", "expression", 
		"expressions", "expressionList", "cascade", "message", "assignment", "variable", 
		"binarySend", "unarySend", "keywordSend", "keywordMessage", "keywordPair", 
		"operand", "subexpression", "literal", "runtimeLiteral", "block", "blockParamList", 
		"dynamicDictionary", "dynamicArray", "parsetimeLiteral", "number", "numberExp", 
		"charConstant", "hex", "stInteger", "stFloat", "pseudoVariable", "string", 
		"symbol", "primitive", "bareSymbol", "literalArray", "literalArrayRest", 
		"bareLiteralArray", "unaryTail", "unaryMessage", "unarySelector", "keywords", 
		"reference", "binaryTail", "binaryMessage"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'['", "']'", "')'", "'('", "'|'", "'.'", "';'", 
		null, "'<'", "'>'", "'-'", null, null, "'^'", "':'", "':='", "'#'", "'$'", 
		"'e'", "'16r'", "'#('", "'#{'", "'}'", "'{'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SEPARATOR", "STRING", "COMMENT", "BLOCK_START", "BLOCK_END", "CLOSE_PAREN", 
		"OPEN_PAREN", "PIPE", "PERIOD", "SEMI_COLON", "BINARY_SELECTOR", "LT", 
		"GT", "MINUS", "RESERVED_WORD", "IDENTIFIER", "CARROT", "COLON", "ASSIGNMENT", 
		"HASH", "DOLLAR", "EXP", "HEX", "LITARR_START", "DYNDICT_START", "DYNARR_END", 
		"DYNARR_START", "DIGIT", "HEXDIGIT", "KEYWORD", "BLOCK_PARAM", "CHARACTER_CONSTANT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Smalltalk.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SmalltalkParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ScriptContext extends ParserRuleContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public WsContext ws() {
			return getRuleContext(WsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SmalltalkParser.EOF, 0); }
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
			setState(96);
			sequence();
			setState(97);
			ws();
			setState(98);
			match(EOF);
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
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public List<TempsContext> temps() {
			return getRuleContexts(TempsContext.class);
		}
		public TempsContext temps(int i) {
			return getRuleContext(TempsContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			ws();
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(103);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STRING:
					case BLOCK_START:
					case OPEN_PAREN:
					case LT:
					case MINUS:
					case RESERVED_WORD:
					case IDENTIFIER:
					case CARROT:
					case HASH:
					case HEX:
					case LITARR_START:
					case DYNDICT_START:
					case DYNARR_START:
					case DIGIT:
					case CHARACTER_CONSTANT:
						{
						setState(101);
						statements();
						}
						break;
					case SEPARATOR:
					case COMMENT:
					case PIPE:
						{
						setState(102);
						temps();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(108);
			ws();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BLOCK_START) | (1L << OPEN_PAREN) | (1L << LT) | (1L << MINUS) | (1L << RESERVED_WORD) | (1L << IDENTIFIER) | (1L << CARROT) | (1L << HASH) | (1L << HEX) | (1L << LITARR_START) | (1L << DYNDICT_START) | (1L << DYNARR_START) | (1L << DIGIT) | (1L << CHARACTER_CONSTANT))) != 0)) {
				{
				setState(109);
				statements();
				}
			}

			setState(112);
			ws();
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
		public List<TerminalNode> SEPARATOR() { return getTokens(SmalltalkParser.SEPARATOR); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(SmalltalkParser.SEPARATOR, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(SmalltalkParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(SmalltalkParser.COMMENT, i);
		}
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
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(114);
					_la = _input.LA(1);
					if ( !(_la==SEPARATOR || _la==COMMENT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<TerminalNode> PIPE() { return getTokens(SmalltalkParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(SmalltalkParser.PIPE, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(SmalltalkParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SmalltalkParser.IDENTIFIER, i);
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
			setState(120);
			ws();
			setState(121);
			match(PIPE);
			setState(125); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(122);
					ws();
					setState(123);
					match(IDENTIFIER);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(127); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(129);
			ws();
			setState(130);
			match(PIPE);
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
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	 
		public StatementsContext() { }
		public void copyFrom(StatementsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementAnswerContext extends StatementsContext {
		public AnswerContext answer() {
			return getRuleContext(AnswerContext.class,0);
		}
		public WsContext ws() {
			return getRuleContext(WsContext.class,0);
		}
		public StatementAnswerContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitStatementAnswer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementExpressionsContext extends StatementsContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public WsContext ws() {
			return getRuleContext(WsContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(SmalltalkParser.PERIOD, 0); }
		public StatementExpressionsContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitStatementExpressions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementExpressionsAnswerContext extends StatementsContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public TerminalNode PERIOD() { return getToken(SmalltalkParser.PERIOD, 0); }
		public AnswerContext answer() {
			return getRuleContext(AnswerContext.class,0);
		}
		public StatementExpressionsAnswerContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitStatementExpressionsAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statements);
		int _la;
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new StatementAnswerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				answer();
				setState(133);
				ws();
				}
				break;
			case 2:
				_localctx = new StatementExpressionsAnswerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				expressions();
				setState(136);
				ws();
				setState(137);
				match(PERIOD);
				setState(138);
				ws();
				setState(139);
				answer();
				}
				break;
			case 3:
				_localctx = new StatementExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				expressions();
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PERIOD) {
					{
					setState(142);
					match(PERIOD);
					}
				}

				setState(145);
				ws();
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
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(149);
			match(CARROT);
			setState(150);
			ws();
			setState(151);
			expression();
			setState(152);
			ws();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERIOD) {
				{
				setState(153);
				match(PERIOD);
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
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public CascadeContext cascade() {
			return getRuleContext(CascadeContext.class,0);
		}
		public KeywordSendContext keywordSend() {
			return getRuleContext(KeywordSendContext.class,0);
		}
		public BinarySendContext binarySend() {
			return getRuleContext(BinarySendContext.class,0);
		}
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
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
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				cascade();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				keywordSend();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(159);
				binarySend();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(160);
				primitive();
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ExpressionListContext> expressionList() {
			return getRuleContexts(ExpressionListContext.class);
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
			setState(163);
			expression();
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(164);
					expressionList();
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		public TerminalNode PERIOD() { return getToken(SmalltalkParser.PERIOD, 0); }
		public WsContext ws() {
			return getRuleContext(WsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
			setState(170);
			match(PERIOD);
			setState(171);
			ws();
			setState(172);
			expression();
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
		public KeywordSendContext keywordSend() {
			return getRuleContext(KeywordSendContext.class,0);
		}
		public BinarySendContext binarySend() {
			return getRuleContext(BinarySendContext.class,0);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<TerminalNode> SEMI_COLON() { return getTokens(SmalltalkParser.SEMI_COLON); }
		public TerminalNode SEMI_COLON(int i) {
			return getToken(SmalltalkParser.SEMI_COLON, i);
		}
		public List<MessageContext> message() {
			return getRuleContexts(MessageContext.class);
		}
		public MessageContext message(int i) {
			return getRuleContext(MessageContext.class,i);
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
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(174);
				keywordSend();
				}
				break;
			case 2:
				{
				setState(175);
				binarySend();
				}
				break;
			}
			setState(183); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(178);
					ws();
					setState(179);
					match(SEMI_COLON);
					setState(180);
					ws();
					setState(181);
					message();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(185); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public UnaryMessageContext unaryMessage() {
			return getRuleContext(UnaryMessageContext.class,0);
		}
		public KeywordMessageContext keywordMessage() {
			return getRuleContext(KeywordMessageContext.class,0);
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
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				binaryMessage();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				unaryMessage();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				keywordMessage();
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
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public TerminalNode ASSIGNMENT() { return getToken(SmalltalkParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(192);
			variable();
			setState(193);
			ws();
			setState(194);
			match(ASSIGNMENT);
			setState(195);
			ws();
			setState(196);
			expression();
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
			setState(198);
			match(IDENTIFIER);
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
		public UnarySendContext unarySend() {
			return getRuleContext(UnarySendContext.class,0);
		}
		public BinaryTailContext binaryTail() {
			return getRuleContext(BinaryTailContext.class,0);
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
			setState(200);
			unarySend();
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(201);
				binaryTail();
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
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public WsContext ws() {
			return getRuleContext(WsContext.class,0);
		}
		public UnaryTailContext unaryTail() {
			return getRuleContext(UnaryTailContext.class,0);
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
			setState(204);
			operand();
			setState(205);
			ws();
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(206);
				unaryTail();
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
		public BinarySendContext binarySend() {
			return getRuleContext(BinarySendContext.class,0);
		}
		public KeywordMessageContext keywordMessage() {
			return getRuleContext(KeywordMessageContext.class,0);
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
			setState(209);
			binarySend();
			setState(210);
			keywordMessage();
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
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<KeywordPairContext> keywordPair() {
			return getRuleContexts(KeywordPairContext.class);
		}
		public KeywordPairContext keywordPair(int i) {
			return getRuleContext(KeywordPairContext.class,i);
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
			setState(212);
			ws();
			setState(216); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(213);
				keywordPair();
				setState(214);
				ws();
				}
				}
				setState(218); 
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
		public TerminalNode KEYWORD() { return getToken(SmalltalkParser.KEYWORD, 0); }
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public BinarySendContext binarySend() {
			return getRuleContext(BinarySendContext.class,0);
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
			setState(220);
			match(KEYWORD);
			setState(221);
			ws();
			setState(222);
			binarySend();
			setState(223);
			ws();
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
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public SubexpressionContext subexpression() {
			return getRuleContext(SubexpressionContext.class,0);
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
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case BLOCK_START:
			case MINUS:
			case RESERVED_WORD:
			case HASH:
			case HEX:
			case LITARR_START:
			case DYNDICT_START:
			case DYNARR_START:
			case DIGIT:
			case CHARACTER_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				literal();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				reference();
				}
				break;
			case OPEN_PAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				subexpression();
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
		public TerminalNode OPEN_PAREN() { return getToken(SmalltalkParser.OPEN_PAREN, 0); }
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(SmalltalkParser.CLOSE_PAREN, 0); }
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
			setState(230);
			match(OPEN_PAREN);
			setState(231);
			ws();
			setState(232);
			expression();
			setState(233);
			ws();
			setState(234);
			match(CLOSE_PAREN);
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
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BLOCK_START:
			case DYNDICT_START:
			case DYNARR_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				runtimeLiteral();
				}
				break;
			case STRING:
			case MINUS:
			case RESERVED_WORD:
			case HASH:
			case HEX:
			case LITARR_START:
			case DIGIT:
			case CHARACTER_CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				parsetimeLiteral();
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
		public DynamicDictionaryContext dynamicDictionary() {
			return getRuleContext(DynamicDictionaryContext.class,0);
		}
		public DynamicArrayContext dynamicArray() {
			return getRuleContext(DynamicArrayContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DYNDICT_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				dynamicDictionary();
				}
				break;
			case DYNARR_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				dynamicArray();
				}
				break;
			case BLOCK_START:
				enterOuterAlt(_localctx, 3);
				{
				setState(242);
				block();
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
		public TerminalNode BLOCK_START() { return getToken(SmalltalkParser.BLOCK_START, 0); }
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode BLOCK_END() { return getToken(SmalltalkParser.BLOCK_END, 0); }
		public BlockParamListContext blockParamList() {
			return getRuleContext(BlockParamListContext.class,0);
		}
		public TerminalNode PIPE() { return getToken(SmalltalkParser.PIPE, 0); }
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
			setState(245);
			match(BLOCK_START);
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(246);
				blockParamList();
				}
				break;
			}
			setState(249);
			ws();
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(250);
				match(PIPE);
				setState(251);
				ws();
				}
				break;
			}
			setState(254);
			sequence();
			setState(255);
			match(BLOCK_END);
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
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<TerminalNode> BLOCK_PARAM() { return getTokens(SmalltalkParser.BLOCK_PARAM); }
		public TerminalNode BLOCK_PARAM(int i) {
			return getToken(SmalltalkParser.BLOCK_PARAM, i);
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
			setState(260); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(257);
					ws();
					setState(258);
					match(BLOCK_PARAM);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(262); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode DYNDICT_START() { return getToken(SmalltalkParser.DYNDICT_START, 0); }
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public TerminalNode DYNARR_END() { return getToken(SmalltalkParser.DYNARR_END, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(DYNDICT_START);
			setState(265);
			ws();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BLOCK_START) | (1L << OPEN_PAREN) | (1L << LT) | (1L << MINUS) | (1L << RESERVED_WORD) | (1L << IDENTIFIER) | (1L << HASH) | (1L << HEX) | (1L << LITARR_START) | (1L << DYNDICT_START) | (1L << DYNARR_START) | (1L << DIGIT) | (1L << CHARACTER_CONSTANT))) != 0)) {
				{
				setState(266);
				expressions();
				}
			}

			setState(269);
			ws();
			setState(270);
			match(DYNARR_END);
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
		public TerminalNode DYNARR_START() { return getToken(SmalltalkParser.DYNARR_START, 0); }
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public TerminalNode DYNARR_END() { return getToken(SmalltalkParser.DYNARR_END, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(DYNARR_START);
			setState(273);
			ws();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BLOCK_START) | (1L << OPEN_PAREN) | (1L << LT) | (1L << MINUS) | (1L << RESERVED_WORD) | (1L << IDENTIFIER) | (1L << HASH) | (1L << HEX) | (1L << LITARR_START) | (1L << DYNDICT_START) | (1L << DYNARR_START) | (1L << DIGIT) | (1L << CHARACTER_CONSTANT))) != 0)) {
				{
				setState(274);
				expressions();
				}
			}

			setState(277);
			ws();
			setState(278);
			match(DYNARR_END);
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
		public CharConstantContext charConstant() {
			return getRuleContext(CharConstantContext.class,0);
		}
		public PseudoVariableContext pseudoVariable() {
			return getRuleContext(PseudoVariableContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public LiteralArrayContext literalArray() {
			return getRuleContext(LiteralArrayContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
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
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHARACTER_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				charConstant();
				}
				break;
			case RESERVED_WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				pseudoVariable();
				}
				break;
			case MINUS:
			case HEX:
			case DIGIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
				number();
				}
				break;
			case LITARR_START:
				enterOuterAlt(_localctx, 4);
				{
				setState(283);
				literalArray();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(284);
				string();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 6);
				{
				setState(285);
				symbol();
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
		public NumberExpContext numberExp() {
			return getRuleContext(NumberExpContext.class,0);
		}
		public HexContext hex() {
			return getRuleContext(HexContext.class,0);
		}
		public StFloatContext stFloat() {
			return getRuleContext(StFloatContext.class,0);
		}
		public StIntegerContext stInteger() {
			return getRuleContext(StIntegerContext.class,0);
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
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				numberExp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				hex();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				stFloat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(291);
				stInteger();
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
		public TerminalNode EXP() { return getToken(SmalltalkParser.EXP, 0); }
		public List<StIntegerContext> stInteger() {
			return getRuleContexts(StIntegerContext.class);
		}
		public StIntegerContext stInteger(int i) {
			return getRuleContext(StIntegerContext.class,i);
		}
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
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(294);
				stFloat();
				}
				break;
			case 2:
				{
				setState(295);
				stInteger();
				}
				break;
			}
			setState(298);
			match(EXP);
			setState(299);
			stInteger();
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
			setState(301);
			match(CHARACTER_CONSTANT);
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
		public TerminalNode HEX() { return getToken(SmalltalkParser.HEX, 0); }
		public TerminalNode MINUS() { return getToken(SmalltalkParser.MINUS, 0); }
		public List<TerminalNode> HEXDIGIT() { return getTokens(SmalltalkParser.HEXDIGIT); }
		public TerminalNode HEXDIGIT(int i) {
			return getToken(SmalltalkParser.HEXDIGIT, i);
		}
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
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(303);
				match(MINUS);
				}
			}

			setState(306);
			match(HEX);
			setState(308); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(307);
				match(HEXDIGIT);
				}
				}
				setState(310); 
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
		public TerminalNode MINUS() { return getToken(SmalltalkParser.MINUS, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(SmalltalkParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(SmalltalkParser.DIGIT, i);
		}
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(312);
				match(MINUS);
				}
			}

			setState(316); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(315);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(318); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode PERIOD() { return getToken(SmalltalkParser.PERIOD, 0); }
		public TerminalNode MINUS() { return getToken(SmalltalkParser.MINUS, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(SmalltalkParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(SmalltalkParser.DIGIT, i);
		}
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(320);
				match(MINUS);
				}
			}

			setState(324); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(323);
				match(DIGIT);
				}
				}
				setState(326); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			setState(328);
			match(PERIOD);
			setState(330); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(329);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(332); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
			setState(334);
			match(RESERVED_WORD);
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
			setState(336);
			match(STRING);
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
			setState(338);
			match(HASH);
			setState(339);
			bareSymbol();
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
		public TerminalNode LT() { return getToken(SmalltalkParser.LT, 0); }
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public TerminalNode KEYWORD() { return getToken(SmalltalkParser.KEYWORD, 0); }
		public TerminalNode GT() { return getToken(SmalltalkParser.GT, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(SmalltalkParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(SmalltalkParser.DIGIT, i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(LT);
			setState(342);
			ws();
			setState(343);
			match(KEYWORD);
			setState(344);
			ws();
			setState(346); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(345);
				match(DIGIT);
				}
				}
				setState(348); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			setState(350);
			ws();
			setState(351);
			match(GT);
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
		public TerminalNode IDENTIFIER() { return getToken(SmalltalkParser.IDENTIFIER, 0); }
		public TerminalNode BINARY_SELECTOR() { return getToken(SmalltalkParser.BINARY_SELECTOR, 0); }
		public List<TerminalNode> KEYWORD() { return getTokens(SmalltalkParser.KEYWORD); }
		public TerminalNode KEYWORD(int i) {
			return getToken(SmalltalkParser.KEYWORD, i);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public List<TerminalNode> PIPE() { return getTokens(SmalltalkParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(SmalltalkParser.PIPE, i);
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
			setState(365);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BINARY_SELECTOR:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				_la = _input.LA(1);
				if ( !(_la==BINARY_SELECTOR || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case KEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(355); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(354);
						match(KEYWORD);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(357); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(359);
				string();
				}
				break;
			case PIPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(361); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(360);
						match(PIPE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(363); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
			setState(367);
			match(LITARR_START);
			setState(368);
			literalArrayRest();
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
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(SmalltalkParser.CLOSE_PAREN, 0); }
		public List<ParsetimeLiteralContext> parsetimeLiteral() {
			return getRuleContexts(ParsetimeLiteralContext.class);
		}
		public ParsetimeLiteralContext parsetimeLiteral(int i) {
			return getRuleContext(ParsetimeLiteralContext.class,i);
		}
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(370);
					ws();
					setState(374);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						setState(371);
						parsetimeLiteral();
						}
						break;
					case 2:
						{
						setState(372);
						bareLiteralArray();
						}
						break;
					case 3:
						{
						setState(373);
						bareSymbol();
						}
						break;
					}
					}
					} 
				}
				setState(380);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(381);
			ws();
			setState(382);
			match(CLOSE_PAREN);
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
			setState(384);
			match(OPEN_PAREN);
			setState(385);
			literalArrayRest();
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
		public UnaryMessageContext unaryMessage() {
			return getRuleContext(UnaryMessageContext.class,0);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public UnaryTailContext unaryTail() {
			return getRuleContext(UnaryTailContext.class,0);
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
		enterRule(_localctx, 82, RULE_unaryTail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			unaryMessage();
			setState(388);
			ws();
			setState(390);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(389);
				unaryTail();
				}
				break;
			}
			setState(392);
			ws();
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
		public WsContext ws() {
			return getRuleContext(WsContext.class,0);
		}
		public UnarySelectorContext unarySelector() {
			return getRuleContext(UnarySelectorContext.class,0);
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
		enterRule(_localctx, 84, RULE_unaryMessage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			ws();
			setState(395);
			unarySelector();
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
		enterRule(_localctx, 86, RULE_unarySelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(IDENTIFIER);
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
		enterRule(_localctx, 88, RULE_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(399);
				match(KEYWORD);
				}
				}
				setState(402); 
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
		enterRule(_localctx, 90, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			variable();
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
		enterRule(_localctx, 92, RULE_binaryTail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			binaryMessage();
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(407);
				binaryTail();
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
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public TerminalNode BINARY_SELECTOR() { return getToken(SmalltalkParser.BINARY_SELECTOR, 0); }
		public UnarySendContext unarySend() {
			return getRuleContext(UnarySendContext.class,0);
		}
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
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
		enterRule(_localctx, 94, RULE_binaryMessage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			ws();
			setState(411);
			match(BINARY_SELECTOR);
			setState(412);
			ws();
			setState(415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(413);
				unarySend();
				}
				break;
			case 2:
				{
				setState(414);
				operand();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u01a4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\7\3j\n\3\f\3\16\3m\13\3\3\3\3\3\5\3q\n\3\3\3\3\3\3\4\7\4v\n\4\f\4\16"+
		"\4y\13\4\3\5\3\5\3\5\3\5\3\5\6\5\u0080\n\5\r\5\16\5\u0081\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0092\n\6\3\6\3\6\5\6"+
		"\u0096\n\6\3\7\3\7\3\7\3\7\3\7\5\7\u009d\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u00a4"+
		"\n\b\3\t\3\t\7\t\u00a8\n\t\f\t\16\t\u00ab\13\t\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\5\13\u00b3\n\13\3\13\3\13\3\13\3\13\3\13\6\13\u00ba\n\13\r\13\16\13"+
		"\u00bb\3\f\3\f\3\f\5\f\u00c1\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\5\17\u00cd\n\17\3\20\3\20\3\20\5\20\u00d2\n\20\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\6\22\u00db\n\22\r\22\16\22\u00dc\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\5\24\u00e7\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\5\26\u00f1\n\26\3\27\3\27\3\27\5\27\u00f6\n\27\3\30\3\30\5\30\u00fa"+
		"\n\30\3\30\3\30\3\30\5\30\u00ff\n\30\3\30\3\30\3\30\3\31\3\31\3\31\6\31"+
		"\u0107\n\31\r\31\16\31\u0108\3\32\3\32\3\32\5\32\u010e\n\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\5\33\u0116\n\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u0121\n\34\3\35\3\35\3\35\3\35\5\35\u0127\n\35\3\36\3"+
		"\36\5\36\u012b\n\36\3\36\3\36\3\36\3\37\3\37\3 \5 \u0133\n \3 \3 \6 \u0137"+
		"\n \r \16 \u0138\3!\5!\u013c\n!\3!\6!\u013f\n!\r!\16!\u0140\3\"\5\"\u0144"+
		"\n\"\3\"\6\"\u0147\n\"\r\"\16\"\u0148\3\"\3\"\6\"\u014d\n\"\r\"\16\"\u014e"+
		"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\6&\u015d\n&\r&\16&\u015e\3&\3&\3"+
		"&\3\'\3\'\6\'\u0166\n\'\r\'\16\'\u0167\3\'\3\'\6\'\u016c\n\'\r\'\16\'"+
		"\u016d\5\'\u0170\n\'\3(\3(\3(\3)\3)\3)\3)\5)\u0179\n)\7)\u017b\n)\f)\16"+
		")\u017e\13)\3)\3)\3)\3*\3*\3*\3+\3+\3+\5+\u0189\n+\3+\3+\3,\3,\3,\3-\3"+
		"-\3.\6.\u0193\n.\r.\16.\u0194\3/\3/\3\60\3\60\5\60\u019b\n\60\3\61\3\61"+
		"\3\61\3\61\3\61\5\61\u01a2\n\61\3\61\2\2\62\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`\2\4\4\2\3\3\5"+
		"\5\4\2\r\r\22\22\2\u01af\2b\3\2\2\2\4f\3\2\2\2\6w\3\2\2\2\bz\3\2\2\2\n"+
		"\u0095\3\2\2\2\f\u0097\3\2\2\2\16\u00a3\3\2\2\2\20\u00a5\3\2\2\2\22\u00ac"+
		"\3\2\2\2\24\u00b2\3\2\2\2\26\u00c0\3\2\2\2\30\u00c2\3\2\2\2\32\u00c8\3"+
		"\2\2\2\34\u00ca\3\2\2\2\36\u00ce\3\2\2\2 \u00d3\3\2\2\2\"\u00d6\3\2\2"+
		"\2$\u00de\3\2\2\2&\u00e6\3\2\2\2(\u00e8\3\2\2\2*\u00f0\3\2\2\2,\u00f5"+
		"\3\2\2\2.\u00f7\3\2\2\2\60\u0106\3\2\2\2\62\u010a\3\2\2\2\64\u0112\3\2"+
		"\2\2\66\u0120\3\2\2\28\u0126\3\2\2\2:\u012a\3\2\2\2<\u012f\3\2\2\2>\u0132"+
		"\3\2\2\2@\u013b\3\2\2\2B\u0143\3\2\2\2D\u0150\3\2\2\2F\u0152\3\2\2\2H"+
		"\u0154\3\2\2\2J\u0157\3\2\2\2L\u016f\3\2\2\2N\u0171\3\2\2\2P\u017c\3\2"+
		"\2\2R\u0182\3\2\2\2T\u0185\3\2\2\2V\u018c\3\2\2\2X\u018f\3\2\2\2Z\u0192"+
		"\3\2\2\2\\\u0196\3\2\2\2^\u0198\3\2\2\2`\u019c\3\2\2\2bc\5\4\3\2cd\5\6"+
		"\4\2de\7\2\2\3e\3\3\2\2\2fk\5\6\4\2gj\5\n\6\2hj\5\b\5\2ig\3\2\2\2ih\3"+
		"\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2np\5\6\4\2oq\5"+
		"\n\6\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\5\6\4\2s\5\3\2\2\2tv\t\2\2\2ut"+
		"\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\7\3\2\2\2yw\3\2\2\2z{\5\6\4\2"+
		"{\177\7\n\2\2|}\5\6\4\2}~\7\22\2\2~\u0080\3\2\2\2\177|\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\5\6\4\2\u0084\u0085\7\n\2\2\u0085\t\3\2\2\2\u0086\u0087\5\f\7\2"+
		"\u0087\u0088\5\6\4\2\u0088\u0096\3\2\2\2\u0089\u008a\5\20\t\2\u008a\u008b"+
		"\5\6\4\2\u008b\u008c\7\13\2\2\u008c\u008d\5\6\4\2\u008d\u008e\5\f\7\2"+
		"\u008e\u0096\3\2\2\2\u008f\u0091\5\20\t\2\u0090\u0092\7\13\2\2\u0091\u0090"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\5\6\4\2\u0094"+
		"\u0096\3\2\2\2\u0095\u0086\3\2\2\2\u0095\u0089\3\2\2\2\u0095\u008f\3\2"+
		"\2\2\u0096\13\3\2\2\2\u0097\u0098\7\23\2\2\u0098\u0099\5\6\4\2\u0099\u009a"+
		"\5\16\b\2\u009a\u009c\5\6\4\2\u009b\u009d\7\13\2\2\u009c\u009b\3\2\2\2"+
		"\u009c\u009d\3\2\2\2\u009d\r\3\2\2\2\u009e\u00a4\5\30\r\2\u009f\u00a4"+
		"\5\24\13\2\u00a0\u00a4\5 \21\2\u00a1\u00a4\5\34\17\2\u00a2\u00a4\5J&\2"+
		"\u00a3\u009e\3\2\2\2\u00a3\u009f\3\2\2\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\17\3\2\2\2\u00a5\u00a9\5\16\b\2\u00a6"+
		"\u00a8\5\22\n\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3"+
		"\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\21\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac"+
		"\u00ad\7\13\2\2\u00ad\u00ae\5\6\4\2\u00ae\u00af\5\16\b\2\u00af\23\3\2"+
		"\2\2\u00b0\u00b3\5 \21\2\u00b1\u00b3\5\34\17\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3\u00b9\3\2\2\2\u00b4\u00b5\5\6\4\2\u00b5\u00b6\7\f"+
		"\2\2\u00b6\u00b7\5\6\4\2\u00b7\u00b8\5\26\f\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00b4\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\25\3\2\2\2\u00bd\u00c1\5`\61\2\u00be\u00c1\5V,\2\u00bf\u00c1"+
		"\5\"\22\2\u00c0\u00bd\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2"+
		"\u00c1\27\3\2\2\2\u00c2\u00c3\5\32\16\2\u00c3\u00c4\5\6\4\2\u00c4\u00c5"+
		"\7\25\2\2\u00c5\u00c6\5\6\4\2\u00c6\u00c7\5\16\b\2\u00c7\31\3\2\2\2\u00c8"+
		"\u00c9\7\22\2\2\u00c9\33\3\2\2\2\u00ca\u00cc\5\36\20\2\u00cb\u00cd\5^"+
		"\60\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\35\3\2\2\2\u00ce\u00cf"+
		"\5&\24\2\u00cf\u00d1\5\6\4\2\u00d0\u00d2\5T+\2\u00d1\u00d0\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\37\3\2\2\2\u00d3\u00d4\5\34\17\2\u00d4\u00d5\5\""+
		"\22\2\u00d5!\3\2\2\2\u00d6\u00da\5\6\4\2\u00d7\u00d8\5$\23\2\u00d8\u00d9"+
		"\5\6\4\2\u00d9\u00db\3\2\2\2\u00da\u00d7\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd#\3\2\2\2\u00de\u00df\7 \2\2\u00df"+
		"\u00e0\5\6\4\2\u00e0\u00e1\5\34\17\2\u00e1\u00e2\5\6\4\2\u00e2%\3\2\2"+
		"\2\u00e3\u00e7\5*\26\2\u00e4\u00e7\5\\/\2\u00e5\u00e7\5(\25\2\u00e6\u00e3"+
		"\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\'\3\2\2\2\u00e8"+
		"\u00e9\7\t\2\2\u00e9\u00ea\5\6\4\2\u00ea\u00eb\5\16\b\2\u00eb\u00ec\5"+
		"\6\4\2\u00ec\u00ed\7\b\2\2\u00ed)\3\2\2\2\u00ee\u00f1\5,\27\2\u00ef\u00f1"+
		"\5\66\34\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1+\3\2\2\2\u00f2"+
		"\u00f6\5\62\32\2\u00f3\u00f6\5\64\33\2\u00f4\u00f6\5.\30\2\u00f5\u00f2"+
		"\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6-\3\2\2\2\u00f7"+
		"\u00f9\7\6\2\2\u00f8\u00fa\5\60\31\2\u00f9\u00f8\3\2\2\2\u00f9\u00fa\3"+
		"\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fe\5\6\4\2\u00fc\u00fd\7\n\2\2\u00fd"+
		"\u00ff\5\6\4\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0101\5\4\3\2\u0101\u0102\7\7\2\2\u0102/\3\2\2\2\u0103\u0104"+
		"\5\6\4\2\u0104\u0105\7!\2\2\u0105\u0107\3\2\2\2\u0106\u0103\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\61\3\2\2"+
		"\2\u010a\u010b\7\33\2\2\u010b\u010d\5\6\4\2\u010c\u010e\5\20\t\2\u010d"+
		"\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\5\6"+
		"\4\2\u0110\u0111\7\34\2\2\u0111\63\3\2\2\2\u0112\u0113\7\35\2\2\u0113"+
		"\u0115\5\6\4\2\u0114\u0116\5\20\t\2\u0115\u0114\3\2\2\2\u0115\u0116\3"+
		"\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\5\6\4\2\u0118\u0119\7\34\2\2\u0119"+
		"\65\3\2\2\2\u011a\u0121\5<\37\2\u011b\u0121\5D#\2\u011c\u0121\58\35\2"+
		"\u011d\u0121\5N(\2\u011e\u0121\5F$\2\u011f\u0121\5H%\2\u0120\u011a\3\2"+
		"\2\2\u0120\u011b\3\2\2\2\u0120\u011c\3\2\2\2\u0120\u011d\3\2\2\2\u0120"+
		"\u011e\3\2\2\2\u0120\u011f\3\2\2\2\u0121\67\3\2\2\2\u0122\u0127\5:\36"+
		"\2\u0123\u0127\5> \2\u0124\u0127\5B\"\2\u0125\u0127\5@!\2\u0126\u0122"+
		"\3\2\2\2\u0126\u0123\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127"+
		"9\3\2\2\2\u0128\u012b\5B\"\2\u0129\u012b\5@!\2\u012a\u0128\3\2\2\2\u012a"+
		"\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\7\30\2\2\u012d\u012e\5"+
		"@!\2\u012e;\3\2\2\2\u012f\u0130\7\"\2\2\u0130=\3\2\2\2\u0131\u0133\7\20"+
		"\2\2\u0132\u0131\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0136\7\31\2\2\u0135\u0137\7\37\2\2\u0136\u0135\3\2\2\2\u0137\u0138\3"+
		"\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139?\3\2\2\2\u013a\u013c"+
		"\7\20\2\2\u013b\u013a\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2"+
		"\u013d\u013f\7\36\2\2\u013e\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u013e"+
		"\3\2\2\2\u0140\u0141\3\2\2\2\u0141A\3\2\2\2\u0142\u0144\7\20\2\2\u0143"+
		"\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145\u0147\7\36"+
		"\2\2\u0146\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0146\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\7\13\2\2\u014b\u014d\7"+
		"\36\2\2\u014c\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014c\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014fC\3\2\2\2\u0150\u0151\7\21\2\2\u0151E\3\2\2\2\u0152"+
		"\u0153\7\4\2\2\u0153G\3\2\2\2\u0154\u0155\7\26\2\2\u0155\u0156\5L\'\2"+
		"\u0156I\3\2\2\2\u0157\u0158\7\16\2\2\u0158\u0159\5\6\4\2\u0159\u015a\7"+
		" \2\2\u015a\u015c\5\6\4\2\u015b\u015d\7\36\2\2\u015c\u015b\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2"+
		"\2\2\u0160\u0161\5\6\4\2\u0161\u0162\7\17\2\2\u0162K\3\2\2\2\u0163\u0170"+
		"\t\3\2\2\u0164\u0166\7 \2\2\u0165\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167"+
		"\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0170\3\2\2\2\u0169\u0170\5F"+
		"$\2\u016a\u016c\7\n\2\2\u016b\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0170\3\2\2\2\u016f\u0163\3\2"+
		"\2\2\u016f\u0165\3\2\2\2\u016f\u0169\3\2\2\2\u016f\u016b\3\2\2\2\u0170"+
		"M\3\2\2\2\u0171\u0172\7\32\2\2\u0172\u0173\5P)\2\u0173O\3\2\2\2\u0174"+
		"\u0178\5\6\4\2\u0175\u0179\5\66\34\2\u0176\u0179\5R*\2\u0177\u0179\5L"+
		"\'\2\u0178\u0175\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0177\3\2\2\2\u0179"+
		"\u017b\3\2\2\2\u017a\u0174\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2"+
		"\2\2\u017c\u017d\3\2\2\2\u017d\u017f\3\2\2\2\u017e\u017c\3\2\2\2\u017f"+
		"\u0180\5\6\4\2\u0180\u0181\7\b\2\2\u0181Q\3\2\2\2\u0182\u0183\7\t\2\2"+
		"\u0183\u0184\5P)\2\u0184S\3\2\2\2\u0185\u0186\5V,\2\u0186\u0188\5\6\4"+
		"\2\u0187\u0189\5T+\2\u0188\u0187\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a"+
		"\3\2\2\2\u018a\u018b\5\6\4\2\u018bU\3\2\2\2\u018c\u018d\5\6\4\2\u018d"+
		"\u018e\5X-\2\u018eW\3\2\2\2\u018f\u0190\7\22\2\2\u0190Y\3\2\2\2\u0191"+
		"\u0193\7 \2\2\u0192\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0192\3\2"+
		"\2\2\u0194\u0195\3\2\2\2\u0195[\3\2\2\2\u0196\u0197\5\32\16\2\u0197]\3"+
		"\2\2\2\u0198\u019a\5`\61\2\u0199\u019b\5^\60\2\u019a\u0199\3\2\2\2\u019a"+
		"\u019b\3\2\2\2\u019b_\3\2\2\2\u019c\u019d\5\6\4\2\u019d\u019e\7\r\2\2"+
		"\u019e\u01a1\5\6\4\2\u019f\u01a2\5\36\20\2\u01a0\u01a2\5&\24\2\u01a1\u019f"+
		"\3\2\2\2\u01a1\u01a0\3\2\2\2\u01a2a\3\2\2\2.ikpw\u0081\u0091\u0095\u009c"+
		"\u00a3\u00a9\u00b2\u00bb\u00c0\u00cc\u00d1\u00dc\u00e6\u00f0\u00f5\u00f9"+
		"\u00fe\u0108\u010d\u0115\u0120\u0126\u012a\u0132\u0138\u013b\u0140\u0143"+
		"\u0148\u014e\u015e\u0167\u016d\u016f\u0178\u017c\u0188\u0194\u019a\u01a1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}