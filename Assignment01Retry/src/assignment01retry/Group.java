package assignment01retry;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Group {
    private final int size;
    private final Student[] group;
    
    public Group (int size) {
        this.size = size;
        group = new Student[size];
    }
    
    public void addStudent (Student student, int index) {
        group[index] = student;
    }
    
    public void changeStudent (int index, String firstName, String lastName, int sNumber) {
        group[index].changeStudent (firstName, lastName, sNumber);
    }
    
    public int findSNumber (int sNumber) {
        for (int i = 0; i < size; i++)
            if (group[i].getSNumber() == sNumber) return i;
        return -1;
    }
    
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append (group[i].toString());
            sb.append ("\n");
        }
        return sb.toString();
    }
}
