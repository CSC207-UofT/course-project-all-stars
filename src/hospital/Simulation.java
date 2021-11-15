package hospital;
import Priority.PriorityAdmission;
import Priority.PriorityTreatment;
import database.PatientDatabaseCloud;
import diagnosis.Diagnosis;
import person.Patient;
import person.PatientArrayList;

import java.lang.reflect.InvocationTargetException;
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

    public static void main(String args[]) throws SQLException, InvocationTargetException, IllegalAccessException {
        home();
    }

    public static void home() throws SQLException, InvocationTargetException, IllegalAccessException {
        int choice;
        System.out.println("Welcome Doctor!" + "\n" + "Select one of the following menu options:");
        System.out.println("1. Treat Patient");
        System.out.println("2. Discharge Patient");
        System.out.println("3. View Patient Details");
        System.out.println("4. View Hospital Details");
        System.out.println("5. Add Patient");
        System.out.println("6. Quit");
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
            Add_Patient();
        }
        else if(choice == 6){
            System.out.println("Thanks for using HMS by All Stars Inc");
            System.exit(0);
        }
    }

    public static void treat() throws SQLException, InvocationTargetException, IllegalAccessException {
        for(Patient p: patients){
            priority.add_patient(p);
        }
        for (Patient top_patient: priority.show_patientList()){
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
                    priorityTreatment.add_patient(top_patient);
                    priority.delete_patient(top_patient);
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
                    priority.delete_patient(top_patient);
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

    public static void discharge() throws SQLException, InvocationTargetException, IllegalAccessException {
        System.out.println("Select a Patient to Discharge:");
        for (Patient p : priorityTreatment.show_patientList()) {
            if (priorityTreatment.show_patientList().size() >= 1) {
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
                        priorityTreatment.delete_patient(p);
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

    public static void patient_details() throws SQLException, InvocationTargetException, IllegalAccessException {
        System.out.println("Coming Soon in Phase 2");
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

    public static void Hospital_details() throws SQLException, InvocationTargetException, IllegalAccessException {
        System.out.println("Coming Soon in Phase 2");
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

    public static void Add_Patient(){
        PatientDatabaseCloud database = new PatientDatabaseCloud();
        final String Name, Address, Sex, symptom_1, symptom_2, symptom_3;
        final int age, health;
        final boolean insurance;
        Scanner option = new Scanner(System.in);
        System.out.println("Enter Name:");
        Name = option.nextLine();
        System.out.println("Enter Address:");
        Address = option.nextLine();
        System.out.println("Enter Sex:");
        Sex = option.nextLine();
        System.out.println("Enter Age:");
        age = option.nextInt();
        System.out.println("Enter Health:");
        health = option.nextInt();
        System.out.println("Does the Patient have Insurance(y/n):");
        String select = option.next();
        insurance = select.equals("y");
        System.out.println("Enter Symptom 1:");
        symptom_1 = option.nextLine();
        System.out.println("Enter Symptom 2:");
        symptom_2 = option.nextLine();
        System.out.println("Enter Symptom 3:");
        symptom_3 = option.nextLine();
        database.writeData(Name, Address, Sex, age, health, insurance, symptom_1, symptom_2, symptom_3);

        }

    }

