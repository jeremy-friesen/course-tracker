package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.Serializable;
import java.time.LocalDate;

public class CourseComponent implements Serializable {
	private double markWeight;
	private double mark = 0.0;
	private Button componentNameButton;
	private LocalDate date;

	public CourseComponent(){}

	// Getters
	public double getMarkWeight() {
		return markWeight;
	}
	public double getMark() {
		return mark;
	}
	public Button getComponentNameButton() {
		return componentNameButton;
	}
	public LocalDate getDate(){
		return date;
	}

	// Setters
	public void setMarkWeight(double markWeight){
		this.markWeight = markWeight;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public void setComponentNameButton(Button componentNameButton) {
		this.componentNameButton = componentNameButton;
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
		System.out.println("\tCourseComponent " + getComponentNameButton().getText() + ":");
		//System.out.println("\n\t\t" + "Due Date: " + dueDate.toString());
		System.out.println("\t\t" + "Mark Weight: " + getMarkWeight() + "%");
		System.out.println("\n\t\t" + "Mark: " + getMark() + "%");
	}

	public String toString(){
		String string = "\tCourseComponent " + getComponentNameButton().getText() + ":";
		//string = string + "\n\t\t" + "Due Date: " + dueDate.toString());
		string = string + "\n\t\t" + "Mark Weight: " + getMarkWeight() + "%";
		string = string + "\n\t\t" + "Mark: " + getMark() + "%";
		return string;
	}

	public VBox toVBox(){
		VBox ComponentVbox = new VBox();
		ComponentVbox.setPadding(new Insets( 5));
		ComponentVbox.setStyle("-fx-border-width: 2px; -fx-border-color: white;");
		ComponentVbox.setSpacing(5);

		Text dateText = new Text(date.toString());
		Text markWeightText = new Text(markWeight + "%");
		dateText.setStyle("-fx-font-weight: bold");
		markWeightText.setStyle("-fx-font-weight: bold");

		componentNameButton.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");
		componentNameButton.setAlignment(Pos.CENTER);

		ComponentVbox.getChildren().add(componentNameButton);
		ComponentVbox.getChildren().add(dateText);
		ComponentVbox.getChildren().add(markWeightText);

		return ComponentVbox;
	}

}
