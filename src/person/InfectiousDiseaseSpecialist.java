package person;

//subclass of Doctor having Infectious diseases as its specialization and that can cure Malaria, Rabies, Polio.
public class InfectiousDiseaseSpecialist extends Doctor{
    final private String specialization;
    public InfectiousDiseaseSpecialist(int id, String name, String address, String sex, int age) {
        super(id, name, address, sex, age);
        specialization = "Infectious diseases";
        can_cure.add("Malaria");
        can_cure.add("Polio");
        can_cure.add("Rabies");
    }
    //getter method
    public String getSpecialization() {
        return specialization;
    }
}
