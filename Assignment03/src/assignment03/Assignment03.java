//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment03;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Assignment03 {
    private final Scanner scan  = new Scanner (System.in);
    private ArrayList<GeoObject> objectList;

    public static void main(String[] args) {
        Assignment03 assignment = new Assignment03();
        assignment.start();
    }
    
    private void start () {
        String[] commands = {"Help", "Quit", "Show", "Circle", "Rectangle", "Move", "Remove", "Sort"};
        int maxObjects = 10;
        objectList = new ArrayList<>(maxObjects);
        
        System.out.println ("Type 'Help' for a list of commands.");
        while (true) {
            int command = userCommand (commands);
            switch (command) {
                case 0: showCommands (commands);   break;
                case 1: scan.close();              System.exit (0);
                case 2: showObjects();             break;
                case 3: addCircle (maxObjects);    break;
                case 4: addRectangle (maxObjects); break;
                case 5: move();                    break;
                case 6: remove();                  break;
                case 7: Sort();                    break;
            }
        }
    }
    
    private int userCommand (String[] commands) {
        int command;
        System.out.println("\nEnter a command: ");
        do {
            String input = scan.next();
            command = getCommand (input, commands);
        } while (command == -1);
        return command;
    }
    
    private int getCommand (String input, String[] commands) {
        for (int i = 0; i < commands.length; i++)
            if (input.equals(commands[i]))
                return i;
        scan.nextLine();
        System.out.println ("Command not found, please enter a new command: ");
        return -1;
    }
    
    private void showCommands (String[] commands) {
        for (int i = 1; i < commands.length; i++)
            System.out.println (i + "): " + commands[i]);
    }
    
    private void showObjects () {
        if (objectList.isEmpty())
            System.out.println ("Nothing to show.");

        for (int i = 0; i < objectList.size(); i++)
            System.out.println (objectList.get(i).toString());
    }
    
    private void addCircle (int maxObjects) {
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        double r = scan.nextDouble();
        
        if (checkArrayFull(maxObjects)) {
            Circle circle = new Circle (x, y, r);
            GeoObject object = new GeoObject (circle);
            objectList.add (object);
        }
    }
    
    private void addRectangle (int maxObjects) {
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        double w = scan.nextDouble();
        double h = scan.nextDouble();
        
        if (checkArrayFull(maxObjects)) {
            Rectangle rectangle = new Rectangle (x, y, w, h);
            GeoObject object = new GeoObject (rectangle);
            objectList.add (object);
        }
    }
    
    private void move () {
        int i     = scan.nextInt();
        double dx = scan.nextDouble();
        double dy = scan.nextDouble();
        
        if (checkObjectExists(i))
            objectList.get(i).move (dx, dy);    
    }
    
    private void remove () {
        int i = scan.nextInt();
        if (checkObjectExists(i))
            objectList.remove (i);
    }
    
    private void Sort () {
        char method = 0;
        String in = scan.nextLine();
        if (!in.isEmpty())
            method = in.charAt(1);
        
        GeoObject[] objectArray = new GeoObject[objectList.size()];
        objectList.toArray(objectArray);
        switch (method) {
            case 'x': Arrays.sort (objectArray, 0, objectArray.length, new xComparator()); break;
            case 'y': Arrays.sort (objectArray, 0, objectArray.length, new yComparator()); break;
            case 0  : Arrays.sort (objectArray, 0, objectArray.length);                    break;
            default : System.out.println ("Enter x, y or nothing."); break;
        }
        objectList = new ArrayList<> (Arrays.asList(objectArray));
    }
    
    private boolean checkArrayFull (int maxObjects) {
        if (objectList.size() < maxObjects)
            return true;
        System.out.println ("The array is full.");
        return false;
    }
    
    private boolean checkObjectExists (int i) {
        if (i < objectList.size())
            return true;
        System.out.println ("That object does not exist.");
        return false;
    }
}