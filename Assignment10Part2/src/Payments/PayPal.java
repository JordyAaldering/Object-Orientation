package Payments;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class PayPal implements Strategy {
    private String eMail;
    private String password;

    public PayPal (String e, String p) {
        this.eMail = e;
        this.password = p;
    }

    @Override
    public boolean pay (Double price) {
        System.out.println("EMail: " + eMail);
        System.out.println("Password: " + password);
        System.out.println("Price: " + price + "\n");
        return true;
    }
}
