package Assignment;
import java.util.ArrayList;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

public class Path {
    private Line line;
    private ArrayList<Shape> circles = new ArrayList<>();

    Path() {
        line = new Line(0, 0, 0, 0);
    }

    public void update(double x, double y) {
        line.setEndX(x);
        line.setEndY(y);
    }

    public Line getLine() {
        return line;
    }

    public void addShape(Shape shape) {
        circles.add(shape);
    }

    public void placeShapes() {
        for (int i = 0; i < circles.size(); i++) {
            double n = (i+1.0)/circles.size();
            double x = line.getEndX()*n;
            double y = line.getEndY()*n;

            Color color = new Color(1-n, 0, n, 1);
            circles.get(i).setColor(color);
            circles.get(i).setPos(x, y);
        }
    }

    public ArrayList<Shape> getCircles() {
        return circles;
    }
}
