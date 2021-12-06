package affliction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import database.afflictionDatabase.AfflictionCloudInterface;
import database.afflictionDatabase.AfflictionDatabaseCloud;

public class AfflictionConstructor {
    /**
     * Responsible for creating and returning ArrayList containing Affliction objects.
     */

    public static ArrayList<Affliction> afflictionsFromDatabase() throws SQLException {
        /*
          Creates an ArrayList of Affliction objects created from a database.
          Format: diseaseName, urgencyLevel, cureTime, symptom1, symptom2, symptom3
          @return ArrayList<patient> constructed using database
         */
        ArrayList<Affliction> afflictionArrayList = new ArrayList<>();
        AfflictionCloudInterface database = new AfflictionDatabaseCloud();
        ResultSet dataset = database.readData();
        while(dataset.next()){ //Continue accessing data
            String diseaseName = dataset.getString(1);
            int urgencyLevel = dataset.getInt(2);
            int cureTime = dataset.getInt(3);
            String symptom1 = dataset.getString(4);
            String symptom2 = dataset.getString(5);
            String symptom3 = dataset.getString(6);
            afflictionArrayList.add(new Affliction(diseaseName,urgencyLevel,cureTime,symptom1,symptom2,symptom3));
        }
        return afflictionArrayList;
    }

    public static Hashtable<String, ArrayList<String>> disease_data() throws SQLException {
        Hashtable<String, ArrayList<String>> diseases = new Hashtable<>();
        for(Affliction i: afflictionsFromDatabase()){
            ArrayList<String> set = new ArrayList<>();
            set.add(i.getSymptom1());
            set.add(i.getSymptom2());
            set.add(i.getSymptom3());
            diseases.put(i.getDiseaseName(), set);
        }
        return diseases;
    }
}
