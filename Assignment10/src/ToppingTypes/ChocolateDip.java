package ToppingTypes;
import IceTypes.Ice;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class ChocolateDip extends IceDecorator {
    public ChocolateDip(Ice ice) {
        super(ice);
    }

    @Override
    public String getDescription() {
        return decoratedIce.getDescription() + " with a chocolate dip topping";
    }

    @Override
    public int getPrice() {
        return decoratedIce.getPrice() + 30;
    }
}
