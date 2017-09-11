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
            airlineCodesAndNames = airlineReader.get2DArray(airlines);
            
            flights = flightReader.readfile(pathToFlightFile, airlineCodesAndNames);
            customers = customerReader.readfile(pathToCustomerFile, flights);
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
        Customer c = new Customer(firstName, lastName);
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).equals(c)) {
                return customers.get(i).getMileageReport();
            }
        }
        return null;
    }
    

}
