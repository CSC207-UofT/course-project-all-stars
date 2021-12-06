package person;

import java.util.Collections;
import java.util.Set;
import java.util.*;

//subclass of Doctor having Neurology as its specialization and that can cure Meningitis and Depression.
public class Neurologist extends Doctor {
    final private String specialization;

    //constructor method
    public Neurologist(int id, String name, String address, String sex, int age) {
        super(id, name, address, sex, age);
        specialization = "Neurology";
        can_cure.add("Meningitis");
        can_cure.add("Depression");
    }

    //getter method
    public String getSpecialization() {
        return specialization;
    }
}
