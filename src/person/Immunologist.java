package person;

public class Immunologist extends Doctor{
    final private String specialization;
    public Immunologist(int id, String name, String address, String sex, int age) {
        super(id, name, address, sex, age);
        specialization = "Immunology";
        can_cure.add("Anaphylaxis");
        can_cure.add("Arthritis");
        can_cure.add("Seasonal Flu");
        can_cure.add("Conjunctivitis");
    }

    public String getSpecialization() {
        return specialization;
    }
}
