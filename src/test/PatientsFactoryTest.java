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
        for(int i = 0; i < arrayOfTenPatients.size(); i++){
            for(int j = 0; j < arrayOfTenPatients.size(); j++){
                if (i != j) {
                    Patient firstPatient = arrayOfTenPatients.get(i);
                    Patient secondPatient = arrayOfTenPatients.get(j);
                    if(firstPatient.equals(secondPatient) && arrayOfTenPatients.indexOf(firstPatient) ==
                            arrayOfTenPatients.indexOf(secondPatient)){
                        equalPatients = true;
                    }
                }
            }
        }
        assert(equalPatients.equals(false));
    }
}
