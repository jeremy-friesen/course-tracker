package sample;

import java.io.*;

public class SaveSystem {
	private static String defaultFilePath = "default.ctf";

	// save semester object to default file path
	public static void saveSemester(Semester semester){
		try {
			// sets all VBox's to null because the VBox class isn't Serializable
			for(int i = 0; i < semester.getCourses().size(); i++){
				semester.getCourses().get(i).resetCourseVBox();
			}
			FileOutputStream fileOut = new FileOutputStream(defaultFilePath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(semester);
			objectOut.close();
			System.out.println("The Semester object was successfully written to a file");
			// update all VBox's so they are no longer null
			for(int i = 0; i < semester.getCourses().size(); i++){
				semester.getCourses().get(i).updateVBox();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// save semester object to custom file path
	public static void saveSemester(Semester semester, String filePath){
		try {
			// sets all VBox's to null because the VBox class isn't Serializable
			for(int i = 0; i < semester.getCourses().size(); i++){
				semester.getCourses().get(i).resetCourseVBox();
			}
			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(semester);
			objectOut.close();
			System.out.println("The Semester object was successfully written to a file");
			// update all VBox's so they are no longer null
			for(int i = 0; i < semester.getCourses().size(); i++){
				semester.getCourses().get(i).updateVBox();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// load semester object from default file path
	public static Semester loadSemester(){
		Semester semester = new Semester();
		try {
			File file = new File(defaultFilePath);
			if(!file.exists()){
				System.out.println("Error: file does not exist");
			}
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
