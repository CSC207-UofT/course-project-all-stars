package cli;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class PatientDetails extends Simulation {

    public static void main(String[] args) throws SQLException, InvocationTargetException, IllegalAccessException {
        home();
    }

    public static void patient_details() throws SQLException, InvocationTargetException, IllegalAccessException {
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
                home();
        }
    }
}
