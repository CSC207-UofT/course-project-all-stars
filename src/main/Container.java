package main;

import java.util.ArrayList;

public abstract class Container {
    ArrayList<Patient> patientList;


    public Container() {
        this.patientList = new ArrayList<>();
    }

    public abstract void add(Patient item);

    public Patient delete(Patient patient) {
        patientList.remove(patient);
        return patient;
    }
    public Patient delete() {
        Patient x = patientList.get(0);
        patientList.remove(x);
        return x;
    }

    public boolean isEmpty() {
        return patientList.isEmpty();
    }

    public ArrayList<Patient> show() {
        return patientList;

    }
}
