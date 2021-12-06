package cli.hospital;

import hospital.Hospital;
import person.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientDetails {

    private static Hospital hospital;
    public PatientDetails(Hospital hospital){
        PatientDetails.hospital = hospital;
    }

    public static void patientDetails() throws SQLException {

        ArrayList<Integer> patients = new ArrayList<Integer>();
        Patient selectedPatient = null;

        for(Patient patient: hospital.getPatientsList()){
            patients.add(patient.getId());
        }

        System.out.println();
        System.out.println("Enter the Patient ID to get the Patient Details");
        // User Input
        int choice;
        while (true) {
            Scanner option = new Scanner(System.in);
            System.out.println();
            choice = option.nextInt();
            if (!patients.contains(choice)) {
                System.out.println("Invalid ID or Patient by this ID Doesn't Exist. Try Creating a new " +
                        "patient instead. Please try again.");
            } else
                break;
        }

        for(Patient p: hospital.getPatientsList()){
            if(p.getId() == choice){
                selectedPatient = p;
            }
        }

        System.out.println();
        assert selectedPatient != null;
        System.out.println("Patient Name: " + selectedPatient.getName());
        System.out.println("Id: " + selectedPatient.getId());
        System.out.println("Age: " + selectedPatient.getAge());
        System.out.println("Sex: " + selectedPatient.getSex());
        System.out.println("Address: " + selectedPatient.getAddress());
        System.out.println("Health XP: " + selectedPatient.getHealth());
        System.out.println("Symptoms: " + selectedPatient.getSymptoms());
        System.out.println("Diagnosis: " + selectedPatient.getDiagnose());
        System.out.println("Admission Status: " + selectedPatient.getIs_Admitted());
        System.out.println("Assigned Doctor: " + selectedPatient.getDoctor().getName());
        System.out.println();

        System.out.println("1. Check Another Patient");
        System.out.println("2. Go Back");

        //Checks for if the user entered a valid option
        while (true) {
            Scanner option = new Scanner(System.in);
            System.out.println();
            choice = option.nextInt();
            if ((choice > 2 || choice < 1)) {
                System.out.println("Invalid Choice. Please try again.");
            } else
                break;
        }

        // Option 1: Select Hospital
        if (choice == 1) {
            patientDetails();
        }
        else
            HospitalHomepage.home();
    }
}
