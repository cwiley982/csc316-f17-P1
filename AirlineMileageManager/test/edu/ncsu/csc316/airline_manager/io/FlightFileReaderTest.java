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
    
    private LinkedList<Flight> flights;
    private String[][] airlineArray;
    private LinkedList<Flight> actual;
    private AirlineFileReader airlineReader = new AirlineFileReader();
    private FlightFileReader flightReader = new FlightFileReader();
    
    @Before
    public void setUp() throws Exception {
        Flight united = new Flight("UA", "United Airlines", 346, "ORD", "MIA", 1197);
        Flight delta = new Flight("DL", "Delta Air Lines", 1233, "ATL", "ORF", 516);
        Flight jetblue = new Flight("B6", "JetBlue Airways", 1316, "FLL", "JAX", 319);
        flights = new LinkedList<Flight>();
        flights.add(united); // third
        flights.add(delta); // second
        flights.add(jetblue); // first
        LinkedList<Airline> airlines = airlineReader.readfile("input/airline_file");
        airlineArray = airlineReader.get2DArray(airlines);
    }
    
    @Test
    public void test() {
        try {
            actual = flightReader.readfile("input/flight_file", airlineArray);
            actual.sort();
            assertEquals("B6", actual.get(0).getAirlineCode());
            assertEquals("ATL", actual.get(1).getOrigin());
            assertEquals(1233, actual.get(1).getFlightNumber());
            assertEquals(3, actual.size());
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
}
