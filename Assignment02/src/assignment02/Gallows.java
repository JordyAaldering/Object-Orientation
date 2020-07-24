//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment02;
public class Gallows {
    private int length;
    private final String word;
    private String secret;
    
    Gallows (String s) {
        this.word = s;
    }
    
    Gallows () {
        WordReader reader = new WordReader("words.txt");
        this.word = reader.getWord();
    }
    
    public String GetWord () {
        return this.word;
    }
    
    public void CreateSecret (int leng) {
        this.length = leng;
        String s = "";
        for (int i = 0; i < length; i++)
            s += ".";
        this.secret = s;
    }
    
    public String GetSecret () {
        return this.secret;
    }
    
    public boolean CheckSecret () {
        for (int i = 0; i < length; i++)
            if (this.secret.charAt(i) == '.')
                return false;
        return true;
    }
    
    public boolean CheckLetter (char letter) {
        return this.word.indexOf (letter) != -1;
    }
    
    public void AddLetter (char letter) {
        for (int i = 0; i < length; i++)
            if (this.word.charAt(i) == letter) {
                char[] secretChars = secret.toCharArray();
                secretChars[i] = letter;
                secret = String.valueOf(secretChars);
            }
    }
}
