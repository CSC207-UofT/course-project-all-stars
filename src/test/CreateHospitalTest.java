package test;

import database.CreateHospitalDatabase;
import org.junit.Test;

public class CreateHospitalTest {

    @Test
    public void createhospital(){
        CreateHospitalDatabase create = new CreateHospitalDatabase();
        create.createHospital("PelociCapital");
    }
}
