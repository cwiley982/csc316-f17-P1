package edu.ncsu.csc316.airline_mileage.data;

import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class Customer implements Comparable<Customer> {
    
    private String first_name;
    private String last_name;
    private LinkedList<Flight> flights;
    private Miles miles;
    
    public Customer(String first_name, String last_name) {
        setFirstName(first_name);
        setLastName(last_name);
        flights = new LinkedList<Flight>();
        miles = new Miles();
    }
    
    public void addFlight(Flight f) {
        flights.add(f);
        // need to get full airline name before passing it into the method below
        // TODO - update miles though
        miles.addMiles(f.getAirline(), f.getDistance());
    }
    
    public void getMileageReport() {
        System.out.println(first_name + " " + last_name + " has earned\n");
        miles.getMilesReport();
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
    
    @Override
    public int compareTo(Customer o) {
        // sort by last name, then first
        if (o.getLastName().compareToIgnoreCase(this.getLastName()) == 0) {
            // last names are the same, compare first names
            return o.getFirstName().compareToIgnoreCase(this.getFirstName());
        } else {
            return o.getLastName().compareToIgnoreCase(this.getLastName());
        }
    }
    
}