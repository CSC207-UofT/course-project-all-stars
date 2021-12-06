package person.DoctorTypes;

import person.Doctor;

//subclass of Doctor having Cardiology as its specialization and that can cure Heart Disease.
public class Cardiologist extends Doctor {

    public Cardiologist(int id, String name, String address, String sex, int age){
        super(id, name, address, sex, age);
        can_cure.add("Heart Disease");
        specialization = "Cardiologist";
    }

    public String getSpecialization() {
        return specialization;
    }
}
