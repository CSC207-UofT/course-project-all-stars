package cli.hospital;

import diagnosis.Diagnosis;
import hospital.Hospital;
import person.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Treat {

    private static Hospital hospital;

    public Treat(Hospital hospital) {
        Treat.hospital = hospital;
    }


    public static void treat() throws SQLException {
        ArrayList<Patient> patients = hospital.getPatientsList();

        for (Patient p: patients){
            hospital.getPriorityAdmission().add_patient(p);
        }
        for (Patient top_patient: hospital.getPriorityAdmission().show_patientList()){
            System.out.println();
            System.out.println("Patient Details:");
            System.out.println();
            System.out.println(top_patient.getName() + "\n" +"Patient is " + top_patient.getSex() +" of age "+
                    top_patient.getAge());
            System.out.println("They are experiencing the following symptoms: " + top_patient.getSymptoms());
            System.out.println();
            System.out.println("1. Diagnose");
            System.out.println("2. Skip to the next patient");
            System.out.println("3. Go Back");
            System.out.println();

            int choice;
            while(true){
                Scanner option = new Scanner(System.in);
                try {
                    choice = option.nextInt();
                } catch (Exception e) {
                    choice = -1;
                }
                if((choice > 3 || choice < 1)){
                    System.out.println("Invalid Input!");
                }
                else
                    break;
            }
            if(choice == 1){
                Diagnosis.diagnose_patient(top_patient);
                System.out.println();
                System.out.println("The Patient has " + top_patient.getDiagnose());
                System.out.println();
                System.out.println("1. Admit and Treat");
                System.out.println("2. Send them Home");
                System.out.println();
                int choice2;
                while(true){
                    Scanner option = new Scanner(System.in);
                    try {
                        choice2 = option.nextInt();
                    } catch (Exception e) {
                        choice2 = -1;
                    }
                    if((choice2 > 2 || choice2 < 1)){
                        System.out.println("Invalid Input!");
                    }
                    else
                        break;
                }
                if(choice2 == 1){
                    System.out.println();
                    String status = hospital.admitPatient(top_patient);
                    System.out.println(status);
                    System.out.println();
                    if(top_patient.getIs_Admitted()){
                        hospital.getPriorityTreatment().add_patient(top_patient);
                        hospital.getPriorityAdmission().delete_patient(top_patient);
                    }
                    System.out.println("1. Next Patient");
                    System.out.println("2. Go Home");
                    System.out.println();
                    int choice4;
                    while(true){
                        Scanner option = new Scanner(System.in);
                        try {
                            choice4 = option.nextInt();
                        } catch (Exception e) {
                            choice4 = -1;
                        }
                        if((choice4 > 2 || choice4 < 1)){
                            System.out.println("Invalid Input!");
                            System.out.println();
                        }
                        else
                            break;
                    }
                    if(choice4 == 1){
                        treat();
                    }
                    else {
                        break;
                    }

                }
                else {
                    System.out.println();
                    System.out.println("Patient Sent Home");
                    hospital.getPriorityAdmission().delete_patient(top_patient);
                    System.out.println("1. Next Patient");
                    System.out.println("2. Go Home");
                    System.out.println();
                    int choice3;
                    while(true){
                        Scanner option = new Scanner(System.in);
                        try {
                            choice3 = option.nextInt();
                        } catch (Exception e) {
                            choice3 = -3;
                        }
                        if((choice3 > 2 || choice3 < 1)){
                            System.out.println();
                            System.out.println("Invalid Input!");
                        }
                        else
                            break;
                    }
                    if(choice3 == 1){
                        treat();
                    }
                    else {
                        break;
                    }
                }
            }
            else if(choice == 2){
                continue;
            }
            else{
                break;
            }
        }

        HospitalHomepage.home();
    }
}
