package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {

    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };
    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        pane.setHgap(10);
        Rectangle[] arr1 = new Rectangle[8];
        Rectangle[] arr2 = new Rectangle[8];
        Color[] ColorArray = {Color.BLACK, Color.BLUE, Color.GREEN, Color.ORANGE, Color.GRAY, Color.CYAN, Color.YELLOW, Color.PURPLE};
        for(int i=0;i<8;i++)
        {
            Rectangle r = new Rectangle(0,0,20,avgHousingPricesByYear[i]/1000);
            Rectangle r2 = new Rectangle(0,0,20,avgCommercialPricesByYear[i]/1000);
            r.setStroke(Color.RED);
            r.setFill(Color.RED);
            r2.setStroke(Color.BLUE);
            r2.setFill(Color.BLUE);
            arr1[i] = r;
            arr2[i] = r2;

        }
        int count = 1;
        for(int j=0;j<8;j++)
        {
            pane.add(arr1[j],count,0);
            count++;
            pane.add(arr2[j],count,0);
            count++;
        }
        Arc[] arcArr = new Arc[6];

        arcArr[0] = new Arc(150, 150, 80, 80, 18, 7); // Create an arc
        arcArr[0].setFill(Color.RED); // Set fill color
        arcArr[0].setType(ArcType.ROUND); // Set arc type
        pane.add(arcArr[0],18,1); // Add arc to pane

        arcArr[1] = new Arc(150, 150, 80, 80, 26, 9); // Create an arc
        arcArr[1].setFill(Color.RED); // Set fill color
        arcArr[1].setType(ArcType.ROUND); // Set arc type
        pane.add(arcArr[1],18,1); // Add arc to pane



        Scene scene = new Scene(pane,800,800);
        primaryStage.setTitle("ControlRectangle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }


    public static void main(String[] args) {
        launch(args);
    }
}
