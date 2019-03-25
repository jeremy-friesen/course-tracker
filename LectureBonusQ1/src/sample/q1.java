package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class q1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        File file = new File("Exercise_01.txt");
        FileWriter br =  new FileWriter(file, true);
        BufferedWriter bw =  new BufferedWriter(br);
        PrintWriter output = new PrintWriter(bw);
        for(int i=0;i<100;i++)
        {
            output.print((int) (Math.random() * ((100) + 1))+ " ");
        }

        output.close();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
