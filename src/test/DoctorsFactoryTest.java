package test;

import database.hospitalDatabase.HospitalCloudInterface;
import database.hospitalDatabase.HospitalDatabaseCloud;
import hospital.DoctorsFactory;
import hospital.PatientsFactory;
import org.junit.Test;
import person.Patient;
import person.Doctor;
import database.hospitalDatabase.HospitalCloudInterface;
import database.hospitalDatabase.HospitalDatabaseCloud;

import javax.print.Doc;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorsFactoryTest {



    //Test if number of patients created equals the input number.
    @Test
    public void testDoctorsFactoryReturnsTwentyFiveDoctors() throws SQLException {
        HospitalCloudInterface database = new HospitalDatabaseCloud();
        ArrayList<Doctor> arrayOfTwentyFiveDoctors = DoctorsFactory.createDoctors();
        assert arrayOfTwentyFiveDoctors.size() == 25;
    }

    //Test that all the doctors are distinct
    @Test
    public void testDoctorsAreDistinct() throws SQLException {
        HospitalCloudInterface database = new HospitalDatabaseCloud();
        Boolean  equalDoctors = false;
        ArrayList<Doctor> arrayOfTwentyFiveDoctors = DoctorsFactory.createDoctors();
        for(Doctor doctor:arrayOfTwentyFiveDoctors){
            for(Doctor secondDoctor:arrayOfTwentyFiveDoctors){
                if(doctor.equals(secondDoctor) && arrayOfTwentyFiveDoctors.indexOf(doctor) ==
                        arrayOfTwentyFiveDoctors.indexOf(secondDoctor)){
                    equalDoctors = true;
                }
            }
        }
        assert(equalDoctors.equals(false));
    }
}
