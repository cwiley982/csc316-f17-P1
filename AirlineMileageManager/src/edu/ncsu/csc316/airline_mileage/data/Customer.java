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
        result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
        result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
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
        if (first_name == null) {
            if (other.first_name != null)
                return false;
        } else if (!first_name.equals(other.first_name))
            return false;
        if (last_name == null) {
            if (other.last_name != null)
                return false;
        } else if (!last_name.equals(other.last_name))
            return false;
        return true;
    }
    
}