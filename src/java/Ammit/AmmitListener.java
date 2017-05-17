// Generated from Ammit.g4 by ANTLR 4.5.3
package Ammit;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AmmitParser}.
 */
public interface AmmitListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AmmitParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(AmmitParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link AmmitParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(AmmitParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link AmmitParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(AmmitParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AmmitParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(AmmitParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AmmitParser#nint}.
	 * @param ctx the parse tree
	 */
	void enterNint(AmmitParser.NintContext ctx);
	/**
	 * Exit a parse tree produced by {@link AmmitParser#nint}.
	 * @param ctx the parse tree
	 */
	void exitNint(AmmitParser.NintContext ctx);
	/**
	 * Enter a parse tree produced by {@link AmmitParser#nstr}.
	 * @param ctx the parse tree
	 */
	void enterNstr(AmmitParser.NstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link AmmitParser#nstr}.
	 * @param ctx the parse tree
	 */
	void exitNstr(AmmitParser.NstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link AmmitParser#intrange}.
	 * @param ctx the parse tree
	 */
	void enterIntrange(AmmitParser.IntrangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AmmitParser#intrange}.
	 * @param ctx the parse tree
	 */
	void exitIntrange(AmmitParser.IntrangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AmmitParser#min}.
	 * @param ctx the parse tree
	 */
	void enterMin(AmmitParser.MinContext ctx);
	/**
	 * Exit a parse tree produced by {@link AmmitParser#min}.
	 * @param ctx the parse tree
	 */
	void exitMin(AmmitParser.MinContext ctx);
	/**
	 * Enter a parse tree produced by {@link AmmitParser#max}.
	 * @param ctx the parse tree
	 */
	void enterMax(AmmitParser.MaxContext ctx);
	/**
	 * Exit a parse tree produced by {@link AmmitParser#max}.
	 * @param ctx the parse tree
	 */
	void exitMax(AmmitParser.MaxContext ctx);
	/**
	 * Enter a parse tree produced by {@link AmmitParser#strregex}.
	 * @param ctx the parse tree
	 */
	void enterStrregex(AmmitParser.StrregexContext ctx);
	/**
	 * Exit a parse tree produced by {@link AmmitParser#strregex}.
	 * @param ctx the parse tree
	 */
	void exitStrregex(AmmitParser.StrregexContext ctx);
}