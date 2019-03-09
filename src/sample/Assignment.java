package sample;

import java.time.LocalDate;

public class Assignment extends Evaluation {
	private LocalDate dueDate;

	// Constructor
	public Assignment(double markWeight, LocalDate dueDate){
		super(markWeight);
		this.dueDate = dueDate;
	}

	// date get & set methods
	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate duDate) {
		this.dueDate = dueDate;
	}
}
