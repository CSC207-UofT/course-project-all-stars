package container;

import person.Patient;

public class PriorityAdmission extends Container {

    public PriorityAdmission() {
        super();
    }

    public void add(Patient newPatient, Method priortization) throws InvocationTargetException, IllegalAccessException {
        //Patient with top priority at the start of the queue
        if (this.patientList.size() == 0) {
            this.patientList.add(person);
        }
        int i = 0;
        while (!this.patientList.contains(person)) {
            if (higherPriority_1(this.patientList.get(i), person)) {
                int num;
                num = this.patientList.indexOf(this.patientList.get(i));
                this.patientList.add(num, person);
            }
            else if ( i == this.patientList.size() - 1) {
                this.patientList.add(this.patientList.size(), person);
            }
            else {
                i += 1;
            }
        }
    }


    private boolean higherPriority_1(Patient p, Patient newPatient) {
        //Order by lowest HP and who got into the queue first for now
        //For ties, insurance status can be used
        //Might add infectious diseases too later to check for ties and other prioritising strategies
        if (p.health == newPatient.health){
            return !p.insurance & newPatient.insurance;
        }
    return p.health > newPatient.health;
    }

}
/* 1. Make an abstract Container class with add, remove, isEmpty methods.
Instance variables: Callable priority function (?? does it go here or in subclass??), initialise empty patient list
2. Two subclasses Priority_admission and priority_treatment which implement the methods above.
Priority_admission Add (takes one patient and the patient_list): Maybe based on a combination of urgency level, HP,
insurance (?). If list is empty, just add.
Write a for loop comparing with every patient
Priority_admission Remove: When the person has been admitted
Priority_treatment Add: Just on HP(?) If list is empty, just add.
Priority_treatment Remove: When the person is being treated(?)
3. Class with 2 priority sorting functions based on admission and treatment: takes two patients and returns a bool.
 */

