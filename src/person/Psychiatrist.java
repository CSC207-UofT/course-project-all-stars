package person;

public class Psychiatrist extends Doctor{
    public Psychiatrist(String name, String address, String sex, int age){
        super(name, address, sex, age);
        specialization = "Psychiatry";
        can_cure.add("Depression");
    }
}
