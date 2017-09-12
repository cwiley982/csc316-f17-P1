package edu.ncsu.csc316.airline_mileage.data;

public class Flight implements Comparable<Flight> {
    
    private String airline_code;
    private String airline;
    private int flight_number;
    private String origin;
    private String destination;
    private int distance;
    
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
     * @return the airline
     */
    public String getAirlineCode() {
        return airline_code;
    }
    
    /**
     * @param airline
     *            the airline to set
     */
    private void setAirlineCode(String airline_code) {
        this.airline_code = airline_code;
    }
    
    /**
     * @return the flight_number
     */
    public int getFlightNumber() {
        return flight_number;
    }
    
    /**
     * @param flight_number
     *            the flight_number to set
     */
    private void setFlightNumber(int flight_number) {
        this.flight_number = flight_number;
    }
    
    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }
    
    /**
     * @param origin
     *            the origin to set
     */
    private void setOrigin(String origin) {
        this.origin = origin;
    }
    
    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }
    
    /**
     * @param destination
     *            the destination to set
     */
    private void setDestination(String destination) {
        this.destination = destination;
    }
    
    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }
    
    /**
     * @param distance
     *            the distance to set
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
            if (this.getFlightNumber() < o.getFlightNumber()) {
                return -1;
            } else if (this.getFlightNumber() > o.getFlightNumber()) {
                return 1;
            } else { // flight numbers are the same
                if (this.getOrigin().compareTo(o.getOrigin()) > 0) {
                    return 1;
                } else if (this.getOrigin().compareTo(o.getOrigin()) < 0) {
                    return -1;
                } else { // origins are the same
                    if (this.getDestination().compareTo(o.getDestination()) > 0) {
                        return 1;
                    } else if (this.getDestination().compareTo(o.getDestination()) < 0) {
                        return -1;
                    } else { // destinations are the same
                        return 0;
                    }
                }
            }
        }
    }
    
    public String getFlightString() {
        return airline_code + flight_number;
    }
}
