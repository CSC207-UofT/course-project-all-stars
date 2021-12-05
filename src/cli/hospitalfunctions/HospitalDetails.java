package cli.hospitalfunctions;

import hospital.Hospital;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
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

    public void hospitalDetails() throws SQLException, InvocationTargetException, IllegalAccessException {

        System.out.println("This hospital is named " + this.hospital.getName() + ".");
        System.out.println( this.hospital.getName() + " was founded in " + this.hospital.getFoundedWhen());
        System.out.println(this.hospital.getName() + "has" + this.hospital.getNumRooms());
        System.out.println(this.hospital.getName() + " is currently serving " + this.hospital.getPatientsList().size()
        + " patients.");

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
