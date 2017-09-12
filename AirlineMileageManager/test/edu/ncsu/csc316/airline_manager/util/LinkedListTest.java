package edu.ncsu.csc316.airline_manager.util;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.airline_manager.io.AirlineFileReader;
import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

/**
 * Tests LinkedList functionality
 * 
 * @author Caitlyn Wiley
 *
 */
public class LinkedListTest {
    
    private String firstExpectedAirlineCode = "B6";
    private String secondExpectedAirlineCode = "CA";
    private String thirdExpectedDescription = "Delta Air Lines";
    private String airlineFilename = "input/airline_file";
    private AirlineFileReader airlineReader = new AirlineFileReader();
    private LinkedList<Airline> airlines;
    
    /**
     * creates linked list of airlines to be tested later
     */
    @Before
    public void setUp() {
        try {
            airlines = airlineReader.readfile(airlineFilename);
        } catch (FileNotFoundException e) {
            // do nothing
        }
    }
    
    /**
     * Tests that mergeSort method sorts correctly
     */
    @Test
    public void testMergeSort() {
        airlines.sort();
        assertEquals(firstExpectedAirlineCode, airlines.get(0).getAirlineCode());
        assertEquals(secondExpectedAirlineCode, airlines.get(1).getAirlineCode());
        assertEquals(thirdExpectedDescription, airlines.get(2).getDescription());
    }
    
}
