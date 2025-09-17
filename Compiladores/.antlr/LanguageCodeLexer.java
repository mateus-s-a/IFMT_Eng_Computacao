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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, READ=6, ADD=7, SUB=8, MUL=9, DIV=10, 
		FLOAT=11, INT=12, ID=13, STRING=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "READ", "ADD", "SUB", "MUL", 
			"DIV", "FLOAT", "INT", "ID", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'print'", "'('", "')'", "'read'", "'+'", "'-'", 
			"'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "READ", "ADD", "SUB", "MUL", "DIV", 
			"FLOAT", "INT", "ID", "STRING", "WS"
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
		"\u0004\u0000\u000fa\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\n\u0004\n<\b\n\u000b\n\f\n=\u0001\n\u0001\n\u0004"+
		"\nB\b\n\u000b\n\f\nC\u0001\u000b\u0004\u000bG\b\u000b\u000b\u000b\f\u000b"+
		"H\u0001\f\u0001\f\u0005\fM\b\f\n\f\f\fP\t\f\u0001\r\u0001\r\u0005\rT\b"+
		"\r\n\r\f\rW\t\r\u0001\r\u0001\r\u0001\u000e\u0004\u000e\\\b\u000e\u000b"+
		"\u000e\f\u000e]\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u0001\u0000\u0005\u0001\u000009\u0002\u0000AZaz\u0004\u000009AZ__az\u0001"+
		"\u0000\"\"\u0003\u0000\t\n\r\r  f\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0001\u001f"+
		"\u0001\u0000\u0000\u0000\u0003!\u0001\u0000\u0000\u0000\u0005#\u0001\u0000"+
		"\u0000\u0000\u0007)\u0001\u0000\u0000\u0000\t+\u0001\u0000\u0000\u0000"+
		"\u000b-\u0001\u0000\u0000\u0000\r2\u0001\u0000\u0000\u0000\u000f4\u0001"+
		"\u0000\u0000\u0000\u00116\u0001\u0000\u0000\u0000\u00138\u0001\u0000\u0000"+
		"\u0000\u0015;\u0001\u0000\u0000\u0000\u0017F\u0001\u0000\u0000\u0000\u0019"+
		"J\u0001\u0000\u0000\u0000\u001bQ\u0001\u0000\u0000\u0000\u001d[\u0001"+
		"\u0000\u0000\u0000\u001f \u0005=\u0000\u0000 \u0002\u0001\u0000\u0000"+
		"\u0000!\"\u0005;\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000#$\u0005p"+
		"\u0000\u0000$%\u0005r\u0000\u0000%&\u0005i\u0000\u0000&\'\u0005n\u0000"+
		"\u0000\'(\u0005t\u0000\u0000(\u0006\u0001\u0000\u0000\u0000)*\u0005(\u0000"+
		"\u0000*\b\u0001\u0000\u0000\u0000+,\u0005)\u0000\u0000,\n\u0001\u0000"+
		"\u0000\u0000-.\u0005r\u0000\u0000./\u0005e\u0000\u0000/0\u0005a\u0000"+
		"\u000001\u0005d\u0000\u00001\f\u0001\u0000\u0000\u000023\u0005+\u0000"+
		"\u00003\u000e\u0001\u0000\u0000\u000045\u0005-\u0000\u00005\u0010\u0001"+
		"\u0000\u0000\u000067\u0005*\u0000\u00007\u0012\u0001\u0000\u0000\u0000"+
		"89\u0005/\u0000\u00009\u0014\u0001\u0000\u0000\u0000:<\u0007\u0000\u0000"+
		"\u0000;:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001\u0000"+
		"\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0005"+
		".\u0000\u0000@B\u0007\u0000\u0000\u0000A@\u0001\u0000\u0000\u0000BC\u0001"+
		"\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000"+
		"D\u0016\u0001\u0000\u0000\u0000EG\u0007\u0000\u0000\u0000FE\u0001\u0000"+
		"\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001"+
		"\u0000\u0000\u0000I\u0018\u0001\u0000\u0000\u0000JN\u0007\u0001\u0000"+
		"\u0000KM\u0007\u0002\u0000\u0000LK\u0001\u0000\u0000\u0000MP\u0001\u0000"+
		"\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u001a"+
		"\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000QU\u0005\"\u0000\u0000"+
		"RT\b\u0003\u0000\u0000SR\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000"+
		"US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0001\u0000\u0000"+
		"\u0000WU\u0001\u0000\u0000\u0000XY\u0005\"\u0000\u0000Y\u001c\u0001\u0000"+
		"\u0000\u0000Z\\\u0007\u0004\u0000\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_`\u0006\u000e\u0000\u0000`\u001e\u0001\u0000"+
		"\u0000\u0000\u0007\u0000=CHNU]\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}