package Visitor;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public interface Form {
    void accept (FormVisitor formVisitor);
    //public <R> R accept (FormVisitor<R> visitor);
    
    public Form getOperand1 ();
    public Form getOperand2 ();
    
    public boolean getValue ();
    @Override 
    public String toString ();
    public String toStringWithParantheses ();
}
