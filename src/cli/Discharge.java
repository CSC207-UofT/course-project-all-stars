package cli;

import person.Patient;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class Discharge extends Simulation {

    public static void main(String[] args) throws SQLException, InvocationTargetException, IllegalAccessException {
        home();
    }
    public static void discharge() throws SQLException, InvocationTargetException, IllegalAccessException {
        System.out.println("Select a Patient to Discharge:");
        for (Patient p : priorityTreatment.show_patientList()) {
            if (priorityTreatment.show_patientList().size() >= 1) {
                System.out.println("1. " + p.getName());
                int choice;
                while (true) {
                    Scanner option = new Scanner(System.in);
                    System.out.println("Select your option:");
                    choice = option.nextInt();
                    if ((choice > 2 || choice < 1)) {
                        System.out.println("Invalid Input!");
                    } else {
                        p.setIs_admitted(false);
                        priorityTreatment.delete_patient(p);
                        System.out.println("Patient Discharged");
                        System.out.println("1. Go Home");
                        int choice2;
                        while (true) {
                            Scanner option2 = new Scanner(System.in);
                            System.out.println("Select your option:");
                            choice = option.nextInt();
                            if ((choice != 1)) {
                                System.out.println("Invalid Input!");
                            } else
                                home();
                        }
                    }
                }
            } else {
                System.out.println("No Patients Ready to be Discharged");
                System.out.println("1. Go Back");
                int choice;
                while (true) {
                    Scanner option = new Scanner(System.in);
                    System.out.println("Select your option:");
                    choice = option.nextInt();
                    if ((choice != 1)) {
                        System.out.println("Invalid Input!");
                    } else
                        home();
                }

            }
        }
    }
}
