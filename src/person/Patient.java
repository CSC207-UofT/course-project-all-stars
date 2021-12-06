package person;

import java.util.ArrayList;


//Subclass of person, it adds all the information needed in order for a person to be a patient, so it adds health points
//from 1 to 100, whether the person is currently admitted into any hospital, whether the person is insured and the symptoms
// that the person is experiencing and, if any, the diagnosis that the person received.

public class Patient extends Person {
    private boolean is_admitted;
    private int health;
    private final boolean insurance;
    private final ArrayList<String> symptoms_set;
    private String Diagnose;
    private Doctor doctor;

    //constructor method
    public Patient(int id, String name, String address, String sex, int age, int health, boolean insurance,
                   ArrayList<String> symptoms_set) {
        super(id, name, address, sex, age);
        this.is_admitted = false;
        this.health = health;
        this.insurance = insurance;
        this.symptoms_set = symptoms_set;
        this.Diagnose = "Not Yet Diagnosed";
    }

    // Getter Methods
    public boolean getIs_Admitted() {
        return is_admitted;
    }
    public String getName() {
        return super.getName();
    }
    public String getAddress() {
        return super.getAddress();
    }
    public String getSex() {
        return super.getSex();
    }
    public int getAge() {
        return super.getAge();
    }
    public int getHealth() {
        return health;
    }
    public boolean getInsurance(){
        return insurance;
    }
    public ArrayList<String> getSymptoms(){
        return this.symptoms_set;
    }
    public String getDiagnose(){
        return this.Diagnose;
    }
    public Doctor getDoctor() {
        return doctor;
    }

    //Setter Methods
    public void setHealth(int health){
        this.health = health;
    }

    public void setDiagnose(String disease){
        this.Diagnose = disease;
    }
    public void setIs_admitted(boolean is_admitted) {
        this.is_admitted = is_admitted;
    }

    public void setDoctor(Doctor d) {
        doctor = d;
    }
}