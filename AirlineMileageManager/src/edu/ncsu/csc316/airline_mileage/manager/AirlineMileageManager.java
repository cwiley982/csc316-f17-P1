package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;
import io.AirlineFileReader;
import io.CustomerFileReader;
import io.FlightFileReader;

public class AirlineMileageManager {
    
    private LinkedList<Customer> customers; // alphabetical by last then first
                                            // name
    private LinkedList<Flight> flights; // alphabetical by airline code
    private LinkedList<Airline> airlines;
    
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
    public AirlineMileageManager(String pathToAirlineFile, String pathToCustomerFile, String pathToFlightFile) {
        try {
            airlines = AirlineFileReader.readfile(pathToAirlineFile);
            flights = FlightFileReader.readfile(pathToFlightFile);
            customers = CustomerFileReader.readfile(pathToCustomerFile, flights);
        } catch (FileNotFoundException e) {
            System.out.println("Invalid filename");
        }
    }
    
    /**
     * Produces the mileage report for all customers as a String, sorted
     * alphabetically by customer last name.
     * 
     * @return the mileage report for all customers
     */
    public String getMileageReport() {
        // TODO: add your implementation
        for (int i = 0; i < customers.size(); i++) {
            customers.get(i).getMileageReport();
        }
        return null;
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
        return null;
        // TODO: add your implementation
        // find customer with matching first and last name, print their report
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
        AirlineMileageManager manager = new AirlineMileageManager(airline_filename,
                customer_filename, flight_filename);
        System.out.println(
                "Would you like to query a customer (Q), print a mileage report (R), or exit the program (E)? ");
        String command = in.next();
        while (!command.equalsIgnoreCase("E")) {
            // handle user requests
            if (command.equalsIgnoreCase("Q")) {
                // get first and last name
                // print customer report
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
        in.close();
    }
}
