package test;
import database.hospitalDatabase.HospitalCloudInterface;
import database.hospitalDatabase.HospitalDatabaseCloud;
import hospital.DoctorsFactory;
import hospital.PatientsFactory;
import org.junit.Test;
import person.Doctor;
import person.Patient;

import javax.print.Doc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class DoctorTest {


    @Test
    public void TestDontTreatPatientsWithUnknownDisease(){
        Doctor doc = new Doctor(101, "Alex", "1111", "Male", 10);
        ArrayList<String> symptoms = new ArrayList<>();
        symptoms.add("Chest pain");
        symptoms.add("Shortness of breath");
        symptoms.add("Neck pain");
        Patient patient = new Patient(400, "Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Heart Disease");
        patient.setIs_admitted(true);
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, false);
    }

    @Test
    public void TestDocTreatsPatientsWithKnownDisease(){
        Doctor doc = new Doctor(102, "Alex", "1111", "Male", 10);
        ArrayList<String> symptoms = new ArrayList<>();
        symptoms.add("Loss of taste and smell");
        symptoms.add("Fever");
        symptoms.add("Cough");
        Patient patient = new Patient(401, "Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Covid");
        patient.setIs_admitted(true);
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, true);
    }
    @Test
    public void TestDoctorLearnHowToCure(){
        Doctor doc = new Doctor(103, "Alex", "1111", "Male", 10);
        ArrayList<String> symptoms = new ArrayList<>();
        symptoms.add("Chest pain");
        symptoms.add("Shortness of breath");
        symptoms.add("Neck pain");
        Patient patient = new Patient(402, "Mark", "Main Street 1", "Male", 60, 20,
                false, symptoms);
        patient.setDiagnose("Heart Disease");
        patient.setIs_admitted(true);
        doc.LearnHowToCure("Heart Disease");
        boolean b = doc.treatPatient(patient);
        assert Objects.equals(b, true);
    }

    @Test
    public void testCreate() throws SQLException {
        DoctorsFactory DoctorFactory = new DoctorsFactory();
        ArrayList<Doctor> x = DoctorFactory.createDoctors();
        assert x.size() == 25;
    }

//    @Test
//    public void testWrite() throws SQLException {
//        DoctorsFactory DoctorFactory = new DoctorsFactory();
//        ArrayList<Doctor> x = DoctorFactory.createDoctors();
//        HospitalCloudInterface hospital = new HospitalDatabaseCloud();
//        for(Doctor d: x){
//            hospital.writeDoctorData("test_hospital", d);
//        }
//    }

//    @Test
//    public void testLoad() throws SQLException{
//        DoctorsFactory Factory = new DoctorsFactory();
//        ArrayList<Doctor> doctors = Factory.loadDoctors("test_hospital");
//        assert doctors.size() == 25;
//    }




}
