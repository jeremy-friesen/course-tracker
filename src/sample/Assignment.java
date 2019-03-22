package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.Serializable;
import java.time.LocalDate;

public class Assignment extends CourseComponent implements Serializable {

	// Constructors
	public Assignment(){
		super(10.0);
		super.setDate(LocalDate.now());
		super.setName("Assignment");
	}

	public Assignment(double markWeight){
		super(markWeight);
		super.setDate(LocalDate.now());
		super.setName("Assignment");
	}

	public Assignment(double markWeight, LocalDate dueDate){
		super(markWeight);
		super.setDate(dueDate);
		super.setName("Assignment");
	}

	public Assignment(double markWeight, LocalDate dueDate, String name){
		super(markWeight);
		super.setDate(dueDate);
		super.setName(name);
	}

	// print method
	public void print(){
		System.out.println("Assignment " + getName() + ":");
		System.out.println("\t" + "Due Date: " + super.getDate().toString());
		System.out.println("\t" + "Mark Weight: " + getMarkWeight() + "%");
		System.out.println("\t" + "Mark: " + getMark() + "%");
	}

	public VBox toVBox(){
		final VBox vbox = new VBox();
		vbox.setPadding(new Insets(5, 5, 5, 5));
		vbox.getChildren().add(new Text(super.getName() + ":"));
		vbox.getChildren().add(new Text("Due date: " + super.getDate().toString()));
		vbox.getChildren().add(new Text("Mark weight: " + super.getMarkWeight()));
		vbox.setStyle("-fx-border-color: blue;");
		return vbox;
	}
}
