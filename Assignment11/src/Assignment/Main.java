package Assignment;
import javafx.animation.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.util.Duration;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.application.Application;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Main extends Application {

    private GridPane  grid;
    private Timeline  timeLine;
    private TextField timeField;
    private ProgressBar progress;
    private Button btnStart, btnStop, btnQuit;

    public void start(Stage stage) {
        setUI();
        setButtons();
        setGrid();
        setScene(stage);
    }

    private void setUI() {
        progress  = new ProgressBar();
        timeField = new TextField("Time (seconds)");
        timeField.setTooltip(new Tooltip("Numbers only"));

        btnStart = new Button();
        btnStop  = new Button();
        btnQuit  = new Button();

        btnStart.setText("Start");
        btnStop.setText("Stop");
        btnQuit.setText("Quit");
    }

    private void setButtons() {
        btnStart.setOnAction(e -> {
            grid.setStyle("-fx-background-color: WHITE");
            int time = Integer.parseInt(timeField.getText());
            if (time > 0) {
                timeLine = new Timeline(
                    new KeyFrame(Duration.ZERO,new KeyValue(progress.progressProperty(), 1)),
                    new KeyFrame(Duration.seconds(time), f -> grid.setStyle("-fx-background-color: RED"),
                    new KeyValue(progress.progressProperty(), 0))
                );
                timeLine.setCycleCount(1);
                timeLine.play();
            }
        });

        btnStop.setOnAction(e -> {
            timeLine.stop();
            grid.setStyle("-fx-background-color: WHITE");
        });

        btnQuit.setOnAction(e -> System.exit(1));
    }

    private void setGrid() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        grid.add(progress, 1,1);
        grid.add(timeField,1,2);
        grid.add(btnStart, 2,2);
        grid.add(btnStop,  1,3);
        grid.add(btnQuit,  2,3);
    }

    private void setScene(Stage stage) {
        Scene scene = new Scene(grid,250,125);
        stage.setTitle("Time flies!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
