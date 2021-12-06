package person;

public class Rheumatologist extends Doctor {
    final private String specialization;
    public Rheumatologist(String name, String address, String sex, int age) {
        super(name, address, sex, age);
        specialization = "Rheumatology";
        can_cure.add("Tuberculosis");
        can_cure.add("Bronchitis");
        can_cure.add("Fibromyalgia");
        can_cure.add("Strep Throat");
        can_cure.add("Asthma");
        can_cure.add("Upper Respiratory Infection");
        can_cure.add("Pneumonia");
    }
    public String getSpecialization() {
        return specialization;
    }
}
