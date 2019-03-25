package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class q2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String outputFile = "Exercise_02.dat";
        FileOutputStream outputStream = new FileOutputStream(outputFile,true);
        for(int i=0;i<100;i++)
        {
            outputStream.write((int) (Math.random() * ((100) + 1)));
        }

        outputStream.close();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
