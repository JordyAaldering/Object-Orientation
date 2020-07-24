package assignment01retry;
import java.util.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Main {
    public static void main (String[] args) {
        Main assignment = new Main();
        Scanner scan = new Scanner (System.in);
        
        Group group = assignment.makeGroup (scan);
        System.out.println (assignment.toString(group));
        for (;;) assignment.changeStudent (scan, group);
    }
    
    private Group makeGroup (Scanner scan) {
        System.out.print ("Enter group size: ");
        int size    = scan.nextInt();
        Group group = new Group (size);
        
        System.out.println ("Enter first name, last name and student number:");
        for (int i = 0; i < size; i++) {
            System.out.print ((i+1) + ") ");
            String firstName = scan.next();
            String lastName  = scan.next();
            int sNumber      = scan.nextInt();
            Student student  = new Student (firstName, lastName, sNumber);
            group.addStudent (student, i);
        }
        return group;
    }
    
    private void changeStudent (Scanner scan, Group group) {
        System.out.print ("Enter student number to change: ");
        int sNumber = scan.nextInt();
        int index   = group.findSNumber (sNumber);
        if (index < 0) 
            System.out.println ("s" + sNumber + " does not exist!");
        else {
            System.out.println ("Enter new first name, last name and student number:");
            String newfirstName = scan.next();
            String newlastName  = scan.next();
            int newSNumber      = scan.nextInt();
            group.changeStudent(index, newfirstName, newlastName, newSNumber);
        }
    }
    
    private String toString (Group group) {
        StringBuilder sb = new StringBuilder();
        sb.append ("The group now contains:\n");
        sb.append (group.toString());
        return sb.toString();
    }
}
