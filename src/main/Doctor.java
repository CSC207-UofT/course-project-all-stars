package main;

public class Doctor extends Person {
    String specialization;

    public Doctor(String name, String address, String sex, int age) {
        super(name, address, sex, age);
    }

    public Doctor(String name, String address, String sex, int age, String specialization) {
        super(name, address, sex, age);
        this.specialization = specialization;
    }

    public boolean treatPatient(Patient p) {
        if (p.getIs_Admitted()) {
            p.health = 100;
            return true;
        }
        else {
            return false;
        }
    }
}
