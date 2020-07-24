package Visitor;
import Forms.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class EvalFormVisitor implements FormVisitor {
    @Override
    public void visit (Form f) {
        System.out.println(f.getValue() ? "True\n" : "False\n");
    }

    @Override
    public Object visit(StringForm f) {
        boolean value    = f.getValue();
        BooleanForm form = new BooleanForm(value);
        return form;
    }

    @Override
    public Object visit (BooleanForm f) {
        boolean value    = f.getValue();
        BooleanForm form = new BooleanForm(value);
        return form;
    }

    @Override
    public Object visit (NotForm f) {
        Form operand = f.getOperand1();
        NotForm form = new NotForm(operand);
        return form;
    }

    @Override
    public Object visit (AndForm f) {
        Form operand1 = f.getOperand1();
        Form operand2 = f.getOperand1();
        AndForm form  = new AndForm(operand1, operand2);
        return form;
    }

    @Override
    public Object visit (OrForm f) {
        Form operand1 = f.getOperand1();
        Form operand2 = f.getOperand1();
        OrForm form = new OrForm(operand1, operand2);
        return form;
    }

    @Override
    public Object visit (ImpliesForm f) {
        Form operand1 = f.getOperand1();
        Form operand2 = f.getOperand1();
        ImpliesForm form = new ImpliesForm(operand1, operand2);
        return form;
    }
}
