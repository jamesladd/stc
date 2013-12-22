// Generated from Smalltalk.g4 by ANTLR 4.1
package st.redline.compiler;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmalltalkLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'|'", "'.'", "'^'", "':'", "';'", "':='", "'-'", "'#'", "'$'", "'e'", 
		"'16r'", "'#('", "')'", "'('", "'#{'", "'}'", "'{'", "'['", "']'", "'<'", 
		"'>'", "RESERVED_WORD", "DIGIT", "DIGITS", "HEXDIGIT", "BINARY_SELECTOR", 
		"IDENTIFIER", "KEYWORD", "BLOCK_PARAM", "CHARACTER_CONSTANT", "SEPARATOR", 
		"STRING", "COMMENT"
	};
	public static final String[] ruleNames = {
		"PIPE", "PERIOD", "CARROT", "COLON", "SEMI_COLON", "ASSIGNMENT", "MINUS", 
		"HASH", "DOLLAR", "EXP", "HEX", "LITARR_START", "CLOSE_PAREN", "OPEN_PAREN", 
		"DYNDICT_START", "DYNARR_END", "DYNARR_START", "BLOCK_START", "BLOCK_END", 
		"LT", "GT", "RESERVED_WORD", "DIGIT", "DIGITS", "HEXDIGIT", "BINARY_SELECTOR", 
		"IDENTIFIER", "KEYWORD", "BLOCK_PARAM", "CHARACTER_CONSTANT", "SEPARATOR", 
		"STRING", "COMMENT"
	};


	public SmalltalkLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Smalltalk.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2#\u00c4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u008a\n\27\3\30\3\30"+
		"\3\31\6\31\u008f\n\31\r\31\16\31\u0090\3\32\3\32\5\32\u0095\n\32\3\33"+
		"\6\33\u0098\n\33\r\33\16\33\u0099\3\34\3\34\7\34\u009e\n\34\f\34\16\34"+
		"\u00a1\13\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\5\37\u00ac\n"+
		"\37\3 \6 \u00af\n \r \16 \u00b0\3!\3!\7!\u00b5\n!\f!\16!\u00b8\13!\3!"+
		"\3!\3\"\3\"\7\"\u00be\n\"\f\"\16\"\u00c1\13\"\3\"\3\"\4\u00b6\u00bf#\3"+
		"\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r"+
		"\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27"+
		"\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\""+
		"\1C#\1\3\2\6\4\2C\\c|\t\2\'(,/\61\61>B^^~~\u0080\u0080\6\2\62;C\\aac|"+
		"\b\2\13\f\17\17\"\"\u00a2\u00a2\u202a\u202b\uff01\uff01\u00cf\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5G\3\2\2\2\7I\3"+
		"\2\2\2\tK\3\2\2\2\13M\3\2\2\2\rO\3\2\2\2\17R\3\2\2\2\21T\3\2\2\2\23V\3"+
		"\2\2\2\25X\3\2\2\2\27Z\3\2\2\2\31^\3\2\2\2\33a\3\2\2\2\35c\3\2\2\2\37"+
		"e\3\2\2\2!h\3\2\2\2#j\3\2\2\2%l\3\2\2\2\'n\3\2\2\2)p\3\2\2\2+r\3\2\2\2"+
		"-\u0089\3\2\2\2/\u008b\3\2\2\2\61\u008e\3\2\2\2\63\u0094\3\2\2\2\65\u0097"+
		"\3\2\2\2\67\u009b\3\2\2\29\u00a2\3\2\2\2;\u00a5\3\2\2\2=\u00a8\3\2\2\2"+
		"?\u00ae\3\2\2\2A\u00b2\3\2\2\2C\u00bb\3\2\2\2EF\7~\2\2F\4\3\2\2\2GH\7"+
		"\60\2\2H\6\3\2\2\2IJ\7`\2\2J\b\3\2\2\2KL\7<\2\2L\n\3\2\2\2MN\7=\2\2N\f"+
		"\3\2\2\2OP\7<\2\2PQ\7?\2\2Q\16\3\2\2\2RS\7/\2\2S\20\3\2\2\2TU\7%\2\2U"+
		"\22\3\2\2\2VW\7&\2\2W\24\3\2\2\2XY\7g\2\2Y\26\3\2\2\2Z[\7\63\2\2[\\\7"+
		"8\2\2\\]\7t\2\2]\30\3\2\2\2^_\7%\2\2_`\7*\2\2`\32\3\2\2\2ab\7+\2\2b\34"+
		"\3\2\2\2cd\7*\2\2d\36\3\2\2\2ef\7%\2\2fg\7}\2\2g \3\2\2\2hi\7\177\2\2"+
		"i\"\3\2\2\2jk\7}\2\2k$\3\2\2\2lm\7]\2\2m&\3\2\2\2no\7_\2\2o(\3\2\2\2p"+
		"q\7>\2\2q*\3\2\2\2rs\7@\2\2s,\3\2\2\2tu\7u\2\2uv\7g\2\2vw\7n\2\2w\u008a"+
		"\7h\2\2xy\7p\2\2yz\7k\2\2z\u008a\7n\2\2{|\7v\2\2|}\7t\2\2}~\7w\2\2~\u008a"+
		"\7g\2\2\177\u0080\7h\2\2\u0080\u0081\7c\2\2\u0081\u0082\7n\2\2\u0082\u0083"+
		"\7u\2\2\u0083\u008a\7g\2\2\u0084\u0085\7u\2\2\u0085\u0086\7w\2\2\u0086"+
		"\u0087\7r\2\2\u0087\u0088\7g\2\2\u0088\u008a\7t\2\2\u0089t\3\2\2\2\u0089"+
		"x\3\2\2\2\u0089{\3\2\2\2\u0089\177\3\2\2\2\u0089\u0084\3\2\2\2\u008a."+
		"\3\2\2\2\u008b\u008c\4\62;\2\u008c\60\3\2\2\2\u008d\u008f\4\62;\2\u008e"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\62\3\2\2\2\u0092\u0095\t\2\2\2\u0093\u0095\5/\30\2\u0094\u0092"+
		"\3\2\2\2\u0094\u0093\3\2\2\2\u0095\64\3\2\2\2\u0096\u0098\t\3\2\2\u0097"+
		"\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\66\3\2\2\2\u009b\u009f\t\2\2\2\u009c\u009e\t\4\2\2\u009d\u009c"+
		"\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"8\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\5\67\34\2\u00a3\u00a4\5\t\5"+
		"\2\u00a4:\3\2\2\2\u00a5\u00a6\5\t\5\2\u00a6\u00a7\5\67\34\2\u00a7<\3\2"+
		"\2\2\u00a8\u00ab\5\23\n\2\u00a9\u00ac\5\63\32\2\u00aa\u00ac\5\23\n\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac>\3\2\2\2\u00ad\u00af\t\5\2\2"+
		"\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1@\3\2\2\2\u00b2\u00b6\7)\2\2\u00b3\u00b5\13\2\2\2\u00b4"+
		"\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7)\2\2\u00ba"+
		"B\3\2\2\2\u00bb\u00bf\7$\2\2\u00bc\u00be\13\2\2\2\u00bd\u00bc\3\2\2\2"+
		"\u00be\u00c1\3\2\2\2\u00bf\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c2"+
		"\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7$\2\2\u00c3D\3\2\2\2\f\2\u0089"+
		"\u0090\u0094\u0099\u009f\u00ab\u00b0\u00b6\u00bf";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}