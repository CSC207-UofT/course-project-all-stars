package cli;

import database.PatientDatabaseCloud;

import java.util.Scanner;

public class AddPatient {


    public AddPatient() {

    }

//    public static void main(String[] args) throws SQLException, InvocationTargetException, IllegalAccessException {
//        home();
//    }

    public static void addPatient(){
        PatientDatabaseCloud database = new PatientDatabaseCloud("test_hospital");
        final String Name, Address, Sex, symptom_1, symptom_2, symptom_3;
        final int id;
        final int age;
        final int health;
        final boolean insurance;
        Scanner option = new Scanner(System.in);
        System.out.println("Enter Name:");
        Name = option.nextLine();
        System.out.println("Enter Patient Id Number:");
        id = option.nextInt();
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
        database.writeData(id, Name, Address, Sex, age, health, insurance, symptom_1, symptom_2, symptom_3);
    }
}
