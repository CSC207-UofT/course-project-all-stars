package person;

import person.Patient;
import person.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A subclass of the Person Class. Doctors have a maximum of 25 patients that are stored in an ArrayList.
 * Doctors can treat patients and have an ArrayList of curable diseases.
 * Doctors are in the Entity Layer
 *
 * @version 2.0
 * @since 1.0
 */

public class Doctor extends Person {
    public ArrayList<String> can_cure = new ArrayList<>(Arrays.asList("Salmonella", "Anaphylaxis",
            "Alcohol poisoning", "Shingles", "Chickenpox", "Seasonal Flu",
            "Tuberculosis", "Conjunctivitis", "Mononucleosis", "Strep Throat", "Headaches",
            "Lyme disease","Measles","Tetanus","Obesity", "Rabies", "Gastritis", "Anemia",
            "Hemorrhoids", "Decubitus Ulcer", "Celiac Disease"));

    final int max_patients = 25;
    ArrayList<Patient> patients;
    public String specialization;

    public Doctor(int id, String name, String address, String sex, int age) {
        super(id, name, address, sex, age);
        this.specialization = "General";
    }

    public boolean treatPatient(Patient p) {
        if (p.getIs_Admitted()) {
            String disease = p.getDiagnose();
            if (can_cure.contains(disease)) {
                p.setHealth(100);
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

    public boolean isFull(){
        return patients.size() >= max_patients;
    }

    public ArrayList<String> getCurables(){
        return can_cure;
    }

    public String getSpecialization(){
        return this.specialization;
    }


    public void assignPatient(Patient p){
        //Assigns Patient p to the doctor's patient list
        patients.add(p);
    }

}
