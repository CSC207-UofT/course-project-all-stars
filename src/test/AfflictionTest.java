package test;

import affliction.Affliction;
import affliction.AfflictionConstructor;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class AfflictionTest{

    //Test Affliction.java
    @Test
    public void testRead(){
        ArrayList<Affliction> x = AfflictionConstructor.afflictionsFromDatabase();
        for(Affliction affliction : x){
            System.out.println(affliction.getDiseaseName());
            System.out.println(affliction.getUrgencyLevel());
            System.out.println(affliction.getCureTime());
            System.out.println(affliction.getSymptom1());
            System.out.println(affliction.getSymptom2());
            System.out.println(affliction.getSymptom3());
        }
    }

    // Test Disease Data
    @Test
    public void test_disease_data(){
        ArrayList<String> symptoms = new ArrayList<>();
        symptoms.add("Loss of Taste and Smell");
        symptoms.add("Fever");
        symptoms.add("Cough");

        Hashtable<String, ArrayList<String>> disease_data = AfflictionConstructor.disease_data();
        ArrayList<String> covid = disease_data.get("Covid");
        assert covid.equals(symptoms);
    }

}