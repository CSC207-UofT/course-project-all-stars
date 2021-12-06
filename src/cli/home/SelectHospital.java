package cli.home;

import cli.hospital.HospitalHomepage;
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
public class SelectHospital {

    public SelectHospital() throws SQLException {


        // Hospital Database
        HospitalDatabaseCloud hospital_database = new HospitalDatabaseCloud();

        // Output
        System.out.println();
        System.out.println("Please type in the name of a hospital you would like to select from the list below:");
        System.out.println();
        for (String name : hospital_database.listHospitals()) {
            System.out.println(name);
        }
        System.out.println();

        // User Input
        String choice;
        while (true) {
            Scanner option = new Scanner(System.in);
            System.out.println();
            choice = option.next();
            if (!hospital_database.listHospitals().contains(choice)) {
                System.out.println("Invalid Choice. Please try again.");
            } else
                break;
        }

        new HospitalHomepage(choice);

    }
}
