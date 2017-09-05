package edu.ncsu.csc316.airline_mileage.data;

import edu.ncsu.csc316.airline_mileage.util.ArrayList;

public class Cardholder implements Comparable<E> {
    
    private String first_name;
    private String last_name;
    private ArrayList<Flight> flights;
    
    public Cardholder(String first_name, String last_name) {
        setFirstName(first_name);
        setLastName(last_name);
        flights = null;
    }
    
    public void addFlight(Flight f) {
        flights.add(f);
        // TODO
    }
    
    public void getMileageReport() {
        // TODO
    }
    
    /**
     * @return the first_name
     */
    public String getFirstName() {
        return first_name;
    }
    
    /**
     * @param first_name
     *            the first_name to set
     */
    private void setFirstName(String first_name) {
        this.first_name = first_name;
    }
    
    /**
     * @return the last_name
     */
    public String getLastName() {
        return last_name;
    }
    
    /**
     * @param last_name
     *            the last_name to set
     */
    private void setLastName(String last_name) {
        this.last_name = last_name;
    }
    
}