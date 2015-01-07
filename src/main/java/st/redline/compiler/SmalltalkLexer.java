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
		SEPARATOR=1, STRING=2, COMMENT=3, BLOCK_START=4, BLOCK_END=5, LT=6, GT=7, 
		PIPE=8, MINUS=9, RESERVED_WORD=10, IDENTIFIER=11, PERIOD=12, CARROT=13, 
		COLON=14, SEMI_COLON=15, ASSIGNMENT=16, HASH=17, DOLLAR=18, EXP=19, HEX=20, 
		LITARR_START=21, CLOSE_PAREN=22, OPEN_PAREN=23, DYNDICT_START=24, DYNARR_END=25, 
		DYNARR_START=26, DIGIT=27, HEXDIGIT=28, BINARY_SELECTOR=29, KEYWORD=30, 
		BLOCK_PARAM=31, CHARACTER_CONSTANT=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"SEPARATOR", "STRING", "COMMENT", "'['", "']'", "'<'", "'>'", "'|'", "'-'", 
		"RESERVED_WORD", "IDENTIFIER", "'.'", "'^'", "':'", "';'", "':='", "'#'", 
		"'$'", "'e'", "'16r'", "'#('", "')'", "'('", "'#{'", "'}'", "'{'", "DIGIT", 
		"HEXDIGIT", "BINARY_SELECTOR", "KEYWORD", "BLOCK_PARAM", "CHARACTER_CONSTANT"
	};
	public static final String[] ruleNames = {
		"SEPARATOR", "STRING", "COMMENT", "BLOCK_START", "BLOCK_END", "LT", "GT", 
		"PIPE", "MINUS", "RESERVED_WORD", "IDENTIFIER", "PERIOD", "CARROT", "COLON", 
		"SEMI_COLON", "ASSIGNMENT", "HASH", "DOLLAR", "EXP", "HEX", "LITARR_START", 
		"CLOSE_PAREN", "OPEN_PAREN", "DYNDICT_START", "DYNARR_END", "DYNARR_START", 
		"DIGIT", "HEXDIGIT", "BINARY_SELECTOR", "KEYWORD", "BLOCK_PARAM", "CHARACTER_CONSTANT"
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
		"\t!\3\2\3\2\3\3\3\3\7\3H\n\3\f\3\16\3K\13\3\3\3\3\3\3\4\3\4\7\4Q\n\4\f"+
		"\4\16\4T\13\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13y\n\13\3\f\6\f|\n\f\r\f\16\f}"+
		"\3\f\7\f\u0081\n\f\f\f\16\f\u0084\13\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\6\36\u00b5"+
		"\n\36\r\36\16\36\u00b6\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\5!\u00c2\n!\4"+
		"IR\"\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1"+
		"\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1"+
		"+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1"+
		"A\"\1\3\2\t\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\5\2\62"+
		";CHch\6\2,-\61\61??^^\6\2\'\'..BB\u0080\u0080\u00d3\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5E\3\2\2\2\7N\3\2\2\2\tW\3\2\2\2\13Y\3"+
		"\2\2\2\r[\3\2\2\2\17]\3\2\2\2\21_\3\2\2\2\23a\3\2\2\2\25x\3\2\2\2\27{"+
		"\3\2\2\2\31\u0085\3\2\2\2\33\u0087\3\2\2\2\35\u0089\3\2\2\2\37\u008b\3"+
		"\2\2\2!\u008d\3\2\2\2#\u0090\3\2\2\2%\u0092\3\2\2\2\'\u0094\3\2\2\2)\u0096"+
		"\3\2\2\2+\u009a\3\2\2\2-\u009d\3\2\2\2/\u009f\3\2\2\2\61\u00a1\3\2\2\2"+
		"\63\u00a4\3\2\2\2\65\u00a6\3\2\2\2\67\u00a8\3\2\2\29\u00aa\3\2\2\2;\u00b4"+
		"\3\2\2\2=\u00b8\3\2\2\2?\u00bb\3\2\2\2A\u00be\3\2\2\2CD\t\2\2\2D\4\3\2"+
		"\2\2EI\7)\2\2FH\13\2\2\2GF\3\2\2\2HK\3\2\2\2IJ\3\2\2\2IG\3\2\2\2JL\3\2"+
		"\2\2KI\3\2\2\2LM\7)\2\2M\6\3\2\2\2NR\7$\2\2OQ\13\2\2\2PO\3\2\2\2QT\3\2"+
		"\2\2RS\3\2\2\2RP\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7$\2\2V\b\3\2\2\2WX\7]"+
		"\2\2X\n\3\2\2\2YZ\7_\2\2Z\f\3\2\2\2[\\\7>\2\2\\\16\3\2\2\2]^\7@\2\2^\20"+
		"\3\2\2\2_`\7~\2\2`\22\3\2\2\2ab\7/\2\2b\24\3\2\2\2cd\7p\2\2de\7k\2\2e"+
		"y\7n\2\2fg\7v\2\2gh\7t\2\2hi\7w\2\2iy\7g\2\2jk\7h\2\2kl\7c\2\2lm\7n\2"+
		"\2mn\7u\2\2ny\7g\2\2op\7u\2\2pq\7g\2\2qr\7n\2\2ry\7h\2\2st\7u\2\2tu\7"+
		"w\2\2uv\7r\2\2vw\7g\2\2wy\7t\2\2xc\3\2\2\2xf\3\2\2\2xj\3\2\2\2xo\3\2\2"+
		"\2xs\3\2\2\2y\26\3\2\2\2z|\t\3\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2"+
		"\2\2~\u0082\3\2\2\2\177\u0081\t\4\2\2\u0080\177\3\2\2\2\u0081\u0084\3"+
		"\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\30\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0085\u0086\7\60\2\2\u0086\32\3\2\2\2\u0087\u0088\7`\2"+
		"\2\u0088\34\3\2\2\2\u0089\u008a\7<\2\2\u008a\36\3\2\2\2\u008b\u008c\7"+
		"=\2\2\u008c \3\2\2\2\u008d\u008e\7<\2\2\u008e\u008f\7?\2\2\u008f\"\3\2"+
		"\2\2\u0090\u0091\7%\2\2\u0091$\3\2\2\2\u0092\u0093\7&\2\2\u0093&\3\2\2"+
		"\2\u0094\u0095\7g\2\2\u0095(\3\2\2\2\u0096\u0097\7\63\2\2\u0097\u0098"+
		"\78\2\2\u0098\u0099\7t\2\2\u0099*\3\2\2\2\u009a\u009b\7%\2\2\u009b\u009c"+
		"\7*\2\2\u009c,\3\2\2\2\u009d\u009e\7+\2\2\u009e.\3\2\2\2\u009f\u00a0\7"+
		"*\2\2\u00a0\60\3\2\2\2\u00a1\u00a2\7%\2\2\u00a2\u00a3\7}\2\2\u00a3\62"+
		"\3\2\2\2\u00a4\u00a5\7\177\2\2\u00a5\64\3\2\2\2\u00a6\u00a7\7}\2\2\u00a7"+
		"\66\3\2\2\2\u00a8\u00a9\t\5\2\2\u00a98\3\2\2\2\u00aa\u00ab\t\6\2\2\u00ab"+
		":\3\2\2\2\u00ac\u00b5\t\7\2\2\u00ad\u00b5\5\17\b\2\u00ae\u00b5\5\r\7\2"+
		"\u00af\u00b5\t\b\2\2\u00b0\u00b5\5\21\t\2\u00b1\u00b5\7(\2\2\u00b2\u00b5"+
		"\5\23\n\2\u00b3\u00b5\7A\2\2\u00b4\u00ac\3\2\2\2\u00b4\u00ad\3\2\2\2\u00b4"+
		"\u00ae\3\2\2\2\u00b4\u00af\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b1\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7<\3\2\2\2\u00b8\u00b9\5\27\f\2"+
		"\u00b9\u00ba\5\35\17\2\u00ba>\3\2\2\2\u00bb\u00bc\5\35\17\2\u00bc\u00bd"+
		"\5\27\f\2\u00bd@\3\2\2\2\u00be\u00c1\5%\23\2\u00bf\u00c2\59\35\2\u00c0"+
		"\u00c2\5%\23\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2B\3\2\2\2"+
		"\13\2IRx}\u0082\u00b4\u00b6\u00c1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}