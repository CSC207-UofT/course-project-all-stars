package person;

public class Cardiologist extends Doctor{
    final private String specialization;

    public Cardiologist(int id, String name, String address, String sex, int age){
        super(id, name, address, sex, age);
        specialization = "Cardiology";
        can_cure.add("Heart Disease");
    }

    public String getSpecialization() {
        return specialization;
    }
}
