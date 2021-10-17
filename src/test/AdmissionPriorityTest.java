package test;
import main.Patient;
import main.PriorityAdmission;
import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AdmissionPriorityTest {

    @Test
    public void test_add() {
        ArrayList<Patient> patients = Patient.constructPatient();
        assert patients != null;
        Patient P1 = patients.get(0);
        Patient P2 = patients.get(1);
        Patient P3 = patients.get(2);

        PriorityAdmission priority = new PriorityAdmission();
        priority.add(P1);
        priority.add(P2);
        priority.add(P3);

        assert P1.getName().equals(priority.show().get(1).getName());
    }

}
