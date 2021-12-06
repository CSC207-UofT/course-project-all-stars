package person;

import java.util.Collections;
import java.util.Set;
import java.util.*;

public class Neurologist extends Doctor {
    final private String specialization;

    public Neurologist(String name, String address, String sex, int age) {
        super(name, address, sex, age);
        specialization = "Neurology";
        can_cure.add("Meningitis");
        can_cure.add("Depression");
        can_cure.add("Headaches");
        can_cure.add("Dementia");
        can_cure.add("Epilepsy");
        can_cure.add("Parkinson");
        can_cure.add("Attention Deficit Hyperactivity Disorder");
        can_cure.add("Cerebellar stroke");
    }

    public String getSpecialization() {
        return specialization;
    }
}
