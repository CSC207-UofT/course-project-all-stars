package test;
import database.hospitalDatabase.HospitalCloudInterface;
import database.hospitalDatabase.HospitalDatabaseCloud;
import hospital.PatientsFactory;
import org.junit.Test;
import person.Patient;

import java.sql.SQLException;
import java.util.ArrayList;

public class PatientsFactoryTest {


    //Test if number of patients created equals the input number.
    @Test
    public void testNumberOfPatientsReturned() throws SQLException {
        ArrayList<Patient> arrayOfTenPatients = PatientsFactory.createPatients(10);
        assert arrayOfTenPatients.size() == 10;
    }

    //Test that all the patients are distinct
    @Test
    public void testPatientsAreDistinct() throws SQLException {
        Boolean  equalPatients = false;
        ArrayList<Patient> arrayOfTenPatients = PatientsFactory.createPatients(200);
        for(Patient patient:arrayOfTenPatients){
            for(Patient secondPatient:arrayOfTenPatients){
                if(patient.equals(secondPatient) && arrayOfTenPatients.indexOf(patient) ==
                        arrayOfTenPatients.indexOf(secondPatient)){
                    equalPatients = true;
                }
            }
        }
        assert(equalPatients.equals(false));
    }
}
