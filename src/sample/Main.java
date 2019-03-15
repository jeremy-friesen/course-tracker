package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;

import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class Main extends Application {
	GridPane gridPane = new GridPane();
	Semester semester = new Semester();

    @Override
    public void start(Stage primaryStage) throws Exception{
    	Course course = new Course();
    	Menu filemenu = new Menu ("File");
    	MenuBar menubar = new MenuBar();
		Menu editmenu= new Menu("Edit");

    	MenuItem save = new MenuItem("Save");
    	filemenu.getItems().add(save);
    	MenuItem saveas = new MenuItem("Save As...");
    	filemenu.getItems().add(saveas);
    	MenuItem exit = new MenuItem("Exit");
    	filemenu.getItems().add(exit);
    	exit.setOnAction(e-> Platform.exit());

		MenuItem cut= new MenuItem("Cut");
		editmenu.getItems().add(cut);
		MenuItem copy= new MenuItem("Copy");
		editmenu.getItems().add(copy);
		MenuItem paste= new MenuItem("Paste");
		editmenu.getItems().add(paste);

		menubar.getMenus().addAll(filemenu, editmenu);

		BorderPane pane = new BorderPane();
		pane.setTop(menubar);

		//Add course text fields
        TextField courseNameTextField = new TextField();
        courseNameTextField.setPromptText("Course Name");

        TextField courseCodeTextField = new TextField();
        courseCodeTextField.setPromptText("Course Code");

        MenuButton addCourseComponentMenuButton = new MenuButton("Add CourseComponent");
        MenuItem addAssignmentMenuItem = new MenuItem("Assignment");
        MenuItem addTestMenuItem = new MenuItem("Test");
        addCourseComponentMenuButton.getItems().addAll(addAssignmentMenuItem, addTestMenuItem);

        // Add CourseComponent Fields/Buttons
		TextField courseComponentNameTextField = new TextField("Assignment");
		courseComponentNameTextField.setPromptText("Name(optional)");
		TextField markWeightTextField = new TextField("0");
		markWeightTextField.setPromptText("Mark Weight (%)");
		DatePicker datePicker = new DatePicker();
		datePicker.setPromptText("Date");
		datePicker.setValue(LocalDate.now());

		// Course "Add" button
		Button submitCourseButton = new Button("Submit Course Name + Code");
		submitCourseButton.setOnAction(e -> {
			course.setCourseName(courseNameTextField.getText());
			course.setCourseCode(courseCodeTextField.getText());
			course.print();
		});

		// assignment "Add" button
		Button addAssignmentButton = new Button("Add");
		addAssignmentButton.setOnAction(e -> {
			Assignment assignment = new Assignment();
			assignment.setName(courseComponentNameTextField.getText());
			assignment.setMarkWeight(Double.valueOf(markWeightTextField.getText()));
			assignment.setDate(datePicker.getValue());
			course.addCourseComponent(assignment);
			course.print();
			course.generateDisplayPane();
		});

		// test "Add" button
		Button addTestButton = new Button("Add");
		addTestButton.setOnAction(e -> {
			Test test = new Test();
			test.setName(courseComponentNameTextField.getText());
			test.setMarkWeight(Double.valueOf(markWeightTextField.getText()));
			test.setDate(datePicker.getValue());
			course.addCourseComponent(test);
			course.print();
			course.generateDisplayPane();
		});

		// Add assignment menu item action
        addAssignmentMenuItem.setOnAction(e ->{
			addCourseComponentMenuButton.setText("Assignment");
			if(!gridPane.getChildren().contains(courseComponentNameTextField)) {
				gridPane.add(courseComponentNameTextField, 0, 3);
				gridPane.add(markWeightTextField, 0, 4);
				gridPane.add(datePicker, 0, 5);
			}
			gridPane.getChildren().remove(6, 6);
			gridPane.add(addAssignmentButton, 0, 6);
		});

		// Add test menu item action
		addTestMenuItem.setOnAction(e ->{
			addCourseComponentMenuButton.setText("Test");
			if(!gridPane.getChildren().contains(courseComponentNameTextField)) {
				gridPane.add(courseComponentNameTextField, 0, 3);
				gridPane.add(markWeightTextField, 0, 4);
				gridPane.add(datePicker, 0, 5);
			}
			gridPane.getChildren().remove(6, 6);
			gridPane.add(addTestButton, 0, 6);
		});

        gridPane.add(courseNameTextField, 0, 0);
        gridPane.add(courseCodeTextField, 0, 1);
        gridPane.add(addCourseComponentMenuButton, 0, 2);
		gridPane.add(submitCourseButton, 0, 7);
        pane.setCenter(gridPane);
        Scene scene = new Scene(pane, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	// Test
    public static void main(String[] args) {
        launch(args);
    }
}


