package person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import database.PatientDatabaseCloud;

public class PatientArrayList {
    /**
     * Responsible for creating and returning ArrayList containing Patient objects
     */

    public static ArrayList<Patient> constructPatient(String hospital_name) throws SQLException {
        /**
         * Creates all Patient objects using a database and return an ArrayList containing the objects
         * Format: Name, Address, Sex, Age, Health, Insurance, Symptom A, Symptom B, Symptom C
         * @return ArrayList<patient> constructed using database
         */
        ArrayList<Patient> patientArrayList = new ArrayList<Patient>();
        PatientDatabaseCloud database = new PatientDatabaseCloud(hospital_name);
        ResultSet dataset = database.readData();
        while(dataset.next()){ // Continue accessing data until end of database
            int id = dataset.getInt(1);
            String name = dataset.getString(2);
            String address = dataset.getString(3);
            String sex = dataset.getString(4);
            int age = dataset.getInt(5);
            int health = dataset.getInt(6);
            boolean insurance = dataset.getBoolean(7);
            ArrayList<String> symptoms_set = new ArrayList<>();
            symptoms_set.add(dataset.getString(8));
            symptoms_set.add(dataset.getString(9));
            symptoms_set.add(dataset.getString(10));
            patientArrayList.add(new Patient(id, name, address, sex, age, health, insurance, symptoms_set));
        }
        return patientArrayList;
    }

}

