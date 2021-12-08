package hospital;

import priority.Priority;
import person.Doctor;
import person.Patient;

import java.util.ArrayList;
/**
 * This is a public class that creates a Hospital Object.
 */

public class Hospital {
    private ArrayList<Patient> patientsList;
    private ArrayList<Doctor> doctorsList;
    private Priority admissionPriority;
    private Priority treatmentPriority;
    private String name; //Hospital names must be unique
    private int foundedWhen;
    private final int maxPatients = 10000;
    private final int maxDoctors = 1000;
    private ArrayList<Patient> admitedPatients = new ArrayList<>();
    private ArrayList<Patient> treatedPatients = new ArrayList<>();

    public Hospital(ArrayList<Patient> patientsList, ArrayList<Doctor> doctorsList, int numPatients,
                    Priority admissionPriority, Priority treatmentPriority, String name, int foundedWhen) {
        this.doctorsList = doctorsList;
        this.patientsList = patientsList;
        this.name = name;
        this.admissionPriority = admissionPriority;
        this.treatmentPriority = treatmentPriority;
        this.foundedWhen = foundedWhen;
    }
    /**
     * Determines if the patient has been diagno
     */
    public String admitPatient(Patient p) {
        if (patientsList.size() < maxPatients) {
            if(!p.getDiagnose().equals("Not Yet Diagnosed")){
                for(Doctor d: doctorsList) {
                    if (d.getCurables().contains(p.getDiagnose()) && !d.isFull()) {
                        this.admitedPatients.add(p);
                        p.setIs_admitted(true);
                        d.assignPatient(p);
                        p.setDoctor(d);
                        return "A new patient named " + p.getName() + " has been admitted! They have been assigned to " +
                                "Doctor " + p.getDoctor().getName() + ". Check back later in Discharge Menu to see if the " +
                                "patient is cured.";
                    }
                }
                return "No doctor found that can be assigned to this patient. Please try again later.";
            }
            return "This patients has not been diagnosed";
        }
        return "This Hospital is at max capacity";
    }


    /**
     * Adds patient with patientID to a list of treatedPatients and removes them from patientsList and
     * admittedPatients.
     *
     * Returns the removed patient if successful and returns null if no patient has patientID
    */
    public Patient dischargePatient(int patientID) {
        for(Patient p: this.patientsList){
            if(p.getId() == patientID){
                this.treatedPatients.add(p);
                this.patientsList.remove(p);
                this.admitedPatients.remove(p);
                return p;
            }
        }
        return null;
    }

    /**
     * Add a doctor to doctorsList if the hospital has room to hire another doctor
     *
     * Returns appropriate strings
     */
    public String hireDoctor(Doctor d) {
        if (doctorsList.size() < maxDoctors) {
            this.doctorsList.add(d);
            return "A new doctor named " + d.getName() + " has been hired";
        }
        return "This Hospital already has " + maxDoctors + " Doctors. No more can be hired";
    }

    // Getter functions
    public String getName(){
        return this.name;
    }
    public Priority getPriorityAdmission() { return this.admissionPriority; }
    public Priority getPriorityTreatment() { return this.treatmentPriority; }
    public ArrayList<Patient> getPatientsList() { return this.patientsList; }
    public ArrayList<Doctor> getDoctorsList() { return this.doctorsList; }
    public int getFoundedWhen() { return this.foundedWhen; }
    public ArrayList<Patient> getTreatedPatients(){ return this.treatedPatients; }
}

