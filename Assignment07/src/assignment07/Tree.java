package assignment07;
import java.util.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Tree {
    private ArrayList<Tree> children;
    private final int val;

    Tree (int i) {
        this.children = new ArrayList<Tree>();
        this.val = i;
    }

    public void addChild (Tree child) {
        children.add (child);
    }
    
    public int getValue () {
        return val;
    }
    
    public int getSize () {
        return children.size();
    }
    
    public Tree getChild (int i) {
        if (children.size() >= i + 1) return children.get (i);
        else return null;
    }
    
    public boolean empty () {
        return children.isEmpty();
    }
}
