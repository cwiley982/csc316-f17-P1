package edu.ncsu.csc316.airline_mileage.data;

public class Airline implements Comparable<Airline> {
    
    private String description;
    private String airline_code;
    private String callsign;
    private String country;
    
    public Airline(String description, String airline_code, String callsign, String country) {
        setDescription(description);
        setAirlineCode(airline_code);
        setCallsign(callsign);
        setCountry(country);
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
    public String getAirline_code() {
        return airline_code;
    }
    
    /**
     * @return the callsign of the airline
     */
    public String getCallsign() {
        return callsign;
    }
    
    /**
     * @return the country
     */
    public String getCountry() {
        return country;
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
    
    /**
     * @param callsign
     *            the callsign to set
     */
    private void setCallsign(String callsign) {
        this.callsign = callsign;
    }
    
    /**
     * @param country
     *            the country to set
     */
    private void setCountry(String country) {
        this.country = country;
    }
    
    @Override
    public int compareTo(Airline o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
