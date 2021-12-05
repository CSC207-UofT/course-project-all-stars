package test;

import database.HospitalDatabaseCloud;
import org.junit.Test;

public class CreateHospitalTest {

    @Test
    public void createhospital(){
        HospitalDatabaseCloud create = new HospitalDatabaseCloud();
        create.createHospital("PelociCapital");
    }
}
