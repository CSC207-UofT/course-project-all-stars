package person;

import javax.print.Doc;

public class Oncologist extends Doctor{

    final private String specialization;

    public Oncologist(String name, String address, String sex, int age){
        super(name, address, sex, age);
        specialization = "Oncology";
        can_cure.add("Cancer");
        can_cure.add("Fibroid Tumor");
        can_cure.add("Melanoma");
        can_cure.add("Malignant Neoplasm of Lung");
        can_cure.add("Breast Cancer");
    }

    public String getSpecialization() {
        return specialization;
    }

}
