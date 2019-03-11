package sample;

import java.time.LocalDate;

public class Assignment extends Evaluation {
	private LocalDate dueDate;

	// Constructors
	public Assignment(){
		super(10.0);
		this.dueDate = LocalDate.now();
		super.setName("Assignment");
	}

	public Assignment(double markWeight){
		super(markWeight);
		this.dueDate = LocalDate.now();
		super.setName("Assignment");
	}

	public Assignment(double markWeight, LocalDate dueDate){
		super(markWeight);
		this.dueDate = dueDate;
		super.setName("Assignment");
	}

	public Assignment(double markWeight, LocalDate dueDate, String name){
		super(markWeight);
		this.dueDate = dueDate;
		super.setName(name);
	}

	// date get & set methods
	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate duDate) {
		this.dueDate = dueDate;
	}

	// print method
	public void print(){
		System.out.println("Assignment " + getName() + ":");
		System.out.println("\t" + "Due Date: " + dueDate.toString());
		System.out.println("\t" + "Mark Weight: " + getMarkWeight() + "%");
		System.out.print("\t" + "Mark: " + getMark() + "%");
	}
}
