package edu.ncsu.csc316.airline_manager.manager;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.manager.AirlineMileageManager;

/**
 * Tests AMM functionality
 * 
 * @author Caitlyn Wiley
 *
 */
public class AirlineMileageMangerTest {
    
    private AirlineMileageManager manager;
    private String airlineFile = "input/airline_file.txt";
    private String flightFile = "input/flight_file.txt";
    private String customerFile = "input/customer_file.txt";
    private String erickMcfarlandReport = "Erick Mcfarland earned\n    3591 miles with United Airlines (UA)\n    516 miles with Delta Air Lines (DL)\n    319 miles with JetBlue Airways (B6)";
    private String kassandraStiltnerReport = "Kassandra Stiltner earned\n    5985 miles with United Airlines (UA)";
    private String fullReport = "Courtney Gilligan earned\n    215 miles with Sky Courtney (SC)\n\n"
            + erickMcfarlandReport + "\n\n" + kassandraStiltnerReport
            + "\n\nCaitlyn Wiley earned\n    200 miles with Caitlyn Air Ways (CA)\n\nErick Zynn earned\n    220 miles with Sky Courtney (SC)";
    
    /**
     * tests all methods in AMM
     */
    @Test
    public void test() {
        manager = new AirlineMileageManager(airlineFile, customerFile, flightFile);
        assertEquals(erickMcfarlandReport, manager.getMiles("Erick", "Mcfarland"));
        assertEquals(kassandraStiltnerReport, manager.getMiles("Kassandra", "Stiltner"));
        assertEquals(fullReport, manager.getMileageReport());
    }
    
}
