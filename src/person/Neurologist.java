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
    }

    public String getSpecialization() {
        return specialization;
    }
}
