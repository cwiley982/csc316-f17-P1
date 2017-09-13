package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.airline_manager.io.AirlineFileReader;
import edu.ncsu.csc316.airline_manager.io.CustomerFileReader;
import edu.ncsu.csc316.airline_manager.io.FlightFileReader;
import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.ArrayList;

/**
 * This is the main class that reads in the input files and gets the miles for
 * each customer individually and gets a mileage report for all customers at
 * once.
 * 
 * @author Caitlyn Wiley
 *
 */
public class AirlineMileageManager {
    
    /** Holds a list of all customers from file specified by user */
    private ArrayList<Customer> customers;
    /** Holds a list of all flights from file specified by user */
    private ArrayList<Flight> flights;
    /** Holds a list of all airlines from file specified by user */
    private ArrayList<Airline> airlines;
    /** Creates and AirlineFileReader object to read in the airline file */
    private AirlineFileReader airlineReader = new AirlineFileReader();
    /** Creates a FlightFileReader object to read in the flight file */
    private FlightFileReader flightReader = new FlightFileReader();
    /** Creates a CustomerFileReader object to read in the customer file */
    private CustomerFileReader customerReader = new CustomerFileReader();
    /**
     * Stores the airline codes and descriptions for each airline, to be
     * accessed in flight reader
     */
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
            String pathToFlightFile) {
        try {
            airlines = airlineReader.readfile(pathToAirlineFile);
            airlines.sort();
            airlineCodesAndNames = airlineReader.get2DArray(airlines);
            flights = flightReader.readfile(pathToFlightFile, airlineCodesAndNames);
            flights.sort();
            customers = customerReader.readfile(pathToCustomerFile, flights);
            customers.sort();
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception was thrown in AMM");
        }
    }
    
    /**
     * Produces the mileage report for all customers as a String, sorted
     * alphabetically by customer last name.
     * 
     * @return the mileage report for all customers
     */
    public String getMileageReport() {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            report.append(customers.get(i).getMileageReport());
            if (i < customers.size() - 1) {
                report.append("\n\n");
            }
        }
        return report.toString();
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
        Customer c = getCustomer(firstName, lastName);
        if (c != null) {
            return c.getMileageReport();
        } else {
            return firstName + " " + lastName + " earned\n    no miles.";
        }
    }
    
    /**
     * Gets a customer by their first and last name using binary search
     * 
     * @param first
     *            first name of the customer
     * @param last
     *            last name of the customer
     * @return a Customer object holding the customer with matching first and
     *         last names, null if no such customer exists
     */
    private Customer getCustomer(String first, String last) {
        Customer c = new Customer(first, last);
        int index = binarySearch(0, customers.size() - 1, c);
        if (index == -1) {
            return null;
        } else {
            return customers.get(index);
        }
    }
    
    /**
     * Recursively searches through the list by checking to see if the customer
     * will be in the left or right half of the list, then checking that half
     * and so on
     * 
     * @param min
     *            minimum index of the list
     * @param max
     *            maximum index of the list
     * @param c
     *            the customer to search for
     * @return the index where the customer was found, -1 if customer wasn't
     *         found
     */
    private int binarySearch(int min, int max, Customer c) {
        // recursive call
        if (min > max) { // entire list was searched through, customer not found
            return -1;
        }
        int mid = ((max - min) / 2) + min;
        if (c.compareTo(customers.get(mid)) == 0) {
            return mid;
        }
        if (c.compareTo(customers.get(mid)) < 0) {
            // c comes before mid, search left half
            return binarySearch(0, mid - 1, c);
        } else {
            // c comes after mid, search right half
            return binarySearch(mid + 1, max, c);
        }
    }

}
