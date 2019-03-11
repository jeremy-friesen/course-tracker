package sample;

public class Evaluation {
	private double markWeight;
	private boolean isComplete = false;
	private double mark;
	private String name;

	// Constructors
	public Evaluation(double markWeight){
		this.markWeight = markWeight;
	}

	public Evaluation(double markWeight, boolean isComplete){
		this.markWeight = markWeight;
		this.isComplete = isComplete;
	}

	public Evaluation(){}

	// getters
	public double getMarkWeight() {
		return markWeight;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public double getMark() {
		return mark;
	}

	public String getName() { return name;	}

	// setters
	public void setMarkWeight(double markWeight){
		this.markWeight = markWeight;
	}

	public void setComplete(boolean complete) {
		isComplete = complete;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public void setName(String name) { this.name = name; }

	// print method
	public void print() {
		System.out.println("super method");
	}
}
