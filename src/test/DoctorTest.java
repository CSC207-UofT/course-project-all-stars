package test;
import org.junit.Test;
import person.Doctor;
import person.Patient;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Objects;

public class DoctorTest {


    @Test
    public void TestDontTreatPatientsWithUnknownDisease(){
        Doctor doc = new Doctor("Alex", "1111", "Male", 10);
        HashSet<String> symptoms = new HashSet<>();
        symptoms.add("Chest pain");
        symptoms.add("Shortness of breath");
        symptoms.add("Neck pain");
        Patient patient = new Patient("Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Heart Disease");
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, false);
    }

    @Test
    public void TestDocTreatsPatientsWithKnownDisease(){
        Doctor doc = new Doctor("Alex", "1111", "Male", 10);
        HashSet<String> symptoms = new HashSet<>();
        symptoms.add("Loss of taste and smell");
        symptoms.add("Fever");
        symptoms.add("Cough");
        Patient patient = new Patient("Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Covid");
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, true);
    }
    @Test
    public void TestDoctorLearnHowToCure(){
        Doctor doc = new Doctor("Alex", "1111", "Male", 10);
        HashSet<String> symptoms = new HashSet<>();
        symptoms.add("Chest pain");
        symptoms.add("Shortness of breath");
        symptoms.add("Neck pain");
        Patient patient = new Patient("Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Heart Disease");
        doc.LearnHowToCure("Heart Disease");
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, true);
    }


}
