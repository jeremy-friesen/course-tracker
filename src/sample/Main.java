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

        // Add Assignment Fields/Buttons
		TextField assignmentNameTextField = new TextField("Assignment");
		assignmentNameTextField.setPromptText("Name(optional)");
		TextField markWeightTextField = new TextField();
		markWeightTextField.setPromptText("Mark Weight (%)");
		DatePicker dueDatePicker = new DatePicker();
		dueDatePicker.setValue(LocalDate.now());
		Button addAssignmentButton = new Button("Add");
		addAssignmentButton.setOnAction(e -> {
			Assignment assignment = new Assignment();
			assignment.setName(assignmentNameTextField.getText());
			assignment.setMarkWeight(Double.valueOf(markWeightTextField.getText()));
			assignment.setDueDate(dueDatePicker.getValue());
			course.addEvaluation(assignment);
			course.print();
		});

		// Add assignment menu item action
        addAssignmentMenuItem.setOnAction(e ->{
			gridPane.add(assignmentNameTextField, 0, 3);
			gridPane.add(markWeightTextField, 0, 4);
			gridPane.add(dueDatePicker, 0, 5);
			gridPane.add(addAssignmentButton, 0, 6);
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


