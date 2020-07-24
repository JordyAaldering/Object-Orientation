package assignment06retry;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Assignment06Retry {
    public static void main (String[] args) {
        int[] board = {1, 2, 3, 4, 5, 6, 9, 7, 8};
        SlidingGame sg = new SlidingGame (board, null);
        Solver s = new Solver (sg);
        System.out.println(s.solve());
    }
}
