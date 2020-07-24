package assignment06retry;
import java.util.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public interface Configuration extends Comparable<Configuration> {
    public abstract Configuration parent();
    
    public abstract Collection<Configuration> successors();
    
    public abstract boolean isSolution();
    
    public default List<Configuration> pathFromRoot(){
        List<Configuration>  list  = new ArrayList<>();
        Stack<Configuration> stack = new Stack<>();
        
        Configuration curr = this;
        while(curr != null) {
            stack.push (curr);
            curr = curr.parent();
        }
        while(!stack.isEmpty()) {
            curr = stack.pop();
            list.add (curr);
        }
        return list;
    }
}
