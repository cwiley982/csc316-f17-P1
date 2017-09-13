package edu.ncsu.csc316.airline_mileage.data;

/**
 * Creates a customer object with fields first and last name
 * 
 * @author Caitlyn Wiley
 *
 */
public class Customer implements Comparable<Customer> {
    
    /** First name of the customer */
    private String firstName;
    /** Last name of the customer */
    private String lastName;
    /** Keeps track of miles accumulated with each airline */
    private Miles miles;
    /** Holds a string representation of a customer's mileage report */
    private StringBuilder report;
    
    /**
     * Constructs a customer with first and last name and sets fields
     * 
     * @param firstName
     *            customer's first name
     * @param lastName
     *            customer's last name
     */
    public Customer(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        miles = new Miles();
        report = new StringBuilder();
    }
    
    /**
     * Adds miles for flight passed in to the miles field
     * 
     * @param f
     *            flight to get miles for
     */
    public void addFlight(Flight f) {
        miles.addMiles(f.getAirline(), f.getAirlineCode(), f.getDistance());
    }
    
    /**
     * Returns a string representation of the customer's miles field with their
     * full name in front
     * 
     * @return string describing miles flown
     */
    public String getMileageReport() {
        if (report.length() == 0) {
            report.append(firstName).append(" ").append(lastName).append(" earned")
                    .append(miles.getMilesReport());
        }
        return report.toString();
    }
    
    /**
     * Gets the first name
     * 
     * @return the first_name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Sets the first name
     * 
     * @param firstName
     *            the first_name to set
     */
    private void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Invalid first name.");
        }
        this.firstName = firstName;
    }
    
    /**
     * Gets the last name
     * 
     * @return the last_name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets the last name
     * 
     * @param lastName
     *            the last_name to set
     */
    private void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Invalid last name.");
        }
        this.lastName = lastName;
    }
    
    @Override
    public int compareTo(Customer c) {
        // sort by last name, then first
        if (this.getLastName().compareToIgnoreCase(c.getLastName()) == 0) {
            // last names are the same, compare first names
            return this.getFirstName().compareToIgnoreCase(c.getFirstName());
        } else {
            return this.getLastName().compareToIgnoreCase(c.getLastName());
        }
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }
    
}