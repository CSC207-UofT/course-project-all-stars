package affliction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import database.*;
import person.Patient;

public class AfflictionConstructor {
    /**
     * Responsible for creating and returning ArrayList containing Affliction objects.
     */

    final static int NAME = 0;
    final static int URGENCY = 1;
    final static int TIME = 2;
    final static  int SYMPT1 = 3;
    final static  int SYMPT2 = 4;
    final static  int SYMPT3 = 5;

    public static ArrayList<Affliction> afflictionsFromDatabase(){
        /**
         * Creates an ArrayList of Affliction objects created from a database.
         * Format: diseaseName, urgencyLevel, cureTime, symptom1, symptom2, symptom3
         * @return ArrayList<patient> constructed using database
         */
        ArrayList<Affliction> afflictionArrayList = new ArrayList<Affliction>();
        int row = 0;
        AfflictionDatabaseText afflictionDatabaseText = new AfflictionDatabaseText();
        while(afflictionDatabaseText.rowExist(row) == true){ //Continue accessing data
            String diseaseName = afflictionDatabaseText.readData(row, NAME);
            int urgencyLevel = Integer.parseInt(afflictionDatabaseText.readData(row, URGENCY));
            int cureTime = Integer.parseInt(afflictionDatabaseText.readData(row, TIME));
            String symptom1 = afflictionDatabaseText.readData(row, SYMPT1);
            String symptom2 = afflictionDatabaseText.readData(row, SYMPT2);
            String symptom3 = afflictionDatabaseText.readData(row, SYMPT3);
            afflictionArrayList.add(new Affliction(diseaseName,urgencyLevel,cureTime,symptom1,symptom2,symptom3));

            row ++;
        }
        return afflictionArrayList;
    }

    public static ArrayList<Affliction> AfflictionsFromText(){
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
}
