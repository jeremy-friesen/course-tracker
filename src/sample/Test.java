package sample;

import java.time.LocalDate;

public class Test extends CourseComponent {
	private LocalDate date;

	// Constructors
	public Test(){
		super(10.0);
		this.date = LocalDate.now();
		super.setName("Test");
	}

	public Test(double markWeight){
		super(markWeight);
		this.date = LocalDate.now();
		super.setName("Test");
	}

	public Test(double markWeight, LocalDate date){
		super(markWeight);
		this.date = date;
		super.setName("Test");
	}

	public Test(double markWeight, LocalDate date, String name){
		super(markWeight);
		this.date = date;
		super.setName(name);
	}

	// date get & set methods
	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	// print method
	public void print(){
		System.out.println("Test " + getName() + ":");
		System.out.println("\t" + "Test Date: " + date.toString());
		System.out.println("\t" + "Mark Weight: " + getMarkWeight() + "%");
		System.out.println("\t" + "Mark: " + getMark() + "%");
	}
}
