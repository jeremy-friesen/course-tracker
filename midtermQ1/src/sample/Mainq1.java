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
        ImageView imageView1 = new ImageView("file:///C:/Users/JAGma/Desktop/Java/midtermQ1/src/sample/x.gif");
        ImageView imageView2 = new ImageView("file:///C:/Users/JAGma/Desktop/Java/midtermQ1/src/sample/o.gif");
        double rand = 0;

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                rand = Math.random()*3;
                if(rand<1)
                {
                    pane.add(imageView1,j,i); //Does not run because I cannot place same image on pane again. I would figure it out with more time
                }
                else if(rand>1 && rand<2)
                {
                    pane.add(imageView2,j,i);
                }

            }
        }


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