package sample;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
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
		public ArrayList<CourseComponent> getCourseComponent(){
			return courseComponents;
		}

		public void addCourseComponent(CourseComponent newCourseComponent){

			courseComponents.add(courseComponents.size(), newCourseComponent);
			courseComponents.sort(Comparator.comparing(o -> o.getDate()));
	}

	public void addCourseComponents(ArrayList<CourseComponent> newCourseComponents){
		this.courseComponents.addAll(newCourseComponents);
	}

	// getters & setters
	public String getCourseCode(){
		return courseCode;
	}

	public void setCourseName(String courseName) {this.courseName = courseName;}

	public void setCourseCode(String courseCode){
		this.courseCode = courseCode;
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
	public void generateDisplayPane(){
		Stage courseInfoWindow = new Stage();
		final HBox hbox = new HBox();
		hbox.getChildren().add(new Text(courseName + ":"));
		hbox.getChildren().add(new Text(courseCode + ":"));
		for(int i = 0; i < courseComponents.size(); i++){
			hbox.getChildren().add(new Text(courseComponents.get(i).toString()));
		}

		hbox.setStyle("-fx-border-color: red;");

		Scene scene2 = new Scene(hbox);
		courseInfoWindow.setScene(scene2);
		courseInfoWindow.show();
	}
}
