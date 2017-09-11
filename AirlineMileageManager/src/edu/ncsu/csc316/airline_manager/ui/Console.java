package edu.ncsu.csc316.airline_manager.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.manager.AirlineMileageManager;

public class Console {
    public static void main(String[] args) {
        System.out.println(
                "Welcome to AirlineMileageManager! To get started, please enter the airline "
                        + "filename: ");
        Scanner in = new Scanner(System.in);
        String airline_filename = in.next();
        Scanner fakeScanner = null;
        while (fakeScanner == null) {
            try {
                fakeScanner = new Scanner(new File(airline_filename));
            } catch (FileNotFoundException e) {
                System.out.println("Invalid airline filename. Please try again."
                        + "\nEnter the airline filename: ");
                airline_filename = in.next();
            }
        }
        System.out.println("Please enter the flight filename: ");
        String flight_filename = in.next();
        fakeScanner = null;
        while (fakeScanner == null) {
            try {
                fakeScanner = new Scanner(new File(airline_filename));
            } catch (FileNotFoundException e) {
                System.out.println(
                        "Invalid flight filename. Please try again.\nEnter the flight filename: ");
                airline_filename = in.next();
            }
        }
        System.out.println("Please enter the customer filename: ");
        String customer_filename = in.next();
        fakeScanner = null;
        while (fakeScanner == null) {
            try {
                fakeScanner = new Scanner(new File(airline_filename));
            } catch (FileNotFoundException e) {
                System.out
                        .println("Invalid customer filename. Please try again.\nEnter the customer "
                                + "filename: ");
                airline_filename = in.next();
            }
        }
        AirlineMileageManager manager = new AirlineMileageManager(airline_filename,
                customer_filename, flight_filename);
        System.out.println("Would you like to query a customer (Q), print a mileage report (R), "
                + "or exit the program (E)? ");
        String command = in.next();
        while (!command.equalsIgnoreCase("E")) {
            // handle user requests
            if (command.equalsIgnoreCase("Q")) {
                // get first and last name
                System.out.println("Enter the first name of the customer: ");
                String firstName = in.next();
                System.out.println("Enter the last name of the customer: ");
                String lastName = in.next();
                // print customer report
                manager.getMiles(firstName, lastName);
            } else if (command.equalsIgnoreCase("R")) {
                manager.getMileageReport();
            } else {
                System.out.println("Invalid command. Please try again.");
            }
            System.out
                    .println("Would you like to query a customer (Q), print a mileage report (R), "
                            + "or exit the program (E)? ");
            command = in.next();
        }
        System.out.println("Thank you for using AirlineMileageManager!");
        
        in.close();
    }
}
