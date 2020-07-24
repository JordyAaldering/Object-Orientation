import Items.*;
import Payments.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class Main {
    public static void main (String[] args) {
        ShoppingCart cart = makeCart();
        pay(cart.getPrice());
    }

    private static ShoppingCart makeCart () {
        ShoppingCart cart = new ShoppingCart();
        Item melon = new WaterMelon();
        Item wine  = new WineGlasses();
        Item wash  = new WashingMachine();
        cart.addItem(melon);
        cart.addItem(melon);
        cart.addItem(wine);
        cart.addItem(wash);
        cart.addItem(wash);
        cart.addItem(wash);
        cart.removeItem(5);
        return cart;
    }

    private static void pay (Double price) {
        ChangePaymentMethod method = new ChangePaymentMethod(new CreditCard(1234, "12 12 1234"));
        method.pay(price);
        method.setStrategy(new PayPal("a@b.com", "1234"));
        method.pay(price);
        method.setStrategy(new IDeal("Rabobank", "RABO1234", 1234));
        method.pay(price);
    }
}
