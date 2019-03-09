package sample;

import java.time.LocalDate;

public class Test extends Evaluation {
	private LocalDate date;

	// Constructor
	public Test(double markWeight, LocalDate date){
		super(markWeight);
		this.date = date;
	}

	// date get & set methods
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
