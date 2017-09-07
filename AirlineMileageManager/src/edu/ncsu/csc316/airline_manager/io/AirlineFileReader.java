package edu.ncsu.csc316.airline_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class AirlineFileReader {
    
    public static LinkedList<Airline> readfile(String filename) throws FileNotFoundException {
        LinkedList<Airline> airlines = new LinkedList<Airline>();
        Scanner scan = new Scanner(new File(filename));
        scan.nextLine(); // skips first line that describes each column
        Scanner lineScan;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            String description = lineScan.next();
            String airline_code = lineScan.next();
            String callsign = lineScan.next();
            String country = lineScan.next();
            airlines.add(new Airline(description, airline_code, callsign, country));
        }
        scan.close();
        return airlines;
    }
}
