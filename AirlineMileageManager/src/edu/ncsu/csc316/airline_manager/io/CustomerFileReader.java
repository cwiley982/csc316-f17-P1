package edu.ncsu.csc316.airline_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.ArrayList;

/**
 * This class is responsible for reading in a customer file
 * 
 * @author Caitlyn Wiley
 *
 */
public class CustomerFileReader {
    
    // private ArrayList<Flight> flights;
    private ArrayList<Customer> customers;
    
    /**
     * Reads in a customer file and creates a linked list of Customer objects
     * 
     * @param filename
     *            the file to read from
     * @param flights
     *            linked list of flights to match up with customer info
     * @return linked list of customers
     * @throws FileNotFoundException
     *             if file can't be found and read from
     */
    public ArrayList<Customer> readfile(String filename, ArrayList<Flight> flights)
            throws FileNotFoundException {
        // this.flights = flights;
        customers = new ArrayList<Customer>();
        Scanner scan = new Scanner(new File(filename));
        scan.nextLine(); // skips first line that describes each column
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            String first = lineScan.next();
            String last = lineScan.next();
            lineScan.next(); // skips over date
            String flight = lineScan.next();
            String origin = lineScan.next();
            String dest = lineScan.next();
            lineScan.close();
            
            String airlineCode = flight.substring(0, 2);
            int flightNumber = Integer.parseInt(flight.substring(2));
            
            Customer c = new Customer(first, last);
            int customerIndex = findCustomer(c);
            if (customerIndex != -1) {
                c = customers.get(customerIndex);
            } else {
                customers.add(c);
            }
            Flight f = new Flight(airlineCode, flightNumber, origin, dest);
            c.addFlight(flights.get(flights.binarySearch(0, flights.size() - 1, f)));
        }
        scan.close();
        return customers;
    }
    
    private int findCustomer(Customer c) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).equals(c)) {
                return i;
            }
        }
        return -1;
    }
    
}
