package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    // Override the start method in the Application class
    public void start(Stage primaryStage) {
        FlowPane pane = new FlowPane();
        pane.setHgap(2);
        TextField num1 = new TextField();
        TextField num2 = new TextField();
        TextField result = new TextField();


        num1.setPrefColumnCount(3);
        num2.setPrefColumnCount(3);
        result.setPrefColumnCount(3);

        pane.getChildren().addAll(new Label("Number 1: "), num1,
                new Label("Number 2: "), num2, new Label("Result: "), result);

        HBox hBox = new HBox(5);
        Button btAdd = new Button("Add");
        Button btSub = new Button("Subtract");
        Button btMul = new Button("Multiply");
        Button btDiv = new Button("Divide");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btAdd, btSub, btMul, btDiv);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.TOP_CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 250, 150);
        primaryStage.setTitle("Question3"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        btAdd.setOnAction(e -> {
            result.setText(Double.parseDouble(num1.getText()) +
                    Double.parseDouble(num2.getText()) + "");
        });

        btSub.setOnAction(e -> {
            result.setText(Double.parseDouble(num1.getText()) -
                    Double.parseDouble(num2.getText()) + "");
        });

        btMul.setOnAction(e -> {
            result.setText(Double.parseDouble(num1.getText()) *
                    Double.parseDouble(num2.getText()) + "");
        });

        btDiv.setOnAction(e -> {
            result.setText(Double.parseDouble(num1.getText()) /
                    Double.parseDouble(num2.getText()) + "");
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
