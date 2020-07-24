package Forms;
import Visitor.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class BooleanForm implements Form {
    private final boolean operand;
    
    public BooleanForm (boolean b) {
        this.operand = b;
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
        return operand ? " T " : " F ";
    }
    
    @Override
    public String toStringWithParantheses() {
        return operand ? " T " : " F ";
    }
    
    @Override
    public boolean getValue () {
        return operand;
    }
    
}