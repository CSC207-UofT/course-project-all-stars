package test;

import person.Patient;
import container.PriorityTreatment;
import org.junit.Test;

import java.util.ArrayList;

public class TreatmentPriorityTest {

    @Test
    public void test_add() {
        ArrayList<Patient> patients = Patient.constructPatient();
        assert patients != null;
        Patient P1 = patients.get(0);
        Patient P2 = patients.get(1);
        Patient P3 = patients.get(2);

        PriorityTreatment priority = new PriorityTreatment();
        priority.add(P1);
        priority.add(P2);
        priority.add(P3);

        assert P1.getName().equals(priority.show().get(1).getName());
    }
}
