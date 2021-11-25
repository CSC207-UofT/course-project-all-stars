package person;

public class InfectiousDiseaseSpecialist extends Doctor{
    final private String specialization;
    public InfectiousDiseaseSpecialist(String name, String address, String sex, int age) {
        super(name, address, sex, age);
        specialization = "Infectious disease";
        can_cure.add("Lyme disease");
        can_cure.add("Malaria");
        can_cure.add("Measles");
        can_cure.add("Polio");
        can_cure.add("Rabies");
        can_cure.add("Shingles");
        can_cure.add("Salmonella");
    }
}
