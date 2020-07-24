//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment02;
import java.util.Scanner;

public class Assignment02 {
    public static void main (String[] args) {
        Assignment02 assignment = new Assignment02();
        assignment.Game();
    }
    
    public void Game () {
        Gallows gallow = UserInput();
        User user = new User (10);
        
        gallow.CreateSecret(gallow.GetWord().length());
        System.out.println("The secret is: " + gallow.GetSecret() + "\nMax misses: " + user.GetMaxMisses());
        user.CreateVector();
        
        Loop (gallow, user);
        if (gallow.CheckSecret())
            System.out.println("\nYou guessed the secret! Misses: " + user.GetMisses());
        else
            System.out.println("\nYou lost! The secret was: " + gallow.GetWord());
    }
    
    public Gallows UserInput () {
        System.out.println("Type a word or keep empty to get a random word: ");
        Scanner scan = new Scanner (System.in);
        Gallows gallow;
        
        String input = scan.nextLine();
        if (input.length() == 0)
            gallow = new Gallows ();
        else
            gallow = new Gallows(input);
        return gallow;
    }
    
    public void Loop (Gallows gallow, User user) {
        while (user.GetMisses() < user.GetMaxMisses() && !gallow.CheckSecret()) {
            char letter = GetLetter (user);
            CheckLetter (gallow, user, letter);
        }
    }
    
    public char GetLetter (User user) {
        System.out.println("\nPlease enter a letter: ");
        Scanner scan = new Scanner (System.in);
        char letter = scan.next().charAt(0);
        
        while (user.CheckLetter(letter)) {
            System.out.println("You already guessed '" + letter + "', choose a new letter: ");
            letter = scan.next().charAt(0);
        }
        user.AddLetter (letter);
        return letter;
    }
    
    public void CheckLetter (Gallows gallow, User user, char letter) {
        if (gallow.CheckLetter (letter)) {
            gallow.AddLetter (letter);
            System.out.println("That letter is correct.");
        } else {
            user.IncrMisses (1);
            System.out.println("That letter is not correct.");
        }
        System.out.println("Misses: " + user.GetMisses() + "\nSecret: " + gallow.GetSecret());
    }
}
