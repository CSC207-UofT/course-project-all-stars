package diagnosis;

import affliction.Affliction;
import affliction.AfflictionConstructor;
import person.Patient;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Set;

public class Diagnosis {
    public static void diagnose_patient(Patient p) throws SQLException {
        Hashtable<String, Set> disease_data = AfflictionConstructor.disease_data();
        for(String keys: disease_data.keySet()){
            if(p.getSymptoms().equals(disease_data.get(keys))){
                p.setDiagnose(keys);
                break;
            }
        }
    }
}
