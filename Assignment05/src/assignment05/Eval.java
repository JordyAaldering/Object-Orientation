//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment05;

public class Eval {
    private String str;
    private String out;
    private int pos;
    private int ch;
    
    private NoArgExpression arg0;
    private OneArgExpression arg1;
    private TwoArgExpression arg2;
    
    Eval (String s) {
        this.out = "";
        this.str = s;
        this.pos = -1;
    }
    
    public double evaluate () {
        nextChar();
        return parseExpr();
    }
    
    
    private void nextChar () {
        if (++pos < str.length())
            ch = str.charAt(pos);
        else
            ch = -1;
    }
    
    private boolean eat (int charToEat) {
        while (ch == ' ') 
            nextChar();
        if (ch == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }
    
    
    private double parseExpr () {
        double x = parseTerm();
        while (true) {
            if (eat('+')) {
                arg2 = new TwoArgExpression ('+', x, parseTerm());
                out += arg2.toString() + " -> ";
                x = arg2.getNum();
            }
            else if (eat('-')) {
                arg2 = new TwoArgExpression ('-', x, parseTerm());
                out += arg2.toString() + " -> ";
                x = arg2.getNum();
            }
            else 
                return x;
        }
    }
    
    private double parseTerm () {
        double x = parseFactor();
        while (true) {
            if (eat('*')) {
                arg2 = new TwoArgExpression ('*', x, parseTerm());
                out += arg2.toString() + " -> ";
                x = arg2.getNum();
            }
            else if (eat('/')) {
                arg2 = new TwoArgExpression ('/', x, parseTerm());
                out += arg2.toString() + " -> ";
                x = arg2.getNum();
            }
            else return x;
        }
    }
    
    private double parseFactor () {
        if (eat('+')) {
                arg1 = new OneArgExpression ('+', parseFactor());
                out += arg1.toString() + " -> ";
                return arg1.getNum();
            }
        if (eat('-')) {
                arg1 = new OneArgExpression ('-', parseFactor());
                out += arg1.toString() + " -> ";
                return arg1.getNum();
            }

        double x = 0;
        int startPos = pos;
        if (eat('(')) {
            x = parseExpr();
            eat(')');
        }
        else if ((ch >= '0' && ch <= '9') || ch == '.') {
            while ((ch >= '0' && ch <= '9') || ch == '.') 
                nextChar();
            x = Double.parseDouble(str.substring(startPos, pos));
        } 
        else if (ch >= 'a' && ch <= 'z') {
            while (ch >= 'a' && ch <= 'z') 
                nextChar();
            String func = str.substring(startPos, pos);
            x = parseFactor();
            if (func.equals("sqrt")) {
                arg1 = new OneArgExpression ('s', x);
                out += arg1.toString() + " -> ";
                x = arg1.getNum();
            }
            if (func.equals("pi") || func.equals("a") || func.equals("e")) {
                arg0 = new NoArgExpression (func);
                out += arg0.toString() + " -> ";
                x = arg0.getNum();
            }
        }
        if (eat('^')) {
            arg2 = new TwoArgExpression ('^', x, parseFactor());
            out += arg2.toString() + " -> ";
            x = arg2.getNum();
        } return x;
    }
    
    @Override
    public String toString () {
        return out;
    }
}
