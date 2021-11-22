package test;
import org.junit.Test;
import person.Oncologist;
import person.Patient;

import java.util.ArrayList;
import java.util.Objects;

public class CardiologistTest {

    @Test
    public void CardiologistCanTreatHeartDisease(){
        Oncologist doc = new Oncologist("Alex", "1111", "Male", 10);
        ArrayList<String> symptoms = new ArrayList<>();
        symptoms.add("Chest pain");
        symptoms.add("Shortness of breath");
        symptoms.add("Neck pain");
        Patient patient = new Patient("Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Heart Disease");
        patient.setIs_admitted(true);
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, false);
    }
}
