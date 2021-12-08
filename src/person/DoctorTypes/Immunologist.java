package person.DoctorTypes;

import person.Doctor;

//subclass of Doctor having Immunology as its specialization and that can cure Anaphylaxis and Covid.
public class Immunologist extends Doctor {

    public Immunologist(int id, String name, String address, String sex, int age) {
        super(id, name, address, sex, age);
        setSpecialization("Immunologist");
        can_cure.add("Anaphylaxis");
        can_cure.add("Covid");
    }
}
