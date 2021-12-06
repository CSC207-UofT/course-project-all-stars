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
    //Curable Diseases
    ArrayList<String> can_cure = new ArrayList<>(Arrays.asList("Salmonella", "Anaphylaxis",
            "Alcohol poisoning", "Shingles", "Chickenpox", "Seasonal Flu",
            "Tuberculosis", "Conjunctivitis", "Mononucleosis", "Strep Throat", "Headaches",
            "Lyme disease","Measles","Tetanus","Obesity", "Rabies", "Gastritis", "Anemia",
            "Hemorrhoids", "Decubitus Ulcer", "Celiac Disease"));

    //Patients information
    final int max_patients = 25;
    ArrayList<Patient> patients;

    //Constructor
    public Doctor(int id, String name, String address, String sex, int age) {
        super(id, name, address, sex, age);
    }

    //Treat a patient that has a disease curable by the doctor and that is admitted
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

    //Returns a list of patients assigned to this doctor
    public ArrayList<Patient> getPatients(){
        return patients;
    }

    //Returns a boolean that is true when a doctor has as many or more patients than they are allowed to have
    public boolean isFull(){
        return patients.size() >= max_patients;
    }

    //Return an ArrayList of strings describing diseases they are capable of curing
    public ArrayList<String> getCurables(){
        return can_cure;
    }

    //Assign a patient to this doctor
    public void assignPatient(Patient p){
        //Assigns Patient p to the doctor's patient list
        patients.add(p);
    }

    //Teach the doctor to cure disease
    public void LearnHowToCure(String disease) {
        if (!can_cure.contains(disease)) {
            can_cure.add(disease);
        }
    }

}
