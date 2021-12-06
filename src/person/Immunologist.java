package person;

public class Immunologist extends Doctor{
    final private String specialization;
    public Immunologist(String name, String address, String sex, int age) {
        super(name, address, sex, age);
        specialization = "Immunology";
        can_cure.add("Anaphylaxis");
        can_cure.add("Arthritis");
        can_cure.add("Covid");
        can_cure.add("Conjunctivitis");
        can_cure.add("Pancreatitis");
        can_cure.add("Lymphoma");
        can_cure.add("Neutropenia");
        can_cure.add("Cystic fibrosis");
    }

    public String getSpecialization() {
        return specialization;
    }
}
