package test;
import org.junit.Test;
import person.Doctor;
import person.Oncologist;
import person.Patient;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Objects;

public class OncologistTest {

    @Test
    public void OncologistCanTreatCancer(){
        Oncologist doc = new Oncologist("Alex", "1111", "Male", 10);
        HashSet<String> symptoms = new HashSet<>();
        symptoms.add("Fatigue");
        symptoms.add("Swelling");
        symptoms.add("Unusual bleeding");
        Patient patient = new Patient("Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Cancer");
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, true);
    }
}
