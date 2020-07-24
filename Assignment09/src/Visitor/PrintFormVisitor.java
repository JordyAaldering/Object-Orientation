package Visitor;
import Forms.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class PrintFormVisitor {
    public void visit (Form f) {
        System.out.println(withoutParantheses(f));
        System.out.println(withParantheses(f));
    }
    
    private String withoutParantheses (Form f) {
        String s = f.toString();
        s = s.trim();
        s = s.replace("~ ", "~");
        return s;
    }
    
    private String withParantheses (Form f) {
        String s = f.toStringWithParantheses();
        s = s.substring(1, s.length()-1);
        s = s.trim();
        s = s.replace("~ ", "~");
        return s;
    }
}
