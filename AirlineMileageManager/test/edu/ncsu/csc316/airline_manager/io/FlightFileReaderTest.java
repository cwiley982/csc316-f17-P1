package edu.ncsu.csc316.airline_manager.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class FlightFileReaderTest {
    
    private String[][] airlineArray;
    private LinkedList<Flight> actual;
    private AirlineFileReader airlineReader = new AirlineFileReader();
    private FlightFileReader flightReader = new FlightFileReader();
    
    @Before
    public void setUp() throws Exception {
        LinkedList<Airline> airlines = airlineReader.readfile("input/airline_file");
        airlineArray = airlineReader.get2DArray(airlines);
    }
    
    @Test
    public void test() {
        try {
            actual = flightReader.readfile("input/flight_file", airlineArray);
            actual.sort();
            assertEquals("B6", actual.get(0).getAirlineCode());
            assertEquals("RDU", actual.get(1).getOrigin());
            assertEquals(2115, actual.get(3).getFlightNumber());
            assertEquals("SC2115", actual.get(3).getFlightString());
            assertEquals(6, actual.size());
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
}
