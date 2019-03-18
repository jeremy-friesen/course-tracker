package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class Test extends CourseComponent {

	// Constructors
	public Test(){
		super(10.0);
		super.setDate(LocalDate.now());
		super.setName("Test");
	}

	public Test(double markWeight){
		super(markWeight);
		super.setDate(LocalDate.now());
		super.setName("Test");
	}

	public Test(double markWeight, LocalDate date){
		super(markWeight);
		super.setDate(date);
		super.setName("Test");
	}

	public Test(double markWeight, LocalDate date, String name){
		super(markWeight);
		super.setDate(date);
		super.setName(name);
	}

	// print method
	public void print(){
		System.out.println("Test " + getName() + ":");
		System.out.println("\t" + "Test Date: " + super.getDate().toString());
		System.out.println("\t" + "Mark Weight: " + getMarkWeight() + "%");
		System.out.println("\t" + "Mark: " + getMark() + "%");
	}

	public VBox toVBox(){
		final VBox vbox = new VBox();
		vbox.setPadding(new Insets(5, 5, 5, 5));
		vbox.getChildren().add(new Text(super.getName() + ":"));
		vbox.getChildren().add(new Text("Date: " + super.getDate().toString()));
		vbox.getChildren().add(new Text("Mark weight: " + super.getMarkWeight()));
		vbox.setStyle("-fx-border-color: red;");
		return vbox;
	}
}
