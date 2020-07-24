package assignment03retry;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Command {
    private final String[] commands = {"Help", "Quit", "Show", "Circle", "Rectangle", "Move", "Remove", "Sort"};
    private String command = null;
    
    
    public Command (String input) {
        for (String s : commands)
            if (input.equals(s))
                this.command = s;
    }
    
    public String getCommand () {
        return command;
    }
    
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (String s : commands)
            sb.append(i++).append(") ").append(s).append("\n");
        return sb.toString();
    }
}
