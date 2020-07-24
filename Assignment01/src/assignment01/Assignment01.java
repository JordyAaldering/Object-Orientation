//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment01;
import java.util.Scanner;

public class Assignment01 {
    
    public static class Student {
        public String firstName, lastName;
        public int    sNumber;
        
        public Student (String firstName, String lastName, int sNumber) {
            this.firstName = firstName;
            this.lastName  = lastName;
            this.sNumber   = sNumber;
        }
    }
    
    static int EnterGroupSize () {
        System.out.println("Please enter the group size: ");
        Scanner scan = new Scanner (System.in);
        int groupSize = scan.nextInt();
        System.out.println("The group contains " + groupSize + " students.");
        return groupSize;
    }
    
    static void FillGroup (int groupSize, Student[] group) {
        String firstName, lastName;
        int    sNumber;
        
        System.out.println("\nPlease enter first name, last name and student number.");
        Scanner scan = new Scanner (System.in);
        for (int i = 0; i < groupSize; i++) {
            firstName = scan.next();
            lastName  = scan.next();
            sNumber   = scan.nextInt();
            group[i] = new Student (firstName, lastName, sNumber);
        }
    }
    
    static void ShowList (int groupSize, Student[] group) {
        System.out.println("\nThe group now contains: ");
        for (int i = 0; i < groupSize; i++) {
            System.out.println(group[i].firstName + " " + group[i].lastName + ", s" + group[i].sNumber);
        }
    }
    
    static int ChangeStudent (int groupSize, Student[] group) {
        int    findNumber, changePos = -1;
        String newFirstName, newLastName;
        Scanner scan = new Scanner (System.in);
        
        System.out.println("\nEnter a student number and a new name: ");
        findNumber = scan.nextInt();
        if (findNumber < 0)
            return -1;
        for (int i = 0; i < groupSize; i++)
            if (group[i].sNumber == findNumber)
                changePos = i;
        if (changePos == -1)
            return 0;
        newFirstName = scan.next();
        newLastName  = scan.next();
        
        group[changePos].firstName = newFirstName;
        group[changePos].lastName = newLastName;
        return 1;
    }
    
    static void ChangeLoop (int groupSize, Student[] group) {
        int next = 0;
        while (next >= 0) {
            next = ChangeStudent (groupSize, group);
            switch (next) {
                case 1:  ShowList (groupSize, group);
                         break;
                case 0:  System.out.println("Student number not found.");
                         break;
                default: System.out.println("Negative number entered; shutting down.");
                         break;
            }
        }
    }
    
    public static void main(String[] args) {
        int groupSize = EnterGroupSize ();
        Student[] group = new Student[groupSize];
        FillGroup  (groupSize, group);
        ShowList   (groupSize, group);
        ChangeLoop (groupSize, group);
    }
}
