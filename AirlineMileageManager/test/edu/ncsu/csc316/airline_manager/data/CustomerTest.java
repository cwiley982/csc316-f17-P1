package edu.ncsu.csc316.airline_manager.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Customer;

/**
 * Tests functionality of Customer class
 * 
 * @author Caitlyn Wiley
 *
 */
public class CustomerTest {
    
    private String firstName = "Caitlyn";
    private String lastName = "Wiley";
    private Customer customer = new Customer(firstName, lastName);
    
    /**
     * Tests constructing a customer object with valid and invalid arguments
     */
    @Test
    public void testCustomer() {
        Customer c = null;
        
        try {
            c = new Customer("", lastName);
            fail();
        } catch (IllegalArgumentException e) {
            assertNull(c);
        }
        
        try {
            c = new Customer(null, lastName);
            fail();
        } catch (IllegalArgumentException e) {
            assertNull(c);
        }
        
        try {
            c = new Customer(firstName, "");
            fail();
        } catch (IllegalArgumentException e) {
            assertNull(c);
        }
        
        try {
            c = new Customer(firstName, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertNull(c);
        }
        
        try {
            c = new Customer(firstName, lastName);
        } catch (IllegalArgumentException e) {
            assertNotNull(c);
        }
    }
    
    /**
     * Tests getting first name
     */
    @Test
    public void testGetFirstName() {
        assertEquals("Caitlyn", customer.getFirstName());
    }
    
    /**
     * tests getting last name
     */
    @Test
    public void testGetLastName() {
        assertEquals("Wiley", customer.getLastName());
    }
    
    /**
     * tests the compareTo method
     */
    @Test
    public void testCompareTo() {
        Customer c2 = new Customer("Courtney", "Wiley");
        assertTrue(customer.compareTo(c2) < 0);
        Customer c3 = new Customer("Juanita", "Thompson");
        assertTrue(customer.compareTo(c3) > 0);
        Customer c4 = new Customer("Juanita", "Massey");
        assertTrue(c4.compareTo(c3) < 0);
        assertTrue(c2.compareTo(customer) > 0);
        assertEquals(0, c2.compareTo(c2));
    }
    
    /**
     * Tests the equals method
     */
    @Test
    public void testEquals() {
        Customer c2 = new Customer("Courtney", "Wiley");
        Customer c3 = new Customer("Juanita", "Thompson");
        Customer c4 = new Customer("Juanita", "Massey");
        assertFalse(c2.equals(customer));
        assertFalse(c2.equals(c3));
        assertFalse(c4.equals(c3));
    }
    
    /**
     * tests the hashCode method
     */
    @Test
    public void testHashCode() {
        Customer c = new Customer("Caitlyn", "Wiley");
        assertTrue(c.hashCode() < 0);
    }

}
