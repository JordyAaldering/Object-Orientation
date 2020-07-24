//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment04;

public class Human implements Player {
    private final String name;
    private final char type;
    
    Human (String n, char t) {
        this.name = n;
        this.type = t;
    }
    
    @Override
    public void play (int y, int x, Board b) {
        b.play (y, x, type);
    }
    
    @Override
    public String getName () {
        return name;
    }
    
    @Override
    public char getType () {
        return type;
    }
}
