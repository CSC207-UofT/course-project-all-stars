package main;

import java.util.ArrayList;

public class Hospital {
    ArrayList<Patient> patientsList;
    ArrayList<Doctor> doctorsList;
    int numRooms;
    String priorityProtocol;
    String name;
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


    public String getHospitalDetails() {
        return "This hospital," + " " +  this.name + " " + "founded in" + " " + this.foundedWhen + " " +
                "is currently treating" + " " + this.patientsList.size() + " " + "patients.";
    }

}

