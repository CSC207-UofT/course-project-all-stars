package cli.hospital;

import hospital.Hospital;

import java.util.Scanner;
/**
 * A public class that displays the hospital details of the CLI.
 *
 * @author Ratantej and Justice
 * @version 2.0
 * @since 1.0
 */
public class HospitalDetails {
    Hospital hospital;

    public HospitalDetails(Hospital hospital) {
        this.hospital = hospital;
    }

    public void hospitalDetails()  {

        System.out.println();
        System.out.println("This hospital is named " + this.hospital.getName() + ".");
        System.out.println( this.hospital.getName() + " was founded in " + this.hospital.getFoundedWhen());
        System.out.println(this.hospital.getName() + " is currently serving " + this.hospital.getPatientsList().size()
        + " patients.");

        System.out.println();
        System.out.println("1. Go Back");
        System.out.println();
        int choice;
        while (true) {
            Scanner option = new Scanner(System.in);
            try {
                choice = option.nextInt();
            } catch (Exception e) {
                choice = -1;
            }
            if ((choice != 1)) {
                System.out.println("Invalid Input!");
            } else
                break;
        }
    }
}
