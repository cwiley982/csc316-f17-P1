package edu.ncsu.csc316.airline_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class CustomerFileReader {
    
    private LinkedList<Flight> flights;
    
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
        this.flights = flights;
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
                customers.sort(); // sorting after adding to make contains more
                                  // efficient, but still using merge sort
            } catch (IllegalArgumentException e) {
                // customer exists, get original customer object
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).equals(x)) {
                        x = customers.get(i);
                    }
                }
            }
            x.addFlight(findMatch(dateString, flight, origin, dest));
        }
        scan.close();
        return customers;
    }
    
    private Flight findMatch(String date, String flightString, String origin, String destination) {
        // find matching flight, use binary search
        int index = binarySearch(0, flights.size() - 1, flightString, origin, destination);
        if (index != -1) {
            return flights.get(index);
        } else {
            return null;
        }
    }
    
    private int binarySearch(int min, int max, String flightString, String origin,
            String destination) {
        // recursive call
        if (min > max) { // entire list was searched through, flight not found
            return -1;
        }
        int mid = ((max - min) / 2) + min;
        Flight midFlight = flights.get(mid);
        if (flightString.compareTo(midFlight.getFlightString()) == 0) {
            if (origin.compareTo(midFlight.getOrigin()) == 0) {
                if (destination.compareTo(midFlight.getDestination()) == 0) {
                    return mid;
                } else if (destination.compareTo(midFlight.getDestination()) < 0) {
                    // dest comes before midFlight, check left half
                    return binarySearch(min, mid - 1, flightString, origin, destination);
                } else {
                    return binarySearch(mid + 1, max, flightString, origin, destination);
                }
            } else if (origin.compareTo(midFlight.getOrigin()) < 0) {
                // look in left
                return binarySearch(0, mid - 1, flightString, origin, destination);
            } else {
                // look in right
                return binarySearch(mid + 1, max, flightString, origin, destination);
            }
        } else if (flightString.compareTo(midFlight.getFlightString()) < 0) {
            return binarySearch(0, mid - 1, flightString, origin, destination);
        } else {
            return binarySearch(mid + 1, max, flightString, origin, destination);
        }
    }
}
