package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;



public class q3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create File with Integers
        DataOutputStream output= new DataOutputStream(new FileOutputStream("Exercise_03.dat"));
        for(int i=0;i<10;i++){
            output.writeInt(i);

        }
        output.close();

        //Sum them
        DataInputStream input= new DataInputStream(new FileInputStream("Exercise_03.dat"));
        int sum=0;
        while(input.available()>0){
            sum += input.readInt();
        }
        System.out.println(sum);
        input.close();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
