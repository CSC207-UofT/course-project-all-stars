package test;
import diagnosis.Diagnosis;
import person.Patient;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class DiagnosisTest {

    @Test
    public void testDiagnose() throws SQLException {
        ArrayList<String> set = new ArrayList<>();
        set.add("Loss of Taste and Smell");
        set.add("Fever");
        set.add("Cough");

        Patient p = new Patient(1000, "Carl", "Your Mom", "Yes Please", 99, 30, false, set);

        Diagnosis.diagnose_patient(p);

        assert p.getDiagnose().equals("Covid");
    }
}
