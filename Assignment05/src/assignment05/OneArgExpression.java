//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment05;

import static java.lang.Math.sqrt;

public class OneArgExpression {
    private final char symbol;
    private final double in;
    private double out;
    
    OneArgExpression (char s, double a) {
        this.symbol = s;
        this.in = a;
        switch (symbol) {
            case '+': positive (in);   break;
            case '-': negate (in);     break;
            case 's': squareRoot (in); break;
        }
    }
    
    public final void positive (double a) {
        this.out = a;
    }
    
    public final void negate (double a) {
        this.out = -a;
    }
    
    public final void squareRoot (double a) {
        this.out = sqrt(a);
    }
    
    public double getNum () {
        return out;
    }
    
    @Override
    public String toString () {
        if (symbol == 's')
            return "sqrt" + in;
        else
            return symbol + Double.toString(in);
    }
}
