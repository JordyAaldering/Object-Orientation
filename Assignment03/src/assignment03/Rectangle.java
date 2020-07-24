//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment03;

public class Rectangle {
    private double posX;
    private double posY;
    private final double width;
    private final double height;
    
    private double leftBorder;
    private double rightBorder;
    private double topBorder;
    private double bottomBorder;
    
    Rectangle (double x, double y, double w, double h) {
        this.posX   = x;
        this.posY   = y;
        this.width  = w;
        this.height = h;
        
        this.leftBorder   = x;
        this.rightBorder  = x + w;
        this.topBorder    = y + h;
        this.bottomBorder = y;
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
        return width * height;
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
       return "Rectangle | X: " + posX + ", Y: " + posY + 
                    ", Width: " + width + ", Height: " + height + 
                     ", Area: " + getArea();
    }
}
