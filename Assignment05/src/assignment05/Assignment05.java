//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment05;
import java.util.Scanner;

public class Assignment05 {

    public static void main(String[] args) {
        Assignment05 assignment = new Assignment05();
        
        Scanner scan = new Scanner (System.in);
        assignment.loop(scan);
        scan.close();
    }
    
    private void loop (Scanner scan) {
        System.out.println ("Enter a numerical expression:");
        Eval expr = new Eval (scan.nextLine());
        Double num = expr.evaluate();
        System.out.println (expr.toString() + num);
    }
}
