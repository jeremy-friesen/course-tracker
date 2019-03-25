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
	private String name;
	private LocalDate date;

	public CourseComponent(){}

	// Getters
	public double getMarkWeight() {
		return markWeight;
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

	// Setters
	public void setMarkWeight(double markWeight){
		this.markWeight = markWeight;
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
		VBox ComponentVbox = new VBox();
		ComponentVbox.setPadding(new Insets( 5));
		ComponentVbox.setStyle("-fx-border-width: 2px; -fx-border-color: white;");
		ComponentVbox.setSpacing(5);

		Button componentButton = new Button();

		componentButton.setOnAction(e -> {
			editComponent(ComponentVbox);
		});

		Text dateText = new Text(date.toString());
		Text markWeightText = new Text(markWeight + "%");
		dateText.setStyle("-fx-font-weight: bold");
		markWeightText.setStyle("-fx-font-weight: bold");

		componentButton.setText(name);
		componentButton.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");
		componentButton.setAlignment(Pos.CENTER);

		ComponentVbox.getChildren().add(componentButton);
		ComponentVbox.getChildren().add(dateText);
		ComponentVbox.getChildren().add(markWeightText);

		return ComponentVbox;
	}

	public void editComponent(VBox ComponentVbox){
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		gridPane.add(new Label("Name:"), 0, 0);
		TextField nameTextField = new TextField();
		gridPane.add(nameTextField, 1, 0);
		nameTextField.setText(this.name);

		gridPane.add(new Label("Date:"), 0, 2);
		DatePicker datePicker = new DatePicker();
		gridPane.add(datePicker, 1, 2);
		datePicker.setValue(this.date);

		gridPane.add(new Label("Mark Weight:"), 0, 1);
		TextField markWeightTextField = new TextField();
		gridPane.add(markWeightTextField, 1, 1);
		markWeightTextField.setText(Double.toString(this.markWeight));

		Button editButton = new Button("Apply");
		Button deleteButton = new Button("Delete");
		HBox editButtonsHbox = new HBox();
		editButtonsHbox.setPadding(new Insets(5));
		editButtonsHbox.setSpacing(5);
		editButtonsHbox.getChildren().add(editButton);
		editButtonsHbox.getChildren().add(deleteButton);

		gridPane.add(editButtonsHbox, 1, 4);

		Stage newStage = new Stage();
		Scene scene = new Scene(gridPane, 325, 180);
		newStage.setScene(scene);
		newStage.setTitle("Edit Course Components");
		newStage.show();

		// effects are only seen when another component is added under the same course
		editButton.setOnAction(e -> {
			setName(nameTextField.getText());
			setDate(datePicker.getValue());
			setMarkWeight(Double.parseDouble(markWeightTextField.getText()));
		});

		// deletes visually, doesn't delete instance variables or the actual vbox
		// Once another component is added whatever that was deleted before will respawn
		deleteButton.setOnAction(e -> {
			ComponentVbox.getChildren().clear();
			scene.setFill(null);
			newStage.setScene(scene);
			newStage.show();
			newStage.close();
		});
	}
}
