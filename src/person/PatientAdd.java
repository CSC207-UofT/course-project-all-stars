package person;

import database.DataInterfaceCloud;
import database.PatientDatabaseCloud;


public class PatientAdd {
    /**
     * Responsible for adding Patient object information into database
     */

    public static void addPatient(int id, String name, String address, String sex, int age, int health, boolean insurance,
                                  String symptomA, String symptomB, String symptomC){
        /**
         * Method to add new Patient object into database.
         * @return void
         */
        DataInterfaceCloud database = new PatientDatabaseCloud();
//        database(id, name, address, sex, age, health, insurance, symptomA, symptomB, symptomC);
//        database.writeData();

    }

}
