package person;

import person.Patient;
import person.Person;

import java.util.ArrayList;
import java.util.Arrays;

    /*
        A Doctor will be able to cure patients with diseases with a low Urgency Level.
        Doctors from this class will be doctors that don't have a specific specialization.
        For this reason
    */

public class Doctor extends Person {
    String specialization;
    ArrayList<String> can_cure = new ArrayList<>(Arrays.asList("Salmonella", "Anaphylaxis",
            "Alcohol poisoning", "Fibromyalgia", "Shingles", "Chickenpox"));


    public Doctor(String name, String address, String sex, int age) {

        super(name, address, sex, age);
        specialization = "None";
    }

    public boolean treatPatient(Patient p) {
        if (p.getIs_Admitted()) {
            String disease = p.getDiagnose();
            if (can_cure.contains(disease)) {
                p.health = 100;
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

}
