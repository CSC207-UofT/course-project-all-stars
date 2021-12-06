package cli.hospital;


import java.util.Scanner;

public class PatientDetails {



    public static void patientDetails()  {
        System.out.println("Coming Soon in Phase 2");
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
