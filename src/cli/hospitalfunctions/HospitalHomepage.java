package cli.hospitalfunctions;



import Priority.PriorityAdmission;
import Priority.PriorityTreatment;
import hospital.DoctorsFactory;
import hospital.Hospital;
import hospital.PatientsFactory;
import person.Doctor;
import person.Patient;

import java.sql.SQLException;
import java.util.ArrayList;


public class HospitalHomepage {

    public HospitalHomepage(String hospital_name) throws SQLException {

        /**
         * Initializing a hospital from the database
         */

        // Initialize Patients
        ArrayList<Patient> patients = PatientsFactory.loadPatients(hospital_name);

        // Initialize Doctors
        ArrayList<Doctor> doctors = DoctorsFactory.loadDoctors(hospital_name);

        // Initialize Hospital
        PriorityAdmission admission = new PriorityAdmission();
        PriorityTreatment treatment = new PriorityTreatment();
        Hospital selected_hospital = new Hospital(patients, doctors, patients.size(), admission,
                treatment, hospital_name, 2021);

        // User input options
        int choice;
        System.out.println();
        System.out.println("Welcome Doctor! " + hospital_name + " Hospital selected. Please choose one of the " +
                "following menu options to proceed:");
        System.out.println();
        System.out.println("1. Treat Patient");
        System.out.println("2. Discharge Patient");
        System.out.println("3. View Patient Details");
        System.out.println("4. View Hospital Details");
        System.out.println("5. Add Patient");
        System.out.println("6. Quit");



    }
}
