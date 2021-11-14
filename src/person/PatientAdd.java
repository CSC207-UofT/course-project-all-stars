package person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import database.*;

public class PatientAdd {
    /**
     * Responsible for adding Patient object information into database
     */

    public static void addPatient(String name, String address, String sex, int age, int health, boolean insurance,
                                  String symptomA, String symptomB, String symptomC){
        /**
         * Method to add new Patient object into database.
         * @return void
         */
        PatientDatabaseText patientDatabaseText = new PatientDatabaseText();
        patientDatabaseText.writeData(name, address, sex, age, health, insurance, symptomA, symptomB, symptomC);

    }

}
