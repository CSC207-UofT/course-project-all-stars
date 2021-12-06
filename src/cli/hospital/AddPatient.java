package cli.hospital;

import database.hospitalDatabase.HospitalCloudInterface;
import database.hospitalDatabase.HospitalDatabaseCloud;
import database.patientDatabase.PatientDatabaseCloud;
import hospital.Hospital;
import person.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class AddPatient {

    private static Hospital hospital;
    public AddPatient(Hospital hospital) {
        AddPatient.hospital = hospital;
    }

    public static void addPatient() {
        HospitalCloudInterface database = new HospitalDatabaseCloud();
        final String name, address, sex, symptom_1, symptom_2, symptom_3;
        final int id;
        final int age;
        final int health;
        final boolean insurance;

        System.out.println();
        System.out.println("Enter the patient details as follows:");
        System.out.println();
        Scanner option = new Scanner(System.in);
        System.out.println("Enter Name:");
        System.out.println();
        name = option.nextLine();
        System.out.println();
        System.out.println("Enter Patient Id Number:");
        System.out.println();
        id = option.nextInt();
        System.out.println();
        System.out.println("Enter Address:");
        System.out.println();
        address = option.next();
        System.out.println();
        System.out.println("Enter Sex:");
        System.out.println();
        option.nextLine();
        sex = option.next();
        System.out.println();
        System.out.println("Enter Age:");
        System.out.println();
        age = option.nextInt();
        System.out.println();
        System.out.println("Enter Health:");
        System.out.println();
        health = option.nextInt();
        System.out.println();
        System.out.println("Does the Patient have Insurance(y/n):");
        System.out.println();
        option.nextLine();
        String select = option.nextLine();
        System.out.println();
        insurance = select.equals("y");
        System.out.println("Enter Symptom 1:");
        System.out.println();
        symptom_1 = option.nextLine();
        System.out.println();
        System.out.println("Enter Symptom 2:");
        System.out.println();
        symptom_2 = option.nextLine();
        System.out.println();
        System.out.println("Enter Symptom 3:");
        System.out.println();
        symptom_3 = option.nextLine();
        System.out.println();

        database.writePatientData(hospital.getName(),id, name, address, sex, age, health, insurance,
                symptom_1, symptom_2, symptom_3);
        ArrayList<String> symptoms = new ArrayList<>();
        symptoms.add(symptom_1);
        symptoms.add(symptom_2);
        symptoms.add(symptom_3);
        Patient patient = new Patient(id, name, address, sex, age, health, insurance, symptoms);
        hospital.getPatientsList().add(patient);
        if(hospital.getPatientsList().contains(patient)) {
            System.out.println("Patient Added Successfully");
        }
        else
            System.out.println("404. Ops Something went wrong.");
    }
}
