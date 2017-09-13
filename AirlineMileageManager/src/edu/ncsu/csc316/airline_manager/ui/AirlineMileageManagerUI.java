package edu.ncsu.csc316.airline_manager.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.manager.AirlineMileageManager;

/**
 * This class is what the user interacts with. It handles user input and outputs
 * what it's prompted for.
 * 
 * @author Caitlyn Wiley
 *
 */
public class AirlineMileageManagerUI {
    
    /**
     * Prompts user for input files, reads them in, then prompts user to choose
     * an option from a menu and handles the request
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main(String[] args) {
        System.out.println(
                "Welcome to AirlineMileageManager! To get started, please enter the airline "
                        + "filename: ");
        Scanner in = new Scanner(System.in);
        String airlineFilename = in.next();
        Scanner fakeScanner = null;
        while (fakeScanner == null) {
            try {
                fakeScanner = new Scanner(new File(airlineFilename));
            } catch (FileNotFoundException e) {
                System.out.println("Invalid airline filename. Please try again."
                        + "\nEnter the airline filename: ");
                airlineFilename = in.next();
            }
        }
        System.out.println("Please enter the flight filename: ");
        String flightFilename = in.next();
        fakeScanner = null;
        while (fakeScanner == null) {
            try {
                fakeScanner = new Scanner(new File(airlineFilename));
            } catch (FileNotFoundException e) {
                System.out.println(
                        "Invalid flight filename. Please try again.\nEnter the flight filename: ");
                airlineFilename = in.next();
            }
        }
        System.out.println("Please enter the customer filename: ");
        String customerFilename = in.next();
        fakeScanner = null;
        while (fakeScanner == null) {
            try {
                fakeScanner = new Scanner(new File(airlineFilename));
            } catch (FileNotFoundException e) {
                System.out
                        .println("Invalid customer filename. Please try again.\nEnter the customer "
                                + "filename: ");
                airlineFilename = in.next();
            }
        }
        AirlineMileageManager manager = new AirlineMileageManager(airlineFilename, customerFilename,
                flightFilename);
        System.out.println("Would you like to query a customer (Q), print a mileage report (R), "
                + "or exit the program (E)? ");
        String command = in.next();
        
        String output = "";
        while (!command.equalsIgnoreCase("E")) {
            // handle user requests
            if (command.equalsIgnoreCase("Q")) {
                // get first and last name
                System.out.println("Enter the first name of the customer: ");
                String firstName = in.next();
                System.out.println("Enter the last name of the customer: ");
                String lastName = in.next();
                // print customer report
                output += manager.getMiles(firstName, lastName) + "\n\n";
                System.out.println(manager.getMiles(firstName, lastName) + "\n\n");
            } else if (command.equalsIgnoreCase("R")) {
                output += manager.getMileageReport() + "\n\n";
                System.out.println(manager.getMileageReport() + "\n\n");
            } else {
                System.out.println("Invalid command. Please try again.");
            }
            System.out
                    .println("Would you like to query a customer (Q), print a mileage report (R), "
                            + "or exit the program (E)? ");
            command = in.next();
        }
        try {
            PrintStream fileWriter = new PrintStream(new File("output/reportOutput.txt"));
            fileWriter.println(output);
        } catch (FileNotFoundException e) {
            System.out.println("Could not write to file");
        }
        System.out.println("Thank you for using AirlineMileageManager!");
        
        in.close();
    }
}
