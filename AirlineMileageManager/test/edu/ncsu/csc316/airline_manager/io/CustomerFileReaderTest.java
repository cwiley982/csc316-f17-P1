package edu.ncsu.csc316.airline_manager.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class CustomerFileReaderTest {
    
    private String filename = "input/customer_file";
    private LinkedList<Customer> customers = new LinkedList<Customer>();
    private LinkedList<Flight> flights;
    private LinkedList<Customer> actual;
    private Customer c1 = new Customer("Erick", "Mcfarland");
    private Customer c2 = new Customer("Kassandra", "Stiltner");
    private AirlineFileReader airlineReader = new AirlineFileReader();
    private FlightFileReader flightReader = new FlightFileReader();
    private CustomerFileReader customerReader = new CustomerFileReader();
    
    @Before
    public void setUp() {
        customers.add(c1);
        customers.add(c2);
        try {
            LinkedList<Airline> airlines = airlineReader.readfile("input/airline_file");
            String[][] airlineArray = airlineReader.get2DArray(airlines);
            flights = flightReader.readfile("input/flight_file", airlineArray);
            flights.sort();
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
    @Test
    public void testFileReader() {
        try {
            actual = customerReader.readfile(filename, flights);
            actual.sort();
            assertEquals("Greene", actual.get(0).getLastName());
            assertEquals("Erick", actual.get(1).getFirstName());
            assertEquals("Wiley", actual.get(3).getLastName());
            assertEquals(5, actual.size());
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
}
