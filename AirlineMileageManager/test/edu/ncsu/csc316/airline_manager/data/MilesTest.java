package edu.ncsu.csc316.airline_manager.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Miles;

public class MilesTest {
    
    @Test
    public void test() {
        Miles miles = new Miles();
        miles.addMiles("United Airlines", "UA", 1234);
        miles.addMiles("American Airlines", "AA", 1234);
        miles.addMiles("Delta Air Lines", "DL", 3000);
        String report = miles.getMilesReport();
        String expected = "\n    3000 miles with Delta Air Lines (DL)\n    1234 miles with American Airlines (AA)\n    1234 miles with United Airlines (UA)";
        // System.out.println(report);
        assertEquals(expected, report);
        miles.addMiles("Caitlyn's Airways", "CA", 1234);
        report = miles.getMilesReport();
        expected = "\n    3000 miles with Delta Air Lines (DL)\n    1234 miles with American Airlines (AA)\n    1234 miles with Caitlyn's Airways (CA)\n    1234 miles with United Airlines (UA)";
        // System.out.println(report);
        assertEquals(expected, report);
    }
    
}
