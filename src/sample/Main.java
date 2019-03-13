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
import java.time.LocalDate;

public class Main extends Application {
	GridPane gridPane = new GridPane();
	Semester semester = new Semester();

    @Override
    public void start(Stage primaryStage) throws Exception{
    	Course course = new Course();

        //Add course text fields
        TextField courseNameTextField = new TextField();
        courseNameTextField.setPromptText("Course Name");

        TextField courseCodeTextField = new TextField();
        courseCodeTextField.setPromptText("Course Code");

        MenuButton addEvaluationMenuButton = new MenuButton("Add Evaluation");
        MenuItem addAssignmentMenuItem = new MenuItem("Assignment");
        MenuItem addTestMenuItem = new MenuItem("Test");
        addEvaluationMenuButton.getItems().addAll(addAssignmentMenuItem, addTestMenuItem);

        // Add Evaluation Fields/Buttons
		TextField evaluationNameTextField = new TextField("Assignment");
		evaluationNameTextField.setPromptText("Name(optional)");
		TextField markWeightTextField = new TextField("0");
		markWeightTextField.setPromptText("Mark Weight (%)");
		DatePicker datePicker = new DatePicker();
		datePicker.setPromptText("Date");
		datePicker.setValue(LocalDate.now());

		// assignment "Add" button
		Button addAssignmentButton = new Button("Add");
		addAssignmentButton.setOnAction(e -> {
			Assignment assignment = new Assignment();
			assignment.setName(evaluationNameTextField.getText());
			assignment.setMarkWeight(Double.valueOf(markWeightTextField.getText()));
			assignment.setDueDate(datePicker.getValue());
			course.addEvaluation(assignment);
			course.print();
		});

		// test "Add" button
		Button addTestButton = new Button("Add");
		addTestButton.setOnAction(e -> {
			Test test = new Test();
			test.setName(evaluationNameTextField.getText());
			test.setMarkWeight(Double.valueOf(markWeightTextField.getText()));
			test.setDate(datePicker.getValue());
			course.addEvaluation(test);
			course.print();
		});

		// Add assignment menu item action
        addAssignmentMenuItem.setOnAction(e ->{
			addEvaluationMenuButton.setText("Assignment");
			if(!gridPane.getChildren().contains(evaluationNameTextField)) {
				gridPane.add(evaluationNameTextField, 0, 3);
				gridPane.add(markWeightTextField, 0, 4);
				gridPane.add(datePicker, 0, 5);
			}
			gridPane.getChildren().remove(6, 6);
			gridPane.add(addAssignmentButton, 0, 6);
		});

		// Add test menu item action
		addTestMenuItem.setOnAction(e ->{
			addEvaluationMenuButton.setText("Test");
			if(!gridPane.getChildren().contains(evaluationNameTextField)) {
				gridPane.add(evaluationNameTextField, 0, 3);
				gridPane.add(markWeightTextField, 0, 4);
				gridPane.add(datePicker, 0, 5);
			}
			gridPane.getChildren().remove(6, 6);
			gridPane.add(addTestButton, 0, 6);
		});

        gridPane.add(courseNameTextField, 0, 0);
        gridPane.add(courseCodeTextField, 0, 1);
        gridPane.add(addEvaluationMenuButton, 0, 2);
        Scene scene = new Scene(gridPane, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


