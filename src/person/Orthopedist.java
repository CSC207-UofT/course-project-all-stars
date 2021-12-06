package person;

public class Orthopedist extends Doctor{
    final private String specialization;
    public Orthopedist(int id, String name, String address, String sex, int age){
        super(id, name, address, sex, age);
        specialization = "Orthopedist";
        can_cure.add("Arthritis");
        can_cure.add("Osteoporosis");
        can_cure.add("Scoliosis");
        can_cure.add("Hip Fracture");
        can_cure.add("Fibromyalgia");
        can_cure.add("Torn Meniscus");
    }
    public String getSpecialization() {
        return specialization;
    }
}