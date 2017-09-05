package io;

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
        while (scan.hasNextLine()) {
            scan.useDelimiter(",");
            String description = scan.next();
            String airline_code = scan.next();
            String callsign = scan.next();
            String country = scan.next();
            airlines.add(new Airline(description, airline_code, callsign, country));
        }
        scan.close();
        return airlines;
    }
}
