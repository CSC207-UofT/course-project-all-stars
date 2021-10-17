package main;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Affliction {
    String diseaseName;
    double urgencyLevel;
    double cureTime;
    String symptom1;
    String symptom2;
    String symptom3;

    public Affliction(String diseaseName, double urgencyLevel, double cureTime, String symptom1, String symptom2,
                      String symptom3){
        this.diseaseName = diseaseName;
        this.urgencyLevel = urgencyLevel;
        this.cureTime = cureTime;
        this.symptom1 = symptom1;
        this.symptom2 = symptom2;
        this.symptom3 = symptom3;
    }

    // Getter Methods
    public String getDiseaseName() {
        return diseaseName;
    }

    public double getUrgencyLevel() {
        return urgencyLevel;
    }

    public double getCureTime() {
        return cureTime;
    }

    public String getSymptom1() {
        return symptom1;
    }

    public String getSymptom2() {
        return symptom2;
    }

    public String getSymptom3() {
        return symptom3;
    }

    /*
        constructAffliction() creates all Affliction object using "database" Disease.txt and returns an ArrayList containing
        the objects.
         Disease.txt format:
         Disease Name,Urgency Level,Cure Time,Symptoms 1,Symptoms 2,Symptoms 3

         Make sure there are no spaces between ","
         */
    public static ArrayList<Affliction> constructAffliction(){
        // Initialize Variables
        ArrayList<Affliction> afflictionArrayList = new ArrayList<Affliction>();
        String relativePath = "src\\datasets\\Disease.txt";
        BufferedReader br = null;
        String line = "";
        // Read File
        try{
            br = new BufferedReader(new FileReader("/Users/ratantejmadan/OneDrive - University of Toronto/Year 3/Fall/CSC 207/Project/healthcare-management-csc207/src/datasets/Disease.txt"));
            while((line = br.readLine()) != null){ // Keep reading file until end of line
                String[] values = line.split(","); // Separate parameters from each line using "," as separation
                String diseaseName = values[0]; // Parameter 1
                double urgencyLevel = Double.parseDouble(values[1]); // Parameter 2
                double cureTime = Double.parseDouble(values[2]); // Parameter 3
                String symptom1 = values[3]; // Parameter 4
                String symptom2 = values[4]; // Parameter 5
                String symptom3 = values[5]; // Parameter 6
                afflictionArrayList.add(new Affliction(diseaseName, urgencyLevel, cureTime, symptom1, symptom2,
                        symptom3));

            }
            br.close(); // Close BufferedReader after reading file
            return afflictionArrayList; // return an ArrayList containing all Affliction object created from .txt
        }
        catch (Exception e) {
            return null;
        }
    }

    public static Hashtable<String, Set> disease_data(){
        Hashtable<String, Set> diseases = new Hashtable<String, Set>();
        for(Affliction i: constructAffliction()){
            Set<String> set = new HashSet<>();
            set.add(i.symptom1);
            set.add(i.symptom2);
            set.add(i.symptom3);
            diseases.put(i.getDiseaseName(), set);
        }
        return diseases;
    }



}
