/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;
import Ammit.AmmitBaseListener;
import Ammit.AmmitLexer;
import Ammit.AmmitParser;
import java.util.Random;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author Renam
 */
public class InputGenerator extends AmmitBaseListener {
    private String output;
    private int min, max;
    private final int MAXINT=32767;
    private final int MININT=-32768;
    private ParseTreeWalker walker;
    private ParseTree tree;

    public InputGenerator(String seed){
        super();
        walker=new ParseTreeWalker();
        tree=new AmmitParser(new CommonTokenStream(new AmmitLexer(new ANTLRInputStream(seed)))).row();
    }
    
    public InputGenerator(){
        super();
    }
    
    public String generate(){
        walker.walk(this, tree);
        return output;
    }
    
    public void setSeed(String seed){
        tree=new AmmitParser(new CommonTokenStream(new AmmitLexer(new ANTLRInputStream(seed)))).row();
    }
    
    @Override
    public void enterRow(AmmitParser.RowContext ctx){
        output="";
    }
    
    @Override
    public void enterNint(AmmitParser.NintContext ctx){
        min=MININT; max=MAXINT;
    }
    
    @Override
    public void exitNint(AmmitParser.NintContext ctx){
        int x=new Random().nextInt(max-min+1)+min;
        output += " " +x;
        output = output.trim();
    }
    
    @Override
    public void exitMax(AmmitParser.MaxContext ctx){
        max=Integer.valueOf(ctx.INT().getText());
    }
    
    @Override
    public void exitMin(AmmitParser.MinContext ctx){
        min=Integer.valueOf(ctx.INT().getText());
    }
    
}
