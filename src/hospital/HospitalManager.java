package hospital;

import person.Patient;

import java.util.ArrayList;

public class HospitalManager {
    /*
    Manages Multiple Hospitals
    */
    private ArrayList<Hospital> hospitals;

    public HospitalManager(){

    }

    public String addHospital(Hospital hospital){
        //Add Hospital to HospitalManager arraylist of Hospitals
        this.hospitals.add(hospital);
        return hospital.getName() + " has been added to this Hospital network.";
    }

    public String removeHospital(String hospitalName){
        //Remove Hospital with name hospitalName from hospitals
        for(Hospital h: hospitals){
            if(h.getName().equals(hospitalName)){
                hospitals.remove(h);
                return h.getName() + " has been removed from this Hospital network.";
            }
        }
        return "No Hospital with name: " + hospitalName + " in this Hospital network.";
    }

    public String transferPatient(Hospital from, Hospital to,  int patientID){
        //Transfers patient with patientID from from hospital to to hospital
        Patient p = from.dischargePatient(patientID);
        if(p != null){
            to.admitPatient(p);
            return p.getName() + " has been transferred from " + from.getName() + " to " + to.getName() + ".";
        }
        return "Patient with ID: " + patientID + " not found in Hospital " + from.getName() + ".";
    }
}
