package edu.ncsu.csc316.airline_manager.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;

/**
 * Tests functionality of Airline class
 * 
 * @author Caitlyn
 *
 */
public class AirlineTest {
    
    /**
     * tests the compareTo method
     */
    @Test
    public void testCompareTo() {
        Airline a1 = new Airline("United Airlines", "UA");
        Airline a2 = new Airline("American Airlines", "AA");
        assertTrue(a2.compareTo(a1) < 0);
        assertTrue(a1.compareTo(a2) > 0);
        assertEquals(0, a1.compareTo(a1));
    }
    
}
