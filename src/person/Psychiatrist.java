package person;

public class Psychiatrist extends Doctor{
    final private String specialization;

    public Psychiatrist(int id, String name, String address, String sex, int age){
        super(id, name, address, sex, age);
        specialization = "Psychiatry";
        can_cure.add("Depression");
    }

    public String getSpecialization() {
        return specialization;
    }
}
