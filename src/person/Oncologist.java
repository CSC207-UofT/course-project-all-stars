package person;

import javax.print.Doc;

//subclass of Doctor having Oncology as its specialization and that can cure Cancer.
public class Oncologist extends Doctor{

    final private String specialization;

    //constructor
    public Oncologist(int id, String name, String address, String sex, int age){
        super(id, name, address, sex, age);
        specialization = "Oncology";
        can_cure.add("Cancer");
    }

    //getter method for specialization
    public String getSpecialization() {
        return specialization;
    }

}
