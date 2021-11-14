package test;
import org.junit.Test;
import person.Doctor;
import person.Neurologist;
import person.Oncologist;
import person.Patient;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Objects;

public class NeurologistTest {

    @Test
    public void NeurologistCanTreatMeningitis(){
        Neurologist doc = new Neurologist("Alex", "1111", "Male", 10);
        HashSet<String> symptoms = new HashSet<>();
        symptoms.add("Headache");
        symptoms.add("Nausea");
        symptoms.add("Photophobia");
        Patient patient = new Patient("Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Meningitis");
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, true);
    }
}

