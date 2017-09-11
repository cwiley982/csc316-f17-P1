package edu.ncsu.csc316.airline_manager.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Flight;

public class FlightTest {
    
    @Test
    public void testCompareTo() {
        Flight f1 = new Flight("1/12/2023", 2, "UA", "United Airlines", 234, "MIA", "FOR", 534, 524,
                700, 1120, 32);
        Flight f2 = new Flight("1/12/2023", 2, "UA", "United Airlines", 234, "MIA", "FOR", 534, 524, 700, 1120, 32);
        Flight f3 = new Flight("1/12/2023", 2, "UA", "United Airlines", 234, "MIA", "FOX", 534, 524,
                700, 1120, 32);
        Flight f4 = new Flight("1/12/2023", 2, "UA", "United Airlines", 234, "MIN", "FOX", 534, 524,
                700, 1120, 32);
        Flight f5 = new Flight("1/12/2023", 2, "UA", "United Airlines", 235, "MIN", "FOX", 534, 524,
                700, 1120, 32);
        Flight f6 = new Flight("1/12/2023", 2, "AA", "American Airlines", 234, "MIN", "FOX", 534,
                524, 700, 1120, 32);
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
