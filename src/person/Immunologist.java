package person;

//subclass of Doctor having Immunology as its specialization and that can cure Anaphylaxis and Covid.
public class Immunologist extends Doctor{
    final private String specialization;
    public Immunologist(int id, String name, String address, String sex, int age) {
        super(id, name, address, sex, age);
        specialization = "Immunology";
        can_cure.add("Anaphylaxis");
        can_cure.add("Covid");
    }

    //getter method
    public String getSpecialization() {
        return specialization;
    }
}
