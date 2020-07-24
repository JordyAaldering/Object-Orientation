package Items;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class WashingMachine implements Item {
    @Override
    public String getDescription() {
        return "washing machine";
    }

    @Override
    public Double getPrice() {
        return 499.00;
    }

    @Override
    public Double getShipping() {
        return 30.00;
    }
}
