package edu.ncsu.csc316.airline_manager.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.airline_manager.io.AirlineFileReader;
import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.util.ArrayList;

/**
 * Tests ArrayList functionality
 * 
 * @author Caitlyn Wiley
 *
 */
public class ArrayListTest {
    
    private String firstExpectedAirlineCode = "B6";
    private String secondExpectedAirlineCode = "CA";
    private String thirdExpectedDescription = "Delta Air Lines";
    private String airlineFilename = "input/airline_file.txt";
    private AirlineFileReader airlineReader = new AirlineFileReader();
    private ArrayList<Airline> airlines;
    
    /**
     * creates linked list of airlines to be tested later
     */
    @Before
    public void setUp() {
        try {
            airlines = airlineReader.readfile(airlineFilename);
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
    /**
     * Tests that mergeSort method sorts correctly
     */
    @Test
    public void testMergeSort() {
        airlines.sort();
        assertEquals(firstExpectedAirlineCode, airlines.get(0).getAirlineCode());
        assertEquals(secondExpectedAirlineCode, airlines.get(1).getAirlineCode());
        assertEquals(thirdExpectedDescription, airlines.get(2).getDescription());
    }
    
    /**
     * tests the grow array method
     */
    @Test
    public void testGrowArray() {
        ArrayList<String> array = new ArrayList<String>();
        array.add("a"); // 0
        array.add("c");
        array.add("e");
        array.add("f");
        array.add("j");
        array.add("g"); // 5
        array.add("m");
        array.add("b");
        array.add("h");
        array.add("d");
        array.add("k"); // 10
        array.add("i");
        array.add("a");
        array.add("o");
        array.add("l");
        array.add("n"); // 15
        array.add("p");
        array.add("m");
        assertEquals("p", array.get(16));
    }
    
}
