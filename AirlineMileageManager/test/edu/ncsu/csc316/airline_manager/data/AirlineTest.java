package edu.ncsu.csc316.airline_manager.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;

public class AirlineTest {
    
    @Test
    public void testCompareTo() {
        Airline a1 = new Airline("United Airlines", "UA", "UNITED", "United States");
        Airline a2 = new Airline("American Airlines", "AA", "AMERICAN", "United States");
        assertEquals(-1, a2.compareTo(a1));
        assertEquals(1, a1.compareTo(a2));
        assertEquals(0, a1.compareTo(a1));
    }
    
}
