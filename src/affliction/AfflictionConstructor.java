package affliction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
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

    public static Hashtable<String, Set> disease_data(){
        Hashtable<String, Set> diseases = new Hashtable<String, Set>();
        AfflictionConstructor ac = new AfflictionConstructor();
        for(Affliction i: ac.afflictionsFromDatabase()){
            Set<String> set = new HashSet<>();
            set.add(i.symptom1);
            set.add(i.symptom2);
            set.add(i.symptom3);
            diseases.put(i.getDiseaseName(), set);
        }
        return diseases;
    }
}
