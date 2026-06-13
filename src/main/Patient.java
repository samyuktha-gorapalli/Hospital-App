package test;

public class Patient extends Person {

	
	private static int starter = 100; 
	private boolean medication; 
	private int patientID; 
	private String contactNumber; 
	
	public Patient(boolean medication, String contactNumber, String name, int age, String gender) {
			super(name, age, gender); 
			this.medication = medication; 
			this.patientID = starter+1; 
			this.contactNumber = contactNumber; 
		}
	
	//DISPLAY PATIENT INFORMATION 
	
	public void displayPatientDetails() {
		System.out.println("Patient ID:" + patientID); 
		System.out.println("Name: " + getName());
		System.out.println("Age: " + getAge());
		System.out.println("Gender: " + getGender());
		System.out.println("Currently on medication?: " + medication);
		System.out.println("Contact Number: " + contactNumber);
		
	}
	
	//GETTERS 
	public boolean getMedication() {
		return medication; 
	}
	
	
	public int getPatientID() {
		return patientID; 
	}
	
	public String getContactNumber() {
		return contactNumber; 
	}


}
