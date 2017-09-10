package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_manager.io.AirlineFileReader;
import edu.ncsu.csc316.airline_manager.io.CustomerFileReader;
import edu.ncsu.csc316.airline_manager.io.FlightFileReader;
import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class AirlineMileageManager {
    
    /** Holds a list of all customers from file specified by user */
    private LinkedList<Customer> customers;
    /** Holds a list of all flights from file specified by user */
    private LinkedList<Flight> flights;
    /** Holds a list of all airlines from file specified by user */
    private LinkedList<Airline> airlines;
    private String[][] airlineCodesAndNames;
    
    /**
     * Constructs an AirlineMileageManager
     * 
     * @param pathToAirlineFile
     *            - path to the airline information file
     * @param pathToCustomerFile
     *            - path to the customer information file
     * @param pathToFlightFile
     *            - path to the flight information file
     */
    public AirlineMileageManager(String pathToAirlineFile, String pathToCustomerFile,
            String pathToFlightFile) throws FileNotFoundException {
        airlines = AirlineFileReader.readfile(pathToAirlineFile);
        airlineCodesAndNames = AirlineFileReader.get2DArray(airlines);
        
        flights = FlightFileReader.readfile(pathToFlightFile, airlineCodesAndNames);
        customers = CustomerFileReader.readfile(pathToCustomerFile, flights);
    }
    
    /**
     * Produces the mileage report for all customers as a String, sorted
     * alphabetically by customer last name.
     * 
     * @return the mileage report for all customers
     */
    public String getMileageReport() {
        String report = "";
        for (int i = 0; i < customers.size(); i++) {
            report += customers.get(i).getMileageReport();
            if (i < customers.size() - 1) {
                report += "\n\n";
            }
        }
        return report;
    }
    
    /**
     * Retrieves the frequent flier mileage for the specified customer with the
     * given first name and last name. Miles are listed in descending order by
     * distance
     * 
     * @param firstName
     *            - the customer's first name
     * @param lastName
     *            - the customer's last name
     * @return the frequent flier mileage information for the customer
     */
    public String getMiles(String firstName, String lastName) {
        // find customer with matching first and last name, print their report
        Customer c = new Customer(firstName, lastName);
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).equals(c)) {
                return customers.get(i).getMileageReport();
            }
        }
        return null;
    }
    
    public void main(String[] args) {
        System.out.println(
                "Welcome to AirlineMileageManager! To get started, please enter the airline information filename: ");
        Scanner in = new Scanner(System.in);
        String airline_filename = in.next();
        System.out.println("Please enter the flight information filename: ");
        String flight_filename = in.next();
        System.out.println("Please enter the customer information filename: ");
        String customer_filename = in.next();
        AirlineMileageManager manager;
        try {
            manager = new AirlineMileageManager(airline_filename,
                customer_filename, flight_filename);
            System.out.println(
                    "Would you like to query a customer (Q), print a mileage report (R), or exit the program (E)? ");
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
                System.out.println(
                        "Would you like to query a customer (Q), print a mileage report (R), or exit the program (E)? ");
                command = in.next();
            }
            System.out.println("Thank you for using AirlineMileageManager!");
        } catch (FileNotFoundException e) {
            // print something
        }
        
        in.close();
    }
}
