package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;

public class Course implements Serializable {
	private String courseName;
	private String courseCode;
	private ArrayList<CourseComponent> courseComponents = new ArrayList<CourseComponent>();

	// Constructor
	public Course(){
		this.courseName = "defaultCourseName";
	}

	public Course(String courseName){
		this.courseName = courseName;
	}

	public Course(String courseName, String courseCode){
		this.courseName = courseName;
		this.courseCode = courseCode;
	}

	// CourseComponents get and add
	public ArrayList<CourseComponent> getCourseComponents(){
		return courseComponents;
	}

	public void addCourseComponent(CourseComponent newCourseComponent){
		courseComponents.add(courseComponents.size(), newCourseComponent);
		courseComponents.sort(Comparator.comparing(c -> c.getDate()));
	}

	public void addCourseComponents(ArrayList<CourseComponent> newCourseComponents){
		this.courseComponents.addAll(newCourseComponents);
	}

	// getters & setters
	public String getCourseName(){
		return courseName;
	}

	public String getCourseCode(){
		return courseCode;
	}

	public void setCourseName(String courseName) {this.courseName = courseName;}

	public void setCourseCode(String courseCode){
		this.courseCode = courseCode;
	}

	public GridPane courseDisplay(){
		GridPane gridPane = new GridPane();
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

		// assignment "Add" button
		Button addAssignmentButton = new Button("Add");
		addAssignmentButton.setOnAction(e -> {
			Assignment assignment = new Assignment();
			assignment.setName(courseComponentNameTextField.getText());
			assignment.setMarkWeight(Double.valueOf(markWeightTextField.getText()));
			assignment.setDate(datePicker.getValue());
			this.addCourseComponent(assignment);
			this.print();
		});

		// test "Add" button
		Button addTestButton = new Button("Add");
		addTestButton.setOnAction(e -> {
			Test test = new Test();
			test.setName(courseComponentNameTextField.getText());
			test.setMarkWeight(Double.valueOf(markWeightTextField.getText()));
			test.setDate(datePicker.getValue());
			this.addCourseComponent(test);
			this.print();
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
		gridPane.add(addCourseComponentMenuButton, 0, 2);
		return gridPane;
	}

	// print method
	public void print(){
		System.out.print("Course: ");
		if(courseName != null){
			System.out.print(courseName);
		}
		System.out.println("\nCourseComponents:");
		for(int i = 0; i < courseComponents.size(); i++){
			courseComponents.get(i).print();
		}
	}

	// display pane method
	public VBox toVBox(){
		final VBox vbox = new VBox();
		Button addComponent = new Button();
		//vbox.setPadding(new Insets(5,5,5,5));
		addComponent.setText("Add Course Component");
		vbox.setPadding(new Insets(5, 5, 5, 5));
		vbox.getChildren().add(new Text(courseName + ":"));
		vbox.getChildren().add(new Text("Course code: " + courseCode));
		vbox.getChildren().add(new Text("Components:"));
		for(int i = 0; i < courseComponents.size(); i++){
			vbox.getChildren().add(courseComponents.get(i).toVBox());
		}
		addComponent.setOnAction(e -> {
			Stage newStage = new Stage();
			GridPane displayCourse = courseDisplay();
			Scene scene1 = new Scene(displayCourse,500,500);
			newStage.setScene(scene1);
			newStage.show();
		});
		vbox.getChildren().add(addComponent);

		vbox.setStyle("-fx-border-color: green;");
		return vbox;
	}




}

/*
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

		// assignment "Add" button
		Button addAssignmentButton = new Button("Add");
		addAssignmentButton.setOnAction(e -> {
			Assignment assignment = new Assignment();
			assignment.setName(courseComponentNameTextField.getText());
			assignment.setMarkWeight(Double.valueOf(markWeightTextField.getText()));
			assignment.setDate(datePicker.getValue());
			course.addCourseComponent(assignment);
			course.print();
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
 */
