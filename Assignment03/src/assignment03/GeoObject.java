//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment03;

public class GeoObject implements Comparable<GeoObject> {
    private final char type;
    private Circle     circObject;
    private Rectangle  rectObject;
    
    GeoObject (Circle c) {
        this.circObject = c;
        this.type = 'c';
    }
    GeoObject (Rectangle r) {
        this.rectObject = r;
        this.type = 'r';
    }
    
    public Circle getCircle () {
        return circObject;
    }
    public Rectangle getRectangle () {
        return rectObject;
    }
    
    public void move (double dx, double dy) {
        if (this.type == 'c')
            this.circObject.move(dx, dy);
        else
            this.rectObject.move(dx, dy);
    }
    
    public double getLeftBorder () {
        if (this.type == 'c')
            return circObject.getLeftBorder();
        else
            return rectObject.getLeftBorder();
    }
    public double getBottomBorder () {
        if (this.type == 'c')
            return circObject.getBottomBorder();
        else
            return rectObject.getBottomBorder();
    }
    private double getArea () {
        if (this.type == 'c')
            return circObject.getArea();
        else
            return rectObject.getArea();
    }
    
    @Override
    public String toString () {
        if (this.type == 'c')
            return circObject.toString();
        else
            return rectObject.toString();
    }
    
    @Override
    public int compareTo (GeoObject o) {
        if (getArea() < o.getArea())
            return -1;
        else if (getArea() == o.getArea())
            return 0;
        else
            return 1;
    }
}