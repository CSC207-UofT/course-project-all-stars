package person.DoctorTypes;

import person.Doctor;

import java.util.Collections;
import java.util.Set;
import java.util.*;

//subclass of Doctor having Neurology as its specialization and that can cure Meningitis and Depression.
public class Neurologist extends Doctor {


    //constructor method
    public Neurologist(int id, String name, String address, String sex, int age) {
        super(id, name, address, sex, age);
        setSpecialization("Neurologist");
        can_cure.add("Meningitis");
        can_cure.add("Depression");
    }
}
