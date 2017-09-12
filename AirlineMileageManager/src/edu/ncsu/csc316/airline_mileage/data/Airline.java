package edu.ncsu.csc316.airline_mileage.data;

/**
 * Creates and airline object holding an airline code and descrption
 * 
 * @author Caitlyn
 *
 */
public class Airline implements Comparable<Airline> {
    
    private String description;
    private String airlineCode;
    
    /**
     * Constructs an airline object and sets the fields
     * 
     * @param description
     *            description of airline
     * @param airlineCode
     *            code for airline
     */
    public Airline(String description, String airlineCode) {
        setDescription(description);
        setAirlineCode(airlineCode);
    }
    
    /**
     * Gets the full name of the airline
     * 
     * @return the full name of the airline
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Gets the airline code
     * 
     * @return the airlineCode
     */
    public String getAirlineCode() {
        return airlineCode;
    }
    
    /**
     * Sets the description of the airline
     * 
     * @param description
     *            the description to set
     */
    private void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Sets the airline code
     * 
     * @param airlineCode
     *            the airline_code to set
     */
    private void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }
    
    @Override
    public int compareTo(Airline o) {
        // cast to airline
        Airline a = (Airline) o;
        // sort by description (airline name)
        return airlineCode.compareTo(a.getAirlineCode());
    }
    
}
