package test; 
import java.util.ArrayList;

public class Doctor {

    private int doctorID;
    private String name;
    private String specialization;
    private ArrayList<String> availableSlots;

    private static int starter = 101;

    public Doctor(String name, String specialization) {
        this.doctorID = starter++;
        this.name = name;
        this.specialization = specialization;
        this.availableSlots = new ArrayList<>();
    }

    public int getDoctorID() {
        return doctorID;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<String> getAvailableSlots() {
        return availableSlots;
    }

    public void addTimeSlot(String slot) {
        availableSlots.add(slot);
    }

    public void removeTimeSlot(String slot) {
        availableSlots.remove(slot);
    }

    public void displayDoctorDetails() {
        System.out.println("ID: " + doctorID +
                " | Dr. " + name +
                " | " + specialization);
        System.out.println("Available Slots: " + availableSlots);
        System.out.println("-----------------------------------");
    }
}