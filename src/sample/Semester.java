package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Semester implements Serializable {
	private ArrayList<Course> courses = new ArrayList<Course>();

	// Constructors
	public Semester(ArrayList<Course> courses){
		this.courses = courses;
	}

	public Semester(){}

	// add / get courses
	public void addCourse(Course newCourse){
		courses.add(courses.size(), newCourse);
	}

	public ArrayList<Course> getCourses(){
		return courses;
	}

	public GridPane getCoursesGridPane(){
		GridPane coursesGridPane = new GridPane();
		coursesGridPane.setPadding(new Insets(5,5,5,5));
		coursesGridPane.add(new Text("Courses:"), 0, 0);
		for(int i = 0; i < courses.size(); i++){
			coursesGridPane.add(courses.get(i).toVBox(), i, 1);
		}
		return coursesGridPane;
	}

	public void print(){
		System.out.println("semester object");
		for(int i = 0; i < courses.size(); i++){
			courses.get(i).print();
		}
	}
}
