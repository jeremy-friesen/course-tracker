package sample;

import javafx.application.Application;

//import java.awt.event.ActionEvent;
import java.lang.*;

import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import javafx.scene.chart.BarChart;

import static java.lang.Character.toUpperCase;

public class Main extends Application {

    //@Override
    public void start(Stage primaryStage) throws Exception{
        String fileName = "chars.txt";
        makeHistogram(primaryStage, fileName);
    }
    public void makeHistogram( Stage primaryStage, String fileName) throws Exception
    {
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        hbox.setSpacing(5);
        vbox.setSpacing(5);

        char[] Characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int[] Frequency = new int[26];
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Character Frequency");
        xAxis.setLabel("Character");
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")));
        yAxis.setLabel("Frequency");

        TextField filePath = new TextField();
        Button btView = new Button("View");

        BufferedReader br = new BufferedReader(new FileReader("chars.txt"));
        if (fileName == "") {

        } else {
            br = new BufferedReader(new FileReader(fileName));
        }


        btView.setOnAction(e -> {
            String fileName2 = filePath.getText();
            makeReader(fileName2);
        });

        String st;
        while ((st = br.readLine()) != null) {
            for (int i = 0; i < st.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    if (toUpperCase(st.charAt(i)) == Characters[j]) {
                        Frequency[j]++;
                    }
                }
            }
        }
        //System.out.println((char)br.read());
/*
        for (int i = 0; i < 26; i++) {
            System.out.print(Frequency[i]);
        }
*/
        br.close();
        //Did not let me use a for loop with Characters[i] in for x Value. Forced to do each value one at a time.
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>("A", Frequency[0]));
        series1.getData().add(new XYChart.Data<>("B", Frequency[1]));
        series1.getData().add(new XYChart.Data<>("C", Frequency[2]));
        series1.getData().add(new XYChart.Data<>("D", Frequency[3]));
        series1.getData().add(new XYChart.Data<>("E", Frequency[4]));
        series1.getData().add(new XYChart.Data<>("F", Frequency[5]));
        series1.getData().add(new XYChart.Data<>("G", Frequency[6]));
        series1.getData().add(new XYChart.Data<>("H", Frequency[7]));
        series1.getData().add(new XYChart.Data<>("I", Frequency[8]));
        series1.getData().add(new XYChart.Data<>("J", Frequency[9]));
        series1.getData().add(new XYChart.Data<>("K", Frequency[10]));
        series1.getData().add(new XYChart.Data<>("L", Frequency[11]));
        series1.getData().add(new XYChart.Data<>("M", Frequency[12]));
        series1.getData().add(new XYChart.Data<>("N", Frequency[13]));
        series1.getData().add(new XYChart.Data<>("O", Frequency[14]));
        series1.getData().add(new XYChart.Data<>("P", Frequency[15]));
        series1.getData().add(new XYChart.Data<>("Q", Frequency[16]));
        series1.getData().add(new XYChart.Data<>("R", Frequency[17]));
        series1.getData().add(new XYChart.Data<>("S", Frequency[18]));
        series1.getData().add(new XYChart.Data<>("T", Frequency[19]));
        series1.getData().add(new XYChart.Data<>("U", Frequency[20]));
        series1.getData().add(new XYChart.Data<>("V", Frequency[21]));
        series1.getData().add(new XYChart.Data<>("W", Frequency[22]));
        series1.getData().add(new XYChart.Data<>("X", Frequency[23]));
        series1.getData().add(new XYChart.Data<>("Y", Frequency[24]));
        series1.getData().add(new XYChart.Data<>("Z", Frequency[25]));

        barChart.getData().addAll(series1);

        vbox.getChildren().add(barChart);
        hbox.getChildren().add(filePath);
        hbox.getChildren().add(btView);

        vbox.getChildren().add(hbox);
        Group root = new Group(vbox);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Histogram"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public void makeReader(String fileName)
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            try
            {
                Stage stage = new Stage();
                makeHistogram(stage,fileName);
            }
            catch(Exception e)
            {
                System.out.print("Error");
            }

        }
        catch(FileNotFoundException err) {
            System.out.println("ERROR - File not found");

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

