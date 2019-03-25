package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

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
			coursesGridPane.add(courses.get(i).getVBox(), i, 1);
		}
		return coursesGridPane;
	}

	public VBox getCourseComponentsByDateVBox(){
			VBox vbox = new VBox();
		ArrayList<CourseComponent> courseComponents = getCourseComponentsByDate();

			for(int i = 0; i < courseComponents.size(); i++){
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
