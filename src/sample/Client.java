package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Client extends Application {
	String courseColour;

	DataOutputStream toServer;
	DataInputStream fromServer;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(addCoursePane());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private GridPane addCoursePane(){
		GridPane gridPane = new GridPane();

		TextField courseNameTextField = new TextField();
		courseNameTextField.setPromptText("Course Name");

		TextField courseCodeTextField = new TextField();
		courseCodeTextField.setPromptText("Course Code");

		HBox colourHBox = new HBox();

		final ToggleGroup radioButtonGroup = new ToggleGroup();
		RadioButton redButton = new RadioButton("Red");
		RadioButton yellowButton = new RadioButton("Yellow");
		RadioButton greenButton = new RadioButton("Green");
		RadioButton blueButton = new RadioButton("Blue");
		RadioButton purpleButton = new RadioButton("Purple");

		redButton.setToggleGroup(radioButtonGroup);
		yellowButton.setToggleGroup(radioButtonGroup);
		greenButton.setToggleGroup(radioButtonGroup);
		blueButton.setToggleGroup(radioButtonGroup);
		purpleButton.setToggleGroup(radioButtonGroup);

		colourHBox.getChildren().add(redButton);
		colourHBox.getChildren().add(yellowButton);
		colourHBox.getChildren().add(greenButton);
		colourHBox.getChildren().add(blueButton);
		colourHBox.getChildren().add(purpleButton);

		redButton.setOnAction(e -> {
			if (redButton.isSelected()) {
				courseColour = "#FA8072";
			}
		});

		yellowButton.setOnAction(e -> {
			if (yellowButton.isSelected()) {
				courseColour = "#FFFACD";
			}
		});

		greenButton.setOnAction(e -> {
			if (greenButton.isSelected()) {
				courseColour = "ACE1AF";
			}
		});

		blueButton.setOnAction(e -> {
			if (blueButton.isSelected()) {
				courseColour = "#ADD8E6";
			}
		});

		purpleButton.setOnAction(e -> {
			if (purpleButton.isSelected()) {
				courseColour = "#E0B0FF";
			}
		});

		// Course "Add" button
		Button submitCourseButton = new Button("Submit Course");
		submitCourseButton.setOnAction(e -> {
			Course course = new Course();
			course.setCourseName(courseNameTextField.getText());
			course.setCourseCode(courseCodeTextField.getText());
			course.setCourseColour(courseColour);
			try {
				Socket socket = new Socket("localhost", 7777);
				System.out.println("Connected!");

				ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
				course.resetVBox();
				objectOutputStream.writeObject(course);
				socket.close();
				System.out.println("object written");
			}
			catch (IOException ex) {
				System.err.println(ex);
			}
		});

		gridPane.add(courseNameTextField, 0, 0);
		gridPane.add(courseCodeTextField, 0, 1);
		//gridPane.add(addCourseComponentMenuButton, 0, 2);
		gridPane.add(colourHBox, 0, 3); // Add color choice
		gridPane.add(submitCourseButton, 0, 4);

		return gridPane;
	}
}
