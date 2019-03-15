package sample;

public class StudentRecord {
    private String ID;
    private double midterm;
    private double assignments;
    private double finalExam;



    public StudentRecord(String ID, double midterm, double assignments, double finalExam) {
        this.ID = ID;
        this.midterm = midterm;
        this.assignments = assignments;
        this.finalExam = finalExam;
    }


public String getID()
{
    return this.ID;
}

public double getMidterm()
{
    return this.midterm;
}

public double getAssignments()
{
    return this.assignments;
}

public double getFinalExam()
{
    return this.finalExam;
}


public double getFinalGrade()
{
    return 0.2*this.assignments + 0.3*this.midterm + 0.5*this.finalExam;
}

}

