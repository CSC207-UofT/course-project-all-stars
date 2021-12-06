package hospital;

import database.hospitalDatabase.HospitalCloudInterface;
import database.hospitalDatabase.HospitalDatabaseCloud;
import database.patientDatabase.PatientCloudInterface;
import database.patientDatabase.PatientDatabaseCloud;
import person.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static hospital.DoctorsFactory.getIntegers;

public class PatientsFactory {

    private static ArrayList<Integer> getRandom(int n) {
        // populating array list with numbers in the range [1, 10^4]
        ArrayList<Integer> numbersArray = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            numbersArray.add(i);
        }
        // populating new array with desired number of random elements n
        return getIntegers(n, numbersArray);
    }

    public static ArrayList<Patient> loadPatients(String hospital_name) throws SQLException {

        HospitalCloudInterface hospital = new HospitalDatabaseCloud();
        ResultSet dataset = hospital.readPatientData(hospital_name);
        ArrayList<Patient> patientArrayList = new ArrayList<>();

        while(dataset.next()){ // Continue accessing data until end of database
            int id = dataset.getInt(1);
            String name = dataset.getString(2);
            String address = dataset.getString(3);
            String sex = dataset.getString(4);
            int age = dataset.getInt(5);
            int health = dataset.getInt(6);
            boolean insurance = dataset.getBoolean(7);
            ArrayList<String> symptoms_set = new ArrayList<>();
            symptoms_set.add(dataset.getString(8));
            symptoms_set.add(dataset.getString(9));
            symptoms_set.add(dataset.getString(10));
            patientArrayList.add(new Patient(id, name, address, sex, age, health, insurance, symptoms_set));
        }
        return patientArrayList;

    }

    public static ArrayList<Patient> createPatients(int numberOfPatients) throws SQLException {
        PatientCloudInterface database = new PatientDatabaseCloud();
        ResultSet dataset = database.readData();
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Integer> lines = getRandom(numberOfPatients);
        HashMap<Integer, ArrayList<Integer>> AgeHealthIdMap = getPatientAgeHealthIdHashmap(dataset);
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
    public static HashMap<Integer, ArrayList<String>> getPatientNameAddressSexInsuranceHashMap(ResultSet dataset)
            throws SQLException {
        HashMap<Integer, ArrayList<String>> PatientInfo = new HashMap<>();
        int index = 0;
        while (dataset.next()) {
            ArrayList<String> PatientNameAddressArray = getPatientNameAddressSexInsurance(dataset);
            PatientInfo.put(index, PatientNameAddressArray);
            index = index + 1;
        }
        dataset.beforeFirst();
        return PatientInfo;
    }

    private static ArrayList<String> getPatientNameAddressSexInsurance(ResultSet dataset) throws SQLException {
        ArrayList<String> patientInfo = new ArrayList<>();
        patientInfo.add(dataset.getString(2)); //name
        patientInfo.add(dataset.getString(3)); //address
        patientInfo.add(dataset.getString(4)); //sex
        patientInfo.add(dataset.getString(7)); //insurance (true or false)
        return patientInfo;
    }

    private static ArrayList<Integer> getPatientAgeHealthPointsAndId(ResultSet dataset) throws SQLException {
        ArrayList<Integer> patientInfo = new ArrayList<>();
        patientInfo.add(dataset.getInt(5)); //age
        patientInfo.add(dataset.getInt(6)); //healthPoints
        patientInfo.add(dataset.getInt(1)); //Id
        return patientInfo;
    }

    private static HashMap<Integer, ArrayList<Integer>> getPatientAgeHealthIdHashmap(ResultSet dataset) throws SQLException {
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

    private static HashMap<Integer, ArrayList<String>> getPatientSymptomsSetHashMap(ResultSet dataset) throws SQLException {
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

    private static ArrayList<String> getSymptomsSet(ResultSet dataset) throws SQLException {
        ArrayList<String> symptoms_set = new ArrayList<>();
        symptoms_set.add(dataset.getString(8));
        symptoms_set.add(dataset.getString(9));
        symptoms_set.add(dataset.getString(10));
        return symptoms_set;
    }

}