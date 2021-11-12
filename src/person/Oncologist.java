package person;

import javax.print.Doc;

public class Oncologist extends Doctor{

    public Oncologist(String name, String address, String sex, int age){
        super(name, address, sex, age);
        specialization = "Oncology";
        can_cure.add("Cancer");
    }

}
