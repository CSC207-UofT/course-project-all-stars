package person;

import database.PatientDatabaseCloud;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Random.*;
import java.util.HashMap.*;

import static java.util.Collections.sort;

public class PatientsFactory {

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

    public ArrayList<Patient> createPatients(int numberOfPatients) throws SQLException {
        PatientDatabaseCloud database = new PatientDatabaseCloud();
        ResultSet dataset = database.readData();
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Integer> lines = getRandom(numberOfPatients);
        HashMap<Integer, ArrayList<Integer>> AgeAndHealthHashMap = getPatientAgeAndHealthHashmap(dataset);
        HashMap<Integer, ArrayList<String>> SymptomsSetHashMap = getPatientSymptomsSetHashMap(dataset);
        HashMap<Integer, ArrayList<String>> NameAddressSexInsuranceHashMap = getPatientNameAddressSexInsuranceHashMap(dataset);
        for (int lineNumber : lines) {
            boolean is_insured = NameAddressSexInsuranceHashMap.get(lineNumber).get(3).equals("true");
            patients.add(new Patient(NameAddressSexInsuranceHashMap.get(lineNumber).get(0), NameAddressSexInsuranceHashMap.get(lineNumber).get(1),
                    NameAddressSexInsuranceHashMap.get(lineNumber).get(2), AgeAndHealthHashMap.get(lineNumber).get(0),
                    AgeAndHealthHashMap.get(lineNumber).get(1), is_insured, SymptomsSetHashMap.get(lineNumber)));
        }
        return patients;
    }
    public HashMap<Integer, ArrayList<String>> getPatientNameAddressSexInsuranceHashMap(ResultSet dataset)
            throws SQLException {
        HashMap<Integer, ArrayList<String>> PatientInfo = new HashMap<>();
        int index = 0;
        while (dataset.next()) {
            ArrayList<String> PatientNameAddressArray = getPatientNameAddressSexInsurance(dataset);
            PatientInfo.put(index, PatientNameAddressArray);
            index = index + 1;
        }
        return PatientInfo;
    }

    private ArrayList<String> getPatientNameAddressSexInsurance(ResultSet dataset) throws SQLException {
        ArrayList<String> patientInfo = new ArrayList<>();
        patientInfo.add(dataset.getString(1)); //name
        patientInfo.add(dataset.getString(2)); //address
        patientInfo.add(dataset.getString(3)); //sex
        patientInfo.add(dataset.getString(6)); //insurance (true or false)
        return patientInfo;
    }

    private ArrayList<Integer> getPatientAgeAndHealthPoints(ResultSet dataset) throws SQLException {
        ArrayList<Integer> patientInfo = new ArrayList<>();
        patientInfo.add(dataset.getInt(4)); //age
        patientInfo.add(dataset.getInt(5)); //healthPoints
        return patientInfo;
    }

    private HashMap<Integer, ArrayList<Integer>> getPatientAgeAndHealthHashmap(ResultSet dataset) throws SQLException {
        HashMap<Integer, ArrayList<Integer>> PatientInfo = new HashMap<>();
        int index = 0;
        while (dataset.next()) {
            ArrayList<Integer> PatientAgeAndHealthArray = getPatientAgeAndHealthPoints(dataset);
            PatientInfo.put(index, PatientAgeAndHealthArray);
            index = index + 1;
        }
        return PatientInfo;
    }

    private HashMap<Integer, ArrayList<String>> getPatientSymptomsSetHashMap(ResultSet dataset) throws SQLException {
        HashMap<Integer, ArrayList<String>> PatientInfo = new HashMap<>();
        int index = 0;
        while (dataset.next()) {
            ArrayList<String> PatientSymptomsSet = getSymptomsSet(dataset);
            PatientInfo.put(index, PatientSymptomsSet);
            index = index + 1;
        }
        return PatientInfo;
    }

    private ArrayList<String> getSymptomsSet(ResultSet dataset) throws SQLException {
        ArrayList<String> symptoms_set = new ArrayList<>();
        symptoms_set.add(dataset.getString(7));
        symptoms_set.add(dataset.getString(8));
        symptoms_set.add(dataset.getString(9));
        return symptoms_set;
    }

}