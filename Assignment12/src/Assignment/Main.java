package Assignment;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;

public class Main extends Application {
    private Pane pane = new Pane();
    private Path path = new Path();

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage stage) {
        path.addShape(new Shape());
        stage.setTitle("A string of beads.");
        stage.setScene(new Scene(pane, 500, 500));
        stage.show();

        pane.addEventHandler(MouseEvent.MOUSE_MOVED, this::update);
        pane.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            path.addShape(new Shape());
            update(me);
        });
    }

    private void update (MouseEvent me) {
        pane.getChildren().clear();
        path.update(me.getX(), me.getY());
        pane.getChildren().add(path.getLine());
        path.placeShapes();
        for (Shape shape : path.getCircles()) {
            pane.getChildren().add(shape.getCircle());
        }
    }
}
