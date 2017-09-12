package edu.ncsu.csc316.airline_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

/**
 * This class is responsible for reading in a flight file and creating a linked
 * list of flights
 * 
 * @author Caitlyn Wiley
 *
 */
public class FlightFileReader {
    
    /**
     * Reads in a flight file and creates a linked list of Flight objects
     * 
     * @param filename
     *            the file to read from
     * @param airlineArray
     *            a 2D array containing airline codes and descriptions to aid in
     *            getting the airline description for each flight
     * @return linked list of flight objects
     * @throws FileNotFoundException
     *             if the file cannot be found and read from
     */
    public LinkedList<Flight> readfile(String filename, String[][] airlineArray)
            throws FileNotFoundException {
        LinkedList<Flight> flights = new LinkedList<Flight>();
        Scanner scan = new Scanner(new File(filename));
        scan.nextLine(); // skips first line that describes each column
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            lineScan.nextInt(); // skips year
            lineScan.nextInt(); // skips month
            lineScan.nextInt(); // skips day
            lineScan.nextInt(); // skips over day of week
            String airlineCode = lineScan.next();
            int flightNumber = lineScan.nextInt();
            String origin = lineScan.next();
            String dest = lineScan.next();
            lineScan.nextInt(); // skips over scheduled departure
            lineScan.nextInt(); // skips over actual departure
            int distance = lineScan.nextInt();
            String airline = getAirline(airlineCode, airlineArray);
            flights.add(new Flight(airlineCode, airline, flightNumber, origin, dest,
                    distance));
            flights.sort();
            lineScan.close();
        }
        scan.close();
        return flights;
    }
    
    private static String getAirline(String airlineCode, String[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (airlineCode.equals(array[i][0])) {
                return array[i][1];
            }
        }
        return null;
    }
}
