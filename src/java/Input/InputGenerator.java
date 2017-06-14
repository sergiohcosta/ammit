/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;
import Ammit.AmmitBaseListener;
import Ammit.AmmitLexer;
import Ammit.AmmitParser;
import com.mifmif.common.regex.Generex;
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
    private int min, max, rep, lastSigint;
    private boolean proceed;
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
        proceed=true;
        rep=1;
    }
    
    @Override
    public void exitRow(AmmitParser.RowContext ctx){
        output=output.trim();
    }
    
    @Override
    public void enterNint(AmmitParser.NintContext ctx){
        min=MININT; max=MAXINT;
    }
    
    @Override
    public void exitNint(AmmitParser.NintContext ctx){
        if(proceed){
            Random rnd=new Random();
            int i,x;
            if (max<min){
                x=min;
                min=max;
                max=x;
            }
            for(i=0; i<rep; i++){
                x=rnd.nextInt(max-min+1)+min;
                output += " " +x;
            }
        }
    }
    
    @Override
    public void exitSigint(AmmitParser.SigintContext ctx){
        lastSigint = Integer.valueOf(ctx.getText());
    }
    
    @Override
    public void exitMax(AmmitParser.MaxContext ctx){
        max=lastSigint;
    }
    
    @Override
    public void exitMin(AmmitParser.MinContext ctx){
        min=lastSigint;
    }
    
    @Override
    public void exitNconst(AmmitParser.NconstContext ctx) {
        output += " " +lastSigint;
    }
    
    
    @Override
    public void exitRepeat(AmmitParser.RepeatContext ctx) {
        try{rep=Integer.valueOf(ctx.INT().getText());}catch (Exception e){proceed=false;}
    }
    
    @Override
    public void exitStrregex(AmmitParser.StrregexContext ctx) {
        output += " " + new Generex(ctx.STR().getText().replaceAll("\"", "")).random();
    }
}
