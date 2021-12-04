package hospital;

import person.Patient;

import java.util.ArrayList;

public class HospitalManager {
    /*
    Manages Multiple Hospitals
     */
    ArrayList<Hospital> hospitals;

    public void addHospital(Hospital hospital){
        //Add Hospital to HospitalManager arraylist of Hospitals
        hospitals.add(hospital);
    }

    public String transferPatient(Hospital from, Hospital to,  int patientID){
        //Transfers patient with patientID from from hospital to to hospital
        for(Patient p: from.patientsList){
            if(p.getId() == patientID){
                from.dischargePatient(p);
                to.admitPatient(p);
                return p.getName() + " has been transferred from " + from.getName() + " to " + to.getName();
            }
        }
        return "Patient with ID: " + patientID + " not found in Hospital " + from.getName();
    }
}
