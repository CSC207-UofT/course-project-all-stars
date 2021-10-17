package test;
import main.Diagnosis;
import main.Patient;
import org.junit.Test;

import java.util.HashSet;

public class DiagnosisTest {

    @Test
    public void testDiagnose(){
        HashSet<String> set = new HashSet<String>();
        set.add("Loss of Taste and Smell");
        set.add("Fever");
        set.add("Cough");

        Patient p = new Patient("Carl", "Your Mom", "Yes Please", 99, 30, false,
                set);

        Diagnosis.diagnose_patient(p);

        assert p.getDiagnose().equals("Covid");
    }
}
