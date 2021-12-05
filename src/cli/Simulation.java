package cli;
import Priority.PriorityAdmission;
import Priority.PriorityTreatment;
import database.PatientDatabaseCloud;
import diagnosis.Diagnosis;
import hospital.Hospital;
import person.Patient;
import person.PatientArrayList;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public static ArrayList<Patient> patients;
    public static Hospital hospital;
    public static String hospital_name = "test_hospital";
    static {
        try {
            patients = PatientArrayList.constructPatient(hospital_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, InvocationTargetException, IllegalAccessException {
        home();
    }

    public static void home() throws SQLException, InvocationTargetException, IllegalAccessException {
        int choice;
        System.out.println("Welcome Doctor!" + "\n" + "Select one of the following menu options:");
        System.out.println("1. Treat Patient");
        System.out.println("2. Discharge Patient");
        System.out.println("3. View Patient Details");
        System.out.println("4. View Hospital Details");
        System.out.println("5. Add Patient");
        System.out.println("6. Quit");
        while (true) {
            Scanner option = new Scanner(System.in);
            System.out.println("Select your option:");
            choice = option.nextInt();
            if ((choice > 5 || choice < 1)) {
                System.out.println("Invalid Input!");
            } else
                break;
        }
        if (choice == 1) {
            new Treat(hospital);
            Treat.treat();
            home();
        } else if (choice == 2) {
            new Discharge(hospital);
            Discharge.discharge();
            home();
        } else if (choice == 3) {
            new PatientDetails();
            PatientDetails.patientDetails();
            home();
        } else if (choice == 4) {
            new HospitalDetails();
            HospitalDetails.hospitalDetails();
        } else if (choice == 5) {
            new AddPatient();
            AddPatient.addPatient();
        } else if (choice == 6) {
            System.out.println("Thanks for using HMS by All Stars Inc");
            System.exit(0);
        }
    }
}
