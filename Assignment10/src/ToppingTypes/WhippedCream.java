package ToppingTypes;
import IceTypes.Ice;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class WhippedCream extends IceDecorator {
    public WhippedCream(Ice ice) {
        super(ice);
    }

    @Override
    public String getDescription() {
        return decoratedIce.getDescription() + " with a whipped cream topping";
    }

    @Override
    public int getPrice() {
        return decoratedIce.getPrice() + 50;
    }
}
