package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.Clipboard;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;


public class Main extends Application {
	BorderPane mainPane = new BorderPane();
	BorderPane mainBorderPane = new BorderPane();
	Semester semester = new Semester();
	ScrollPane coursesScrollPane = new ScrollPane();
	ScrollPane dateScrollPane = new ScrollPane();

	Tab addCourseTab = new Tab();
	Tab componentsTab = new Tab();

	String courseColour;

    @Override
    public void start(Stage primaryStage) throws Exception{
    	TabPane leftMenu = new TabPane();
    	addCourseTab.setText("Add Course");
		addCourseTab.setContent(addCoursePane());
		componentsTab.setText("Components by Date");
		componentsTab.setContent(semester.getCourseComponentsByDateVBox());
    	leftMenu.getTabs().addAll(addCourseTab, componentsTab);
		mainBorderPane.setLeft(leftMenu);

		coursesScrollPane.setContent(semester.getCoursesGridPane());
    	mainBorderPane.setCenter(coursesScrollPane);
		HBox.setHgrow(leftMenu, Priority.ALWAYS);
		HBox.setHgrow(coursesScrollPane, Priority.ALWAYS);

		mainPane.setTop(menuBar());
		mainPane.setCenter(mainBorderPane);
		Scene scene = new Scene(mainPane, 1100, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Course Tracker");
		primaryStage.show();

		Thread serverThread = new Thread(() -> {
			try {
				ServerSocket serverSocket = new ServerSocket(7777);
				while(true) {
					Socket socket = serverSocket.accept();
					try {
						System.out.println("Connected to Client");
						InputStream inputStream = socket.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						Object inputObject = new Object();
						try {
							inputObject = objectInputStream.readObject();
						}
						catch (Exception e){
							e.printStackTrace();
						}
						objectInputStream.close();
						Course newCourse = (Course)inputObject;
						newCourse.updateVBox();
						semester.addCourse(newCourse);
						Platform.runLater(() ->{
							updateUI();
						});
						System.out.println("Course added from Client");
					} catch (IOException ex){
						ex.printStackTrace();
					}
				}
			}
			catch(IOException ex) {
				System.err.println(ex);
			}
		});
		serverThread.start();
    }

    private MenuBar menuBar(){
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu ("File");
		Menu editMenu= new Menu("Edit");

		MenuItem save = new MenuItem("Save");
		save.setOnAction(e ->{
			SaveSystem.saveSemester(semester);
		});
		fileMenu.getItems().add(save);
		MenuItem saveAs = new MenuItem("Save As..");
		saveAs.setOnAction(e -> {
			File file = saveAsFileChooser();
			if (file != null) {
				SaveSystem.saveSemester(semester, file.toString());
			} else {
				System.out.println("Can not save: User backed out of file chooser.");
			}
		});
		fileMenu.getItems().add(saveAs);
		MenuItem load = new MenuItem("Open");
		load.setOnAction(e ->{
			semester = SaveSystem.loadSemester();
			coursesScrollPane.setContent(semester.getCoursesGridPane());
			componentsTab.setContent(semester.getCourseComponentsByDateVBox());
		});
		fileMenu.getItems().add(load);
		MenuItem loadFrom = new MenuItem("Open from..");
		loadFrom.setOnAction(e -> {
			File file = fileChooser();
			if (file != null) {
				semester = SaveSystem.loadSemester(file.toString());
				coursesScrollPane.setContent(semester.getCoursesGridPane());
				componentsTab.setContent(semester.getCourseComponentsByDateVBox());
			} else {
				System.out.println("Can not open: file does not exist or user backed out of file chooser.");
			}
		});
		fileMenu.getItems().add(loadFrom);
		MenuItem newFile = new MenuItem("New");
		newFile.setOnAction(e -> {
			semester = new Semester();
			coursesScrollPane.setContent(semester.getCoursesGridPane());
			componentsTab.setContent(semester.getCourseComponentsByDateVBox());
		});
		fileMenu.getItems().add(newFile);
		MenuItem exit = new Menu("Exit");
		exit.setOnAction(e-> Platform.exit());
		fileMenu.getItems().add(exit);
		MenuItem cut= new MenuItem("Cut");
		editMenu.getItems().add(cut);
		MenuItem copy= new MenuItem("Copy");
		editMenu.getItems().add(copy);
		MenuItem paste= new MenuItem("Paste");
		editMenu.getItems().add(paste);

		menuBar.getMenus().addAll(fileMenu, editMenu);

		/*
		// This is copy (Ctrl C)
		StringSelection data = new StringSelection("This is copied to the clipboard");
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContent(data,data);

		// This is paste (Ctrl V)

		try {
			Transferable t = cb.getContent(null);
			if (t.isDataFlavorSupported(DataFlavor.stringFlavor))
				System.out.println(t.getTransferData(DataFlavor
						.stringFlavor));
		} catch (UnsupportedFlavorException | IOException ex) {
			System.out.println("");
		}
		*/

		return menuBar;
	}

	private GridPane addCoursePane(){
    	GridPane gridPane = new GridPane();

		TextField courseNameTextField = new TextField();
		courseNameTextField.setPromptText("Course Name");

		TextField courseCodeTextField = new TextField();
		courseCodeTextField.setPromptText("Course Code");

		HBox colourHBox = new HBox();

		final ToggleGroup radioButtonGroup = new ToggleGroup();
		RadioButton greyButton = new RadioButton("Grey");
		greyButton.setSelected(true);
		courseColour = "#d3d3d3";
		RadioButton redButton = new RadioButton("Red");
		RadioButton yellowButton = new RadioButton("Yellow");
		RadioButton greenButton = new RadioButton("Green");
		RadioButton blueButton = new RadioButton("Blue");
		RadioButton purpleButton = new RadioButton("Purple");

		greyButton.setToggleGroup(radioButtonGroup);
		redButton.setToggleGroup(radioButtonGroup);
		yellowButton.setToggleGroup(radioButtonGroup);
		greenButton.setToggleGroup(radioButtonGroup);
		blueButton.setToggleGroup(radioButtonGroup);
		purpleButton.setToggleGroup(radioButtonGroup);

		colourHBox.getChildren().add(greyButton);
		colourHBox.getChildren().add(redButton);
		colourHBox.getChildren().add(yellowButton);
		colourHBox.getChildren().add(greenButton);
		colourHBox.getChildren().add(blueButton);
		colourHBox.getChildren().add(purpleButton);

		greyButton.setOnAction(e -> {
			if (greyButton.isSelected()) {
				courseColour = "#d3d3d3";
			}
		});

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
			GridPane content = semester.getCoursesGridPane();

			addCourseToSemester(courseNameTextField.getText(), courseCodeTextField.getText(), courseColour);

			coursesScrollPane.setContent(semester.getCoursesGridPane());
			dateScrollPane.setContent(semester.getCourseComponentsByDateVBox());
			componentsTab.setContent(dateScrollPane);
			courseNameTextField.setText("");
			courseCodeTextField.setText("");

			greyButton.setSelected(true);
			courseColour = "#d3d3d3";
		});



		gridPane.add(courseNameTextField, 0, 0);
		gridPane.add(courseCodeTextField, 0, 1);
		//gridPane.add(addCourseComponentMenuButton, 0, 2);
		gridPane.add(colourHBox, 0, 3); // Add color choice
		gridPane.add(submitCourseButton, 0, 4);

		return gridPane;
	}

	private void addCourseToSemester(String courseName, String courseCode, String courseColour){
		Course course = new Course();
		course.setCourseName(courseName);
		course.setCourseCode(courseCode);
		course.setCourseColour(courseColour);
		semester.addCourse(course);
		System.out.println("Course added:");
		course.print();
	}

	private File fileChooser(){
    	Stage fileChooserStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Course Tracker File", ".ctf");
		fileChooser.getExtensionFilters().add(extensionFilter);
		fileChooser.setTitle("Choose File to Load");
		File file = fileChooser.showOpenDialog(fileChooserStage);
		return file;
	}

	private File saveAsFileChooser(){
    	Stage fileChooserStage = new Stage();
    	FileChooser fileChooser = new FileChooser();
    	FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Course Tracker File", ".ctf");
    	fileChooser.getExtensionFilters().add(extensionFilter);
    	fileChooser.setSelectedExtensionFilter(extensionFilter);
    	fileChooser.setTitle("Choose File to Save to");
    	File file = fileChooser.showSaveDialog(fileChooserStage);
    	return file;
	}

	private void updateUI(){
		coursesScrollPane.setContent(semester.getCoursesGridPane());
		componentsTab.setContent(semester.getCourseComponentsByDateVBox());
	}

    public static void main(String[] args) {
        launch(args);
    }
}


