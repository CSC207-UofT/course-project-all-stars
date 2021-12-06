package person;

import person.Patient;
import person.Person;

import java.util.ArrayList;
import java.util.Arrays;

    /*
        Basic type of Doctor, without the specialization variable.
    */

public class Doctor extends Person {
    ArrayList<String> can_cure = new ArrayList<>(Arrays.asList("Salmonella", "Anaphylaxis",
            "Alcohol poisoning", "Shingles", "Chickenpox", "Seasonal Flu",
            "Tuberculosis", "Conjunctivitis", "Mononucleosis", "Strep Throat", "Headaches",
            "Lyme disease","Measles","Tetanus", "Rabies"));

    public Doctor(int id, String name, String address, String sex, int age) {
        super(id, name, address, sex, age);
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

    public void LearnHowToCure(String disease) {
        if (!can_cure.contains(disease)) {
            can_cure.add(disease);
        }
    }

}
