package sample;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

public class Course {
	private String courseName;
	private String courseCode;
	private ArrayList<CourseComponent> CourseComponents = new ArrayList<CourseComponent>();

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
		return CourseComponents;
	}

	public void addCourseComponent(CourseComponent newCourseComponent){
		CourseComponents.add(CourseComponents.size(), newCourseComponent);
		CourseComponents.sort(Comparator.comparing(o -> o.getDate()));
	}

	public void addCourseComponents(ArrayList<CourseComponent> newCourseComponents){
		this.CourseComponents.addAll(newCourseComponents);
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
		for(int i = 0; i < CourseComponents.size(); i++){
			CourseComponents.get(i).print();
		}
	}

	//
}
