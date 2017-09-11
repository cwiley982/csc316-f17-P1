package edu.ncsu.csc316.airline_mileage.data;

public class Customer implements Comparable<Customer> {
    
    private String first_name;
    private String last_name;
    private Miles miles;
    
    public Customer(String first_name, String last_name) {
        setFirstName(first_name);
        setLastName(last_name);
        miles = new Miles();
    }
    
    public void addFlight(Flight f) {
        miles.addMiles(f.getAirline(), f.getAirlineCode(), f.getDistance());
    }
    
    public String getMileageReport() {
        String report = "";
        report += first_name + " " + last_name + " earned" + miles.getMilesReport();
        return report;
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
        if (first_name == null || first_name.isEmpty()) {
            throw new IllegalArgumentException("Invalid first name.");
        }
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
        if (last_name == null || last_name.isEmpty()) {
            throw new IllegalArgumentException("Invalid last name.");
        }
        this.last_name = last_name;
    }
    
    @Override
    public int compareTo(Customer c) {
        // sort by last name, then first
        if (this.getLastName().compareToIgnoreCase(c.getLastName()) == 0) {
            // last names are the same, compare first names
            if (this.getFirstName().compareToIgnoreCase(c.getFirstName()) < 0) {
                return -1;
            } else if (this.getFirstName().compareToIgnoreCase(c.getFirstName()) > 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (this.getLastName().compareToIgnoreCase(c.getLastName()) < 0) {
                return -1;
            } else { // this.lastname comes after o.lastname
                return 1;
            }
        }
    }
    
    @Override
    public boolean equals(Object o) {
        Customer c = (Customer) o;
        if (first_name.equals(c.getFirstName()) && last_name.equals(c.getLastName())) {
            return true;
        } else {
            return false;
        }
    }
    
}