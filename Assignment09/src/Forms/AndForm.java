package Forms;
import Visitor.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class AndForm implements Form {
    private final Form operand1, operand2;
    
    public AndForm (Form f1, Form f2) {
        this.operand1 = f1;
        this.operand2 = f2;
    }
    
    @Override
    public Form getOperand1 () {
        return operand1;
    }
    
    @Override
    public Form getOperand2 () {
        return operand2;
    }
    
    @Override
    public void accept (FormVisitor v) {
        v.visit(this);
    }
    
    @Override
    public String toString () {
        return operand1.toString() + "/\\" + operand2.toString();
    }
    
    @Override
    public String toStringWithParantheses() {
        return "(" + operand1.toStringWithParantheses() + "/\\" + operand2.toStringWithParantheses() + ")";
    }
    
    @Override
    public boolean getValue () {
        return operand1.getValue() && operand2.getValue();
    }
}
