package test;

import priority.PriorityAdmission;
import priority.PriorityTreatment;
import priority.Admission_COVID;
import person.Patient;
import org.junit.Test;

import java.util.ArrayList;

public class PriorityTest {
    /**
     * A test class for checking if the patients are being added to treatment, admission, and admission during COVID-19
     * according to the priority triages implemented in the respective classes in the priority classes
     */
    @Test
    public void test_add_patient() {
        ArrayList<String> patient1_symptoms = new ArrayList<>();
        patient1_symptoms.add("Loss of Taste and Smell");
        patient1_symptoms.add("Fever");
        patient1_symptoms.add("Cough");

        Patient patient1 = new Patient(1002, "Elon", "14 York St", "male", 54, 30,
                true, patient1_symptoms);

        ArrayList<String> patient2_symptoms = new ArrayList<>();
        patient2_symptoms.add("Chest pain");
        patient2_symptoms.add("Chills");
        patient2_symptoms.add("Cough");

        Patient patient2 = new Patient(1003,"Nina", "10 York St", "female", 20, 30,
                false, patient2_symptoms);

        ArrayList<String> patient3_symptoms = new ArrayList<>();
        patient3_symptoms.add("Nausea");
        patient3_symptoms.add("Chills");
        patient3_symptoms.add("Headache");

        Patient patient3 = new Patient(1004,"Justice", "591 dickhead St", "female", 35, 30,
                false,
                patient3_symptoms);

        PriorityAdmission priorityAdmission = new PriorityAdmission();
        priorityAdmission.add_patient(patient1);
        priorityAdmission.add_patient(patient2);
        priorityAdmission.add_patient(patient3);

        PriorityTreatment priorityTreatment = new PriorityTreatment();
        priorityTreatment.add_patient(patient1);
        priorityTreatment.add_patient(patient2);
        priorityTreatment.add_patient(patient3);

        Admission_COVID priorityCOVID = new Admission_COVID();
        priorityCOVID.add_patient(patient1);
        priorityCOVID.add_patient(patient2);
        priorityCOVID.add_patient(patient3);

        assert priorityTreatment.show_patientList().get(0).equals(patient1);
        assert priorityTreatment.show_patientList().get(1).equals(patient3);
        assert priorityTreatment.show_patientList().get(2).equals(patient2);

        assert priorityCOVID.show_patientList().get(0).equals(patient1);
        assert priorityCOVID.show_patientList().get(1).equals(patient2);
        assert priorityCOVID.show_patientList().get(2).equals(patient3);

        assert priorityAdmission.show_patientList().get(0).equals(patient1);
        assert priorityAdmission.show_patientList().get(1).equals(patient2);
        assert priorityAdmission.show_patientList().get(2).equals(patient3);
    }
}

