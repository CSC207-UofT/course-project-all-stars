package affliction;

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
                      String symptom3) {
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
}
