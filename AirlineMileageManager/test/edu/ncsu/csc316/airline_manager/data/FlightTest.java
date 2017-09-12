package edu.ncsu.csc316.airline_manager.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Flight;

/**
 * Tests functionality of Flight class
 * 
 * @author Caitlyn
 *
 */
public class FlightTest {
    
    /**
     * Tests compareTo method
     */
    @Test
    public void testCompareTo() {
        Flight f1 = new Flight("UA", 234, "MIA", "FOR");
        f1.setAirline("United Airlines");
        f1.setDistance(700);
        Flight f2 = new Flight("UA", 234, "MIA", "FOR");
        f2.setAirline("United Airlines");
        f2.setDistance(700);
        Flight f3 = new Flight("UA", 234, "MIA", "FOX");
        f3.setAirline("United Airlines");
        f3.setDistance(700);
        Flight f4 = new Flight("UA", 234, "MIN", "FOX");
        f4.setAirline("United Airlines");
        f4.setDistance(700);
        Flight f5 = new Flight("UA", 235, "MIN", "FOX");
        f5.setAirline("United Airlines");
        f5.setDistance(700);
        Flight f6 = new Flight("AA", 234, "MIN", "FOX");
        f6.setAirline("American Airlines");
        f6.setDistance(700);
        assertEquals(0, f1.compareTo(f2));
        assertEquals(-1, f1.compareTo(f3));
        assertEquals(1, f3.compareTo(f1));
        assertEquals(-1, f1.compareTo(f4));
        assertEquals(1, f4.compareTo(f1));
        assertEquals(-1, f1.compareTo(f5));
        assertEquals(1, f5.compareTo(f1));
        assertEquals(1, f1.compareTo(f6));
    }
    
}
