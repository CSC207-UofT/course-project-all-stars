package cli.hospital;

import database.hospitalDatabase.HospitalCloudInterface;
import database.hospitalDatabase.HospitalDatabaseCloud;
import hospital.Hospital;
import person.Doctor;
import person.Patient;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Discharge {

    private static Hospital hospital;

    public Discharge(Hospital hospital)  {
        Discharge.hospital = hospital;
    }

    public static void discharge() throws SQLException {

        ArrayList<Patient> admittedPatients = hospital.getPriorityTreatment().show_patientList();
        ArrayList<Patient> treatedPatients = new ArrayList<>();
        ArrayList<Integer> treated_patient_id = new ArrayList<>();
        HospitalCloudInterface database = new HospitalDatabaseCloud();

        // If no patients available to treat
        if(admittedPatients.size() < 1){

            System.out.println();
            System.out.println("No Patients Ready to be Discharged");
            System.out.println("1. Go Back");
            int choice;
            while (true) {
                Scanner option = new Scanner(System.in);
                System.out.println("Select your option:");
                try {
                    choice = option.nextInt();
                } catch (Exception e) {
                    choice = -1;
                }
                if ((choice != 1)) {
                    System.out.println("Invalid Input!");
                    System.out.println();
                } else
                    HospitalHomepage.home();
            }
        }

        // there are patients that can be treated

        System.out.println();
        System.out.println("Enter the ID of the patient you would like to discharge or press 0 to go back to the main" +
                "menu:");
        System.out.println();
        for (Patient p : admittedPatients) {
            Doctor doctor = p.getDoctor();
            doctor.treatPatient(p);
            treatedPatients.add(p);
            treated_patient_id.add(p.getId());
        }
        for (Patient p: treatedPatients){
            System.out.println("ID: "+p.getId()+" "+p.getName());
        }

        int choice;
        while (true) {
            Scanner option = new Scanner(System.in);
            System.out.println();
            try {
                choice = option.nextInt();
            } catch (Exception e) {
                choice = -1;
            }
            if(choice == 0){
                HospitalHomepage.home();
            }
            if (!treated_patient_id.contains(choice)) {
                System.out.println();
                System.out.println("Invalid ID. Please try again.");
            } else
                break;
        }

        hospital.getPriorityTreatment().delete_patient(hospital.dischargePatient(choice));
        database.deletePatient(hospital.getName(), choice);


        System.out.println();
        System.out.println("Patient Discharged");
        System.out.println();
        System.out.println("1. Go Home");
        while (true) {
            Scanner option2 = new Scanner(System.in);
            try {
                choice = option2.nextInt();
            } catch (Exception e) {
                choice = -1;
            }
            if ((choice != 1)) {
                System.out.println();
                System.out.println("Invalid Input!");
            }
            else
                HospitalHomepage.home();
        }
    }
}
