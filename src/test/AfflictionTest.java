package test;

import affliction.Affliction;
import affliction.AfflictionConstructor;
import org.junit.Test;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class AfflictionTest{

    //Test Affliction.java
    @Test
    public void testRead() throws SQLException {
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
    public void test_disease_data() throws SQLException {
        HashSet<String> set = new HashSet<String>();
        set.add("Loss of Taste and Smell");
        set.add("Fever");
        set.add("Cough");

        Hashtable<String, Set> disease_data = AfflictionConstructor.disease_data();
        Set<String> covid = disease_data.get("Covid");
        assert covid.equals(set);
    }

}