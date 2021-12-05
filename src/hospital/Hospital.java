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
    /**
     * Removes a patient from the priority queue of patients by reference to the patient.
     *
     * @param p patient to be admitted to the hospital.
     * @return A string indicating the patient was added.
     */

    public String admitPatient(Patient p) {
        this.patientsList.add(p);
        return "A new patient named " + p.getName() + " has been admitted!";
    }

    public Patient dischargePatient(int patientID) {
        for(Patient p: this.patientsList){
            if(p.getId() == patientID){
                this.patientsList.remove(p);
                return p;
            }
        }
        return null;
    }

    public String hireDoctor(Doctor d) {
        this.doctorsList.add(d);
        return "A new doctor named " + d.getName() + " has been hired";
    }

    public String getHospitalDetails() {
        //Return a short list of facts about the hospital
        return "This hospital," + " " +  this.name + " " + "founded in" + " " + this.foundedWhen + " " +
                "is currently treating" + " " + this.patientsList.size() + " " + "patients.";
    }

}

