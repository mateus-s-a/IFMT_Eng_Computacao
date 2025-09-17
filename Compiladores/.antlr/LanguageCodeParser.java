// Generated from c:/Users/mateus.arruda/Documents/[Estudos]/[Visual Studio Code]/IFMT_Eng_Computacao/Compiladores/LanguageCode.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LanguageCodeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, IF=3, ELSE=4, READ=5, GT=6, LT=7, EQ=8, ADD=9, SUB=10, 
		MUL=11, DIV=12, LPAREN=13, RPAREN=14, LBRACE=15, RBRACE=16, SEMI=17, INT=18, 
		FLOAT=19, STRING=20, ID=21, WS=22;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_ifStatement = 2, RULE_condition = 3, 
		RULE_assignment = 4, RULE_print = 5, RULE_readCommand = 6, RULE_expr = 7, 
		RULE_term = 8, RULE_factor = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "ifStatement", "condition", "assignment", "print", 
			"readCommand", "expr", "term", "factor"
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

	@Override
	public String getGrammarFileName() { return "LanguageCode.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageCodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				statement();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2097196L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public ReadCommandContext readCommand() {
			return getRuleContext(ReadCommandContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				assignment();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				print();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 3);
				{
				setState(27);
				readCommand();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(28);
				ifStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LanguageCodeParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageCodeParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageCodeParser.RPAREN, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(LanguageCodeParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(LanguageCodeParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(LanguageCodeParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(LanguageCodeParser.RBRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LanguageCodeParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(IF);
			setState(32);
			match(LPAREN);
			setState(33);
			condition();
			setState(34);
			match(RPAREN);
			setState(35);
			match(LBRACE);
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				statement();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2097196L) != 0) );
			setState(41);
			match(RBRACE);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(42);
				match(ELSE);
				setState(43);
				match(LBRACE);
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(44);
					statement();
					}
					}
					setState(47); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2097196L) != 0) );
				setState(49);
				match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT() { return getToken(LanguageCodeParser.GT, 0); }
		public TerminalNode LT() { return getToken(LanguageCodeParser.LT, 0); }
		public TerminalNode EQ() { return getToken(LanguageCodeParser.EQ, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			expr();
			setState(54);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(55);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageCodeParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(LanguageCodeParser.SEMI, 0); }
		public TerminalNode STRING() { return getToken(LanguageCodeParser.STRING, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(ID);
			setState(58);
			match(T__0);
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(59);
				match(STRING);
				}
				break;
			case LPAREN:
			case INT:
			case FLOAT:
			case ID:
				{
				setState(60);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(63);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(LanguageCodeParser.SEMI, 0); }
		public TerminalNode STRING() { return getToken(LanguageCodeParser.STRING, 0); }
		public TerminalNode ID() { return getToken(LanguageCodeParser.ID, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__1);
			setState(66);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(67);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReadCommandContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(LanguageCodeParser.READ, 0); }
		public TerminalNode ID() { return getToken(LanguageCodeParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(LanguageCodeParser.SEMI, 0); }
		public ReadCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readCommand; }
	}

	public final ReadCommandContext readCommand() throws RecognitionException {
		ReadCommandContext _localctx = new ReadCommandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_readCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(READ);
			setState(70);
			match(ID);
			setState(71);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> ADD() { return getTokens(LanguageCodeParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(LanguageCodeParser.ADD, i);
		}
		public List<TerminalNode> SUB() { return getTokens(LanguageCodeParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(LanguageCodeParser.SUB, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			term();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(75);
				term();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(LanguageCodeParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(LanguageCodeParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(LanguageCodeParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(LanguageCodeParser.DIV, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			factor();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(82);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(83);
				factor();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageCodeParser.ID, 0); }
		public TerminalNode INT() { return getToken(LanguageCodeParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LanguageCodeParser.FLOAT, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageCodeParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageCodeParser.RPAREN, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_factor);
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(ID);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				match(FLOAT);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				match(LPAREN);
				setState(93);
				expr();
				setState(94);
				match(RPAREN);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0016c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000\u0016\b\u0000\u000b"+
		"\u0000\f\u0000\u0017\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u001e\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0004\u0002&\b\u0002\u000b\u0002\f\u0002\'\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002.\b\u0002\u000b\u0002"+
		"\f\u0002/\u0001\u0002\u0001\u0002\u0003\u00024\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004>\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007M\b\u0007\n\u0007"+
		"\f\u0007P\t\u0007\u0001\b\u0001\b\u0001\b\u0005\bU\b\b\n\b\f\bX\t\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\ta\b\t\u0001"+
		"\t\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000"+
		"\u0004\u0001\u0000\u0006\b\u0001\u0000\u0014\u0015\u0001\u0000\t\n\u0001"+
		"\u0000\u000b\fe\u0000\u0015\u0001\u0000\u0000\u0000\u0002\u001d\u0001"+
		"\u0000\u0000\u0000\u0004\u001f\u0001\u0000\u0000\u0000\u00065\u0001\u0000"+
		"\u0000\u0000\b9\u0001\u0000\u0000\u0000\nA\u0001\u0000\u0000\u0000\fE"+
		"\u0001\u0000\u0000\u0000\u000eI\u0001\u0000\u0000\u0000\u0010Q\u0001\u0000"+
		"\u0000\u0000\u0012`\u0001\u0000\u0000\u0000\u0014\u0016\u0003\u0002\u0001"+
		"\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000"+
		"\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000"+
		"\u0000\u0018\u0001\u0001\u0000\u0000\u0000\u0019\u001e\u0003\b\u0004\u0000"+
		"\u001a\u001e\u0003\n\u0005\u0000\u001b\u001e\u0003\f\u0006\u0000\u001c"+
		"\u001e\u0003\u0004\u0002\u0000\u001d\u0019\u0001\u0000\u0000\u0000\u001d"+
		"\u001a\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d"+
		"\u001c\u0001\u0000\u0000\u0000\u001e\u0003\u0001\u0000\u0000\u0000\u001f"+
		" \u0005\u0003\u0000\u0000 !\u0005\r\u0000\u0000!\"\u0003\u0006\u0003\u0000"+
		"\"#\u0005\u000e\u0000\u0000#%\u0005\u000f\u0000\u0000$&\u0003\u0002\u0001"+
		"\u0000%$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'%\u0001\u0000"+
		"\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)3\u0005"+
		"\u0010\u0000\u0000*+\u0005\u0004\u0000\u0000+-\u0005\u000f\u0000\u0000"+
		",.\u0003\u0002\u0001\u0000-,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000001\u0001\u0000"+
		"\u0000\u000012\u0005\u0010\u0000\u000024\u0001\u0000\u0000\u00003*\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u00004\u0005\u0001\u0000\u0000"+
		"\u000056\u0003\u000e\u0007\u000067\u0007\u0000\u0000\u000078\u0003\u000e"+
		"\u0007\u00008\u0007\u0001\u0000\u0000\u00009:\u0005\u0015\u0000\u0000"+
		":=\u0005\u0001\u0000\u0000;>\u0005\u0014\u0000\u0000<>\u0003\u000e\u0007"+
		"\u0000=;\u0001\u0000\u0000\u0000=<\u0001\u0000\u0000\u0000>?\u0001\u0000"+
		"\u0000\u0000?@\u0005\u0011\u0000\u0000@\t\u0001\u0000\u0000\u0000AB\u0005"+
		"\u0002\u0000\u0000BC\u0007\u0001\u0000\u0000CD\u0005\u0011\u0000\u0000"+
		"D\u000b\u0001\u0000\u0000\u0000EF\u0005\u0005\u0000\u0000FG\u0005\u0015"+
		"\u0000\u0000GH\u0005\u0011\u0000\u0000H\r\u0001\u0000\u0000\u0000IN\u0003"+
		"\u0010\b\u0000JK\u0007\u0002\u0000\u0000KM\u0003\u0010\b\u0000LJ\u0001"+
		"\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000"+
		"NO\u0001\u0000\u0000\u0000O\u000f\u0001\u0000\u0000\u0000PN\u0001\u0000"+
		"\u0000\u0000QV\u0003\u0012\t\u0000RS\u0007\u0003\u0000\u0000SU\u0003\u0012"+
		"\t\u0000TR\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000"+
		"\u0000\u0000VW\u0001\u0000\u0000\u0000W\u0011\u0001\u0000\u0000\u0000"+
		"XV\u0001\u0000\u0000\u0000Ya\u0005\u0015\u0000\u0000Za\u0005\u0012\u0000"+
		"\u0000[a\u0005\u0013\u0000\u0000\\]\u0005\r\u0000\u0000]^\u0003\u000e"+
		"\u0007\u0000^_\u0005\u000e\u0000\u0000_a\u0001\u0000\u0000\u0000`Y\u0001"+
		"\u0000\u0000\u0000`Z\u0001\u0000\u0000\u0000`[\u0001\u0000\u0000\u0000"+
		"`\\\u0001\u0000\u0000\u0000a\u0013\u0001\u0000\u0000\u0000\t\u0017\u001d"+
		"\'/3=NV`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}