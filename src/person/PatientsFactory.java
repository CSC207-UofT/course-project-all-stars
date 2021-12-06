package person;

import database.DataInterfaceCloud;
import database.PatientDatabaseCloud;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

//This class is used to create a specific amount of patients that can go up to 10000.
public class PatientsFactory {

    //returns n random integers from the 10000 possible lines
    private ArrayList<Integer> getRandom(int n) {
        // populating array list with numbers in the range [1, 10^4]
        ArrayList<Integer> numbersArray = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            numbersArray.add(i);
        }
        // populating new array with desired number of random elements n
        ArrayList<Integer> copyArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pick = (int) (Math.random() * numbersArray.size());
            copyArray.add(numbersArray.get(pick));
            numbersArray.remove(pick);
        }
        return copyArray;
    }

    //method that returns numberOfPatients different patients
    public ArrayList<Patient> createPatients(int numberOfPatients) throws SQLException {
        DataInterfaceCloud database = new PatientDatabaseCloud(); //database containing patients' info
        ResultSet dataset = database.readData();
        ArrayList<Patient> patients = new ArrayList<>();  //list of patient that needs to be populated
        ArrayList<Integer> lines = getRandom(numberOfPatients); //random distinct lines from which patients info are gonna be picked.
        HashMap<Integer, ArrayList<Integer>> AgeHealthIdMap = getPatientAgeHealthIdHashmap(dataset); //hashmaps mapping line number in database to info
        HashMap<Integer, ArrayList<String>> SymptomsSetMap = getPatientSymptomsSetHashMap(dataset);
        HashMap<Integer, ArrayList<String>> NameAddressSexInsuranceMap = getPatientNameAddressSexInsuranceHashMap(dataset);
        for (int lineNumber : lines) {
            boolean is_insured = NameAddressSexInsuranceMap.get(lineNumber).get(3).equals("true");
            patients.add(new Patient(AgeHealthIdMap.get(lineNumber).get(2),
                    NameAddressSexInsuranceMap.get(lineNumber).get(0),
                    NameAddressSexInsuranceMap.get(lineNumber).get(1),
                    NameAddressSexInsuranceMap.get(lineNumber).get(2),
                    AgeHealthIdMap.get(lineNumber).get(0), AgeHealthIdMap.get(lineNumber).get(1),
                    is_insured, SymptomsSetMap.get(lineNumber)));
        }
        return patients;
    }

    //Method getting hashmap mapping row number in data set to arraylist containing Name,Address,Sex and insurance of the patient.
    private HashMap<Integer, ArrayList<String>> getPatientNameAddressSexInsuranceHashMap(ResultSet dataset)
            throws SQLException {
        HashMap<Integer, ArrayList<String>> PatientInfo = new HashMap<>();
        int index = 0;
        //will iterate through whole dataset
        while (dataset.next()) {
            ArrayList<String> PatientNameAddressArray = getPatientNameAddressSexInsurance(dataset);
            PatientInfo.put(index, PatientNameAddressArray);
            index = index + 1;
        }
        //sends dataset back to beginning:
        dataset.beforeFirst();
        return PatientInfo;
    }

    //
    private ArrayList<String> getPatientNameAddressSexInsurance(ResultSet dataset) throws SQLException {
        ArrayList<String> patientInfo = new ArrayList<>();
        patientInfo.add(dataset.getString(2)); //name
        patientInfo.add(dataset.getString(3)); //address
        patientInfo.add(dataset.getString(4)); //sex
        patientInfo.add(dataset.getString(7)); //insurance (true or false)
        return patientInfo;
    }

    private ArrayList<Integer> getPatientAgeHealthPointsAndId(ResultSet dataset) throws SQLException {
        ArrayList<Integer> patientInfo = new ArrayList<>();
        patientInfo.add(dataset.getInt(5)); //age
        patientInfo.add(dataset.getInt(6)); //healthPoints
        patientInfo.add(dataset.getInt(1)); //Id
        return patientInfo;
    }

    //creates hashmap mapping row numbers to the patient's age, health and id.
    private HashMap<Integer, ArrayList<Integer>> getPatientAgeHealthIdHashmap(ResultSet dataset) throws SQLException {
        HashMap<Integer, ArrayList<Integer>> PatientInfo = new HashMap<>();
        int index = 0;
        while (dataset.next()) {
            ArrayList<Integer> PatientAgeAndHealthArray = getPatientAgeHealthPointsAndId(dataset);
            PatientInfo.put(index, PatientAgeAndHealthArray);
            index = index + 1;
        }
        dataset.beforeFirst();
        return PatientInfo;
    }
    //creates hashmap mapping row numbers to symptoms sets.
    private HashMap<Integer, ArrayList<String>> getPatientSymptomsSetHashMap(ResultSet dataset) throws SQLException {
        HashMap<Integer, ArrayList<String>> PatientInfo = new HashMap<>();
        int index = 0;
        while (dataset.next()) {
            ArrayList<String> PatientSymptomsSet = getSymptomsSet(dataset);
            PatientInfo.put(index, PatientSymptomsSet);
            index = index + 1;
        }
        dataset.beforeFirst();
        return PatientInfo;
    }

    //creates symptoms set from info contained in the row at which the dataset is
    private ArrayList<String> getSymptomsSet(ResultSet dataset) throws SQLException {
        ArrayList<String> symptoms_set = new ArrayList<>();
        symptoms_set.add(dataset.getString(8));
        symptoms_set.add(dataset.getString(9));
        symptoms_set.add(dataset.getString(10));
        return symptoms_set;
    }

}