package edu.ncsu.csc316.airline_mileage.data;

public class Flight implements Comparable<Flight> {
    
    /** The 2 character airline code */
    private String airline_code;
    /** The full name of the airline */
    private String airline;
    /** The flight number */
    private int flight_number;
    /** The origin of the flight */
    private String origin;
    /** The destination of the flight */
    private String destination;
    /** Distance the flight flew in miles */
    private int distance;
    
    /**
     * Constructs a flight object with all necessary information to se fields
     * 
     * @param airline_code
     *            airline code of the flight
     * @param airline
     *            full name of the airline the flight is with
     * @param flight_number
     *            number of the flight
     * @param origin
     *            where the flight started
     * @param dest
     *            where the flight ended
     * @param dist
     *            how far the flight went
     */
    public Flight(String airline_code, String airline, int flight_number,
            String origin, String dest, int dist) {
        setAirlineCode(airline_code);
        setAirline(airline);
        setFlightNumber(flight_number);
        setOrigin(origin);
        setDestination(dest);
        setDistance(dist);
    }
    
    /**
     * Gets the airline code
     * 
     * @return the airline
     */
    public String getAirlineCode() {
        return airline_code;
    }
    
    /**
     * Sets the airline code
     * 
     * @param airline
     *            the airline to set
     */
    private void setAirlineCode(String airline_code) {
        this.airline_code = airline_code;
    }
    
    /**
     * Gets the flight number
     * 
     * @return the flight_number
     */
    public int getFlightNumber() {
        return flight_number;
    }
    
    /**
     * Sets the flight number
     * 
     * @param flight_number
     *            the flight_number to set
     */
    private void setFlightNumber(int flight_number) {
        this.flight_number = flight_number;
    }
    
    /**
     * Gets the origin of the flight
     * 
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }
    
    /**
     * Sets the origin
     * 
     * @param origin
     *            the origin to set
     */
    private void setOrigin(String origin) {
        this.origin = origin;
    }
    
    /**
     * Gets where the flight arrived
     * 
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }
    
    /**
     * Sets the destination of the flight
     * 
     * @param destination
     *            the destination to set
     */
    private void setDestination(String destination) {
        this.destination = destination;
    }
    
    /**
     * Gets the number of miles the flight flew
     * 
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }
    
    /**
     * Sets the distance this flight flew
     * 
     * @param distance
     *            the distance the flight flew
     */
    private void setDistance(int distance) {
        this.distance = distance;
    }
    
    /**
     * Gets the full name of the airline (ie "United Airlines")
     * 
     * @return the name of the airline
     */
    public String getAirline() {
        return airline;
    }
    
    /**
     * Sets the airline passed in to be the airline for the flight object
     * 
     * @param airline
     *            the airline to set
     */
    public void setAirline(String airline) {
        this.airline = airline;
    }
    
    @Override
    public int compareTo(Flight o) {
        if (this.getAirlineCode().compareTo(o.getAirlineCode()) > 0) {
            return 1;
        } else if (this.getAirlineCode().compareTo(o.getAirlineCode()) < 0) {
            return -1;
        } else { // codes are the same
            if (this.getFlightNumber() > o.getFlightNumber()) {
                return 1;
            } else if (this.getFlightNumber() < o.getFlightNumber()) {
                return -1;
            } else { // numbers are the same
                if (this.getOrigin().compareTo(o.getOrigin()) > 0) {
                    return 1;
                } else if (this.getOrigin().compareTo(o.getOrigin()) < 0) {
                    return -1;
                } else { // origins are the same
                    if (this.getDestination().compareTo(o.getDestination()) > 0) {
                        return 1;
                    } else if (this.getDestination().compareTo(o.getDestination()) < 0) {
                        return -1;
                    } else { // destinations are the same, therefore the flight
                             // is
                        // the same
                        return 0;
                    }
                }
            }
        }
    }
    
    /**
     * Gets a string containing the airline code and flight number
     * 
     * @return string containing the airline code and flight number
     */
    public String getFlightString() {
        return airline_code + flight_number;
    }
}
