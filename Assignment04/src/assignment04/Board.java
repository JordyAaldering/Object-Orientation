//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment04;
import java.util.Random;

public class Board {
    private final int rows;
    private final int columns;
    private int winningRow;
    private int winningColumn;
    private int forkRow;
    private int forkColumn;
    private int randomRow;
    private int randomColumn;
    
    private char[][] field;
    private int moves;
    
    Board () {
        this.rows = 3;
        this.columns = 3;
        this.moves = 0;
        this.field = new char[rows][columns];
        fillBoard();
    }
    
    private void fillBoard () {
        for (int y = 0; y < rows; y++)
            for (int x = 0; x < columns; x++)
                this.field[y][x] = '_';
    }
    
    public void play (int y, int x, char c) {
        this.field[y][x] = c;
        this.moves++;
    }
    
    public boolean winning (int y, int x) {
        if (field[y][0] == field[y][1] && field[y][1] == field[y][2])
            return true;
        if (field[0][x] == field[1][x] && field[1][x] == field[2][x])
            return true;
        
        if (x % 2 == 0 || y % 2 == 0 || (x == 1 && y == 1)) {
            if (field[0][0] == field[1][1] && field[1][1] == field[2][2])
                return true;
            if (field[0][2] == field[1][1] && field[1][1] == field[2][0])
                return true;
        }
        return false;
    }
    
    public Board copy () {
        return this;
    }
    
    public boolean isValid (int y, int x) {
        return field[y][x] == '_';
    }
    
    public boolean isBoardFull () {
        return moves >= 9;
    }
    
    @Override
    public String toString () {
        String s = "";
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++)
                s += field[y][x];
            s += "\n";
        }
        return s;
    }
    
    public int getRows () {
        return rows;
    }
    public int getColumns () {
        return columns;
    }
    public int getWinningRow () {
        return winningRow;
    }
    public int getWinningColumn () {
        return winningColumn;
    }
    public int getForkRow () {
        return forkRow;
    }
    public int getForkColumn () {
        return forkColumn;
    }
    public int getRandomRow () {
        return randomRow;
    }
    public int getRandomColumn () {
        return randomColumn;
    }
    
    public int getValue (int y, int x) {
        return field[y][x];
    }
    
    //Set of rules
    public int winningMove (char c) {
        int winningMoves = 0;
        //Check rows
        for (int y = 0; y < rows; y++) {
            if (field[y][0] == c && field[y][1] == c && field[y][2] == '_') {
                this.winningRow = y;
                this.winningColumn = 2;
                winningMoves++;
            } else if (field[y][0] == c && field[y][1] == '_' && field[y][2] == c) {
                this.winningRow = y;
                this.winningColumn = 1;
                winningMoves++;
            } else if (field[y][0] == '_' && field[y][1] == c && field[y][2] == c) {
                this.winningRow = y;
                this.winningColumn = 0;
                winningMoves++;
            }
        }
        
        //Check columns
        for (int x = 0; x < columns; x++) {
            if (field[0][x] == c && field[1][x] == c && field[2][x] == '_') {
                this.winningRow = x;
                this.winningColumn = 2;
                winningMoves++;
            } else if (field[0][x] == c && field[1][x] == '_' && field[2][x] == c) {
                this.winningRow = x;
                this.winningColumn = 1;
                winningMoves++;
            } else if (field[0][x] == '_' && field[1][x] == c && field[2][x] == c) {
                this.winningRow = x;
                this.winningColumn = 0;
                winningMoves++;
            }
        }
        
        //Check diagonal (left top -> right bottom)
        if (field[0][0] == c && field[1][1] == c && field[2][2] == '_') {
            this.winningRow = 2;
            this.winningColumn = 2;
            winningMoves++;
        } else if (field[0][0] == c && field[1][1] == '_' && field[2][2] == c) {
            this.winningRow = 1;
            this.winningColumn = 1;
            winningMoves++;
        } else if (field[0][0] == '_' && field[1][1] == c && field[2][2] == c) {
            this.winningRow = 0;
            this.winningColumn = 0;
            winningMoves++;
        }
        
        //Check diagonal (right top -> left bottom)
        if (field[0][2] == c && field[1][1] == c && field[2][0] == '_') {
            this.winningRow = 2;
            this.winningColumn = 0;
            winningMoves++;
        } else if (field[0][2] == c && field[1][1] == '_' && field[2][0] == c) {
            this.winningRow = 1;
            this.winningColumn = 1;
            winningMoves++;
        } else if (field[0][2] == '_' && field[1][1] == c && field[2][0] == c) {
            this.winningRow = 0;
            this.winningColumn = 2;
            winningMoves++;
        }
        return winningMoves;
    }
    
    public boolean opponentWinningMove (char c) {
        if (c == 'X' && winningMove ('O') > 0)
            return true;
        else return c == 'O' && winningMove ('X') > 0;
    }
    
    public boolean fork (Board board, char c) {
        Board dummy = board.copy();
        boolean forkFound = false;
        
        for (int y = 0; y < rows && !forkFound; y++)
            for (int x = 0; x < columns && !forkFound; x++) {
                dummy.play (y, x, c);
                if (winningMove (c) > 1) {
                    this.forkRow = y;
                    this.forkColumn = x;
                    forkFound = true;
                }
                dummy = board.copy();
            }
        return false;
    }
    
    public boolean opponentFork (char c) {
        boolean forkFound = false;
        
        for (int y = 0; y < rows && !forkFound; y++)
            for (int x = 0; x < columns && !forkFound; x++) {
                if (c == 'X') {
                    play (y, x, 'O');
                    if (winningMove ('O') > 1) {
                        this.forkRow = y;
                        this.forkColumn = x;
                        forkFound = true;
                    }
                } else {
                    play (y, x, 'X');
                    if (winningMove ('X') > 1) {
                        this.forkRow = y;
                        this.forkColumn = x;
                        forkFound = true;
                    }
                }
            }
        return false;
    }
    
    public boolean boardEmpty () {
        for (int y = 0; y < rows; y++)
            for (int x = 0; x < columns; x++)
                if (field[y][x] != '_')
                    return false;
        return true;
    }
    
    public boolean middleFree () {
        return field[1][1] == '_';
    }
    
    public void randomPosition () {
        Random rand = new Random();
        int y, x;
        do {
            y = rand.nextInt(3);
            x = rand.nextInt(3);
        } while (field[y][x] != '_');
        this.randomRow = y;
        this.randomColumn = x;
    }
}