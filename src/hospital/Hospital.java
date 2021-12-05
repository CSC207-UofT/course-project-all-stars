package hospital;

import Priority.PriorityAdmission;
import Priority.PriorityTreatment;
import person.Doctor;
import person.Patient;

import java.util.ArrayList;

public class Hospital {
    ArrayList<Patient> patientsList;
    ArrayList<Doctor> doctorsList;
    int numRooms;
    PriorityAdmission priorityAdmission;
    PriorityTreatment priorityTreatment;
    String name;
    int foundedWhen;

    public Hospital(ArrayList<Patient> patientsList, ArrayList<Doctor> doctorsList, int numRooms,
                    PriorityAdmission priorityAdmission, PriorityTreatment priorityTreatment, String name,
                    int foundedWhen) {
        this.doctorsList = doctorsList;
        this.patientsList = patientsList;
        this.numRooms = numRooms;
        this.name = name;
        this.priorityAdmission = priorityAdmission;
        this.priorityTreatment = priorityTreatment;
        this.foundedWhen = foundedWhen;

    }

    public String getName(){
        return name;
    }

    public String admitPatient(Patient p) {
        patientsList.add(p);
        return "A new patient has been admitted!";

    }

    public void dischargePatient(Patient p) {
        patientsList.remove(p);
    }

    public String hireDoctor(Doctor d) {
        doctorsList.add(d);
        return "A new doctor has been hired!";
    }


//    The following function is made redundant by the getter functions I added. Will go back and remove it once I trace
//    where it's used'
    public String getHospitalDetails() {
        return "This hospital," + " " +  this.name + " " + "founded in" + " " + this.foundedWhen + " " +
                "is currently treating" + " " + this.patientsList.size() + " " + "patients.";
    }
    public ArrayList<Patient> getPatientsList() {return this.patientsList; }
    public ArrayList<Doctor> getDoctorsList(){return this.doctorsList;}
    public int getNumRooms(){return this.numRooms;}
    public String getHospitalName(){return this.name;}
    public PriorityAdmission getPriorityAdmission(){return this.priorityAdmission;}
    public PriorityTreatment getPriorityTreatment(){return this.priorityTreatment;}
    public int getFoundedWhen(){return this.foundedWhen; }

    // set methods

    public void setName(String name) {
        this.name = name;
    }
    public void setPatientsList(ArrayList<Patient> patientsList) {
        this.patientsList = patientsList;
    }
    public void setDoctorsList(ArrayList<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }
}

