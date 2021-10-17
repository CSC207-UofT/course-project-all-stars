package main;

import java.util.Scanner;

public class CommandLineInterface {
    public CommandLineInterface() {
        this.Launch();

    }
    public void Launch() {
        System.out.println(" ****************\nWelcome to HMS!\n ****************\n");
        System.out.println("We’re glad you’re here. This is your hospital management system\n");
        System.out.println("Type 'Treat' to see a list of commands available to treat patients: \n");
        String message = getInput();
        switch(message){
          case "Treat":
            DisplayMainMenu();
            break;
          default:
            System.out.println("Quit the app");
        }
        String newt = getInput();
        switch(newt){
          case "Treat patients":
            DisplayTreatment();
            break;
          case "Discharge patients":
            DisplayDischarge();
            break;
          /* 
          case "View patient details":
          case "View hospital details":
          */
          default:
            System.out.println("Quit the app");
        }
    }


    public String getInput () {
        System.out.print("\n> ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine(); 
    }
    public void sendOutput(String out) {
        System.out.println(out);
    }

    public void DisplayMainMenu() {
        sendOutput("Treat patients");
        sendOutput("Discharge patients");
        sendOutput("View patient details");
        sendOutput("View hospital details");
        sendOutput("Quit the app\n");
    }

    public void DisplayTreatment() {
        sendOutput("Diagnose");
        sendOutput("Next Patient");
        sendOutput("Back\n");
    }

    public void DisplayDischarge() {
        sendOutput("Patient discharged");
    }


    public static void main(final String[] sta){
        if (sta.length < 1)
        {
            CommandLineInterface cmdli = new CommandLineInterface();       
        }

    }
}
