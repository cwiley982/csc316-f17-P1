package edu.ncsu.csc316.airline_manager.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.ArrayList;

/**
 * Tests CustomerFileReader functionality
 * 
 * @author Caitlyn
 *
 */
public class CustomerFileReaderTest {
    
    private String filename = "input/customer_file.txt";
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Flight> flights;
    private ArrayList<Customer> actual;
    private Customer c1 = new Customer("Erick", "Mcfarland");
    private Customer c2 = new Customer("Kassandra", "Stiltner");
    private AirlineFileReader airlineReader = new AirlineFileReader();
    private FlightFileReader flightReader = new FlightFileReader();
    private CustomerFileReader customerReader = new CustomerFileReader();
    
    /**
     * sets up list of airlines and flights to use in reading in customer file
     */
    @Before
    public void setUp() {
        customers.add(c1);
        customers.add(c2);
        try {
            ArrayList<Airline> airlines = airlineReader.readfile("input/airline_file.txt");
            String[][] airlineArray = airlineReader.get2DArray(airlines);
            flights = flightReader.readfile("input/flight_file.txt", airlineArray);
            flights.sort();
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
    /**
     * tests fileReader method
     */
    @Test
    public void testFileReader() {
        try {
            actual = customerReader.readfile(filename, flights);
            actual.sort();
            assertEquals("Gilligan", actual.get(0).getLastName());
            assertEquals("Erick", actual.get(1).getFirstName());
            assertEquals("Wiley", actual.get(3).getLastName());
            assertEquals(5, actual.size());
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
}
