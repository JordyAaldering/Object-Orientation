package assignment03retry;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Rectangle implements GeometricObject {
    private double posX, posY;
    private final double height, width, area;
    
    public Rectangle (double x, double y, double h, double w) {
        this.posX   = x;
        this.posY   = y;
        this.height = h;
        this.width  = w;
        this.area   = h * w;
    }
    
    @Override
    public double getWidth () {
        return width;
    }
    @Override
    public double getHeight () {
        return height;
    }
    @Override
    public double getArea () {
        return area;
    }

    @Override
    public double getX () {
        return posX;
    }
    @Override
    public double getY () {
        return posY;
    }
    
    @Override
    public void move (int x, int y) {
        this.posX += x;
        this.posY += y;
    }
    
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append ("X: ");        sb.append (posX);
        sb.append (", Y: ");      sb.append (posY);
        sb.append (", width: ");  sb.append (width);
        sb.append (", height: "); sb.append (height);
        sb.append (", area: ");   sb.append (area);
        sb.append (".");
        return sb.toString();
    }
}
