package person;

public class Orthopedist extends Doctor{
    final private String specialization;
    public Orthopedist(int id, String name, String address, String sex, int age){
        super(id, name, address, sex, age);
        specialization = "Orthopedist";
        can_cure.add("Arthritis");
    }
    public String getSpecialization() {
        return specialization;
    }
}