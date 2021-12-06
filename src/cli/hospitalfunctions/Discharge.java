package cli.hospitalfunctions;

import hospital.Hospital;
import person.Patient;


import java.util.Scanner;

public class Discharge {

    private static Hospital hospital;

    public Discharge(Hospital hospital)  {
        Discharge.hospital = hospital;

    }



    public static void discharge() {
        System.out.println("Select a Patient to Discharge:");
        for (Patient p : hospital.getPriorityTreatment().show_patientList()) {
            if (hospital.getPriorityTreatment().show_patientList().size() >= 1) {
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
                        hospital.getPriorityTreatment().delete_patient(p);
                        System.out.println("Patient Discharged");
                        System.out.println("1. Go Home");
                        while (true) {
                            Scanner option2 = new Scanner(System.in);
                            System.out.println("Select your option:");
                            choice = option2.nextInt();
                            if ((choice != 1)) {
                                System.out.println("Invalid Input!");
                            } else
                                break;
                        }
                        break;
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
                        break;
                }

            }
        }
    }
}
