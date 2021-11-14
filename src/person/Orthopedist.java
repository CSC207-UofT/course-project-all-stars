package person;

public class Orthopedist extends Doctor{

    public Orthopedist(String name, String address, String sex, int age){
        super(name, address, sex, age);
        specialization = "Orthopedist";
        can_cure.add("Arthritis");
    }
}