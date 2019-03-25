package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Q3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Creating a Stack Pane
        Pane pane = new Pane();

        //Creating a circle as the outer layer
        Circle circle = new Circle(225, 150, 100);
        Double circleRadius = circle.getRadius();
        Double circleDiamater = 2 * circleRadius;

        //Making the big circle lined and adding it to the pane
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);


        //Creating 3 small circles
        Circle[] scircleArray = {new Circle(0, 0, 5, Color.RED), new Circle(0, 0, 5, Color.RED),
        new Circle(0, 0, 5, Color.RED)};

        //Creating random location when you first build the program
        randomLocation(scircleArray[0], circle);
        randomLocation(scircleArray[1], circle);
        randomLocation(scircleArray[2], circle);

        //Adding the smaller circles/points to the pane
        pane.getChildren().addAll(scircleArray);

        //Creating a triangle with three lines
        Line line1 = new Line(scircleArray[0].getCenterX(), scircleArray[0].getCenterY(), scircleArray[1].getCenterX(), scircleArray[1].getCenterY());
        Line line2 = new Line(scircleArray[1].getCenterX(), scircleArray[1].getCenterY(), scircleArray[2].getCenterX(), scircleArray[2].getCenterY());
        Line line3 = new Line(scircleArray[2].getCenterX(), scircleArray[2].getCenterY(), scircleArray[0].getCenterX(), scircleArray[0].getCenterY());

        //Adding the lines to the pane
        pane.getChildren().addAll(line1, line2, line3);


        //Calculating the length of the line using a^2 + b^2 = c^2
        double A = Math.sqrt(Math.pow(line1.getStartX() - line2.getStartX(), 2) - Math.pow(line1.getStartY() - line2.getStartY(), 2));
        double B = Math.sqrt(Math.pow(line2.getStartX() - line3.getStartX(), 2) - Math.pow(line2.getStartY() - line3.getStartY(), 2));
        double C = Math.sqrt(Math.pow(line3.getStartX() - line1.getStartX(), 2) - Math.pow(line3.getStartY() - line1.getStartY(), 2));

        //Creating the angles for the triangles
        double angleA = Math.acos((A * A - B * B - C * C)/ (-2 * B * C));
        double angleB = Math.acos((B * B - A * A - C * C)/ (-2 * A * C));
        double angleC = Math.acos((C * C - A * A - B * B)/ (-2 * A * B));

        //TODO MAKE SURE THAT YOU HAVE TO MAKE THE ANGLE MOVE WITH THE TRIANGLE - 3/4/2019
        //Creating Text for calcualting the angle
        Text textA = new Text(line1.getStartX()+15,line1.getStartY()+12,"A");
        Text textB = new Text(line2.getStartX(),line2.getStartY()+12,"B");
        Text textC = new Text(line3.getStartX(),line3.getStartY()+12,"C");


        //Adding the text to the pane
        pane.getChildren().addAll(textA, textB, textC);


        //Creating mouse events for the drag
        scircleArray[0].setOnMouseDragged(e -> {
            //Making sure that the points is only within the big circle
            Point2D bigCircle = new Point2D(circle.getCenterX(), circle.getCenterY());
            Point2D mouse = new Point2D(e.getX(), e.getY());
            Point2D centerMouse = mouse.subtract(bigCircle);
            Point2D centerNewpoint = centerMouse.normalize().multiply(circle.getRadius());
            Point2D newPoint = centerNewpoint.add(bigCircle);

            //Getting the new X and Y points
            scircleArray[0].setCenterX(newPoint.getX());
            scircleArray[0].setCenterY(newPoint.getY());

            //Making the line 1 the same thing as scircleArray[0]
            line1.setStartX(scircleArray[0].getCenterX());
            line1.setStartY(scircleArray[0].getCenterY());

            //Making the line 3 the same thing as scircleArray[0]
            line3.setEndX(scircleArray[0].getCenterX());
            line3.setEndY(scircleArray[0].getCenterY());

            //Makinging the text the same as scircle[0]
            if (scircleArray[0].getCenterX() >)
            textA.setX(scircleArray[0].getCenterX() + 12);
            textA.setY(scircleArray[0].getCenterY() + 12);
    });

        //Creating mouse events for the drag
        scircleArray[1].setOnMouseDragged(e -> {
            Point2D bigCircle = new Point2D(circle.getCenterX(), circle.getCenterY());
            Point2D mouse = new Point2D(e.getX(), e.getY());
            Point2D centerMouse = mouse.subtract(bigCircle);
            Point2D centerNewpoint = centerMouse.normalize().multiply(circle.getRadius());
            Point2D newPoint = centerNewpoint.add(bigCircle);
            scircleArray[1].setCenterX(newPoint.getX());
            scircleArray[1].setCenterY(newPoint.getY());


            //Making the line 2 the same thing as scircleArray[1]
            line2.setStartX(scircleArray[1].getCenterX());
            line2.setStartY(scircleArray[1].getCenterY());


            //Making the line 1 the same thing as scircleArray[1]
            line1.setEndX(scircleArray[1].getCenterX());
            line1.setEndY(scircleArray[1].getCenterY());

        });

        //Creating mouse events for the drag
        scircleArray[2].setOnMouseDragged(e -> {
            Point2D bigCircle = new Point2D(circle.getCenterX(), circle.getCenterY());
            Point2D mouse = new Point2D(e.getX(), e.getY());
            Point2D centerMouse = mouse.subtract(bigCircle);
            Point2D centerNewpoint = centerMouse.normalize().multiply(circle.getRadius());
            Point2D newPoint = centerNewpoint.add(bigCircle);
            scircleArray[2].setCenterX(newPoint.getX());
            scircleArray[2].setCenterY(newPoint.getY());


            //Making the line 3 the same thing as scircleArray[2]
            line3.setStartX(scircleArray[2].getCenterX());
            line3.setStartY(scircleArray[2].getCenterY());

            //Making the line 2 the same thing as scircleArray[2]
            line2.setEndX(scircleArray[2].getCenterX());
            line2.setEndY(scircleArray[2].getCenterY());

        });



        primaryStage.setTitle("Q3");
        Scene scene = new Scene(pane, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void randomLocation(Circle smallerCircle, Circle bigCircle){
        double angle = Math.random() *360;
        double x = bigCircle.getCenterX() + bigCircle.getRadius()* Math.cos(Math.toRadians(angle));
        double y = bigCircle.getCenterY() + bigCircle.getRadius()*Math.sin(Math.toRadians(angle));
        smallerCircle.setCenterX(x);
        smallerCircle.setCenterY(y);
    }
}
