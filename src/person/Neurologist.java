package person;

import java.util.Collections;
import java.util.Set;
import java.util.*;

public class Neurologist extends Doctor {
    final private String specialization;

    public Neurologist(int id, String name, String address, String sex, int age) {
        super(id, name, address, sex, age);
        specialization = "Neurology";
        can_cure.add("Meningitis");
        can_cure.add("Depression");
        can_cure.add("Headaches");
    }

    public String getSpecialization() {
        return specialization;
    }
}
