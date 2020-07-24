package ToppingTypes;
import IceTypes.Ice;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class Sprinkles extends IceDecorator {
    public Sprinkles(Ice ice) {
        super(ice);
    }

    @Override
    public String getDescription() {
        return decoratedIce.getDescription() + " with a sprinkles topping";
    }

    @Override
    public int getPrice() {
        return decoratedIce.getPrice();
    }
}
