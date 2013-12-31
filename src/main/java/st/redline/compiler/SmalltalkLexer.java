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
		LT=20, GT=21, RESERVED_WORD=22, DIGIT=23, HEXDIGIT=24, BINARY_SELECTOR=25, 
		IDENTIFIER=26, KEYWORD=27, BLOCK_PARAM=28, CHARACTER_CONSTANT=29, SEPARATOR=30, 
		STRING=31, COMMENT=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'|'", "'.'", "'^'", "':'", "';'", "':='", "'-'", "'#'", "'$'", "'e'", 
		"'16r'", "'#('", "')'", "'('", "'#{'", "'}'", "'{'", "'['", "']'", "'<'", 
		"'>'", "RESERVED_WORD", "DIGIT", "HEXDIGIT", "BINARY_SELECTOR", "IDENTIFIER", 
		"KEYWORD", "BLOCK_PARAM", "CHARACTER_CONSTANT", "SEPARATOR", "STRING", 
		"COMMENT"
	};
	public static final String[] ruleNames = {
		"PIPE", "PERIOD", "CARROT", "COLON", "SEMI_COLON", "ASSIGNMENT", "MINUS", 
		"HASH", "DOLLAR", "EXP", "HEX", "LITARR_START", "CLOSE_PAREN", "OPEN_PAREN", 
		"DYNDICT_START", "DYNARR_END", "DYNARR_START", "BLOCK_START", "BLOCK_END", 
		"LT", "GT", "RESERVED_WORD", "DIGIT", "HEXDIGIT", "BINARY_SELECTOR", "IDENTIFIER", 
		"KEYWORD", "BLOCK_PARAM", "CHARACTER_CONSTANT", "SEPARATOR", "STRING", 
		"COMMENT"
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\"\u00bd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0088\n\27\3\30\3\30\3\31"+
		"\3\31\5\31\u008e\n\31\3\32\6\32\u0091\n\32\r\32\16\32\u0092\3\33\3\33"+
		"\7\33\u0097\n\33\f\33\16\33\u009a\13\33\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\5\36\u00a5\n\36\3\37\6\37\u00a8\n\37\r\37\16\37\u00a9"+
		"\3 \3 \7 \u00ae\n \f \16 \u00b1\13 \3 \3 \3!\3!\7!\u00b7\n!\f!\16!\u00ba"+
		"\13!\3!\3!\4\u00af\u00b8\"\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1"+
		"\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23"+
		"\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35"+
		"\19\36\1;\37\1= \1?!\1A\"\1\3\2\6\4\2C\\c|\t\2\'(,/\61\61>B^^~~\u0080"+
		"\u0080\6\2\62;C\\aac|\b\2\13\f\17\17\"\"\u00a2\u00a2\u202a\u202b\uff01"+
		"\uff01\u00c7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5E\3\2\2"+
		"\2\7G\3\2\2\2\tI\3\2\2\2\13K\3\2\2\2\rM\3\2\2\2\17P\3\2\2\2\21R\3\2\2"+
		"\2\23T\3\2\2\2\25V\3\2\2\2\27X\3\2\2\2\31\\\3\2\2\2\33_\3\2\2\2\35a\3"+
		"\2\2\2\37c\3\2\2\2!f\3\2\2\2#h\3\2\2\2%j\3\2\2\2\'l\3\2\2\2)n\3\2\2\2"+
		"+p\3\2\2\2-\u0087\3\2\2\2/\u0089\3\2\2\2\61\u008d\3\2\2\2\63\u0090\3\2"+
		"\2\2\65\u0094\3\2\2\2\67\u009b\3\2\2\29\u009e\3\2\2\2;\u00a1\3\2\2\2="+
		"\u00a7\3\2\2\2?\u00ab\3\2\2\2A\u00b4\3\2\2\2CD\7~\2\2D\4\3\2\2\2EF\7\60"+
		"\2\2F\6\3\2\2\2GH\7`\2\2H\b\3\2\2\2IJ\7<\2\2J\n\3\2\2\2KL\7=\2\2L\f\3"+
		"\2\2\2MN\7<\2\2NO\7?\2\2O\16\3\2\2\2PQ\7/\2\2Q\20\3\2\2\2RS\7%\2\2S\22"+
		"\3\2\2\2TU\7&\2\2U\24\3\2\2\2VW\7g\2\2W\26\3\2\2\2XY\7\63\2\2YZ\78\2\2"+
		"Z[\7t\2\2[\30\3\2\2\2\\]\7%\2\2]^\7*\2\2^\32\3\2\2\2_`\7+\2\2`\34\3\2"+
		"\2\2ab\7*\2\2b\36\3\2\2\2cd\7%\2\2de\7}\2\2e \3\2\2\2fg\7\177\2\2g\"\3"+
		"\2\2\2hi\7}\2\2i$\3\2\2\2jk\7]\2\2k&\3\2\2\2lm\7_\2\2m(\3\2\2\2no\7>\2"+
		"\2o*\3\2\2\2pq\7@\2\2q,\3\2\2\2rs\7u\2\2st\7g\2\2tu\7n\2\2u\u0088\7h\2"+
		"\2vw\7p\2\2wx\7k\2\2x\u0088\7n\2\2yz\7v\2\2z{\7t\2\2{|\7w\2\2|\u0088\7"+
		"g\2\2}~\7h\2\2~\177\7c\2\2\177\u0080\7n\2\2\u0080\u0081\7u\2\2\u0081\u0088"+
		"\7g\2\2\u0082\u0083\7u\2\2\u0083\u0084\7w\2\2\u0084\u0085\7r\2\2\u0085"+
		"\u0086\7g\2\2\u0086\u0088\7t\2\2\u0087r\3\2\2\2\u0087v\3\2\2\2\u0087y"+
		"\3\2\2\2\u0087}\3\2\2\2\u0087\u0082\3\2\2\2\u0088.\3\2\2\2\u0089\u008a"+
		"\4\62;\2\u008a\60\3\2\2\2\u008b\u008e\t\2\2\2\u008c\u008e\5/\30\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\62\3\2\2\2\u008f\u0091\t\3\2"+
		"\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\64\3\2\2\2\u0094\u0098\t\2\2\2\u0095\u0097\t\4\2\2\u0096"+
		"\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\66\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\5\65\33\2\u009c"+
		"\u009d\5\t\5\2\u009d8\3\2\2\2\u009e\u009f\5\t\5\2\u009f\u00a0\5\65\33"+
		"\2\u00a0:\3\2\2\2\u00a1\u00a4\5\23\n\2\u00a2\u00a5\5\61\31\2\u00a3\u00a5"+
		"\5\23\n\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5<\3\2\2\2\u00a6"+
		"\u00a8\t\5\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2"+
		"\2\2\u00a9\u00aa\3\2\2\2\u00aa>\3\2\2\2\u00ab\u00af\7)\2\2\u00ac\u00ae"+
		"\13\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00b0\3\2\2\2"+
		"\u00af\u00ad\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3"+
		"\7)\2\2\u00b3@\3\2\2\2\u00b4\u00b8\7$\2\2\u00b5\u00b7\13\2\2\2\u00b6\u00b5"+
		"\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7$\2\2\u00bcB\3\2\2\2\13"+
		"\2\u0087\u008d\u0092\u0098\u00a4\u00a9\u00af\u00b8";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}