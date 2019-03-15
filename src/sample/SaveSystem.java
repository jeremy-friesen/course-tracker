package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveSystem {
	private static String defaultFilePath = "default.sem";

	// save semester object to default file path
	public static void saveSemester(Semester semester){
		try {
			FileOutputStream fileOut = new FileOutputStream(defaultFilePath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(semester);
			objectOut.close();
			System.out.println("The Semester object was successfully written to a file");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// save semester object to custom file path
	public static void saveSemester(Semester semester, String filePath){
		try {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(semester);
			objectOut.close();
			System.out.println("The Semester object was successfully written to a file");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// load semester object from default file path
	public static Semester loadSemester(){
		Semester semester = new Semester();
		try {
			FileInputStream fileIn = new FileInputStream(defaultFilePath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			Object object = objectIn.readObject();
			objectIn.close();
			semester = (Semester)object;
			System.out.println("The Semester object was successfully read from a file");
			semester.print();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return semester;
	}

	// load semester object from default custom path
	public static Semester loadSemester(String filePath){
		Semester semester = new Semester();
		try {
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			Object object = objectIn.readObject();
			objectIn.close();
			semester = (Semester)object;
			System.out.println("The Semester object was successfully read from a file");
			semester.print();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return semester;
	}
}
