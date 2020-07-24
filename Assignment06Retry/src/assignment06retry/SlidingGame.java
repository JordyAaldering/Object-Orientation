package assignment06retry;
import java.util.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class SlidingGame implements Configuration {
    public  final int N = 3, SIZE = N * N, HOLE = SIZE;
    private final int manDist;
    private final int[][] board;
    private final Configuration predecessor;
    private int holeX, holeY;

    public SlidingGame(int[] start, Configuration predecessor) {
        assert start.length == N*N: "Length of specified board incorrect!";
        board = new int[N][N];
        
        for (int p = 0; p < start.length; p++) {
            board[p % N][p / N] = start[p];
            if (start[p] == HOLE) {
                holeX = p % N;
                holeY = p / N;
            }
        }
        this.predecessor = predecessor;
        this.manDist     = manhattan();
    }

    @Override
    public String toString() {
        String s = "";
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int puzzel = board[col][row];
                s += puzzel == HOLE ? ". " : puzzel + " ";
            }
            s += "\n";
        }
        return s;
    }

    @Override
    public boolean equals (Object o) {
        SlidingGame newSlidingGame = (SlidingGame)o;
        for (int row = 0; row < N; row++)
            for (int col = 0; col < N; col++)
                if (newSlidingGame.board[col][row] != board[col][row])
                    return false;
        return true;
    }

    @Override
    public boolean isSolution () {
        for (int row = 0, i = 0; row < N; row++) 
            for (int col = 0; col < N; col++)
                if (board[col][row] != ++i)
                    return false;
        return true;
    }

    @Override
    public Collection<Configuration> successors() {
        ArrayList<Configuration> successors = new ArrayList();
        for (Direction dir : Direction.values()) {
            int newHX = holeX + dir.GetDX();
            int newHY = holeY + dir.GetDY();
            
            if(newHX >= 0 && newHX < N && newHY >= 0 && newHY < N) {
                int[][] newBoard  = copyBoard();
                int[] constructor = new int[SIZE];
                newBoard[holeX][holeY] = newBoard[newHX][newHY];
                newBoard[newHX][newHY] = HOLE;
                
                for (int row = 0, i = 0; row < N; row++)
                    for (int col = 0; col < N; col++, i++)
                        constructor[i] = newBoard[col][row];
                successors.add (new SlidingGame (constructor, this));        
            }
        }
        return successors;
    }
    
    public int[][] copyBoard () {
        int[][] copy = new int[N][N];
        for(int row = 0; row < N; row++)
            for(int col = 0; col < N; col++)
                copy[col][row] = board[col][row];
        return copy;
    }
        
    @Override
    public int compareTo (Configuration g) {
       SlidingGame newPuzzle = (SlidingGame) g;
       if (manDist == newPuzzle.manDist) return -1;
       else if (manDist > newPuzzle.manDist) return 1;
       else return 0;
    }
    
    private int manhattan () {
       int val, dst = 0;
       for (int row = 0; row < N; row++)
           for (int col = 0; col < N; col++)
               if (board[col][row] != HOLE) {
                   val = board[col][row];
                   dst += Math.abs((val - 1) % N - col) + Math.abs((val - 1) / N - row);
               }
        return dst;
    }
    
    @Override
    public Configuration parent () {
        return predecessor;
    }
    
    @Override
    public int hashCode () {
        int hash = 0;
        for (int x = N - 1; x >= 0; x--)
            for(int y = N - 1; y >= 0; y--)
                hash = 31 * hash + board[y][x];
        return hash;
    }
}
