package hospital;
import container.PriorityAdmission;
import container.PriorityTreatment;
import diagnosis.Diagnosis;
import person.Patient;
import person.PatientArrayList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public static ArrayList <Patient> patients;

    static {
        try {
            patients = PatientArrayList.constructPatient();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PriorityAdmission priority = new PriorityAdmission();
    public static PriorityTreatment priorityTreatment = new PriorityTreatment();

    public static void main(String args[]) throws SQLException {
        home();
    }

    public static void home() throws SQLException {
        int choice;
        System.out.println("Welcome Doctor!" + "\n" + "Select one of the following menu options:");
        System.out.println("1. Treat Patient");
        System.out.println("2. Discharge Patient");
        System.out.println("3. View Patient Details");
        System.out.println("4. View Hospital Details");
        System.out.println("5. Quit");
        while(true){
            Scanner option = new Scanner(System.in);
            System.out.println("Select your option:");
            choice = option.nextInt();
            if((choice > 5 || choice < 1)){
                System.out.println("Invalid Input!");
            }
            else
                break;
        }

        if(choice == 1){
            treat();
        }
        else if(choice == 2){
            discharge();
        }
        else if(choice == 3){
            patient_details();
        }
        else if(choice == 4){
            Hospital_details();
        }
        else if(choice == 5){
            System.out.println("Thanks for using HMS by All Stars Inc");
            System.exit(0);
        }
    }

    public static void treat() throws SQLException {
        for(Patient p: patients){
//            priority.add(p);
        }
        for (Patient top_patient: priority.show()){
            System.out.println("Patient Details:");
            System.out.println(top_patient.getName() + "\n" +"Patient is " +top_patient.getSex() +" of age "+ top_patient.getAge());
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
//                    priorityTreatment.add(top_patient);
                    priority.delete(top_patient);
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
                        treat();
                    }
                    else {
                        home();
                    }

                }
                else {
                    System.out.println("Patient Sent Home");
                    priority.delete(top_patient);
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
                        home();
                    }
                }
            }
            else if(choice == 2){
                continue;
            }
            else if(choice == 3){
                home();
            }
        }

    }

    public static void discharge() throws SQLException {
        System.out.println("Select a Patient to Discharge:");
        for (Patient p : priorityTreatment.show()) {
            if (priorityTreatment.show().size() >= 1) {
                System.out.println("1. " + p.getName());
                int choice;
                while (true) {
                    Scanner option = new Scanner(System.in);
                    System.out.println("Select your option:");
                    choice = option.nextInt();
                    if ((choice > 2 || choice < 1)) {
                        System.out.println("Invalid Input!");
                    } else {
                        p.setIs_admitted(false);
                        priorityTreatment.delete(p);
                        System.out.println("Patient Discharged");
                        System.out.println("1. Go Home");
                        int choice2;
                        while (true) {
                            Scanner option2 = new Scanner(System.in);
                            System.out.println("Select your option:");
                            choice = option.nextInt();
                            if ((choice != 1)) {
                                System.out.println("Invalid Input!");
                            } else
                                home();
                        }
                    }
                }
            } else {
                System.out.println("No Patients Ready to be Discharged");
                System.out.println("1. Go Back");
                int choice;
                while (true) {
                    Scanner option = new Scanner(System.in);
                    System.out.println("Select your option:");
                    choice = option.nextInt();
                    if ((choice != 1)) {
                        System.out.println("Invalid Input!");
                    } else
                        home();
                }

            }
        }
    }

    public static void patient_details() throws SQLException {
        System.out.println("Coming Soon in Phase 1");
        System.out.println("1. Go Back");
        int choice;
        while (true) {
            Scanner option = new Scanner(System.in);
            System.out.println("Select your option:");
            choice = option.nextInt();
            if ((choice != 1)) {
                System.out.println("Invalid Input!");
            } else
                home();
        }
    }

    public static void Hospital_details() throws SQLException {
        System.out.println("Coming Soon in Phase 1");
        System.out.println("1. Go Back");
        int choice;
        while (true) {
            Scanner option = new Scanner(System.in);
            System.out.println("Select your option:");
            choice = option.nextInt();
            if ((choice != 1)) {
                System.out.println("Invalid Input!");
            } else
                home();
        }
    }



}
