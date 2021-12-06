package hospital;

import Priority.Priority;
import person.Doctor;
import person.Patient;

import java.util.ArrayList;
/**
 * This is a public class that creates a Hospital Object.
 *
 * @author Shysta and Justice
 * @version 2.0
 * @since 1.0
 */

public class Hospital {
    ArrayList<Patient> patientsList;
    ArrayList<Doctor> doctorsList;
    int numRooms;
    Priority admissionPriority;
    Priority treatmentPriority;
    String name; //Hospital names must be unique
    int foundedWhen;

    public Hospital(ArrayList<Patient> patientsList, ArrayList<Doctor> doctorsList, int numRooms,
                    Priority admissionPriority, Priority treatmentPriority, String name, int foundedWhen) {
        this.doctorsList = doctorsList;
        this.patientsList = patientsList;
        this.numRooms = numRooms;
        this.name = name;
        this.admissionPriority = admissionPriority;
        this.treatmentPriority = treatmentPriority;
        this.foundedWhen = foundedWhen;
    }
    /**
     * Removes a patient from the priority queue of patients by reference to the patient.
     *
     * @param p patient to be admitted to the hospital.
     * @return A string indicating the patient was added.
     */

    public String admitPatient(Patient p) {
        //Admits a Patient to this Hospital, diagnoses the Patient and assigns them to a doctor
        this.patientsList.add(p);
        p.setIs_admitted(true);
        if(!p.getDiagnose().equals("Not Yet Diagnosed"))
            for(Doctor d: doctorsList){
                if(d.getCurables().contains(p.getDiagnose()) && !d.isFull()){
                    d.assignPatient(p);
                    p.setDoctor(d);
                }
            }
        return "A new patient named " + p.getName() + " has been admitted! They have been assigned to " + p.getDoctor().getName();
    }
    /**
     * Removes a patient from the priority queue of patients by reference to the patient.
     *
     * @param patientID ID of a patient to be removed from the list.
     * @return A string indicating the patient was added.
     */
    public Patient dischargePatient(int patientID) {
        for(Patient p: this.patientsList){
            if(p.getId() == patientID){
                this.patientsList.remove(p);
                return p;
            }
        }
        return null;
    }

    /**
     * Removes a patient from the priority queue of patients by reference to the patient.
     *
     * @param d A doctor to be hired.
     * @return A string indicating the doctor was hired.
     */

    public String hireDoctor(Doctor d) {
        this.doctorsList.add(d);
        return "A new doctor named " + d.getName() + " has been hired";
    }

    // Getter functions
    public String getName(){
        return this.name;
    }
    public Priority getPriorityAdmission() { return this.admissionPriority; }
    public Priority getPriorityTreatment() { return this.treatmentPriority; }
    public int getNumRooms() { return this.numRooms; }
    public ArrayList<Patient> getPatientsList() { return this.patientsList; }
    public ArrayList<Doctor> getDoctorsList() { return this.doctorsList; }
    public int getFoundedWhen() { return this.foundedWhen; }
}

