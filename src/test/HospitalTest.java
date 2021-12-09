package test;
import hospital.DoctorsFactory;
import hospital.EmptyHospitalBuilder;
import hospital.Hospital;
import hospital.PatientsFactory;
import org.junit.Test;
import person.Doctor;
import person.Patient;

import java.sql.SQLException;
import java.util.ArrayList;

public class HospitalTest {

    @Test
    public void TestAdmitPatientNoDoctor() throws SQLException {
        Hospital hospital = new EmptyHospitalBuilder().buildHospital();
        PatientsFactory patientsFactory = new PatientsFactory();
        Patient patient = patientsFactory.createPatients(1).get(0);
        patient.setDiagnose("test");
        String message = hospital.admitPatient(patient);
        assert message.equals("No doctor found that can be assigned to this patient. Please try again later.");
    }

    @Test
    public void TestAdmitPatientNoDiagnosis() throws SQLException {
        Hospital hospital = new EmptyHospitalBuilder().buildHospital();
        PatientsFactory patientsFactory = new PatientsFactory();
        Patient patient = patientsFactory.createPatients(1).get(0);
        String message = hospital.admitPatient(patient);
        assert message.equals("This patients has not been diagnosed");
    }

    @Test
    public void TestAdmitPatientDoctor() throws SQLException {
        DoctorsFactory doctorsFactory = new DoctorsFactory();
        PatientsFactory patientsFactory = new PatientsFactory();
        Patient patient = patientsFactory.createPatients(1).get(0);
        doctorsFactory.createDoctors();
        ArrayList<Doctor> doctors = doctorsFactory.createDoctors();
        Hospital hospital = new EmptyHospitalBuilder().buildHospital();
        for (Doctor doctor: doctors) {
            hospital.hireDoctor(doctor);
        }
        patient.setDiagnose("Shingles");
        String msg = hospital.admitPatient(patient);
        assert msg.contains("A new patient named");
    }

    @Test
    public void TestHireDoctor() throws SQLException{
        ArrayList<Doctor> doctors = new DoctorsFactory().createDoctors();
        Hospital hospital = new EmptyHospitalBuilder().buildHospital();
        String msg = hospital.hireDoctor(doctors.get(0));
        assert msg.equals("A new doctor named " + doctors.get(0).getName() + " has been hired");
    }
}
