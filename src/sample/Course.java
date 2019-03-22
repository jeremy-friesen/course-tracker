package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	private VBox courseVBox = new VBox();

	private String selectedCourseComponentTypeToAdd = "Default";

	// Constructor
	public Course() {
		this.courseName = "defaultCourseName";
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public Course(String courseName, String courseCode) {
		this.courseName = courseName;
		this.courseCode = courseCode;
	}

	// CourseComponents get and add
	public ArrayList<CourseComponent> getCourseComponents() {
		return courseComponents;
	}

	public void addCourseComponent(CourseComponent newCourseComponent) {
		courseComponents.add(courseComponents.size(), newCourseComponent);
		courseComponents.sort(Comparator.comparing(c -> c.getDate()));
	}

	public void addCourseComponents(ArrayList<CourseComponent> newCourseComponents) {
		this.courseComponents.addAll(newCourseComponents);
	}

	// getters & setters
	public String getCourseName() {
		return courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public GridPane addComponentGridPane(){
		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Name:"), 0, 0);
		TextField nameTextField = new TextField();
		gridPane.add(nameTextField, 1, 0);
		gridPane.add(new Label("Date:"), 0, 2);
		DatePicker datePicker = new DatePicker();
		datePicker.setValue(LocalDate.now());
		gridPane.add(datePicker, 1, 2);
		gridPane.add(new Label("Mark Weight:"), 0, 1);
		TextField markWeightTextField = new TextField();
		gridPane.add(markWeightTextField, 1, 1);
		gridPane.add(new Label("Type:"), 0, 3);
		String[] selectedType = {"Default"};
		MenuButton typeMenu = new MenuButton("Default");
		MenuItem defaultMenuItem = new MenuItem("Default");
		defaultMenuItem.setOnAction(e -> {selectedType[0] = "Default"; typeMenu.setText("Default");});
		MenuItem assignmentMenuItem = new MenuItem("Assignment");
		assignmentMenuItem.setOnAction(e -> {selectedType[0] = "Assignment"; typeMenu.setText("Assignment");});
		MenuItem testMenuItem = new MenuItem("Test");
		testMenuItem.setOnAction(e -> {selectedType[0] = "Test"; typeMenu.setText("Test");});
		typeMenu.getItems().addAll(defaultMenuItem, assignmentMenuItem, testMenuItem);
		gridPane.add(typeMenu, 1, 3);
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> {
			CourseComponent newComponent = new CourseComponent();
			if(selectedType[0] == "Assignment"){
				newComponent = new Assignment();
			} else if(selectedType[0] == "Test"){
				newComponent = new Test();
			}
			newComponent.setName(nameTextField.getText());
			if(markWeightTextField.getText().isEmpty()){
				newComponent.setMarkWeight(0);
			}else {
				newComponent.setMarkWeight(Double.parseDouble(markWeightTextField.getText()));
			}
			newComponent.setDate(datePicker.getValue());
			this.addCourseComponent(newComponent);
			updateVBox();
		});
		gridPane.add(addButton, 1, 4);
		return gridPane;
	}

	// print method
	public void print() {
		System.out.print("Course: ");
		if (courseName != null) {
			System.out.print(courseName);
		}
		System.out.println("\nCourseComponents:");
		for (int i = 0; i < courseComponents.size(); i++) {
			courseComponents.get(i).print();
		}
	}

	public VBox getVBox() {
		return courseVBox;
	}

	// display pane method
	public void updateVBox() {
		if(courseVBox == null){
			courseVBox = new VBox();
		}
		courseVBox.getChildren().clear();
		courseVBox.setPadding(new Insets(5, 5, 5, 5));
		courseVBox.getChildren().add(new Text(courseName + ":"));
		courseVBox.getChildren().add(new Text("Course code: " + courseCode));
		courseVBox.getChildren().add(new Text("Components:"));
		for (int i = 0; i < courseComponents.size(); i++) {
			courseVBox.getChildren().add(courseComponents.get(i).toVBox());
		}
		Button addComponent = new Button();
		addComponent.setText("Add Course Components");
		addComponent.setOnAction(e -> {
			Stage newStage = new Stage();
			Scene scene1 = new Scene(addComponentGridPane(), 315, 200);
			newStage.setScene(scene1);
			newStage.setTitle("Add Course Components");
			newStage.show();
		});
		courseVBox.getChildren().add(addComponent);
		courseVBox.setStyle("-fx-border-color: green;");
	}

	public void resetVBox(){
		courseVBox = null;
	}
}