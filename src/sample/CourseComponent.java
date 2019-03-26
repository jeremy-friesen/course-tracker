package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

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

		Text dateText = new Text(date.toString());
		Text markWeightText = new Text(markWeight + "%");
		dateText.setStyle("-fx-font-weight: bold");
		markWeightText.setStyle("-fx-font-weight: bold");

		// Create delete and edit buttons
		Button componentButton = new Button();
		componentButton.setText(name);
		componentButton.setStyle("-fx-font-weight: bold; -fx-font-size: 14; -fx-background-color: transparent;");
		componentButton.setAlignment(Pos.CENTER);

		final VBox vbox = new VBox();
		vbox.setPadding(new Insets( 5));
		vbox.setSpacing(5);
		vbox.getChildren().add(componentButton);
		vbox.getChildren().add(dateText);
		vbox.getChildren().add(markWeightText);
		vbox.setStyle("-fx-border-width: 2px; -fx-border-color: white;");
		return vbox;
	}
}
