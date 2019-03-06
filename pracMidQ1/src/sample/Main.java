package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);
        ImageView imageView1 = new ImageView("file:///C:/Users/JAGma/Desktop/Java/pracMidQ1/src/sample/uk.gif");
        ImageView imageView2 = new ImageView("file:///C:/Users/JAGma/Desktop/Java/pracMidQ1/src/sample/ca.gif");
        ImageView imageView3 = new ImageView("file:///C:/Users/JAGma/Desktop/Java/pracMidQ1/src/sample/china.gif");
        ImageView imageView4 = new ImageView("file:///C:/Users/JAGma/Desktop/Java/pracMidQ1/src/sample/us.gif");

        pane.add(imageView1,0,0);
        pane.add(imageView2,1,0);
        pane.add(imageView3,0,1);
        pane.add(imageView4,1,1);


        //Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Question 1");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
