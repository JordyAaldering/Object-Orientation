//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment02;
import java.util.Scanner;
import java.util.Random;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordReader {
    private final List<String> words;
    private final Random rand;

    public WordReader(String fileName) {
        rand = new Random ();
        words = new ArrayList<> ();
        String pattern = "\\S+"; // consisting of at least one non-space

        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner file = new Scanner(fileReader);

            while (file.hasNext(pattern))
                words.add(file.next(pattern).toLowerCase());
            fileReader.close();
        } catch ( IOException ioe ) {
            System.out.println("Error while reading file with name " + fileName + ": " + ioe.getMessage() );
        }
    }

    public int getNumberOfWords() {
        return words.size();
    }

    public String getWord() {
        if (! words.isEmpty())
            return words.get(rand.nextInt(getNumberOfWords()));
        else
            return "";
    }
}