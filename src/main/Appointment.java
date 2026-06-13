package test;

public class Appointment {
	
	private static int starter = 100; 
	private int appointmentId; 
	
	private Patient patient; 
	private Doctor doctor; 
	
	private String date; 
	private String time;; 
	
	// CONSTRUCTOR
    public Appointment(Patient patient, Doctor doctor, String date, String timeSlot) {

        this.appointmentId = starter+1;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }
      

    // DISPLAY METHOD
    public void displayAppointmentDetails() {
        System.out.println("Appointment ID: " + this.appointmentId);
        System.out.println("Patient: " + this.patient.getName());
        System.out.println("Doctor: " + this.doctor.getName());
        System.out.println("Specialization: " + this.doctor.getSpecialization());
        System.out.println("Date: " + this.date);
        System.out.println("Time: " + this.time);
        System.out.println("-----------------------------------");
    }

    // GETTERS 
    public int getAppointmentId() {
        return appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}