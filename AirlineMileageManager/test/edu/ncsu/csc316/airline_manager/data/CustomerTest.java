package edu.ncsu.csc316.airline_manager.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Customer;

public class CustomerTest {
    
    private String first_name = "Caitlyn";
    private String last_name = "Wiley";
    private Customer customer = new Customer(first_name, last_name);
    
    @Test
    public void testCustomer() {
        Customer c = null;
        
        try {
            c = new Customer("", last_name);
            fail();
        } catch (IllegalArgumentException e) {
            assertNull(c);
        }
        
        try {
            c = new Customer(null, last_name);
            fail();
        } catch (IllegalArgumentException e) {
            assertNull(c);
        }
        
        try {
            c = new Customer(first_name, "");
            fail();
        } catch (IllegalArgumentException e) {
            assertNull(c);
        }
        
        try {
            c = new Customer(first_name, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertNull(c);
        }
        
        try {
            c = new Customer(first_name, last_name);
        } catch (IllegalArgumentException e) {
            assertNotNull(c);
        }
    }
    
    @Test
    public void testGetFirstName() {
        assertEquals("Caitlyn", customer.getFirstName());
    }
    
    @Test
    public void testGetLastName() {
        assertEquals("Wiley", customer.getLastName());
    }
    
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
    
    @Test
    public void testEquals() {
        Customer c2 = new Customer("Courtney", "Wiley");
        Customer c3 = new Customer("Juanita", "Thompson");
        Customer c4 = new Customer("Juanita", "Massey");
        assertFalse(c2.equals(customer));
        assertFalse(c2.equals(c3));
        assertFalse(c4.equals(c3));
    }
    
    @Test
    public void testHashCode() {
        Customer c = new Customer("Caitlyn", "Wiley");
        assertTrue(c.hashCode() < 0);
    }

}
