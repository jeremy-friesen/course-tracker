package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class Main extends Application {
	BorderPane mainPane = new BorderPane();
	GridPane mainGridPane = new GridPane();
	Semester semester = new Semester();

	Tab addCourseTab = new Tab();
	Tab componentsTab = new Tab();

    @Override
    public void start(Stage primaryStage) throws Exception{
    	System.out.println(mainPane.getHeight());
    	TabPane leftMenu = new TabPane();
    	addCourseTab.setText("Add Course");
		addCourseTab.setContent(addCoursePane());
		componentsTab.setText("Components by Date");
		componentsTab.setContent(semester.getCourseComponentsByDateVBox());
    	leftMenu.getTabs().addAll(addCourseTab, componentsTab);
		mainGridPane.add(leftMenu, 0,0);

		//EXAMPLE CODE: remove eventually
/*
    	Course course = new Course("Software Systems", "CSCI-2020U");
    	course.addCourseComponent(new Assignment(10.0, LocalDate.of(2019, 03, 25), "Final Project"));
		course.addCourseComponent(new Test(40.0, LocalDate.of(2019, 04, 10), "Final Exam"));
		semester.addCourse(course);
		semester.addCourse(course);
		semester.addCourse(course);
		componentsTab.setContent(semester.getCourseComponentsByDateVBox());

		//EXAMPLE CODE ENDS
*/



    	mainGridPane.add(semester.getCoursesGridPane(), 1, 0);

		mainPane.setTop(menuBar());
		mainPane.setCenter(mainGridPane);
		Scene scene = new Scene(mainPane, 950, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    private MenuBar menuBar(){
		Menu filemenu = new Menu ("File");
		MenuBar bar = new MenuBar();
		Menu editmenu= new Menu("Edit");

		MenuItem save = new MenuItem("Save");
		filemenu.getItems().add(save);
		MenuItem saveas = new MenuItem("Save As...");
		filemenu.getItems().add(saveas);
		MenuItem exit = new MenuItem("Exit");
		filemenu.getItems().add(exit);
		exit.setOnAction(e-> Platform.exit());
		MenuItem cut= new MenuItem("Cut");
		editmenu.getItems().add(cut);
		MenuItem copy= new MenuItem("Copy");
		editmenu.getItems().add(copy);
		MenuItem paste= new MenuItem("Paste");
		editmenu.getItems().add(paste);

		bar.getMenus().addAll(filemenu, editmenu);
		return  bar;
	}

	private GridPane addCoursePane(){
    	GridPane gridPane = new GridPane();

		TextField courseNameTextField = new TextField();
		courseNameTextField.setPromptText("Course Name");

		TextField courseCodeTextField = new TextField();
		courseCodeTextField.setPromptText("Course Code");

		// Course "Add" button
		Button submitCourseButton = new Button("Submit Course");
		submitCourseButton.setOnAction(e -> {
			Course course = new Course();
			GridPane content = semester.getCoursesGridPane();
			course.setCourseName(courseNameTextField.getText());
			course.setCourseCode(courseCodeTextField.getText());
			course.print();
			semester.addCourse(course);
			mainGridPane.add(semester.getCoursesGridPane(), 1, 0);
			componentsTab.setContent(semester.getCourseComponentsByDateVBox());
		});



		gridPane.add(courseNameTextField, 0, 0);
		gridPane.add(courseCodeTextField, 0, 1);
		//gridPane.add(addCourseComponentMenuButton, 0, 2);
		gridPane.add(submitCourseButton, 0, 7);

		return gridPane;
	}

	private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
		for (Node node : gridPane.getChildren()) {
			if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
				return node;
			}
		}
		return null;
	}


    public static void main(String[] args) {
        launch(args);
    }
}


