package Items;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class WineGlasses implements Item {

    @Override
    public String getDescription() {
        return "wine glasses";
    }

    @Override
    public Double getPrice() {
        return 8.50;
    }

    @Override
    public Double getShipping() {
        return 6.75;
    }
}
