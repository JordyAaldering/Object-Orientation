package Assignment;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Shape {
    private Circle circle;

    Shape() {
        circle = new Circle(10);
    }

    public void setPos(double x, double y) {
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    public void setColor(Paint paint) {
        circle.setFill(paint);
    }

    public Circle getCircle() {
        return circle;
    }
}
