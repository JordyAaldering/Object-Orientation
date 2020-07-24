import IceTypes.*;
import ToppingTypes.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class Main {
    public static void main (String[] args) {
        Ice vanilla   = new Vanilla();
        Ice yoghurt   = new Yoghurt();
        Ice chocolate = new ChocolateDip(new Vanilla());
        Ice sprinkles = new Sprinkles(new Vanilla());
        Ice cream     = new WhippedCream(new Yoghurt());

        System.out.printf("%s.%nPrice: %d cents.%n", vanilla.getDescription(), vanilla.getPrice());
        System.out.printf("%s.%nPrice: %d cents.%n", yoghurt.getDescription(), yoghurt.getPrice());
        System.out.printf("%s.%nPrice: %d cents.%n", chocolate.getDescription(), chocolate.getPrice());
        System.out.printf("%s.%nPrice: %d cents.%n", sprinkles.getDescription(), sprinkles.getPrice());
        System.out.printf("%s.%nPrice: %d cents.%n", cream.getDescription(), cream.getPrice());
    }
}
