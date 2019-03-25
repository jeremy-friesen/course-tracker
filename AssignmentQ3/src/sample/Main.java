
package sample;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Creating a Stack Pane
        Pane pane = new Pane();

        //Creating circle as outside layer
        Circle circle = new Circle(225, 150, 100);
        Double circleRadius = circle.getRadius();
        Double circleDiamater = 2 * circleRadius;

        //Making large circle and adding it to pane
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);


        //Creating 3 small circles
        Circle[] scircArr = {new Circle(0, 0, 5, Color.RED), new Circle(0, 0, 5, Color.RED),
                new Circle(0, 0, 5, Color.RED)};

        //Creating random start points
        randomStart(scircArr[0], circle);
        randomStart(scircArr[1], circle);
        randomStart(scircArr[2], circle);

        //Adding the smaller circles/points to the pane
        pane.getChildren().addAll(scircArr);

        //Creating a triangle
        Line line1 = new Line(scircArr[0].getCenterX(), scircArr[0].getCenterY(), scircArr[1].getCenterX(), scircArr[1].getCenterY());
        Line line2 = new Line(scircArr[1].getCenterX(), scircArr[1].getCenterY(), scircArr[2].getCenterX(), scircArr[2].getCenterY());
        Line line3 = new Line(scircArr[2].getCenterX(), scircArr[2].getCenterY(), scircArr[0].getCenterX(), scircArr[0].getCenterY());

        //Adding lines to pane
        pane.getChildren().addAll(line1, line2, line3);


        //Calculate length of line using pythag theo
        double A = Math.sqrt(Math.pow(line1.getStartX() - line2.getStartX(), 2) - Math.pow(line1.getStartY() - line2.getStartY(), 2));
        double B = Math.sqrt(Math.pow(line2.getStartX() - line3.getStartX(), 2) - Math.pow(line2.getStartY() - line3.getStartY(), 2));
        double C = Math.sqrt(Math.pow(line3.getStartX() - line1.getStartX(), 2) - Math.pow(line3.getStartY() - line1.getStartY(), 2));

        // Compute angles
        double startA = new Point2D(scircArr[2].getCenterX(), scircArr[2].getCenterY()).
                distance(scircArr[1].getCenterX(), scircArr[1].getCenterY());
        double startB = new Point2D(scircArr[2].getCenterX(), scircArr[2].getCenterY()).
                distance(scircArr[0].getCenterX(), scircArr[0].getCenterY());
        double startC = new Point2D(scircArr[1].getCenterX(), scircArr[1].getCenterY()).
                distance(scircArr[0].getCenterX(), scircArr[0].getCenterY());
        double[] angles = new double[3];
        angles[0] = Math.acos((startA * startA - startB * startB - startC * startC) / (-2 * startB * startC));
        angles[1] = Math.acos((startB * startB - startA * startA - startC * startC) / (-2 * startA * startC));
        angles[2] = Math.acos((startC * startC - startB * startB - startA * startA) / (-2 * startA * startB));

        Text[] text = {new Text(), new Text(), new Text()};
        text[0] = new Text(line1.getStartX(), line1.getStartY(), angles[0] + "");
        text[1] = new Text(line2.getStartX(), line2.getStartY(), angles[1] + "");
        text[2] = new Text(line3.getStartX(), line3.getStartY(), angles[2] + "");

        for (int i = 0; i < 3; i++) {
            text[i].setX(scircArr[i].getCenterX());
            text[i].setY(scircArr[i].getCenterY() - 5);
            text[i].setText(String.format("%.2f", Math.toDegrees(angles[i])));
        }
        pane.getChildren().addAll(text[0], text[1], text[2]);


        //Creating mouse events for the drag
        scircArr[0].setOnMouseDragged(e -> {
            //Making sure that the points is only within the big circle
            Point2D bigCircle = new Point2D(circle.getCenterX(), circle.getCenterY());
            Point2D mouse = new Point2D(e.getX(), e.getY());
            Point2D centerMouse = mouse.subtract(bigCircle);
            Point2D centerNewpoint = centerMouse.normalize().multiply(circle.getRadius());
            Point2D newPoint = centerNewpoint.add(bigCircle);

            //Getting the new X and Y points
            scircArr[0].setCenterX(newPoint.getX());
            scircArr[0].setCenterY(newPoint.getY());

            //Making the line 1 the same thing as scircleArray[0]
            line1.setStartX(scircArr[0].getCenterX());
            line1.setStartY(scircArr[0].getCenterY());

            //Making the line 3 the same thing as scircleArray[0]
            line3.setEndX(scircArr[0].getCenterX());
            line3.setEndY(scircArr[0].getCenterY());

            // Compute angles
            double a = new Point2D(scircArr[2].getCenterX(), scircArr[2].getCenterY()).
                    distance(scircArr[1].getCenterX(), scircArr[1].getCenterY());
            double b = new Point2D(scircArr[2].getCenterX(), scircArr[2].getCenterY()).
                    distance(scircArr[0].getCenterX(), scircArr[0].getCenterY());
            double c = new Point2D(scircArr[1].getCenterX(), scircArr[1].getCenterY()).
                    distance(scircArr[0].getCenterX(), scircArr[0].getCenterY());
            double[] angle = new double[3];
            angle[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
            angle[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
            angle[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

            for (int i = 0; i < 3; i++) {
                text[i].setX(scircArr[i].getCenterX());
                text[i].setY(scircArr[i].getCenterY() - 5);
                text[i].setText(String.format("%.2f", Math.toDegrees(angle[i])));
            }




        });

        //Creating mouse events for the drag
        scircArr[1].setOnMouseDragged(e -> {
            Point2D bigCircle = new Point2D(circle.getCenterX(), circle.getCenterY());
            Point2D mouse = new Point2D(e.getX(), e.getY());
            Point2D centerMouse = mouse.subtract(bigCircle);
            Point2D centerNewpoint = centerMouse.normalize().multiply(circle.getRadius());
            Point2D newPoint = centerNewpoint.add(bigCircle);
            scircArr[1].setCenterX(newPoint.getX());
            scircArr[1].setCenterY(newPoint.getY());


            //Making the line 2 the same thing as scircleArray[1]
            line2.setStartX(scircArr[1].getCenterX());
            line2.setStartY(scircArr[1].getCenterY());


            //Making the line 1 the same thing as scircleArray[1]
            line1.setEndX(scircArr[1].getCenterX());
            line1.setEndY(scircArr[1].getCenterY());

            // Compute angles
            double a = new Point2D(scircArr[2].getCenterX(), scircArr[2].getCenterY()).
                    distance(scircArr[1].getCenterX(), scircArr[1].getCenterY());
            double b = new Point2D(scircArr[2].getCenterX(), scircArr[2].getCenterY()).
                    distance(scircArr[0].getCenterX(), scircArr[0].getCenterY());
            double c = new Point2D(scircArr[1].getCenterX(), scircArr[1].getCenterY()).
                    distance(scircArr[0].getCenterX(), scircArr[0].getCenterY());
            double[] angle = new double[3];
            angle[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
            angle[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
            angle[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

            for (int i = 0; i < 3; i++) {
                text[i].setX(scircArr[i].getCenterX());
                text[i].setY(scircArr[i].getCenterY() - 5);
                text[i].setText(String.format("%.2f", Math.toDegrees(angle[i])));
            }

        });

        //Creating mouse events for the drag
        scircArr[2].setOnMouseDragged(e -> {
            Point2D bigCircle = new Point2D(circle.getCenterX(), circle.getCenterY());
            Point2D mouse = new Point2D(e.getX(), e.getY());
            Point2D centerMouse = mouse.subtract(bigCircle);
            Point2D centerNewpoint = centerMouse.normalize().multiply(circle.getRadius());
            Point2D newPoint = centerNewpoint.add(bigCircle);
            scircArr[2].setCenterX(newPoint.getX());
            scircArr[2].setCenterY(newPoint.getY());


            //Making the line 3 the same thing as scircleArray[2]
            line3.setStartX(scircArr[2].getCenterX());
            line3.setStartY(scircArr[2].getCenterY());

            //Making the line 2 the same thing as scircleArray[2]
            line2.setEndX(scircArr[2].getCenterX());
            line2.setEndY(scircArr[2].getCenterY());
            /*
            line1.setStartX(scircArr[0].getCenterX());
            line1.setStartY(scircArr[0].getCenterY());
            line1.setEndX(scircArr[1].getCenterX());
            line1.setEndY(scircArr[1].getCenterY());
            line2.setStartX(scircArr[0].getCenterX());
            line2.setStartY(scircArr[0].getCenterY());
            line2.setEndX(scircArr[2].getCenterX());
            line2.setEndY(scircArr[2].getCenterY());
            line3.setStartX(scircArr[1].getCenterX());
            line3.setStartY(scircArr[1].getCenterY());
            line3.setEndX(scircArr[2].getCenterX());
            line3.setEndY(scircArr[2].getCenterY());
            */
            // Compute angles
            double a = new Point2D(scircArr[2].getCenterX(), scircArr[2].getCenterY()).
                    distance(scircArr[1].getCenterX(), scircArr[1].getCenterY());
            double b = new Point2D(scircArr[2].getCenterX(), scircArr[2].getCenterY()).
                    distance(scircArr[0].getCenterX(), scircArr[0].getCenterY());
            double c = new Point2D(scircArr[1].getCenterX(), scircArr[1].getCenterY()).
                    distance(scircArr[0].getCenterX(), scircArr[0].getCenterY());
            double[] angle = new double[3];
            angles[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
            angles[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
            angles[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

            for (int i = 0; i < 3; i++) {
                text[i].setX(scircArr[i].getCenterX());
                text[i].setY(scircArr[i].getCenterY() - 5);
                text[i].setText(String.format("%.2f", Math.toDegrees(angles[i])));
            }

        });


        primaryStage.setTitle("Question3");
        Scene scene = new Scene(pane, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }


    public void randomStart(Circle smallcirc, Circle largeCirc) {
        double angle = Math.random() * 360;
        double x = largeCirc.getCenterX() + largeCirc.getRadius() * Math.cos(Math.toRadians(angle));
        double y = largeCirc.getCenterY() + largeCirc.getRadius() * Math.sin(Math.toRadians(angle));
        smallcirc.setCenterX(x);
        smallcirc.setCenterY(y);
    }


}