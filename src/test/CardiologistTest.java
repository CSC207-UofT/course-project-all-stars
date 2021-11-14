package test;
import org.junit.Test;
import person.Doctor;
import person.Oncologist;
import person.Patient;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Objects;

public class CardiologistTest {

    @Test
    public void CardiologistCanTreatHeartDisease(){
        Oncologist doc = new Oncologist("Alex", "1111", "Male", 10);
        HashSet<String> symptoms = new HashSet<>();
        symptoms.add("Chest pain");
        symptoms.add("Shortness of breath");
        symptoms.add("Neck pain");
        Patient patient = new Patient("Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Heart Disease");
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, true);
    }
}
