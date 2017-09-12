package edu.ncsu.csc316.airline_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.util.ArrayList;

/**
 * This class is able to read in an airline file and return a linked list of
 * Airline objects
 * 
 * @author Caitlyn Wiley
 *
 */
public class AirlineFileReader {
    
    /**
     * Reads in an airline file and constructs a linked list with Airline
     * objects
     * 
     * @param filename
     *            the file to read from
     * @return a linked list of Airline objects
     * @throws FileNotFoundException
     *             if the file can't be found and read from
     */
    public ArrayList<Airline> readfile(String filename) throws FileNotFoundException {
        ArrayList<Airline> airlines = new ArrayList<Airline>();
        Scanner scan = new Scanner(new File(filename));
        scan.nextLine(); // skips first line that describes each column
        Scanner lineScan;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            String description = lineScan.next();
            String airlineCode = lineScan.next();
            lineScan.close();
            airlines.add(new Airline(description, airlineCode));
        }
        scan.close();
        return airlines;
    }
    
    /**
     * Constructs a 2D String array of airline codes and airline descriptions
     * 
     * @param airlines
     *            the linked list of airlines to get info from
     * @return 2D array containing airline codes and descriptions
     */
    public String[][] get2DArray(ArrayList<Airline> airlines) {
        String[][] array = new String[airlines.size()][2];
        for (int i = 0; i < airlines.size(); i++) {
            array[i][0] = airlines.get(i).getAirlineCode();
            array[i][1] = airlines.get(i).getDescription();
        }
        return array;
    }
}
