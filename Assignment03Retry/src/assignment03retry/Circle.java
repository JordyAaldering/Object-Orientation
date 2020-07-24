package assignment03retry;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Circle implements GeometricObject {
    private double posX, posY;
    private final double height, width, radius, area;
    
    public Circle (double x, double y, double r) {
        this.posX   = x;
        this.posY   = y;
        this.height = 2 * r;
        this.width  = 2 * r;
        this.radius = r;
        this.area   = 2 * Math.PI * r;
    }
    
    public double getRadius () {
        return radius;
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
        sb.append (", radius: "); sb.append (radius);
        sb.append (", area: ");   sb.append (area);
        sb.append (".");
        return sb.toString();
    }
}
