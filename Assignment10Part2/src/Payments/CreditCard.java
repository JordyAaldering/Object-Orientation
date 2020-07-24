package Payments;
import java.util.Scanner;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class CreditCard implements Strategy {
    private int cardNumber;
    private String expiryDate;
    private int expiryDay, expiryMonth, expiryYear;

    public CreditCard (int i, String s) {
        this.cardNumber = i;
        this.expiryDate = s;
        readExpiryDate();
    }

    private void readExpiryDate () {
        Scanner scan = new Scanner(expiryDate);
        this.expiryDay = scan.nextInt();
        this.expiryMonth = scan.nextInt();
        this.expiryYear = scan.nextInt();
        scan.close();
    }

    @Override
    public boolean pay (Double price) {
        System.out.println("Card number: " + cardNumber);
        System.out.println("Expiry date: " + expiryDay + "/" + expiryMonth + "/" + expiryYear);
        System.out.println("Price: " + price + "\n");
        return true;
    }
}
