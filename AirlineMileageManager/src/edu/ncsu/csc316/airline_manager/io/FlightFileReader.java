package edu.ncsu.csc316.airline_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class FlightFileReader {
    
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
            String airline_code = lineScan.next();
            int flight_num = lineScan.nextInt();
            String origin = lineScan.next();
            String dest = lineScan.next();
            lineScan.nextInt(); // skips over scheduled departure
            lineScan.nextInt(); // skips over actual departure
            int distance = lineScan.nextInt();
            String airline = getAirline(airline_code, airlineArray);
            flights.add(new Flight(airline_code, airline, flight_num, origin, dest,
                    distance));
            lineScan.close();
        }
        scan.close();
        return flights;
    }
    
    private static String getAirline(String airline_code, String[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (airline_code.equals(array[i][0])) {
                return array[i][1];
            }
        }
        return null;
    }
}
