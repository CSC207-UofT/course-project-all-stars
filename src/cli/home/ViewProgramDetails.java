package cli.home;

import cli.hospital.HospitalHomepage;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Fill in
 *
 * @author Ratantej
 * @version 2.0
 * @since 1.0
 */
public class ViewProgramDetails {

    public ViewProgramDetails() throws SQLException {

        System.out.println();
        System.out.println("The Hospital Management System designed by All Stars, is a state of the art patient " +
                "managemnet and diagnosis system for Hospitals and Doctors across the board designed for \n" +
                "improving their operational effecincy and reducing costs by automating patient managemnet. ");
        System.out.println();
        System.out.println("Designed amd Created By: Ratantej, Roa, Alessandro, Ernest, Euan, Shysta, Justice");
        System.out.println();
        System.out.println("CSC 207 Project by All Stars. Copyright 2021. All Rights Reserved");
        System.out.println();
        System.out.println("1. Go back");
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
                new Homepage();
        }
    }
}
