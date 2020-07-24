package Assignment08;
import java.util.Scanner;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Main {
    public static void main (String[] args) {
        Main run = new Main();
        
        String line = run.readInput();
        Calculation calc = new Calculation (line);
        System.out.println(calc.toString());
        
        Polynomial poly = calc.makePoly();
    }
    
    private String readInput () {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("Enter an equation: ");
            String in = scan.nextLine();
            boolean error = false;
            
            for(int i = 0; i < in.length(); i++) {
                String curr = in.substring(i, i+1);
                if(!stringAllowed(curr)) {
                    System.out.println("Invalid character: " + curr);
                    error = true;
                    break;
                }
            }
            if(!error) return in;
        }
    }
    
    private boolean stringAllowed (String s) {
        return s.equals("^") || s.equals(" ") 
            || s.equals("-") || s.equals("+") 
            || s.equals("x") || isInt(s);
    }
    
    private boolean isInt (String s) {
        try { 
            int i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } return true;
    }
}
