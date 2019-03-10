package sample;

import java.util.ArrayList;

public class Semester {
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
}
