package affliction;

import java.util.ArrayList;

public class Affliction {
    String diseaseName;
    double urgencyLevel;
    double cureTime;
    ArrayList<String> symptomSet;

    public Affliction(String diseaseName, double urgencyLevel, double cureTime, String symptom1, String symptom2,
                      String symptom3) {
        this.diseaseName = diseaseName;
        this.urgencyLevel = urgencyLevel;
        this.cureTime = cureTime;
        this.symptomSet.add(symptom1);
        this.symptomSet.add(symptom2);
        this.symptomSet.add(symptom3);
    }
    public Affliction(String diseaseName, double urgencyLevel, double cureTime, ArrayList<String> symptomSet) {
        this.diseaseName = diseaseName;
        this.urgencyLevel = urgencyLevel;
        this.cureTime = cureTime;
        this.symptomSet = symptomSet;
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
        return symptomSet.get(0);
    }

    public String getSymptom2() {
        return symptomSet.get(1);
    }

    public String getSymptom3() {
        return symptomSet.get(2);
    }
    public ArrayList<String> getSymptomSet(){
        return symptomSet;
    }

    /*
        constructAffliction() creates all Affliction object using "database" Disease.txt and returns an ArrayList containing
        the objects.
         Disease.txt format:
         Disease Name,Urgency Level,Cure Time,Symptoms 1,Symptoms 2,Symptoms 3

         Make sure there are no spaces between ","
         */
}
