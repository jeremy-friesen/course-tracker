package sample;

public class Evaluation {
	private double markWeight;
	private boolean isComplete = false;
	private double mark;

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
}
