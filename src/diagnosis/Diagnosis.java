package diagnosis;

import affliction.AfflictionConstructor;
import person.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;


public class Diagnosis {
    public static void diagnosePatient(Patient profile) throws SQLException {
        Hashtable<String, ArrayList<String>> diseaseData = AfflictionConstructor.disease_data();
        for(String keys: diseaseData.keySet()){
            if(profile.getSymptoms().equals(diseaseData.get(keys))){
                profile.setDiagnose(keys);
                break;
            }
        }
    }
}

