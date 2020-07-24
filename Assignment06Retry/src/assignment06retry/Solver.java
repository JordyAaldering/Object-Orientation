package assignment06retry;
import java.util.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Solver {
    Queue<Configuration> toExamine = new PriorityQueue<>();
    Set<Configuration>   visited   = new HashSet<>();

    public Solver (Configuration g) {
        toExamine.add (g);
    }
    
    public String solve () {
        while (!toExamine.isEmpty()) {
            Configuration next = toExamine.remove();
            if (next.isSolution()) {
                toString (next.pathFromRoot());
                return "Success!";
            } else 
                for (Configuration succ : next.successors())
                    if(!visited.contains (succ)) {
                        visited.add(succ);
                        toExamine.add(succ);
                    }
        }
        return "Failure!";
    }
    
    private void toString (List<Configuration> next) {
        int step = 0;
        for (Configuration puzzle : next)
            System.out.println ("Step " + step++ + ":\n" + puzzle);
    }
}
