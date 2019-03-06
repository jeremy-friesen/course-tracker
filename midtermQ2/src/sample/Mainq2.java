package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.WHITE;
//Not enough Time
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Pane pane = new Pane();

        Line upLine = new Line(20, 200, 20, 40);
        Line rightLine = new Line(20, 40, 100, 40);
        Line downLine = new Line(100, 40, 100, 90);
        Circle head = new Circle(100,110,20);
        Line downLine2 = new Line(100, 130, 100, 170);
        Line diagLine1 = new Line(100, 170, 70, 200);
        Line diagLine2 = new Line(100, 170, 130, 200);
        Line diagLine3 = new Line(100, 170, 70, 200);
        Line diagLine4 = new Line(100, 170, 130, 200);


        pane.getChildren().addAll(upLine,rightLine,downLine,head,downLine2,diagLine1,diagLine2,diagLine3,diagLine4);


        //Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Question 2");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
