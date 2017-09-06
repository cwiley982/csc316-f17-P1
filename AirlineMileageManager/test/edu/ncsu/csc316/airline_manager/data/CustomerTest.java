package edu.ncsu.csc316.airline_manager.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
        Customer customer2 = new Customer("Courtney", "Wiley");
        assertEquals(-1, customer.compareTo(customer2));
        Customer customer3 = new Customer("Juanita", "Thompson");
        assertEquals(1, customer.compareTo(customer3));
    }

}
