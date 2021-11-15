package test;
import person.Patient;
import container.PriorityAdmission;
import org.junit.Test;
import person.PatientArrayList;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdmissionPriorityTest {

    @Test
    public void test_add() throws SQLException {
        ArrayList<Patient> patients = PatientArrayList.constructPatient();
        assert patients != null;
        Patient P1 = patients.get(0);
        Patient P2 = patients.get(1);
        Patient P3 = patients.get(2);

        PriorityAdmission priority = new PriorityAdmission();
//        priority.add(P1);
//        priority.add(P2);
//        priority.add(P3);

        assert P1.getName().equals(priority.show().get(1).getName());
    }

}
