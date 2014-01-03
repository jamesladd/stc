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
		IDENTIFIER=1, PERIOD=2, CARROT=3, COLON=4, SEMI_COLON=5, ASSIGNMENT=6, 
		HASH=7, DOLLAR=8, EXP=9, HEX=10, LITARR_START=11, CLOSE_PAREN=12, OPEN_PAREN=13, 
		DYNDICT_START=14, DYNARR_END=15, DYNARR_START=16, BLOCK_START=17, BLOCK_END=18, 
		RESERVED_WORD=19, DIGIT=20, HEXDIGIT=21, BINARY_SELECTOR=22, KEYWORD=23, 
		BLOCK_PARAM=24, CHARACTER_CONSTANT=25, SEPARATOR=26, STRING=27, COMMENT=28, 
		LT=29, GT=30, PIPE=31, MINUS=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"IDENTIFIER", "'.'", "'^'", "':'", "';'", "':='", "'#'", "'$'", "'e'", 
		"'16r'", "'#('", "')'", "'('", "'#{'", "'}'", "'{'", "'['", "']'", "RESERVED_WORD", 
		"DIGIT", "HEXDIGIT", "BINARY_SELECTOR", "KEYWORD", "BLOCK_PARAM", "CHARACTER_CONSTANT", 
		"SEPARATOR", "STRING", "COMMENT", "'<'", "'>'", "'|'", "'-'"
	};
	public static final String[] ruleNames = {
		"IDENTIFIER", "PERIOD", "CARROT", "COLON", "SEMI_COLON", "ASSIGNMENT", 
		"HASH", "DOLLAR", "EXP", "HEX", "LITARR_START", "CLOSE_PAREN", "OPEN_PAREN", 
		"DYNDICT_START", "DYNARR_END", "DYNARR_START", "BLOCK_START", "BLOCK_END", 
		"RESERVED_WORD", "DIGIT", "HEXDIGIT", "BINARY_SELECTOR", "KEYWORD", "BLOCK_PARAM", 
		"CHARACTER_CONSTANT", "SEPARATOR", "STRING", "COMMENT", "LT", "GT", "PIPE", 
		"MINUS"
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\"\u00c3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\6\2E\n\2\r\2\16\2F\3\2\7\2J\n\2\f\2\16\2M\13\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u008b\n\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\6\27\u0099"+
		"\n\27\r\27\16\27\u009a\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\5"+
		"\32\u00a6\n\32\3\33\3\33\3\34\3\34\7\34\u00ac\n\34\f\34\16\34\u00af\13"+
		"\34\3\34\3\34\3\35\3\35\7\35\u00b5\n\35\f\35\16\35\u00b8\13\35\3\35\3"+
		"\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\4\u00ad\u00b6\"\3\3\1\5\4\1\7\5\1"+
		"\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17"+
		"\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61"+
		"\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1\3\2\t\4\2C\\c|"+
		"\6\2\62;C\\aac|\3\2\62;\5\2\62;CHch\6\2,-\61\61??^^\6\2\'\'..BB\u0080"+
		"\u0080\5\2\13\f\17\17\"\"\u00d3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\3D\3\2\2\2\5N\3\2\2\2\7P\3\2\2\2\tR\3\2\2\2\13T\3\2\2\2\rV\3\2\2\2\17"+
		"Y\3\2\2\2\21[\3\2\2\2\23]\3\2\2\2\25_\3\2\2\2\27c\3\2\2\2\31f\3\2\2\2"+
		"\33h\3\2\2\2\35j\3\2\2\2\37m\3\2\2\2!o\3\2\2\2#q\3\2\2\2%s\3\2\2\2\'\u008a"+
		"\3\2\2\2)\u008c\3\2\2\2+\u008e\3\2\2\2-\u0098\3\2\2\2/\u009c\3\2\2\2\61"+
		"\u009f\3\2\2\2\63\u00a2\3\2\2\2\65\u00a7\3\2\2\2\67\u00a9\3\2\2\29\u00b2"+
		"\3\2\2\2;\u00bb\3\2\2\2=\u00bd\3\2\2\2?\u00bf\3\2\2\2A\u00c1\3\2\2\2C"+
		"E\t\2\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2GK\3\2\2\2HJ\t\3\2\2"+
		"IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\4\3\2\2\2MK\3\2\2\2NO\7\60\2"+
		"\2O\6\3\2\2\2PQ\7`\2\2Q\b\3\2\2\2RS\7<\2\2S\n\3\2\2\2TU\7=\2\2U\f\3\2"+
		"\2\2VW\7<\2\2WX\7?\2\2X\16\3\2\2\2YZ\7%\2\2Z\20\3\2\2\2[\\\7&\2\2\\\22"+
		"\3\2\2\2]^\7g\2\2^\24\3\2\2\2_`\7\63\2\2`a\78\2\2ab\7t\2\2b\26\3\2\2\2"+
		"cd\7%\2\2de\7*\2\2e\30\3\2\2\2fg\7+\2\2g\32\3\2\2\2hi\7*\2\2i\34\3\2\2"+
		"\2jk\7%\2\2kl\7}\2\2l\36\3\2\2\2mn\7\177\2\2n \3\2\2\2op\7}\2\2p\"\3\2"+
		"\2\2qr\7]\2\2r$\3\2\2\2st\7_\2\2t&\3\2\2\2uv\7p\2\2vw\7k\2\2w\u008b\7"+
		"n\2\2xy\7v\2\2yz\7t\2\2z{\7w\2\2{\u008b\7g\2\2|}\7h\2\2}~\7c\2\2~\177"+
		"\7n\2\2\177\u0080\7u\2\2\u0080\u008b\7g\2\2\u0081\u0082\7u\2\2\u0082\u0083"+
		"\7g\2\2\u0083\u0084\7n\2\2\u0084\u008b\7h\2\2\u0085\u0086\7u\2\2\u0086"+
		"\u0087\7w\2\2\u0087\u0088\7r\2\2\u0088\u0089\7g\2\2\u0089\u008b\7t\2\2"+
		"\u008au\3\2\2\2\u008ax\3\2\2\2\u008a|\3\2\2\2\u008a\u0081\3\2\2\2\u008a"+
		"\u0085\3\2\2\2\u008b(\3\2\2\2\u008c\u008d\t\4\2\2\u008d*\3\2\2\2\u008e"+
		"\u008f\t\5\2\2\u008f,\3\2\2\2\u0090\u0099\t\6\2\2\u0091\u0099\5=\37\2"+
		"\u0092\u0099\5;\36\2\u0093\u0099\t\7\2\2\u0094\u0099\5? \2\u0095\u0099"+
		"\7(\2\2\u0096\u0099\5A!\2\u0097\u0099\7A\2\2\u0098\u0090\3\2\2\2\u0098"+
		"\u0091\3\2\2\2\u0098\u0092\3\2\2\2\u0098\u0093\3\2\2\2\u0098\u0094\3\2"+
		"\2\2\u0098\u0095\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b.\3\2\2\2"+
		"\u009c\u009d\5\3\2\2\u009d\u009e\5\t\5\2\u009e\60\3\2\2\2\u009f\u00a0"+
		"\5\t\5\2\u00a0\u00a1\5\3\2\2\u00a1\62\3\2\2\2\u00a2\u00a5\5\21\t\2\u00a3"+
		"\u00a6\5+\26\2\u00a4\u00a6\5\21\t\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3"+
		"\2\2\2\u00a6\64\3\2\2\2\u00a7\u00a8\t\b\2\2\u00a8\66\3\2\2\2\u00a9\u00ad"+
		"\7)\2\2\u00aa\u00ac\13\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00b0\u00b1\7)\2\2\u00b18\3\2\2\2\u00b2\u00b6\7$\2\2\u00b3\u00b5"+
		"\13\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b7\3\2\2\2"+
		"\u00b6\u00b4\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba"+
		"\7$\2\2\u00ba:\3\2\2\2\u00bb\u00bc\7>\2\2\u00bc<\3\2\2\2\u00bd\u00be\7"+
		"@\2\2\u00be>\3\2\2\2\u00bf\u00c0\7~\2\2\u00c0@\3\2\2\2\u00c1\u00c2\7/"+
		"\2\2\u00c2B\3\2\2\2\13\2FK\u008a\u0098\u009a\u00a5\u00ad\u00b6";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}