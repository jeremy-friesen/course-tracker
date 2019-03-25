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
	private Button courseNameButton;
	private String courseCode;
	private String courseColour;
	private ArrayList<CourseComponent> courseComponents = new ArrayList<CourseComponent>();
	private VBox courseVBox = new VBox();

	// Constructor
	public Course() {
		this.courseNameButton = new Button("Course");
		this.courseColour = "#D3D3D3";
	}

	public Course(Button courseNameButton) {
		this.courseNameButton = courseNameButton;
		this.courseColour = "#D3D3D3";
	}

	public Course(Button courseNameButton, String courseColour) {
		this.courseNameButton = courseNameButton;
		this.courseColour = courseColour;
	}

	public Course(Button courseNameButton, String courseCode, String courseColour) {
		this.courseNameButton = courseNameButton;
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

	// Getters & Setters
	public Button getCourseNameButton() { return courseNameButton; }
	public String getCourseCode() { return courseCode; }
	public String getCourseColour() { return courseColour; }
	public VBox getCourseVBox() { return courseVBox; }

	public void resetCourseVBox(){ courseVBox = null; }

	public void setCourseNameButton(Button courseNameButton) { this.courseNameButton = courseNameButton; }
	public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
	public void setCourseColour(String courseColour) { this.courseColour = courseColour; }

	// display pane method
	public void updateVBox() {
		if(courseVBox == null){
			courseVBox = new VBox();
		}
		courseVBox.getChildren().clear();
		courseVBox.setPadding(new Insets(10));
		courseNameButton.setPadding(new Insets(5));
		courseVBox.getChildren().add(courseNameButton);
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
			Scene scene1 = new Scene(addComponentGridPane(), 325, 180);
			newStage.setScene(scene1);
			newStage.setTitle("Add Course Components");
			newStage.show();
		});

		courseVBox.getChildren().add(addComponent);
		courseVBox.setStyle("-fx-border-color: #FFFFFF;");
		courseVBox.setStyle("-fx-background-color:" + courseColour + ";");
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
			}
			else {
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
		if (courseNameButton != null) {
			System.out.print(courseNameButton.getText());
		}
		System.out.println("\nCourseComponents:");
		for (int i = 0; i < courseComponents.size(); i++) {
			courseComponents.get(i).print();
		}
	}
}