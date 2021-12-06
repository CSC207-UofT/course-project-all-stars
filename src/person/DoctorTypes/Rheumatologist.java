package person.DoctorTypes;

import person.Doctor;

//subclass of Doctor having Rheumatology as its specialization and that can cure Tuberculosis.
public class Rheumatologist extends Doctor {

    //constructor
    public Rheumatologist(int id, String name, String address, String sex, int age) {
        super(id, name, address, sex, age);
        specialization = "Rheumatologist";
        can_cure.add("Tuberculosis");
        can_cure.add("Bronchitis");
        can_cure.add("Fibromyalgia");
        can_cure.add("Strep Throat");
        can_cure.add("Asthma");
        can_cure.add("Upper Respiratory Infection");
        can_cure.add("Pneumonia");
    }
    //getter method
    public String getSpecialization() {
        return specialization;
    }
}
