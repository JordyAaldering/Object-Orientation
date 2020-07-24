//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment06;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        int[] game = {1,2,3, 4,5,6, 7,9,8};

        SlidingGame s = new SlidingGame (game);
        System.out.println(s);
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}
