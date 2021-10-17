package main;

import java.util.Hashtable;
import java.util.Set;

public class Diagnosis {
    public static void diagnose_patient(Patient p){
        Hashtable<String, Set> disease_data = Affliction.disease_data();
        for(String keys: disease_data.keySet()){
            if(p.symptoms_set.equals(disease_data.get(keys))){
                p.setDiagnose(keys);
                break;
            }
        }
    }
}
