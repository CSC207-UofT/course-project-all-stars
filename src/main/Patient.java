package main;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Patient extends Person {
    boolean is_admitted;
    int health;
    boolean insurance;
    Set<String> symptoms_set;
    String Diagnose;

    public Patient(String name, String address, String sex, int age, int health, boolean insurance,
                   Set<String> symptoms_set) {
        super(name, address, sex, age);
        this.is_admitted = false;
        this.health = health;
        this.insurance = insurance;
        this.symptoms_set = symptoms_set;
        this.Diagnose = "Not Yet Diagnosed";
    }

    // Getter Methods
    public boolean getIs_Admitted() {
        return is_admitted;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
    public int getHealth() {
        return health;
    }
    public boolean getInsurance(){
        return insurance;
    }
    public Set<String> getSymptoms(){
        return this.symptoms_set;
    }
    public String getDiagnose(){
        return this.Diagnose;
    }

    //Setter Method
    public void setDiagnose(String disease){
        this.Diagnose = disease;
    }
    public void setIs_admitted(Boolean tf){this.is_admitted = tf;}

    /*
    constructPatient() creates all Patient object using "database" Patient.txt and returns an ArrayList containing
    the objects.
    Patient.txt format:
    Name,Address,Sex,Age
    Make sure there are no spaces between ","
    */

    public static ArrayList<Patient> constructPatient(){
        // Initialize Variables
        ArrayList<Patient> patientArrayList = new ArrayList<Patient>();
        String relativePath = "";
        BufferedReader br = null;
        String line = "";
        // Read File
        try{
            br = new BufferedReader(new FileReader("/Users/ratantejmadan/OneDrive - University of Toronto/Year 3/Fall/CSC 207/Project/healthcare-management-csc207/src/datasets/Patient.txt"));
            while((line = br.readLine()) != null){ // Keep reading file until end of line
                String[] values = line.split(","); // Separate parameters from each line using "," as separation
                String name = values[0]; // Parameter 1
                String address = values[1]; // Parameter 2
                String sex = values[2]; // Parameter 3
                int age = Integer.parseInt(values[3]); // Parameter 4
                int health = Integer.parseInt(values[4]); // Parameter 5
                boolean insurance = Boolean.parseBoolean(values[5]); // Parameter 6
                Set<String> symptoms_set = new HashSet<>();
                symptoms_set.add(values[6]); // Parameter 7
                symptoms_set.add(values[7]); // Parameter 8
                symptoms_set.add(values[8]); // Parameter 9
                patientArrayList.add(new Patient(name, address, sex, age, health, insurance, symptoms_set));
            }
            br.close(); // Close BufferedReader after reading file
            return patientArrayList; // return an ArrayList containing all Patient object created from .txt
        }
        catch (Exception e) {
            return null;
        }
    }

}