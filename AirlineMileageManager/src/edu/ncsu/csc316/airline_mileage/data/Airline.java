package edu.ncsu.csc316.airline_mileage.data;

public class Airline implements Comparable<Airline> {
    
    private String description;
    private String airline_code;
    
    public Airline(String description, String airline_code) {
        setDescription(description);
        setAirlineCode(airline_code);
    }
    
    /**
     * @return the full name of the airline
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @return the airline_code
     */
    public String getAirlineCode() {
        return airline_code;
    }
    
    /**
     * @param description
     *            the description to set
     */
    private void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * @param airline_code
     *            the airline_code to set
     */
    private void setAirlineCode(String airline_code) {
        this.airline_code = airline_code;
    }
    
    @Override
    public int compareTo(Airline o) {
        // cast to airline
        Airline a = (Airline) o;
        // sort by description (airline name)
        return airline_code.compareTo(a.getAirlineCode());
    }
    
}
