package edu.ncsu.csc316.airline_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class CustomerFileReader {
    
    /*
     * I want to return an LinkedList of Customers, but I need to figure out how
     * to deal with there being multiple instances of the same customer in a
     * file. Need to check to see if the person exists already, if not create a
     * new Customer. If they do exist, need to figure out how to add flights to
     * their list. Maybe pass in the flights LinkedList into this method so I'll
     * have access to the flight objects already created when reading in the
     * flight file.
     */
    public LinkedList<Customer> readfile(String filename, LinkedList<Flight> flights)
            throws FileNotFoundException {
        LinkedList<Customer> customers = new LinkedList<Customer>();
        Scanner scan = new Scanner(new File(filename));
        scan.nextLine(); // skips first line that describes each column
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            String first = lineScan.next();
            String last = lineScan.next();
            String dateString = lineScan.next();
            String flight = lineScan.next();
            String origin = lineScan.next();
            String dest = lineScan.next();
            lineScan.close();
            
            Customer x = new Customer(first, last);
            try {
                customers.add(x);
            } catch (IllegalArgumentException e) {
                // customer exists, get original customer object
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).equals(x)) {
                        x = customers.get(i);
                    }
                }
            }
            x.addFlight(findMatch(dateString, flight, origin, dest, flights));
        }
        scan.close();
        return customers;
    }
    
    private static Flight findMatch(String date, String flight, String origin, String destination,
            LinkedList<Flight> flights) {
        // find matching flight, use binary search
        for (int i = 0; i < flights.size(); i++) {
            Flight x = flights.get(i);
            if (x.getDate().equals(date) && x.getFlightString().equals(flight)
                    && x.getOrigin().equals(origin) && x.getDestination().equals(destination)) {
                return x;
            }
        }
        return null;
    }
}
