package cli.hospitalfunctions;

import diagnosis.Diagnosis;
import hospital.Hospital;
import person.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Treat {

    private static Hospital hospital;

    public Treat(Hospital hospital) {
        this.hospital = hospital;
    }


    public static void treat() throws SQLException {
        ArrayList<Patient> patients = hospital.getPatientsList();

        for (Patient p: patients){
            hospital.getPriorityTreatment().add_patient(p);
        }
            for (Patient top_patient: hospital.getPriorityTreatment().show_patientList()){
            System.out.println("Patient Details:");
            System.out.println(top_patient.getName() + "\n" +"Patient is " + top_patient.getSex() +" of age "+ top_patient.getAge());
            System.out.println("They are experiencing the following symptoms: " + top_patient.getSymptoms());
            System.out.println("1. Diagnose");
            System.out.println("2. Skip to the next patient");
            System.out.println("3. Go Back");

            int choice;
            while(true){
                Scanner option = new Scanner(System.in);
                System.out.println("Select your option:");
                choice = option.nextInt();
                if((choice > 3 || choice < 1)){
                    System.out.println("Invalid Input!");
                }
                else
                    break;
            }
            if(choice == 1){
                Diagnosis.diagnose_patient(top_patient);
                System.out.println("The Patient has " + top_patient.getDiagnose());
                System.out.println("1. Admit and Treat");
                System.out.println("2. Send them Home");
                int choice2;
                while(true){
                    Scanner option = new Scanner(System.in);
                    System.out.println("Select your option:");
                    choice2 = option.nextInt();
                    if((choice2 > 2 || choice2 < 1)){
                        System.out.println("Invalid Input!");
                    }
                    else
                        break;
                }
                if(choice2 == 1){
                    System.out.println("Patient Admitted");
                    hospital.getPriorityTreatment().add_patient(top_patient);
                    hospital.getPriorityTreatment().delete_patient(top_patient);
                    top_patient.setIs_admitted(true);
                    System.out.println("1. Next Patient");
                    System.out.println("2. Go Home");
                    int choice4;
                    while(true){
                        Scanner option = new Scanner(System.in);
                        System.out.println("Select your option:");
                        choice4 = option.nextInt();
                        if((choice4 > 2 || choice4 < 1)){
                            System.out.println("Invalid Input!");
                        }
                        else
                            break;
                    }
                    if(choice4 == 1){
                        top_patient.getDoctor().treatPatient(top_patient);
                    }
                    else {
                        break;
                    }

                }
                else {
                    System.out.println("Patient Sent Home");
                    hospital.getPriorityTreatment().delete_patient(top_patient);
                    System.out.println("1. Next Patient");
                    System.out.println("2. Go Home");
                    int choice3;
                    while(true){
                        Scanner option = new Scanner(System.in);
                        System.out.println("Select your option:");
                        choice3 = option.nextInt();
                        if((choice3 > 2 || choice3 < 1)){
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
    }
}
