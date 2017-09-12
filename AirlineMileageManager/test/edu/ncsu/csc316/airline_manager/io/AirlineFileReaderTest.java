package edu.ncsu.csc316.airline_manager.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

/**
 * Tests AirlineFileReader functionality
 * 
 * @author Caitlyn Wiley
 *
 */
public class AirlineFileReaderTest {
    
    private String filename = "input/airline_file";
    private LinkedList<Airline> actual;
    private AirlineFileReader airlineReader = new AirlineFileReader();
    
    /**
     * tests fileReader method
     */
    @Test
    public void testFileReader() {
        try {
            actual = airlineReader.readfile(filename);
            actual.sort();
            assertEquals("CA", actual.get(1).getAirlineCode());
            assertEquals("Delta Air Lines", actual.get(2).getDescription());
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
}
