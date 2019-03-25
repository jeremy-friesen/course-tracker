package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();
        String line = null;
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("weatherwarnings-2015.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        int torCount = 0;
        int floodCount = 0;
        int thunCount = 0;
        int marineCount = 0;
        //ObservableList<PieChart.Data> pieChart = FXCollections.observableArrayList(FXCollections.observableArrayList();

        for(int i=0;i<records.size();i++)
        {
            for(int j=0;j<7;j++)
            {
                if(records.get(i).get(j).equals("TORNADO"))
                {
                    torCount++;
                }
                if(records.get(i).get(j).equals("SPECIAL MARINE"))
                {
                    marineCount++;
                }
                if(records.get(i).get(j).equals("SEVERE THUNDERSTORM"))
                {
                    thunCount++;
                }
                if(records.get(i).get(j).equals("FLASH FLOOD"))
                {
                    floodCount++;
                }
            }
        }
        System.out.println("XYEYEEYEYE" + floodCount + torCount + marineCount + thunCount);

        ObservableList<PieChart.Data> pieChart =
                FXCollections.observableArrayList(
                        new PieChart.Data("TORNADO", torCount),
                        new PieChart.Data("SPECIAL MARINE", marineCount),
                        new PieChart.Data("SEVERE THUNDERSTORM", thunCount),
                        new PieChart.Data("FLASH FLOOD", floodCount));
        final PieChart chart = new PieChart(pieChart);
        chart.setLegendSide(Side.LEFT);
        chart.setPrefSize(800, 800);
        pane.getChildren().addAll(chart);




        Scene scene = new Scene(pane);
        primaryStage.setTitle("Pie Chart"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }


    public static void main(String[] args) {
        launch(args);
    }
}
