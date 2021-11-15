package test;
import org.junit.Test;

import person.Patient;
import person.Psychiatrist;

import java.util.ArrayList;
import java.util.Objects;

public class PsychiatristTest {

    @Test
    public void PsychiatristCanTreatDepression(){
        Psychiatrist doc = new Psychiatrist("Alex", "1111", "Male", 10);
        ArrayList<String> symptoms = new ArrayList<>();
        symptoms.add("Hopelessness");
        symptoms.add("Insomnia");
        symptoms.add("Troubles concentrating");
        Patient patient = new Patient("Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Depression");
        patient.setIs_admitted(true);
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, true);
    }
}

