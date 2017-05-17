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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, INT=7, STR=8, WS=9;
	public static final int
		RULE_row = 0, RULE_expr = 1, RULE_nint = 2, RULE_nstr = 3, RULE_intrange = 4, 
		RULE_min = 5, RULE_max = 6, RULE_strregex = 7;
	public static final String[] ruleNames = {
		"row", "expr", "nint", "nstr", "intrange", "min", "max", "strregex"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'i'", "'['", "']'", "'s'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "INT", "STR", "WS"
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
			setState(16);
			expr();
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(17);
				match(T__0);
				setState(18);
				expr();
				}
				}
				setState(23);
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
			setState(26);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				nint();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				nstr();
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
			setState(28);
			match(T__1);
			setState(33);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(29);
				match(T__2);
				setState(30);
				intrange();
				setState(31);
				match(T__3);
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
			setState(35);
			match(T__4);
			setState(36);
			match(T__2);
			setState(37);
			strregex();
			setState(38);
			match(T__3);
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
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				min();
				setState(41);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(T__5);
				setState(44);
				max();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				min();
				setState(46);
				match(T__5);
				setState(47);
				max();
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

	public static class MinContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AmmitParser.INT, 0); }
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
			setState(51);
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

	public static class MaxContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AmmitParser.INT, 0); }
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
			setState(53);
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
		enterRule(_localctx, 14, RULE_strregex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13<\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\3\3\3\5\3\35\n\3\3\4\3\4\3\4\3\4\3\4\5\4$\n\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\64\n\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\28\2\22\3\2\2\2\4"+
		"\34\3\2\2\2\6\36\3\2\2\2\b%\3\2\2\2\n\63\3\2\2\2\f\65\3\2\2\2\16\67\3"+
		"\2\2\2\209\3\2\2\2\22\27\5\4\3\2\23\24\7\3\2\2\24\26\5\4\3\2\25\23\3\2"+
		"\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\3\3\2\2\2\31\27\3\2"+
		"\2\2\32\35\5\6\4\2\33\35\5\b\5\2\34\32\3\2\2\2\34\33\3\2\2\2\35\5\3\2"+
		"\2\2\36#\7\4\2\2\37 \7\5\2\2 !\5\n\6\2!\"\7\6\2\2\"$\3\2\2\2#\37\3\2\2"+
		"\2#$\3\2\2\2$\7\3\2\2\2%&\7\7\2\2&\'\7\5\2\2\'(\5\20\t\2()\7\6\2\2)\t"+
		"\3\2\2\2*+\5\f\7\2+,\7\b\2\2,\64\3\2\2\2-.\7\b\2\2.\64\5\16\b\2/\60\5"+
		"\f\7\2\60\61\7\b\2\2\61\62\5\16\b\2\62\64\3\2\2\2\63*\3\2\2\2\63-\3\2"+
		"\2\2\63/\3\2\2\2\64\13\3\2\2\2\65\66\7\t\2\2\66\r\3\2\2\2\678\7\t\2\2"+
		"8\17\3\2\2\29:\7\n\2\2:\21\3\2\2\2\6\27\34#\63";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}