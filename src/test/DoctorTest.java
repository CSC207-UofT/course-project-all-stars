package test;
import org.junit.Test;
import person.Doctor;
import person.Patient;

import java.util.ArrayList;
import java.util.Objects;

public class DoctorTest {


    @Test
    public void TestDontTreatPatientsWithUnknownDisease(){
        Doctor doc = new Doctor(10, "Alex", "1111", "Male", 10);
        ArrayList<String> symptoms = new ArrayList<>();
        symptoms.add("Chest pain");
        symptoms.add("Shortness of breath");
        symptoms.add("Neck pain");
        Patient patient = new Patient(20, "Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Heart Disease");
        patient.setIs_admitted(true);
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, false);
    }

    @Test
    public void TestDocTreatsPatientsWithKnownDisease(){
        Doctor doc = new Doctor(5, "Alex", "1111", "Male", 10);
        ArrayList<String> symptoms = new ArrayList<>();
        symptoms.add("Loss of taste and smell");
        symptoms.add("Fever");
        symptoms.add("Cough");
        Patient patient = new Patient(1, "Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Covid");
        patient.setIs_admitted(true);
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, true);
    }
    @Test
    public void TestDoctorLearnHowToCure(){
        Doctor doc = new Doctor(10,"Alex", "1111", "Male", 10);
        ArrayList<String> symptoms = new ArrayList<>();
        symptoms.add("Chest pain");
        symptoms.add("Shortness of breath");
        symptoms.add("Neck pain");
        Patient patient = new Patient(80,"Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Heart Disease");
        patient.setIs_admitted(true);
        doc.LearnHowToCure("Heart Disease");
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, true);
    }


}
