package person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import database.*;

public class PatientArrayList {
    /**
     * Responsible for creating and returning ArrayList containing Patient objects
     */

    public static ArrayList<Patient> constructPatient() {
        /**
         * Creates all Patient objects using a database and return an ArrayList containing the objects
         * Format: Name, Address, Sex, Age, Health, Insurance, Symptom A, Symptom B, Symptom C
         * @return ArrayList<patient> constructed using database
         */
        ArrayList<Patient> patientArrayList = new ArrayList<Patient>();
        int row = 0;
        int column = 0;
        PatientDatabaseText databaseText = new PatientDatabaseText();
        while(databaseText.rowExist(row) == true){ // Continue accessing data until end of database
            String name = databaseText.readData(row, column);
            String address = databaseText.readData(row, column + 1);
            String sex = databaseText.readData(row, column + 2);
            int age = Integer.parseInt(databaseText.readData(row, column + 3));
            int health = Integer.parseInt(databaseText.readData(row, column + 4));
            boolean insurance = Boolean.parseBoolean(databaseText.readData(row, column + 5));
            Set<String> symptoms_set = new HashSet<>();
            symptoms_set.add(databaseText.readData(row, column + 6));
            symptoms_set.add(databaseText.readData(row, column + 7));
            symptoms_set.add(databaseText.readData(row, column + 8));

            patientArrayList.add(new Patient(name, address, sex, age, health, insurance, symptoms_set));

            row = row + 1;

        }
        return patientArrayList;
    }

//    public static ArrayList<Patient> constructPatient(){
//        // Initialize Variables
//        ArrayList<Patient> patientArrayList = new ArrayList<Patient>();
//        String relativePath = "";
//        BufferedReader br = null;
//        String line = "";
//        // Read File
//        try{
//            br = new BufferedReader(new FileReader(""));
//            while((line = br.readLine()) != null){ // Keep reading file until end of line
//                String[] values = line.split(","); // Separate parameters from each line using "," as separation
//                String name = values[0]; // Parameter 1
//                String address = values[1]; // Parameter 2
//                String sex = values[2]; // Parameter 3
//                int age = Integer.parseInt(values[3]); // Parameter 4
//                int health = Integer.parseInt(values[4]); // Parameter 5
//                boolean insurance = Boolean.parseBoolean(values[5]); // Parameter 6
//                Set<String> symptoms_set = new HashSet<>();
//                symptoms_set.add(values[6]); // Parameter 7
//                symptoms_set.add(values[7]); // Parameter 8
//                symptoms_set.add(values[8]); // Parameter 9
//                patientArrayList.add(new Patient(name, address, sex, age, health, insurance, symptoms_set));
//            }
//            br.close(); // Close BufferedReader after reading file
//            return patientArrayList; // return an ArrayList containing all Patient object created from .txt
//        }
//        catch (Exception e) {
//            return null;
//        }
//    }

}

