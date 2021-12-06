package cli.home;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Fill out
 *
 * @author Ratantej
 * @version 2.0
 * @since 1.0
 */
public class Homepage {

    public Homepage() throws SQLException {

        int choice; //user select choice

        // Menu Options
        System.out.println();
        System.out.println("Welcome to All Stars Hospital Management System. Please select one of the following " +
                "menu options below:");
        System.out.println();
        System.out.println("1. Select Hospital");
        System.out.println("2. Create a New Hospital");
        System.out.println("3. Manage Hospital");
        System.out.println("4. View Program Details");
        System.out.println("5. Quit");

        //Checks for if the user entered a valid option
        while (true) {
            Scanner option = new Scanner(System.in);
            System.out.println();
            choice = option.nextInt();
            if ((choice > 5 || choice < 1)) {
                System.out.println("Invalid Choice. Please try again.");
            } else
                break;
        }

        // Option 1: Select Hospital
        if (choice == 1) {
            new SelectHospital();
        }
        // Option 2: Create new Hospital
        else if (choice == 2) {
            new CreateHospital();
        }
        // Option 3: Manage Hospital
        else if (choice == 3) {
            new ManageHospital();
        }
        // Option 4: View program details
        else if (choice == 4) {
            new ViewProgramDetails();
        }
        // Option 5: quit program
        else {
            System.out.println();
            System.out.println("Thank you for using Hospital Management System by All Stars");
            System.exit(0);
        }
    }
}


