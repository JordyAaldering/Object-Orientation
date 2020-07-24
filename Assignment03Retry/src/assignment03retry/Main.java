package assignment03retry;

import java.util.Scanner;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Main {
    private final Scanner scan  = new Scanner (System.in);
    private Command command;
    
    public static void main (String[] args) {
        Main run = new Main();
        run.start();
    }
    
    private void start () {
        boolean loop = true;
        while (loop) {
            String com = getCommand();
            switch (com) {
                case "Help": help();        break;
                case "Quit": loop = false;  break;
                case "Show": break;
                case "Circle": break;
                case "Rectangle": break;
                case "Move": break;
                case "Remove": break;
                case "Sort": break;
            }
        }
        System.out.println("Shutting down.");
        scan.close();
    }
    
    private String getCommand () {
        String str;
        do {
            System.out.print ("Enter a command: ");
            command = new Command (scan.next());
            str = command.getCommand();
        } while (str == null);
        return str;
    }
    
    
    private void help () {
        System.out.println(command.toString());
    }
}
