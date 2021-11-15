package person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import database.PatientDatabaseCloud;

public class PatientArrayList {
    /**
     * Responsible for creating and returning ArrayList containing Patient objects
     */

    public static ArrayList<Patient> constructPatient() throws SQLException {
        /**
         * Creates all Patient objects using a database and return an ArrayList containing the objects
         * Format: Name, Address, Sex, Age, Health, Insurance, Symptom A, Symptom B, Symptom C
         * @return ArrayList<patient> constructed using database
         */
        ArrayList<Patient> patientArrayList = new ArrayList<Patient>();
        PatientDatabaseCloud database = new PatientDatabaseCloud();
        ResultSet dataset = database.readData();
        while(dataset.next()){ // Continue accessing data until end of database
            String name = dataset.getString(1);
            String address = dataset.getString(2);
            String sex = dataset.getString(3);
            int age = dataset.getInt(4);
            int health = dataset.getInt(5);
            boolean insurance = dataset.getBoolean(6);
            Set<String> symptoms_set = new HashSet<>();
            symptoms_set.add(dataset.getString(7));
            symptoms_set.add(dataset.getString(8));
            symptoms_set.add(dataset.getString(9));

            patientArrayList.add(new Patient(name, address, sex, age, health, insurance, symptoms_set));
        }
        return patientArrayList;
    }

}

