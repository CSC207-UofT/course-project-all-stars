package hospital;

import person.Doctor;
import person.Patient;
import priority.PriorityAdmission;
import priority.PriorityTreatment;

import java.util.ArrayList;

public class EmptyHospitalBuilder {
    //Useful for testing

    public Hospital buildHospital(){
        return new Hospital(new ArrayList<Patient>(), new ArrayList<Doctor>(),
                0, new PriorityAdmission(), new PriorityTreatment(), "test", 1900);
    }
}
