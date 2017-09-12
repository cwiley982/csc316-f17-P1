package edu.ncsu.csc316.airline_manager.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class AirlineFileReaderTest {
    
    private String filename = "input/airline_file";
    private LinkedList<Airline> actual;
    private AirlineFileReader airlineReader = new AirlineFileReader();
    
    @Test
    public void testFileReader() {
        try {
            actual = airlineReader.readfile(filename);
            actual.sort();
            assertEquals("DL", actual.get(1).getAirlineCode());
            assertEquals("United Airlines", actual.get(2).getDescription());
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
}
