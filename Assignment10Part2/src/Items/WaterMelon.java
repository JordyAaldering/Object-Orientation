package Items;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class WaterMelon implements Item {
    @Override
    public String getDescription() {
        return "watermelon";
    }

    @Override
    public Double getPrice() {
        return 4.50;
    }

    @Override
    public Double getShipping() {
        return 6.75;
    }
}
