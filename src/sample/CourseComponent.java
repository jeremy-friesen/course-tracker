package sample;

import java.time.LocalDate;

public class CourseComponent {
	private double markWeight;
	private boolean isComplete = false;
	private double mark;
	private String name;
	private LocalDate date;

	// Constructors
	public CourseComponent(double markWeight){
		this.markWeight = markWeight;
	}

	public CourseComponent(double markWeight, boolean isComplete){
		this.markWeight = markWeight;
		this.isComplete = isComplete;
	}

	public CourseComponent(){}

	// getters
	public double getMarkWeight() {
		return markWeight;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public double getMark() {
		return mark;
	}

	public String getName() { return name;	}

	// setters
	public void setMarkWeight(double markWeight){
		this.markWeight = markWeight;
	}

	public void setComplete(boolean complete) {
		isComplete = complete;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public void setName(String name) { this.name = name; }

	public void setDate(LocalDate date){this.date = date;}

	public LocalDate getDate(){return this.date;}

	//@Override
	public int compareTo(CourseComponent o1, CourseComponent o2) {
		return o1.getDate().compareTo(o1.getDate());
	}

	// print method
	public void print() {
		System.out.println("super method");
	}

	public String toString(){
		String string = "\tCourseComponent " + getName() + ":";
		//string = string + "\n\t\t" + "Due Date: " + dueDate.toString());
		string = string + "\n\t\t" + "Mark Weight: " + getMarkWeight() + "%";
		string = string + "\n\t\t" + "Mark: " + getMark() + "%";
		return string;
	}
}
