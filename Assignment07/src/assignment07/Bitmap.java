package assignment07;

/**
 * @author Sjaak Smetsers
 * @coauthor Thomas van Harskamp, s1007576
 * @coauthor Jordy Aaldering,     s1004292
 */
public class Bitmap {
    private final boolean[][] raster;
    private final int bmWidth, bmHeight;
    
    Bitmap (int width, int height) {
        raster   = new boolean[width][height];
        bmWidth  = width;
        bmHeight = height;
    }

    public void setBit (int x, int y, boolean val) {
        raster[x][y] = val;
    }
    
    public int getBit (int x, int y) {
        return raster[x][y] ? 1 : 0;
    }
    
    public int getWidth () {
        return bmWidth;
    }
    
    public int getHeight () {
        return bmHeight;
    }
    
    /**
     * Converts a bitmap into a string
     * 1 is represented by '*'; 0 by 'O'
     * @return the string representation
     */
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < bmHeight; y++) {
            for (int x = 0; x < bmWidth; x++)
               sb.append (raster[x][y] ?  '*' : 'O');
            sb.append( '\n' );
        }
        return sb.toString();
    }
    
    /**
     * Fills a square area of a bitmap with value val
     * @param x: x coordinate of upper-left corner
     * @param y: y coordinate of upper-left corner
     * @param size: size of the square
     * @param val:  the bit value 
      */
    public void fillArea (int x, int y, int size, boolean val){
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                setBit (x+i, y+j, val);
    }
}
