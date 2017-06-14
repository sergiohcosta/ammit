// Generated from Ammit.g4 by ANTLR 4.5.3
package Ammit;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AmmitParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		INT=10, STR=11, WS=12;
	public static final int
		RULE_row = 0, RULE_expr = 1, RULE_nint = 2, RULE_nstr = 3, RULE_intrange = 4, 
		RULE_min = 5, RULE_max = 6, RULE_nconst = 7, RULE_repeat = 8, RULE_sigint = 9, 
		RULE_strregex = 10;
	public static final String[] ruleNames = {
		"row", "expr", "nint", "nstr", "intrange", "min", "max", "nconst", "repeat", 
		"sigint", "strregex"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'i'", "'['", "','", "']'", "'s'", "':'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "INT", "STR", 
		"WS"
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
	public String getGrammarFileName() { return "Ammit.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AmmitParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RowContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).enterRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).exitRow(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			expr();
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(23);
				match(T__0);
				setState(24);
				expr();
				}
				}
				setState(29);
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

	public static class ExprContext extends ParserRuleContext {
		public NintContext nint() {
			return getRuleContext(NintContext.class,0);
		}
		public NstrContext nstr() {
			return getRuleContext(NstrContext.class,0);
		}
		public NconstContext nconst() {
			return getRuleContext(NconstContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(33);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				nint();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				nstr();
				}
				break;
			case T__7:
			case T__8:
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				nconst();
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

	public static class NintContext extends ParserRuleContext {
		public IntrangeContext intrange() {
			return getRuleContext(IntrangeContext.class,0);
		}
		public RepeatContext repeat() {
			return getRuleContext(RepeatContext.class,0);
		}
		public NintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).enterNint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).exitNint(this);
		}
	}

	public final NintContext nint() throws RecognitionException {
		NintContext _localctx = new NintContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__1);
			setState(44);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(36);
				match(T__2);
				setState(37);
				intrange();
				setState(40);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(38);
					match(T__3);
					setState(39);
					repeat();
					}
				}

				setState(42);
				match(T__4);
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

	public static class NstrContext extends ParserRuleContext {
		public StrregexContext strregex() {
			return getRuleContext(StrregexContext.class,0);
		}
		public NstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).enterNstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).exitNstr(this);
		}
	}

	public final NstrContext nstr() throws RecognitionException {
		NstrContext _localctx = new NstrContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__5);
			setState(47);
			match(T__2);
			setState(48);
			strregex();
			setState(49);
			match(T__4);
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

	public static class IntrangeContext extends ParserRuleContext {
		public MinContext min() {
			return getRuleContext(MinContext.class,0);
		}
		public MaxContext max() {
			return getRuleContext(MaxContext.class,0);
		}
		public IntrangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intrange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).enterIntrange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).exitIntrange(this);
		}
	}

	public final IntrangeContext intrange() throws RecognitionException {
		IntrangeContext _localctx = new IntrangeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_intrange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << INT))) != 0)) {
				{
				setState(51);
				min();
				}
			}

			setState(54);
			match(T__6);
			setState(56);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << INT))) != 0)) {
				{
				setState(55);
				max();
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

	public static class MinContext extends ParserRuleContext {
		public SigintContext sigint() {
			return getRuleContext(SigintContext.class,0);
		}
		public MinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_min; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).enterMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).exitMin(this);
		}
	}

	public final MinContext min() throws RecognitionException {
		MinContext _localctx = new MinContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_min);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			sigint();
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

	public static class MaxContext extends ParserRuleContext {
		public SigintContext sigint() {
			return getRuleContext(SigintContext.class,0);
		}
		public MaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_max; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).enterMax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).exitMax(this);
		}
	}

	public final MaxContext max() throws RecognitionException {
		MaxContext _localctx = new MaxContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_max);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			sigint();
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

	public static class NconstContext extends ParserRuleContext {
		public SigintContext sigint() {
			return getRuleContext(SigintContext.class,0);
		}
		public NconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).enterNconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).exitNconst(this);
		}
	}

	public final NconstContext nconst() throws RecognitionException {
		NconstContext _localctx = new NconstContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_nconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			sigint();
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

	public static class RepeatContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AmmitParser.INT, 0); }
		public RepeatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).enterRepeat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).exitRepeat(this);
		}
	}

	public final RepeatContext repeat() throws RecognitionException {
		RepeatContext _localctx = new RepeatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_repeat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(INT);
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

	public static class SigintContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AmmitParser.INT, 0); }
		public SigintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sigint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).enterSigint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).exitSigint(this);
		}
	}

	public final SigintContext sigint() throws RecognitionException {
		SigintContext _localctx = new SigintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sigint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_la = _input.LA(1);
			if (_la==T__7 || _la==T__8) {
				{
				setState(66);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(69);
			match(INT);
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

	public static class StrregexContext extends ParserRuleContext {
		public TerminalNode STR() { return getToken(AmmitParser.STR, 0); }
		public StrregexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strregex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).enterStrregex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AmmitListener ) ((AmmitListener)listener).exitStrregex(this);
		}
	}

	public final StrregexContext strregex() throws RecognitionException {
		StrregexContext _localctx = new StrregexContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_strregex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(STR);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16L\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\3\3\3\3\3\5\3$\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\5\4+\n\4\3\4\3\4\5\4/\n\4\3\5\3\5\3\5\3\5\3\5\3\6\5"+
		"\6\67\n\6\3\6\3\6\5\6;\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\5\13F"+
		"\n\13\3\13\3\13\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\3\3\2\n"+
		"\13H\2\30\3\2\2\2\4#\3\2\2\2\6%\3\2\2\2\b\60\3\2\2\2\n\66\3\2\2\2\f<\3"+
		"\2\2\2\16>\3\2\2\2\20@\3\2\2\2\22B\3\2\2\2\24E\3\2\2\2\26I\3\2\2\2\30"+
		"\35\5\4\3\2\31\32\7\3\2\2\32\34\5\4\3\2\33\31\3\2\2\2\34\37\3\2\2\2\35"+
		"\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37\35\3\2\2\2 $\5\6\4\2!$\5\b\5"+
		"\2\"$\5\20\t\2# \3\2\2\2#!\3\2\2\2#\"\3\2\2\2$\5\3\2\2\2%.\7\4\2\2&\'"+
		"\7\5\2\2\'*\5\n\6\2()\7\6\2\2)+\5\22\n\2*(\3\2\2\2*+\3\2\2\2+,\3\2\2\2"+
		",-\7\7\2\2-/\3\2\2\2.&\3\2\2\2./\3\2\2\2/\7\3\2\2\2\60\61\7\b\2\2\61\62"+
		"\7\5\2\2\62\63\5\26\f\2\63\64\7\7\2\2\64\t\3\2\2\2\65\67\5\f\7\2\66\65"+
		"\3\2\2\2\66\67\3\2\2\2\678\3\2\2\28:\7\t\2\29;\5\16\b\2:9\3\2\2\2:;\3"+
		"\2\2\2;\13\3\2\2\2<=\5\24\13\2=\r\3\2\2\2>?\5\24\13\2?\17\3\2\2\2@A\5"+
		"\24\13\2A\21\3\2\2\2BC\7\f\2\2C\23\3\2\2\2DF\t\2\2\2ED\3\2\2\2EF\3\2\2"+
		"\2FG\3\2\2\2GH\7\f\2\2H\25\3\2\2\2IJ\7\r\2\2J\27\3\2\2\2\t\35#*.\66:E";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}