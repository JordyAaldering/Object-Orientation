//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment05;
import static java.lang.Math.pow;

public class TwoArgExpression {
    private char symbol;
    private double inA;
    private double inB;
    private double out;
    
    TwoArgExpression (char s, double a, double b) {
        this.symbol = s;
        this.inA = a;
        this.inB = b;
        switch (symbol) {
            case '+': addition (inA, inB);       break;
            case '*': multiplication (inA, inB); break;
            case '/': division (inA, inB);       break;
            case '^': power (inA, inB);          break;
        }
    }
    
    public final void addition (double a, double b) {
        if (a == 0)
            this.out = b;
        else if (b == 0)
            this.out = a;
        else
            this.out = a + b;
    }
    
    public final void multiplication (double a, double b) {
        if (a == 0 && b == 0)
            this.out = 0;
        else if (a == 1)
            this.out = b;
        else if (b == 1)
            this.out = a;
        else
            this.out = a * b;
    }
    
    public final void division (double a, double b) {
        if (a == 0)
            this.out = 0;
        else if (b == 1)
            this.out = a;
        else
            this.out = a / b;
    }
    
    public final void power (double a, double b) {
        if (a == 1)
            this.out = 1;
        else if (b == 1)
            this.out = a;
        else if (b == 0)
            this.out = 1;
        else
            this.out = pow(a, b);
    }
    
    public double getNum () {
        return out;
    }
    
    @Override
    public String toString () {
        return "(" + inA + " " + symbol + " " + inB + ")";
    }
}
