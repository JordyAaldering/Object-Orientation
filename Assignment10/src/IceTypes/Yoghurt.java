package IceTypes;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class Yoghurt implements Ice {
    @Override
    public String getDescription () {
        return "Yoghurt ice";
    }

    @Override
    public int getPrice () {
        return 200;
    }
}
