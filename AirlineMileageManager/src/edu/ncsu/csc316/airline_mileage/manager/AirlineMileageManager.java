package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.ArrayList;
import io.AirlineFileReader;
import io.CustomerFileReader;
import io.FlightFileReader;

public class AirlineMileageManager {
    
    private ArrayList<Customer> customers; // alphabetical by last name,
                                               // then first
    private ArrayList<Flight> flights; // alphabetical by airline code
    private ArrayList<Airline> airlines;
    
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
            createCardholderObjects();
        } catch (FileNotFoundException e) {
            System.out.println("Invalid filename");
        }
        // TODO: add your implementation here
    }
    
    private void createCardholderObjects() {
        // TODO Auto-generated method stub
        // use data array to create customers, if the customer exists, add
        // the flight to their flight list
    }
    
    /**
     * Produces the mileage report for all customers as a String, sorted
     * alphabetically by customer last name.
     * 
     * @return the mileage report for all customers
     */
    public String getMileageReport() {
        return null;
        // TODO: add your implementation
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
    }
}
