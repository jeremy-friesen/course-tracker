package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private TableView<StudentRecord> student;

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage ps) {
        ps.setTitle("Lab05 Student Records");

        BorderPane bp = new BorderPane();

        TableColumn<StudentRecord, String> ic = new TableColumn<>("SID");
        ic.setPrefWidth(100);
        ic.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<StudentRecord, String> ac = new TableColumn<>("Assignments");
        ac.setPrefWidth(100);
        ac.setCellValueFactory(new PropertyValueFactory<>("assignments"));

        TableColumn<StudentRecord, String> mc = new TableColumn<>("Midterm");
        mc.setPrefWidth(100);
        mc.setCellValueFactory( new PropertyValueFactory<>("midterm"));

        TableColumn<StudentRecord, String> fe = new TableColumn<>("Final Exam");
        fe.setPrefWidth(100);
        fe.setCellValueFactory( new PropertyValueFactory<>("finalExam"));

        TableColumn<StudentRecord, String> fg = new TableColumn<>("Final Grade");
        fg.setPrefWidth(100);
        fg.setCellValueFactory( new PropertyValueFactory<>("finalGrade"));


        this.student = new TableView<>();
        this.student.getColumns().add(ic);
        this.student.getColumns().add(ac);
        this.student.getColumns().add(mc);
        this.student.getColumns().add(fe);
        this.student.getColumns().add(fg);

        bp.setCenter(this.student);

        Scene scene = new Scene(bp, 500, 300);
        ps.setScene(scene);
        ps.show();
        this.student.setItems(DataSource.getAllMarks());
        //this.student.setItems(StudentRecord.getfinalGrade());
    }
}