package Priority;

import person.Patient;

import java.util.ArrayList;

/** This is an abstract class that creates a PriorityQueue which controls the order in which Patients are admitted
 * to or treated at the hospital.
 * @author Shysta and Justice
 * @version 2.0
 * @since 1.0
 */

public abstract class Priority {

    ArrayList<Patient> patientList;

    /**
     * A constructor for the Priority Class.
     */
    public Priority() {
        this.patientList = new ArrayList<>();
    }

    /**
     Adds a patient to the Priority Queue patientList. This method makes use of the template design pattern.
     It instantiates an algorithm for dynamically ordering the patient's list in the PriorityQueue.
     */
    public void add_patient(Patient patient) {

        if (this.patientList.isEmpty()) {
            this.patientList.add(patient);
        }
        int i = 0;
        while (!this.patientList.contains(patient)) {
            if (higherPriority(this.patientList.get(i), patient)) {
                int num;
                num = this.patientList.indexOf(this.patientList.get(i));
                this.patientList.add(num, patient);
            }
            else if ( i == this.patientList.size() - 1) {
                this.patientList.add(this.patientList.size(), patient);
            }
            else {
                i += 1;
            }
        }
    }

    public abstract boolean higherPriority(Patient patient, Patient newPatient);


    /**
     Removes a patient from the hospital's list of patients by reference to the patient.
     @param patient patient to be removed from the hospital's collection of patients.
     @return the patient that was removed.
     */
    public Patient delete_patient(Patient patient) {
        patientList.remove(patient);
        return patient;
    }

    /**
     Removes the last patient from the list of patients.
     @return the patient that was removed.
     */
    public Patient delete_patient() {
        Patient x = patientList.get(0);
        patientList.remove(x);
        return x;
    }

    /**
     Checks whether the hospital's list of patients is empty.
     @return true if the list is empty and false if it is not.
     */
    public boolean isEmpty() {

        return patientList.isEmpty();
    }

    /**
     Returns a list containing all the patients in the priority queue in the hospital.
     @return a list containing all the patients in the priority queue in the hospital.
     */
    public ArrayList<Patient> show_patientList() {

        return patientList;

    }
}
