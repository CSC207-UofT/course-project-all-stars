package database.hospitalDatabase;

import person.Doctor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface HospitalCloudInterface{


    public Connection connect() throws SQLException;

    public void createHospital(String name);

    ResultSet readPatientData(String name);

    ResultSet readDoctorData(String hospital_name);

    void writeDoctorData(String hospital, Doctor doctor);

    public ArrayList<String> listHospitals();

    void writePatientData(String hospital_name, int id, String name, String address, String sex, int age,
                          int health, boolean insurance,
                          String symptomA, String symptomB, String symptomC);

    void deleteHospital(String hospital);

    void deletePatient(String hospital, int id);
}
