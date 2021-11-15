package person;

import java.util.HashSet;

public class Patient extends Person {
    boolean is_admitted;
    int health;
    boolean insurance;
    HashSet<String> symptoms_set;
    String Diagnose;

    public Patient(String name, String address, String sex, int age, int health, boolean insurance,
                   HashSet<String> symptoms_set) {
        super(name, address, sex, age);
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
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
    public int getHealth() {
        return health;
    }
    public boolean getInsurance(){
        return insurance;
    }
    public HashSet<String> getSymptoms(){
        return this.symptoms_set;
    }
    public String getDiagnose(){
        return this.Diagnose;
    }

    //Setter Method
    public void setDiagnose(String disease){
        this.Diagnose = disease;
    }
    public void setIs_admitted(boolean is_admitted) {
        this.is_admitted = is_admitted;
    }

}