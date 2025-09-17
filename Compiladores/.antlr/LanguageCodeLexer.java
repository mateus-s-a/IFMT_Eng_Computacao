// Generated from c:/Users/mateus.arruda/Documents/[Estudos]/[Visual Studio Code]/IFMT_Eng_Computacao/Compiladores/LanguageCode.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LanguageCodeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, IF=3, ELSE=4, READ=5, GT=6, LT=7, EQ=8, ADD=9, SUB=10, 
		MUL=11, DIV=12, LPAREN=13, RPAREN=14, LBRACE=15, RBRACE=16, SEMI=17, INT=18, 
		FLOAT=19, STRING=20, ID=21, WS=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "IF", "ELSE", "READ", "GT", "LT", "EQ", "ADD", "SUB", 
			"MUL", "DIV", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMI", "INT", 
			"FLOAT", "STRING", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'print'", "'if'", "'else'", "'read'", "'>'", "'<'", "'=='", 
			"'+'", "'-'", "'*'", "'/'", "'('", "')'", "'{'", "'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "IF", "ELSE", "READ", "GT", "LT", "EQ", "ADD", "SUB", 
			"MUL", "DIV", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMI", "INT", 
			"FLOAT", "STRING", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public LanguageCodeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LanguageCode.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0016\u0082\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0004\u0011]\b\u0011\u000b"+
		"\u0011\f\u0011^\u0001\u0012\u0004\u0012b\b\u0012\u000b\u0012\f\u0012c"+
		"\u0001\u0012\u0001\u0012\u0004\u0012h\b\u0012\u000b\u0012\f\u0012i\u0001"+
		"\u0013\u0001\u0013\u0005\u0013n\b\u0013\n\u0013\f\u0013q\t\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0005\u0014w\b\u0014\n\u0014"+
		"\f\u0014z\t\u0014\u0001\u0015\u0004\u0015}\b\u0015\u000b\u0015\f\u0015"+
		"~\u0001\u0015\u0001\u0015\u0000\u0000\u0016\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016\u0001\u0000\u0005\u0001\u000009\u0001"+
		"\u0000\"\"\u0002\u0000AZaz\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u0087"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0001-\u0001\u0000\u0000\u0000\u0003/"+
		"\u0001\u0000\u0000\u0000\u00055\u0001\u0000\u0000\u0000\u00078\u0001\u0000"+
		"\u0000\u0000\t=\u0001\u0000\u0000\u0000\u000bB\u0001\u0000\u0000\u0000"+
		"\rD\u0001\u0000\u0000\u0000\u000fF\u0001\u0000\u0000\u0000\u0011I\u0001"+
		"\u0000\u0000\u0000\u0013K\u0001\u0000\u0000\u0000\u0015M\u0001\u0000\u0000"+
		"\u0000\u0017O\u0001\u0000\u0000\u0000\u0019Q\u0001\u0000\u0000\u0000\u001b"+
		"S\u0001\u0000\u0000\u0000\u001dU\u0001\u0000\u0000\u0000\u001fW\u0001"+
		"\u0000\u0000\u0000!Y\u0001\u0000\u0000\u0000#\\\u0001\u0000\u0000\u0000"+
		"%a\u0001\u0000\u0000\u0000\'k\u0001\u0000\u0000\u0000)t\u0001\u0000\u0000"+
		"\u0000+|\u0001\u0000\u0000\u0000-.\u0005=\u0000\u0000.\u0002\u0001\u0000"+
		"\u0000\u0000/0\u0005p\u0000\u000001\u0005r\u0000\u000012\u0005i\u0000"+
		"\u000023\u0005n\u0000\u000034\u0005t\u0000\u00004\u0004\u0001\u0000\u0000"+
		"\u000056\u0005i\u0000\u000067\u0005f\u0000\u00007\u0006\u0001\u0000\u0000"+
		"\u000089\u0005e\u0000\u00009:\u0005l\u0000\u0000:;\u0005s\u0000\u0000"+
		";<\u0005e\u0000\u0000<\b\u0001\u0000\u0000\u0000=>\u0005r\u0000\u0000"+
		">?\u0005e\u0000\u0000?@\u0005a\u0000\u0000@A\u0005d\u0000\u0000A\n\u0001"+
		"\u0000\u0000\u0000BC\u0005>\u0000\u0000C\f\u0001\u0000\u0000\u0000DE\u0005"+
		"<\u0000\u0000E\u000e\u0001\u0000\u0000\u0000FG\u0005=\u0000\u0000GH\u0005"+
		"=\u0000\u0000H\u0010\u0001\u0000\u0000\u0000IJ\u0005+\u0000\u0000J\u0012"+
		"\u0001\u0000\u0000\u0000KL\u0005-\u0000\u0000L\u0014\u0001\u0000\u0000"+
		"\u0000MN\u0005*\u0000\u0000N\u0016\u0001\u0000\u0000\u0000OP\u0005/\u0000"+
		"\u0000P\u0018\u0001\u0000\u0000\u0000QR\u0005(\u0000\u0000R\u001a\u0001"+
		"\u0000\u0000\u0000ST\u0005)\u0000\u0000T\u001c\u0001\u0000\u0000\u0000"+
		"UV\u0005{\u0000\u0000V\u001e\u0001\u0000\u0000\u0000WX\u0005}\u0000\u0000"+
		"X \u0001\u0000\u0000\u0000YZ\u0005;\u0000\u0000Z\"\u0001\u0000\u0000\u0000"+
		"[]\u0007\u0000\u0000\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_$\u0001\u0000"+
		"\u0000\u0000`b\u0007\u0000\u0000\u0000a`\u0001\u0000\u0000\u0000bc\u0001"+
		"\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000eg\u0005.\u0000\u0000fh\u0007\u0000\u0000\u0000"+
		"gf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000j&\u0001\u0000\u0000\u0000ko\u0005\"\u0000"+
		"\u0000ln\b\u0001\u0000\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000"+
		"\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000"+
		"\u0000\u0000qo\u0001\u0000\u0000\u0000rs\u0005\"\u0000\u0000s(\u0001\u0000"+
		"\u0000\u0000tx\u0007\u0002\u0000\u0000uw\u0007\u0003\u0000\u0000vu\u0001"+
		"\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000"+
		"xy\u0001\u0000\u0000\u0000y*\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000"+
		"\u0000{}\u0007\u0004\u0000\u0000|{\u0001\u0000\u0000\u0000}~\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0006\u0015\u0000\u0000"+
		"\u0081,\u0001\u0000\u0000\u0000\u0007\u0000^ciox~\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}