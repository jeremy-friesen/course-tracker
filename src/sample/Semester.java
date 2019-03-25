package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;



public class Semester implements Serializable {
	private ArrayList<Course> courses = new ArrayList<Course>();

	// Constructors
	public Semester(){}
	public Semester(ArrayList<Course> courses){
		this.courses = courses;
	}

	public ArrayList<Course> getCourses(){
		return courses;
	}

	public void addCourse(Course newCourse){
		courses.add(courses.size(), newCourse);
		System.out.println("Course added:");
		newCourse.print();
	}

	public void deleteCourse(Course oldCourse){
		for(int i = 0; i < courses.size(); i++){
			if (courses.get(i) == oldCourse) {
				courses.remove(i);
				break;
			}
		}
	}

	public ArrayList<CourseComponent> getCourseComponentsByDate(){
		ArrayList<CourseComponent> courseComponents = new ArrayList<>();
		for(int i = 0; i < courses.size(); i++){
			courseComponents.addAll(courses.get(i).getCourseComponents());
		}
		courseComponents.sort(Comparator.comparing(c -> c.getDate()));
		return courseComponents;
	}

	public GridPane getCoursesGridPane(){
		GridPane coursesGridPane = new GridPane();
		coursesGridPane.setPadding(new Insets(5,5,5,5));
		coursesGridPane.add(new Text("Courses:"), 0, 0);
		for(int i = 0; i < courses.size(); i++){
			courses.get(i).updateVBox();
			coursesGridPane.add(courses.get(i).getCourseVBox(), i, 1);
		}
		return coursesGridPane;
	}

	public VBox getCourseComponentsByDateVBox(){
		VBox vbox = new VBox();
		ArrayList<CourseComponent> courseComponents = getCourseComponentsByDate();
		for(int i = 0; i < courseComponents.size(); i++){
			courses.get(i).updateVBox();
			vbox.getChildren().add(courseComponents.get(i).toVBox());
		}
		return vbox;
	}

	public void print(){
		System.out.println("semester object");
		for(int i = 0; i < courses.size(); i++){
			courses.get(i).print();
		}
	}
}
