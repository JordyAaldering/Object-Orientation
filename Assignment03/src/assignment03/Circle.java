//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment03;

public class Circle {
    private double posX;
    private double posY;
    private final double radius;
    
    private double leftBorder;
    private double rightBorder;
    private double topBorder;
    private double bottomBorder;
    
    Circle (double x, double y, double r) {
        this.posX   = x;
        this.posY   = y;
        this.radius = r;
        
        this.leftBorder   = x - r;
        this.rightBorder  = x + r;
        this.topBorder    = y + r;
        this.bottomBorder = y - r;
    }
    
    public double getLeftBorder () {
        return leftBorder;
    }
    public double getRightBorder () {
        return rightBorder;
    }
    public double getTopBorder () {
        return topBorder;
    }
    public double getBottomBorder () {
        return bottomBorder;
    }
    
    public double getArea () {
        return Math.PI * radius * radius;
    }
    
    public void move (double dx, double dy) {
        posX += dx;
        posY += dy;
        leftBorder   += dx;
        rightBorder  += dx;
        topBorder    += dy;
        bottomBorder += dy;
    }
    
    @Override
    public String toString () {
       return "Circle    | X: " + posX + ", Y: " + posY + 
                   ", Radius: " + radius + ", Area: " + getArea();
    }
}
