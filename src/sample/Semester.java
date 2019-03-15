package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Semester implements Serializable {
	private ArrayList<Course> courses = new ArrayList<Course>();

	// Constructors
	public Semester(ArrayList<Course> courses){
		this.courses = courses;
	}

	public Semester(){
	}

	// add / get courses
	public void addCourse(Course newCourse){
		courses.add(courses.size(), newCourse);
	}

	public ArrayList<Course> getCourses(){
		return courses;
	}

	public void print(){
		System.out.println("semester object");
		for(int i = 0; i < courses.size(); i++){
			courses.get(i).print();
		}
	}
}
