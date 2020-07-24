//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment02;
import java.util.Vector;

public class User {
    private int misses;
    private final int maxMisses;
    private Vector guessedLetters;

    User (int max) {
        this.misses = 0;
        this.maxMisses = max;
    }
    
    User () {
        this.misses = 0;
        this.maxMisses = 10;
    }
    
    public void IncrMisses (int incr) {
        this.misses += incr;
    }
    
    public int GetMisses () {
        return this.misses;
    }
    
    public int GetMaxMisses () {
        return this.maxMisses;
    }
    
    public void CreateVector () {
        this.guessedLetters = new Vector (26);
    }
    
    public boolean CheckLetter (char letter) {
        return guessedLetters.contains(letter);
    }
    
    public void AddLetter (char letter) {
        guessedLetters.addElement (letter);
    }
}
