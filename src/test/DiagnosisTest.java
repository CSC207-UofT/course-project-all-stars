package test;
import diagnosis.Diagnosis;
import person.Patient;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashSet;

public class DiagnosisTest {

    @Test
    public void testDiagnose() throws SQLException {
        HashSet<String> set = new HashSet<>();
        set.add("Loss of Taste and Smell");
        set.add("Fever");
        set.add("Cough");

        Patient p = new Patient("Carl", "Your Mom", "Yes Please", 99, 30, false,
                set);

        Diagnosis.diagnose_patient(p);

        assert p.getDiagnose().equals("Covid");
    }
}
