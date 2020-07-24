package Visitor;
import Forms.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public interface FormVisitor<R> {
    public void visit (Form form);
    
    public R visit (StringForm form);
    public R visit (BooleanForm form);
    public R visit (NotForm form);
    public R visit (AndForm form);
    public R visit (OrForm form);
    public R visit (ImpliesForm form);
}
