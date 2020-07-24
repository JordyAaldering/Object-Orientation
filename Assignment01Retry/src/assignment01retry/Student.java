package assignment01retry;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Student {
    private String firstName, lastName;
    private int sNumber;
    
    public Student (String firstName, String lastName, int sNumber) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.sNumber   = sNumber;
    }

    public void changeStudent (String firstName, String lastName, int sNumber) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.sNumber   = sNumber;
    }

    public int getSNumber () {
        return sNumber;
    }

    @Override
    public String toString () {
        return firstName + " " + lastName + ", s" + sNumber;
    }
}
