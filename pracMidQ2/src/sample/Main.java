package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.paint.Color;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        HBox pane = new HBox();
        pane.setAlignment(Pos.CENTER);

        Font font = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22);

        for(int i=0;i<5;i++)
        {
            Text txt = new Text("Java");
            txt.setRotate(90);
            txt.setFont(font);
            txt.setFill(new Color(Math.random(),Math.random(), Math.random(),Math.random()));
            pane.getChildren().add(txt);
        }



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
