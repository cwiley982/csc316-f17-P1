package edu.ncsu.csc316.airline_manager.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.manager.AirlineMileageManager;

public class AirlineMileageMangerTest {
    
    private AirlineMileageManager manager;
    private String airlineFile = "input/airline_file";
    private String flightFile = "input/flight_file";
    private String customerFile = "input/customer_file";
    private String erickMcfarlandReport = "Erick Mcfarland earned\n\t3591 miles with United Airlines (UA)\n\t516 miles with Delta Air Lines (DL)\n\t319 miles with JetBlue Airways (B6)";
    private String kassandraStiltnerReport = "Kassandra Stiltner earned\n\t5985 miles with United Airlines (UA)";
    private String fullReport = erickMcfarlandReport + "\n\n" + kassandraStiltnerReport;
    
    @Before
    public void setUp() throws Exception {
        
    }
    
    @Test
    public void test() {
        try {
            manager = new AirlineMileageManager(airlineFile, customerFile, flightFile);
            assertEquals(erickMcfarlandReport, manager.getMiles("Erick", "Mcfarland"));
            assertEquals(kassandraStiltnerReport, manager.getMiles("Kassandra", "Stiltner"));
            assertEquals(fullReport, manager.getMileageReport());
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
}
