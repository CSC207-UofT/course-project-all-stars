package hospital;

import person.Doctor;
import person.Patient;

import java.util.ArrayList;

public class Hospital {
    ArrayList<Patient> patientsList;
    ArrayList<Doctor> doctorsList;
    int numRooms;
    String priorityProtocol;
    String name; //Hospital names must be unique
    int foundedWhen;

    public Hospital(ArrayList<Patient> patientsList, ArrayList<Doctor> doctorsList, int numRooms,
                    String priorityProtocol, String name, int foundedWhen) {
        this.doctorsList = doctorsList;
        this.patientsList = patientsList;
        this.numRooms = numRooms;
        this.name = name;
        this.priorityProtocol = priorityProtocol;
        this.foundedWhen = foundedWhen;
    }

    public String getName(){
        return name;
    }

    public String admitPatient(Patient p) {
        //Add a new patient and return a message
        patientsList.add(p);
        return "A new patient named " + p.getName() + " has been admitted!";
    }

    public Patient dischargePatient(int patientID) {
        //Remove a patient given a patientID and return the patient object or a null if the patientID was not found
        for(Patient p: patientsList){
            if(p.getId() == patientID){
                patientsList.remove(p);
                return p;
            }
        }
        return null;
    }

    public String hireDoctor(Doctor d) {
        //Add a new doctor to the doctorslist
        doctorsList.add(d);
        return "A new doctor named " + d.getName() + " has been hired";
    }

    public String getHospitalDetails() {
        //Return a short list of facts about the hospital
        return "This hospital," + " " +  this.name + " " + "founded in" + " " + this.foundedWhen + " " +
                "is currently treating" + " " + this.patientsList.size() + " " + "patients.";
    }

}

