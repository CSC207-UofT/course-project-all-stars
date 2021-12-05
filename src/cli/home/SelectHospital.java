package cli.home;

import cli.hospitalfunctions.HospitalHomepage;
import database.HospitalDatabaseCloud;

import java.sql.SQLException;
import java.util.Scanner;

public class SelectHospital {

    public SelectHospital() throws SQLException {


        // Hospital Database
        HospitalDatabaseCloud hospitaldatabse = new HospitalDatabaseCloud();

        // Output
        System.out.println();
        System.out.println("Please type in the name of a hospital you would like to select from the list below:");
        System.out.println();
        for(String name: hospitaldatabse.listHospitals()){
            System.out.println(name);
        }
        System.out.println();

        // User Input
        String choice;
        while (true) {
            Scanner option = new Scanner(System.in);
            System.out.println();
            choice = option.next();
            if (!hospitaldatabse.listHospitals().contains(choice)) {
                System.out.println("Invalid Choice. Please try again.");
            } else
                break;
        }

        new HospitalHomepage(choice);

    }
}
