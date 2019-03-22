package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.Serializable;
import java.time.LocalDate;

public class CourseComponent implements Serializable {
	private double markWeight;
	private boolean isComplete = false;
	private double mark = 0.0;
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

	public String getName() {
		return name;
	}

	public LocalDate getDate(){
		return date;
	}

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

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(LocalDate date){
		this.date = date;
	}

	//@Override
	public int compareTo(CourseComponent o1, CourseComponent o2) {
		return o1.getDate().compareTo(o1.getDate());
	}

	// print method
	public void print() {
		System.out.println("\tCourseComponent " + getName() + ":");
		//System.out.println("\n\t\t" + "Due Date: " + dueDate.toString());
		System.out.println("\t\t" + "Mark Weight: " + getMarkWeight() + "%");
		System.out.println("\n\t\t" + "Mark: " + getMark() + "%");
	}

	public String toString(){
		String string = "\tCourseComponent " + getName() + ":";
		//string = string + "\n\t\t" + "Due Date: " + dueDate.toString());
		string = string + "\n\t\t" + "Mark Weight: " + getMarkWeight() + "%";
		string = string + "\n\t\t" + "Mark: " + getMark() + "%";
		return string;
	}

	public VBox toVBox(){
		final VBox vbox = new VBox();
		vbox.setPadding(new Insets(5, 5, 5, 5));
		vbox.getChildren().add(new Text(name + ":"));
		vbox.getChildren().add(new Text("Date: " + date.toString()));
		vbox.getChildren().add(new Text("Mark weight: " + markWeight));
		vbox.setStyle("-fx-border-color: purple;");
		return vbox;
	}
}
