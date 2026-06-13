package test; 
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalApp {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {

        // ADDING DOCTORS
        Doctor d1 = new Doctor("Smith", "Cardiology"); //ARRAY WITH THE OBJECT DOCTOR
        d1.addTimeSlot("10AM");
        d1.addTimeSlot("11AM");
        d1.addTimeSlot("2PM");

        Doctor d2 = new Doctor("Brown", "Dermatology");
        d2.addTimeSlot("9AM");
        d2.addTimeSlot("1PM");
        d2.addTimeSlot("3PM");

        doctors.add(d1);
        doctors.add(d2);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
        	System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
        	System.out.println("1. Register Patient");
        	System.out.println("2. Add Doctor");
        	System.out.println("3. Book Appointment");
        	System.out.println("4. Cancel Appointment");
        	System.out.println("5. View Patients");
        	System.out.println("6. View Appointments");
        	System.out.println("7. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
            case 1:
                registerPatient();
                break;
            case 2:
                addDoctor();
                break;
            case 3:
                bookAppointment();
                break;
            case 4:
                cancelAppointment();
                break;
            case 5:
                viewPatients();
                break;
            case 6:
                viewAppointments();
                break;
            case 7:
                System.out.println("Exiting system...");
                break;
            default:
                System.out.println("Invalid choice.");
        }} while (choice != 7);

        sc.close();
    }

    public static void registerPatient() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        
        System.out.print("Enter Contact Number: ");
        String contactNumber = sc.nextLine();
        
        System.out.print("Is the patient on medication?(TRUE/FALSE): ");
        boolean isMedication = sc.nextBoolean(); 
        sc.nextLine();

        
        

        Patient newPatient = new Patient(isMedication, contactNumber, name, age, gender);
        patients.add(newPatient);

        System.out.println("\nPatient Registered Successfully!");
        newPatient.displayPatientDetails();
    }

    public static void bookAppointment() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        sc.nextLine();

        Patient selectedPatient = null;

        for (Patient p : patients) {
            if (p.getPatientID() == patientId) {
                selectedPatient = p;
                break;
            }
        }

        if (selectedPatient == null) {
            System.out.println("Invalid Patient ID.");
            return;
        }

        System.out.println("\nAvailable Doctors:");
        for (Doctor d : doctors) {
            d.displayDoctorDetails();
        }

        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();

        Doctor selectedDoctor = null;

        for (Doctor d : doctors) {
            if (d.getDoctorID() == doctorId) {
                selectedDoctor = d;
                break;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("Invalid Doctor ID.");
            return;
        }

        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Time Slot: ");
        String time = sc.nextLine();

        if (!selectedDoctor.getAvailableSlots().contains(time)) {
            System.out.println("Time slot not available.");
            return;
        }

        Appointment newAppointment =
                new Appointment(selectedPatient, selectedDoctor, date, time);

        appointments.add(newAppointment);
        selectedDoctor.removeTimeSlot(time);

        System.out.println("\nAppointment Booked Successfully!");
        newAppointment.displayAppointmentDetails();
    }

    public static void viewPatients() {
        for (Patient p : patients) {
            p.displayPatientDetails();
        }
    }
    
    //METHOD FOR ADDING DOCTORS
    public static void addDoctor() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        Doctor newDoctor = new Doctor(name, specialization);

        System.out.print("How many time slots to add? ");
        int numberOfSlots = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberOfSlots; i++) {
            System.out.print("Enter time slot " + (i + 1) + ": ");
            String slot = sc.nextLine();
            newDoctor.addTimeSlot(slot);
        }

        doctors.add(newDoctor);

        System.out.println("\nDoctor Added Successfully!");
        newDoctor.displayDoctorDetails();
    }
    
    //METHOD FOR CANCELING APPOINTMENTS
    public static void cancelAppointment() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Appointment ID to cancel: ");
        int id = sc.nextInt();

        Appointment appointmentToCancel = null;

        for (Appointment a : appointments) {
            if (a.getAppointmentId() == id) {
                appointmentToCancel = a;
                break;
            }	
        }

        if (appointmentToCancel == null) {
            System.out.println("Appointment not found.");
            return;
        }

        // Return slot back to doctor
        Doctor doctor = appointmentToCancel.getDoctor();
        doctor.addTimeSlot(appointmentToCancel.getTime());

        appointments.remove(appointmentToCancel);

        System.out.println("Appointment Cancelled Successfully!");
    }   
        //VIEW APPOINMENTS 
        public static void viewAppointments() {

            if (appointments.isEmpty()) {
                System.out.println("No appointments found.");
                return;
            }

            System.out.println("\n===== ALL APPOINTMENTS =====");

            for (Appointment a : appointments) {
                a.displayAppointmentDetails();
            }
    }
}