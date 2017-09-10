package edu.ncsu.csc316.airline_manager.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class AirlineFileReaderTest {
    
    private String filename = "input/airline_file";
    private LinkedList<Airline> airlines = new LinkedList<Airline>();
    private LinkedList<Airline> actual;
    private Airline united = new Airline("United Airlines", "UA", "UNITED", "United States");
    private Airline delta = new Airline("Delta Air Lines", "DL", "DELTA", "United States");
    private Airline jetblue = new Airline("JetBlue Airways", "B6", "JETBLUE", "United States");
    
    @Before
    public void setUp() {
        airlines.add(united);
        airlines.add(delta);
        airlines.add(jetblue);
    }
    
    @Test
    public void testFileReader() {
        try {
            actual = AirlineFileReader.readfile(filename);
            assertEquals("DELTA", actual.get(0).getCallsign());
            assertEquals("B6", actual.get(1).getAirline_code());
            assertEquals("United Airlines", actual.get(2).getDescription());
            assertEquals("United States", actual.get(2).getCountry());
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
}
