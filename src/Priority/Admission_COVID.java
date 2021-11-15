package Priority;

import person.Patient;

import java.util.ArrayList;

public class Admission_COVID extends PriorityAdmission implements COVID {
    @Override
    public boolean higherPriority(Patient patient, Patient new_patient) {
        ArrayList<String> COVID_symptoms = new ArrayList<>();
        COVID_symptoms.add("Loss of Taste and Smell");
        COVID_symptoms.add("Fever");
        COVID_symptoms.add("Cough");
        int newPatient_index = 0;
        int patient_index = 0;
        ArrayList<String> new_patient_symptoms = new_patient.getSymptoms();
        ArrayList<String> patient_symptoms = patient.getSymptoms();
        for (String new_patient_symptom : new_patient_symptoms) {
            if (COVID_symptoms.contains(new_patient_symptom)) {
                newPatient_index += 1;
            }
        }
        for (String patient_symptom : patient_symptoms) {
            if (COVID_symptoms.contains(patient_symptom)) {
                patient_index += 1;
            }
        }
        if (patient_index == newPatient_index) {
            if (patient.getHealth() == new_patient.getHealth()) {
                return new_patient.getInsurance() & !patient.getInsurance();
            } else {
                return patient.getHealth() > new_patient.getHealth();
            }
        } else {
            return patient_index < newPatient_index;
        }
    }
}
