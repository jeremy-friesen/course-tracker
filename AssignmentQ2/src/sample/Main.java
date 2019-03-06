package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    // Override the start method in the Application class
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        TextField investmentAmount = new TextField();
        TextField annualInterestRate = new TextField();
        TextField futureValue = new TextField();
        TextField years = new TextField();

        /*
        pane.getChildren().addAll(new Label("Investment Amount "), investmentAmount,
                new Label("Years "), years, new Label("Annual Interest Rate "), annualInterestRate, new Label("Future Value"), futureValue);
        */

        pane.add(new Label("Investment Amount"),0,1);
        pane.add(new Label("Years"),0,2);
        pane.add(new Label("Annual Interest Rate"),0,3);
        pane.add(new  Label("Future Value"),0,4);

        pane.add(investmentAmount,1,1);
        pane.add(years,1,2);
        pane.add(annualInterestRate,1,3);
        pane.add(futureValue,1,4);

        Button btCalculate = new Button("Calculate");
        pane.add(btCalculate,2,5);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Question2"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        btCalculate.setOnAction(e -> {
            futureValue.setText(Double.parseDouble(investmentAmount.getText()) * Math.pow(1 + ((Double.parseDouble(annualInterestRate.getText())) / 100 / 12), (Double.parseDouble(years.getText()) * 12))+ "");
        });

    }

        public static void main (String[]args){
            launch(args);
        }

}
