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
        Flight f1 = new Flight("UA", "United Airlines", 234, "MIA", "FOR", 700);
        Flight f2 = new Flight("UA", "United Airlines", 234, "MIA", "FOR", 700);
        Flight f3 = new Flight("UA", "United Airlines", 234, "MIA", "FOX", 700);
        Flight f4 = new Flight("UA", "United Airlines", 234, "MIN", "FOX", 700);
        Flight f5 = new Flight("UA", "United Airlines", 235, "MIN", "FOX", 700);
        Flight f6 = new Flight("AA", "American Airlines", 234, "MIN", "FOX", 700);
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
