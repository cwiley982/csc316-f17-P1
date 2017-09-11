package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;

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
    private AirlineFileReader airlineReader = new AirlineFileReader();
    private FlightFileReader flightReader = new FlightFileReader();
    private CustomerFileReader customerReader = new CustomerFileReader();
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
            // TODO
        }
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
        Customer c = getCustomer(firstName, lastName);
        if (c != null) {
            return c.getMileageReport();
        } else {
            return firstName + " " + lastName + " earned\n    no miles.";
        }
    }
    
    private Customer getCustomer(String first, String last) {
        Customer c = new Customer(first, last);
        int index = binarySearch(0, customers.size() - 1, c);
        if (index == -1) {
            return null;
        } else {
            return customers.get(index);
        }
    }
    
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
