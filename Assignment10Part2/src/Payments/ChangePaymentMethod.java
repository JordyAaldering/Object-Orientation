package Payments;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class ChangePaymentMethod {
    private Strategy strategy;

    public ChangePaymentMethod (Strategy s) {
        this.strategy = s;
    }

    public void setStrategy (Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean pay (Double price) {
        return strategy.pay(price);
    }
}
