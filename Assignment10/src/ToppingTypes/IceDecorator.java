package ToppingTypes;
import IceTypes.Ice;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class IceDecorator implements Ice {
    protected Ice decoratedIce;

    public IceDecorator (Ice ice) {
        this.decoratedIce = ice;
    }

    @Override
    public String getDescription() {
        return decoratedIce.getDescription();
    }

    @Override
    public int getPrice() {
        return decoratedIce.getPrice();
    }
}
