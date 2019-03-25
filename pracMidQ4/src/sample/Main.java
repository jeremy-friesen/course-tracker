package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        double WIDTH = 200;
        double HEIGHT = 200;

        Pane pane = new Pane();

        for (int i = 0; i < 8; i++) {
            boolean isWhite = i % 2 == 0;

            for (int j = 0; j < 8; j++) {
                Rectangle rectangle = new Rectangle(i * WIDTH / 8,
                        j * HEIGHT / 8, WIDTH / 8, HEIGHT / 8);

                rectangle.setStroke(Color.BLACK);

                if (isWhite) {
                    rectangle.setFill(Color.WHITE);
                }
                else {
                    rectangle.setFill(Color.BLACK);
                }

                isWhite = !isWhite;

                pane.getChildren().add(rectangle);
            }
        }


        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Question4"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}

