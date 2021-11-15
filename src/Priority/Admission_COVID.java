package Priority;

import person.Patient;

import java.util.ArrayList;
/**
 * A subclass of the Priority PriorityAdmission that implements COVID and
 * determines the order in which patients are admitted to the Hospital.
 *
 * @author Shysta and Justice
 * @version 2.0
 * @since 1.0
 */
public class Admission_COVID extends PriorityAdmission implements COVID {
    /**
     * Orders patients according to who has more symptoms of COVID-19. A Patient with more symptoms will
     * be higher priority. In the case of a tie between symptom counts, the Patient with the lower health will
     * be prioritized. In the case of a tie between health amounts, if one Patient has insurance and the other
     * does not, the insured Patient will be prioritized. In the event that neither Patient is insured or both
     * are insured, the existing patient will be prioritized.
     *
     * @param patient    A patient currently in the PriorityQueue.
     * @param newPatient A new patient to be added to the PriorityQueue.
     * @return true if patient has higherer priority than newPatient, false if not.
     */
    @Override
    public boolean higherPriority(Patient patient, Patient newPatient) {
        ArrayList<String> COVID_symptoms = new ArrayList<>();
        COVID_symptoms.add("Loss of Taste and Smell");
        COVID_symptoms.add("Fever");
        COVID_symptoms.add("Cough");
        int newPatient_index = 0;
        int patient_index = 0;
        ArrayList<String> new_patient_symptoms = newPatient.getSymptoms();
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
            if (patient.getHealth() == newPatient.getHealth()) {
                return newPatient.getInsurance() & !patient.getInsurance();
            } else {
                return patient.getHealth() > newPatient.getHealth();
            }
        } else {
            return patient_index < newPatient_index;
        }
    }
}
