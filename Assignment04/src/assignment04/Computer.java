//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment04;

public class Computer implements Player {
    private final String name;
    private final char type;
    
    private int lastRow;
    private int lastColumn;
    
    Computer (char t) {
        this.name = "Computer";
        this.type = t;
    }
    
    @Override
    public void play (int y, int x, Board b) {
        this.lastRow = y;
        this.lastColumn = x;
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
    
    public int getLastRow () {
        return lastRow;
    }
    public int getLastColumn () {
        return lastColumn;
    }
    
    public void bestMove (Board b) {
        Board dummy = makeDummy (b);
        
        if (dummy.winningMove (type) >= 1) {
            System.out.println ("Found a winning move!");
            play (dummy.getWinningRow(), dummy.getWinningColumn(), b);
        } else if (dummy.opponentWinningMove (type)) {
            System.out.println ("Blocked a winning move!");
            play (dummy.getWinningRow(), dummy.getWinningColumn(), b);
        } else if (dummy.opponentFork (type)) {
            System.out.println ("Blocked a opponent fork!");
            play (dummy.getForkRow(), dummy.getForkColumn(), b);
        } else if (dummy.fork(b, type)) {
            System.out.println ("Found a fork!");
            play (dummy.getForkRow(), dummy.getForkColumn(), b);
        } else if (dummy.boardEmpty()) {
            System.out.println ("Board empty.");
            play (0, 0, b);
        } else if (dummy.middleFree()) {
            System.out.println ("Middle empty.");
            play (1, 1, b);
        } else {
            System.out.println ("No optimal found, randomizing.");
            dummy.randomPosition();
            play (dummy.getRandomRow(), dummy.getRandomColumn(), b);
        }
    }
    
    private Board makeDummy (Board b) {
        Board dummy = new Board();
        for (int y = 0; y < b.getRows(); y++)
            for (int x = 0; x < b.getColumns(); x++)
                if (b.getValue (y, x) == 'X')
                    dummy.play (y, x, 'X');
                else if (b.getValue(y, x) == 'O')
                    dummy.play (y, x, 'O');
                else
                    dummy.play (y, x, '_');
        return dummy;
    }
}
