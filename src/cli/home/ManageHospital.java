package cli.home;

import database.hospitalDatabase.HospitalCloudInterface;
import database.hospitalDatabase.HospitalDatabaseCloud;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Fill in
 *
 * @author Ratantej
 * @version 2.0
 * @since 1.0
 */
public class ManageHospital {

    public ManageHospital() throws SQLException {

        HospitalCloudInterface database = new HospitalDatabaseCloud();

        System.out.println();
        System.out.println("Type in the name of the hospital you would like to delete from the list:");
        System.out.println();
        for (String name : database.listHospitals()) {
            System.out.println(name);
        }
        System.out.println();

        // User Input
        String choice;
        while (true) {
            Scanner option = new Scanner(System.in);
            System.out.println();
            choice = option.next();
            if (!database.listHospitals().contains(choice)) {
                System.out.println("Invalid Choice. Please try again.");
            } else
                break;
        }

        database.deleteHospital(choice);
        System.out.println();
        if (!database.listHospitals().contains(choice)) {
            System.out.println("Hospital Deleted Successfully");
        }
        else
            System.out.println("404. Ops Something went wrong. Please try again later");

        System.out.println();
        System.out.println("1. Go Back");
        System.out.println();
        int choice2;
        while (true) {
            Scanner option = new Scanner(System.in);
            choice2 = option.nextInt();
            if ((choice2 != 1)) {
                System.out.println("Invalid Input!");
            } else
                new Homepage();
        }
    }

}
