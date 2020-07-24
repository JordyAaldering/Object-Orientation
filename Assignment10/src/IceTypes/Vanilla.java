package IceTypes;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class Vanilla implements Ice {
    @Override
    public String getDescription () {
        return "Vanilla ice";
    }

    @Override
    public int getPrice () {
        return 150;
    }
}
