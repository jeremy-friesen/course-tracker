package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
		courseComponents.sort(Comparator.comparing(c -> c.getDate()));
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
	public VBox toVBox(){
		final VBox vbox = new VBox();
		vbox.setPadding(new Insets(5, 5, 5, 5));
		vbox.getChildren().add(new Text(courseName + ":"));
		vbox.getChildren().add(new Text("Course code: " + courseCode));
		vbox.getChildren().add(new Text("Components:"));
		for(int i = 0; i < courseComponents.size(); i++){
			vbox.getChildren().add(courseComponents.get(i).toVBox());
		}
		vbox.setStyle("-fx-border-color: green;");
		return vbox;
	}
}
