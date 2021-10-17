package test;

import main.Affliction;
import main.Patient;
import org.junit.Test;


import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PatientTest{

    //Test Patient.java
    @Test
    public void testRead(){
        ArrayList<Patient> x = Patient.constructPatient();
        for(Patient patient : x){
            System.out.println(patient.getName());
            System.out.println(patient.getAddress());
            System.out.println(patient.getSex());
            System.out.println(patient.getAge());
            System.out.println(patient.getIs_Admitted());
            System.out.println(patient.getHealth());
            System.out.println(patient.getInsurance());
            System.out.println(patient.getSymptoms());
        }
    }


}