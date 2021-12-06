package person.DoctorTypes;

import person.Doctor;

public class Psychiatrist extends Doctor {


    public Psychiatrist(int id, String name, String address, String sex, int age){
        super(id, name, address, sex, age);
        specialization = "Psychiatrist";
        can_cure.add("Depression");
        can_cure.add("Anxiety");
        can_cure.add("Bipolar Disorder");
        can_cure.add("Paranoia");
        can_cure.add("Schizophrenia");
        can_cure.add("Delirium");
        can_cure.add("Dependence");
        can_cure.add("Anorexia");
    }

    //getter method
    public String getSpecialization() {
        return specialization;
    }
}
