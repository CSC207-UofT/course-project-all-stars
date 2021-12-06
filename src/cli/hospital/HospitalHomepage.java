package cli.hospital;



import cli.home.Homepage;
import priority.Priority;
import priority.PriorityAdmission;
import priority.PriorityTreatment;
import hospital.DoctorsFactory;
import hospital.Hospital;
import hospital.PatientsFactory;
import person.Doctor;
import person.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class HospitalHomepage {

    public static Hospital selected_hospital;
    public static Priority admission;
    public static Priority treatment;
    public static ArrayList<Patient> patients = new ArrayList<Patient>();
    public static ArrayList<Doctor> doctors = new ArrayList<Doctor>();

    public HospitalHomepage(String hospital_name) throws SQLException {

        /**
         * Initializing a hospital from the database
         */

        // Initialize Patients
        patients = PatientsFactory.loadPatients(hospital_name);

        // Initialize Doctors
        doctors = DoctorsFactory.loadDoctors(hospital_name);

        // Initialize Hospital
        admission = new PriorityAdmission();
        treatment = new PriorityTreatment();
        selected_hospital = new Hospital(patients, doctors, patients.size(), admission,
                treatment, hospital_name, 2021);

        home();

    }

    public static void home() throws SQLException {

        int choice;

        System.out.println();
        System.out.println("Welcome Doctor! " + selected_hospital.getName() +
                " Hospital selected. Please choose one of the " +
                "following menu options to proceed:");
        System.out.println();
        System.out.println("1. Treat Patient");
        System.out.println("2. Discharge Patient");
        System.out.println("3. Add Patient");
        System.out.println("4. Add Doctor");
        System.out.println("5. View Patient Details");
        System.out.println("6. View Hospital Details");
        System.out.println("7. Go Back To Main Menu");
        System.out.println("8. Quit");
        System.out.println();

        while (true) {
            Scanner option = new Scanner(System.in);
            choice = option.nextInt();
            if ((choice > 8 || choice < 1)) {
                System.out.println("Invalid Input!");
            } else
                break;
        }

        if (choice == 1){
            Treat menu = new Treat(selected_hospital);
            menu.treat();
            home();
        }
        else if (choice == 2){
            Discharge menu = new Discharge(selected_hospital);
            menu.discharge();
            home();
        }
        else if (choice == 3){
            // Add Patient
        }
        else if (choice == 4){
            // Add Doctor
        }
        else if (choice == 5){
            // Patient Details
        }
        else if (choice == 6){
            // Hospital Details
        }
        else if (choice == 7){
            new Homepage();
        }
        else {
            System.out.println();
            System.out.println("Thank you for using Hospital Management System by All Stars");
            System.exit(0);
        }
    }
}
