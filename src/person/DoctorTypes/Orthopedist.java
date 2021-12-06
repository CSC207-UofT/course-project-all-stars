package person.DoctorTypes;

//subclass of Doctor having Orthopedist as its specialization and that can cure Arthritis and Fibromyalgia.

import person.Doctor;

public class Orthopedist extends Doctor {

    //constructor
    public Orthopedist(int id, String name, String address, String sex, int age){
        super(id, name, address, sex, age);
        specialization = "Orthopedist";
        can_cure.add("Arthritis");
        can_cure.add("Fibromyalgia");
    }
    //getter method
    public String getSpecialization() {
        return specialization;
    }
}