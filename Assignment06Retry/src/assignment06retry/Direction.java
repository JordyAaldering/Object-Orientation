package assignment06retry;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public enum Direction {
    NORTH (0,-1), EAST (1,0), SOUTH(0,1), WEST(-1,0);
    private final int dX, dY;
    
    Direction (int dx, int dy) {
        this.dX = dx;
        this.dY = dy;
    }
    
    public int GetDX () {
        return dX;
    }
    
    public int GetDY () {
        return dY;
    }
}

