package Forms;
import Visitor.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class NotForm implements Form {
    private final Form operand;
    
    public NotForm (Form f) {
        this.operand = f;
    }
    
    @Override
    public Form getOperand1 () {
        return operand;
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
        return " ~" + operand.toString();
    }
    
    @Override
    public String toStringWithParantheses() {
        return "( ~" + operand.toStringWithParantheses() + ")";
    }
    
    @Override
    public boolean getValue () {
        return !operand.getValue();
    }
}
