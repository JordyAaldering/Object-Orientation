package assignment03retry;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public interface GeometricObject {
    public double getWidth ();
    public double getHeight ();
    public double getArea ();
    
    public double getX ();
    public double getY ();
    
    public void move (int x, int y);
    
    @Override
    public String toString ();
}
