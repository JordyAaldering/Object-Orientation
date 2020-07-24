//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment05;
import java.util.Map;
import java.util.HashMap;

public class NoArgExpression {
    Map<String, Double> store;
    private final String in;
    private final double out;
    
    NoArgExpression (String a) {
        makeStore();
        this.in = a;
        this.out = store.get(a);
    }
    
    public final void makeStore () {
        this.store = new HashMap<>();
        this.store.put("pi", 3.1415);
        this.store.put("e", 2.71828);
        this.store.put("a", 42.);
    }
    
    public double getNum () {
        return out;
    }
    
    @Override
    public String toString () {
        return in;
    }
}
