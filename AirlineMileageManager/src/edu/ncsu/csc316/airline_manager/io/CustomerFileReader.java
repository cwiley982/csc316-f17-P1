package edu.ncsu.csc316.airline_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
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
    public static LinkedList<Customer> readfile(String filename, LinkedList<Flight> flights)
            throws FileNotFoundException {
        LinkedList<Customer> customers = new LinkedList<Customer>();
        Scanner scan = new Scanner(new File(filename));
        scan.nextLine(); // skips first line that describes each column
        while (scan.hasNextLine()) {
            scan.useDelimiter(",");
            String first = scan.next();
            String last = scan.next();
            scan.useDelimiter("/");
            int month = scan.nextInt();
            int day = scan.nextInt();
            scan.useDelimiter(",");
            int year = scan.nextInt();
            Calendar date = Calendar.getInstance();
            date.set(year, month, day);
            String flight = scan.next();
            String origin = scan.next();
            scan.useDelimiter("\n");
            String dest = scan.next();
            
            Customer x = new Customer(first, last);
            try {
                customers.add(x);
            } catch (IllegalArgumentException e) {
                // customer exists, just add flight to customer object
            }
            x.addFlight(findMatch(date, flight, origin, dest, flights));
        }
        scan.close();
        return customers;
    }
    
    private static Flight findMatch(Calendar date, String flight, String origin, String destination,
            LinkedList<Flight> flights) {
        // find matching flight
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
