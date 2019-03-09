package sample;

import java.util.ArrayList;

public class Course {
	private String courseCode;
	private ArrayList<Evaluation> evaluations = new ArrayList<Evaluation>();

	public Course(String courseCode){
		this.courseCode = courseCode;
	}

	// Evaluations get and add
	public ArrayList<Evaluation> getEvaluations(){
		return evaluations;
	}

	public void addEvaluation(Evaluation evaluation){
		evaluations.add(evaluations.size(), evaluation);
	}

	public void addEvaluations(ArrayList<Evaluation> evaluations){
		this.evaluations.addAll(evaluations);
	}

	// getters & setters
	public String getCourseCode(){
		return courseCode;
	}

	public void setCourseCode(String courseCode){
		this.courseCode = courseCode;
	}
}
