package test;
import org.junit.Test;
import person.DoctorTypes.Oncologist;
import person.Patient;

import java.util.ArrayList;
import java.util.Objects;

public class OncologistTest {

    @Test
    public void OncologistCanTreatCancer(){
        Oncologist doc = new Oncologist(500, "Alex", "1111", "Male", 10);
        ArrayList<String> symptoms = new ArrayList<>();
        symptoms.add("Fatigue");
        symptoms.add("Swelling");
        symptoms.add("Unusual bleeding");
        Patient patient = new Patient(502, "Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Cancer");
        patient.setIs_admitted(true);
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, true);
    }
}
