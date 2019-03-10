package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane gridPane = new GridPane();
        Semester semester = new Semester();

        //Add course text fields
        TextField courseNameTextField = new TextField();
        courseNameTextField.setPromptText("Course Name");

        TextField courseCodeTextField = new TextField();
        courseCodeTextField.setPromptText("Course Code");

        MenuButton addEvaluationMenuButton = new MenuButton("Add Evaluation");
        MenuItem addAssignmentMenuItem = new MenuItem("Assignment");
        MenuItem addTestMenuItem = new MenuItem("Test");
        addEvaluationMenuButton.getItems().addAll(addAssignmentMenuItem, addTestMenuItem);

        addAssignmentMenuItem.setOnAction(e -> {
            
        });

        gridPane.add(courseNameTextField, 0, 0);
        gridPane.add(courseCodeTextField, 0, 1);
        gridPane.add(addEvaluationMenuButton, 0, 2);
        primaryStage.setScene(new Scene(gridPane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
