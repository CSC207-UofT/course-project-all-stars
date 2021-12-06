package person;

import person.Patient;
import person.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

    /*
        Basic type of Doctor, without the specialization variable.
    */

public class Doctor extends Person {
    private String specialization;
    ArrayList<String> can_cure = new ArrayList<>(Arrays.asList("Salmonella", "Anaphylaxis",
            "Alcohol poisoning", "Shingles", "Chickenpox", "Seasonal Flu",
            "Tuberculosis", "Conjunctivitis", "Mononucleosis", "Strep Throat", "Headaches",
            "Lyme disease","Measles","Tetanus","Obesity", "Rabies", "Gastritis", "Anemia",
            "Hemorrhoids", "Decubitus Ulcer", "Celiac Disease"));

    final int max_patients = 25;
    ArrayList<Patient> patients;

    public Doctor(int id, String name, String address, String sex, int age, String specialization) {
        super(id, name, address, sex, age);
        this.specialization = specialization;
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

    public boolean isFull(){
        return patients.size() >= max_patients;
    }

    public ArrayList<String> getCurables(){
        return can_cure;
    }

    public void assignPatient(Patient p){
        //Assigns Patient p to the doctor's patient list
        patients.add(p);
    }

}
