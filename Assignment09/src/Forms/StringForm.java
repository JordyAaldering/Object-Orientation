package Forms;
import Visitor.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class StringForm implements Form {
    private final String operand;
    
    public StringForm (String s) {
        this.operand = s;
    }
    
    @Override
    public Form getOperand1 () {
        return null;
    }
    
    @Override
    public Form getOperand2 () {
        return null;
    }
    
    @Override
    public void accept (FormVisitor v) {
        v.visit(this);
    }
    
    @Override
    public String toString () {
        return " " + operand + " ";
    }

    @Override
    public String toStringWithParantheses() {
        return " " + operand + " ";
    }
    
    @Override
    public boolean getValue() {
        return operand.equals("T")
            || operand.equals("t")
            || operand.equals("True")
            || operand.equals("true");
    }
}