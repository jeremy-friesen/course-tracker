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
	private String courseColour;
	private ArrayList<CourseComponent> courseComponents = new ArrayList<CourseComponent>();
	private VBox courseVBox = new VBox();

	private String selectedCourseComponentTypeToAdd = "Default";

	// Constructor
	public Course() {
		this.courseName = "defaultCourseName";
		this.courseColour = courseColour;
	}

	public Course(String courseName) {
		this.courseName = courseName;
		this.courseColour = courseColour;
	}

	public Course(String courseName, String courseCode) {
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.courseColour = courseColour;
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

	// Getters & Setters
	public String getCourseName() {
		return courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public String getCourseColour() {
		return courseColour;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public void setCourseColour(String courseColour) {
		this.courseColour = courseColour;
	}

	public GridPane addComponentGridPane(){
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(5);
		gridPane.setVgap(5);

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



		Button addButton = new Button("Add");
		addButton.setOnAction(e -> {
			CourseComponent newComponent = new CourseComponent();

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
		addComponent.setPadding(new Insets( 5));
		addComponent.setText("Add Course Components");
		addComponent.setOnAction(e -> {
			Stage newStage = new Stage();
			Scene scene1 = new Scene(addComponentGridPane(), 275, 180);
			newStage.setScene(scene1);
			newStage.setTitle("Add Course Components");
			newStage.show();
		});
		courseVBox.getChildren().add(addComponent);
		courseVBox.setStyle("-fx-border-color: #FFFFFF;");
		courseVBox.setStyle("-fx-background-color:" + courseColour + ";");

	}

	public void resetVBox(){
		courseVBox = null;
	}
}