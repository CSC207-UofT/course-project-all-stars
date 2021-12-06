package hospital;

import database.doctorDatabase.DoctorCloudInterface;
import database.doctorDatabase.DoctorDatabaseCloud;
import database.hospitalDatabase.HospitalCloudInterface;
import database.hospitalDatabase.HospitalDatabaseCloud;
import person.*;
import person.DoctorTypes.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

//This class is used to generate a specific amount of random doctors (so instances of Doctor or of subclasses of doctor)
// from a dataset,
public class DoctorsFactory {

    //this will return n random numbers from 1 to 1000
    private static ArrayList<Integer> getRandomLines(int n) {
        // populating array list with numbers in the range [1, 10^3]
        ArrayList<Integer> numbersArray = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
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

    public static ArrayList<Doctor> loadDoctors(String hospital_name) throws SQLException {

        HospitalCloudInterface hospital = new HospitalDatabaseCloud();
        ResultSet dataset = hospital.readDoctorData(hospital_name);
        ArrayList<Doctor> doctorArrayList = new ArrayList<Doctor>();

        while(dataset.next()){ // Continue accessing data until end of database
            int id = dataset.getInt(1);
            String name = dataset.getString(2);
            String address = dataset.getString(3);
            String sex = dataset.getString(4);
            int age = dataset.getInt(5);
            String specialization = dataset.getString(6);
            doctorArrayList.add(doctorCreator(specialization, name, address, sex, id, age));
        }
        return doctorArrayList;
    }

    //this creates numberOfDocs different doctors.
    public static ArrayList<Doctor> createDoctors() throws SQLException {
        int numberOfDocs = 25;
        DoctorCloudInterface database = new DoctorDatabaseCloud();
        ResultSet dataset = database.readData();//reads data and creates dataset
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Integer> lines = getRandomLines(numberOfDocs); //gets random lines
        HashMap<Integer, ArrayList<Integer>> AgeIdMap = getPatientAgeIdHashmap(dataset);
        HashMap<Integer, ArrayList<String>> NameAddressSexDoctorMap = getPatientNameAddressSexDoctorHashMap(dataset);
        for(int lineNumber : lines) {
            doctors.add(doctorCreator(NameAddressSexDoctorMap.get(lineNumber).get(3), NameAddressSexDoctorMap.get(lineNumber).get(0),
                    NameAddressSexDoctorMap.get(lineNumber).get(1), NameAddressSexDoctorMap.get(lineNumber).get(2),
                    AgeIdMap.get(lineNumber).get(1), AgeIdMap.get(lineNumber).get(0)));
        }
        return doctors;
    }

    //creates the instance of doctor.
    public static Doctor doctorCreator(String typeOfDoctor, String name, String address, String sex, int id, int age){
        return switch (typeOfDoctor) {
            case "Immunologist" -> new Immunologist(id, name, address, sex, age);
            case "Oncologist" -> new Oncologist(id, name, address, sex, age);
            case "Orthopedist" -> new Orthopedist(id, name, address, sex, age);
            case "Rheumatologist" -> new Rheumatologist(id, name, address, sex, age);
            case "Doctor" -> new Doctor(id, name, address, sex, age);
            case "Psychiatrist" -> new Psychiatrist(id, name, address, sex, age);
            case "Infectious" -> new InfectiousDiseaseSpecialist(id, name, address, sex, age);
            case "Cardiologist" -> new Cardiologist(id, name, address, sex, age);
            default -> new Neurologist(id, name, address, sex, age);
        };
    }

    //creates hashmap mapping row index to the doctor's name, address,sex and doctor type at that line.
    private static HashMap<Integer, ArrayList<String>> getPatientNameAddressSexDoctorHashMap(ResultSet dataset) throws SQLException {
        HashMap<Integer, ArrayList<String>> DocInfo = new HashMap<>();
        int index = 0;
        while (dataset.next()) {
            ArrayList<String> PatientNameAddressArray = getPatientNameAddressSexDoctor(dataset);
            DocInfo.put(index, PatientNameAddressArray);
            index = index + 1;
        }
        dataset.beforeFirst();
        return DocInfo;
    }


    //returns arraylist containing name address sex and doctor type stored at that row index
    private static ArrayList<String> getPatientNameAddressSexDoctor(ResultSet dataset) throws SQLException {
        ArrayList<String> patientInfo = new ArrayList<>();
        patientInfo.add(dataset.getString(2)); //name
        patientInfo.add(dataset.getString(3)); //address
        patientInfo.add(dataset.getString(4)); //sex
        patientInfo.add(dataset.getString(6)); //doctor type
        return patientInfo;
    }

    //creates hashmap mapping row index to age and id of the patient at that line
    private static HashMap<Integer, ArrayList<Integer>> getPatientAgeIdHashmap(ResultSet dataset) throws SQLException {
        HashMap<Integer, ArrayList<Integer>> DocInfo = new HashMap<>();
        int index = 0;
        while (dataset.next()) {
            ArrayList<Integer> PatientAgeAndHealthArray = getPatientAgeId(dataset);
            DocInfo.put(index, PatientAgeAndHealthArray);
            index = index + 1;
        }
        dataset.beforeFirst();
        return DocInfo;
    }

    //reads age and id in the row that is being read
    private static ArrayList<Integer> getPatientAgeId(ResultSet dataset) throws SQLException {
        ArrayList<Integer> doctorInfo = new ArrayList<>();
        doctorInfo.add(dataset.getInt(5)); //age
        doctorInfo.add(dataset.getInt(1)); //Id
        return doctorInfo;
    }
}
