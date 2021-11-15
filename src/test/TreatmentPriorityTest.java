package test;

import person.Patient;
import Priority.PriorityTreatment;
import org.junit.Test;

import java.util.ArrayList;

public class TreatmentPriorityTest {

    @Test
    public void test_add_patient() {
        ArrayList<String> patient1_symptoms = new ArrayList<>();
        patient1_symptoms.add("Loss of Taste and Smell");
        patient1_symptoms.add("Fever");
        patient1_symptoms.add("Cough");

        Patient patient1 = new Patient("Elon", "14 York St", "male", 54, 30,
                true, patient1_symptoms);

        ArrayList<String> patient2_symptoms = new ArrayList<>();
        patient2_symptoms.add("Chest pain");
        patient2_symptoms.add("Chills");
        patient2_symptoms.add("Cough");

        Patient patient2 = new Patient("Nina", "10 York St", "female", 20, 30,
                false, patient2_symptoms);

        ArrayList<String> patient3_symptoms = new ArrayList<>();
        patient3_symptoms.add("Nausea");
        patient3_symptoms.add("Chills");
        patient3_symptoms.add("Headache");

        Patient patient3 = new Patient("Justice", "591 dickhead St", "female", 35, 30,
                false,
                patient3_symptoms);

        PriorityTreatment priority = new PriorityTreatment();
        priority.add_patient(patient1);
        priority.add_patient(patient2);
        priority.add_patient(patient3);

        assert priority.show_patientList().get(0).equals(patient1);
        assert priority.show_patientList().get(1).equals(patient3);
        assert priority.show_patientList().get(2).equals(patient2);
    }
}
