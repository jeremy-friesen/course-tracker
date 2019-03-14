package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

public class Course {
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
<<<<<<< HEAD

		courseComponents.add(courseComponents.size(), newCourseComponent);
=======
		CourseComponents.add(CourseComponents.size(), newCourseComponent);
		CourseComponents.sort(Comparator.comparing(o -> o.getDate()));
>>>>>>> 1f3b18bed3d3b15bbea52865402453623465a902
	}

	public void addCourseComponents(ArrayList<CourseComponent> newCourseComponents){
		this.courseComponents.addAll(newCourseComponents);
	}

	// getters & setters
	public String getCourseCode(){
		return courseCode;
	}

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
	public Pane generateDisplayPane(){
		final HBox hbox = new HBox();
		hbox.getChildren().add(new Text(courseName + ":"));
		for(int i = 0; i < courseComponents.size(); i++){
			hbox.getChildren().add(new Text(courseComponents.get(i).toString()));
		}
		hbox.setStyle("-fx-border-color: red;");
		return hbox ;
	}
}
