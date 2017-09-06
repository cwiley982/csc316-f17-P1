package edu.ncsu.csc316.airline_mileage.data;

import java.util.Calendar;

public class Flight implements Comparable<Flight> {
    
    private Calendar date;
    private int day_of_week;
    private String airline;
    private int flight_number;
    private String origin;
    private String destination;
    private int scheduled_departure;
    private int actual_departure;
    private int distance;
    private int scheduled_arrival;
    private int arrival_delay;
    
    public Flight(Calendar date, int day_of_week, String airline, int flight_number, String origin,
            String dest, int sched_depart, int act_depart, int dist, int sched_arr, int arr_delay) {
        setDate(date);
        setDayOfWeek(day_of_week);
        setAirline(airline);
        setFlightNumber(flight_number);
        setOrigin(origin);
        setDestination(dest);
        setScheduledDeparture(sched_depart);
        setActualDeparture(act_depart);
        setDistance(dist);
        setScheduledArrival(sched_arr);
        setArrivalDelay(arr_delay);
    }
    
    public int compareTo() {
        return 2;
        // TODO
    }
    
    /**
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }
    
    /**
     * @param year
     *            the year to use in the date
     * @param month
     *            the month to use in the date
     * @param day
     *            the day to use in the date
     */
    private void setDate(Calendar date) {
        this.date = date;
    }
    
    /**
     * @return the day_of_week
     */
    public int getDayOfWeek() {
        return day_of_week;
    }
    
    /**
     * @param day_of_week
     *            the day_of_week to set
     */
    private void setDayOfWeek(int day_of_week) {
        this.day_of_week = day_of_week;
    }
    
    /**
     * @return the airline
     */
    public String getAirline() {
        return airline;
    }
    
    /**
     * @param airline
     *            the airline to set
     */
    private void setAirline(String airline) {
        this.airline = airline;
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
     * @return the scheduled_departure
     */
    public int getScheduledDeparture() {
        return scheduled_departure;
    }
    
    /**
     * @param scheduled_departure
     *            the scheduled_departure to set
     */
    private void setScheduledDeparture(int scheduled_departure) {
        this.scheduled_departure = scheduled_departure;
    }
    
    /**
     * @return the actual_departure
     */
    public int getActualDeparture() {
        return actual_departure;
    }
    
    /**
     * @param actual_departure
     *            the actual_departure to set
     */
    private void setActualDeparture(int actual_departure) {
        this.actual_departure = actual_departure;
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
     * @return the scheduled_arrival
     */
    public int getScheduledArrival() {
        return scheduled_arrival;
    }
    
    /**
     * @param scheduled_arrival
     *            the scheduled_arrival to set
     */
    private void setScheduledArrival(int scheduled_arrival) {
        this.scheduled_arrival = scheduled_arrival;
    }
    
    /**
     * @return the arrival_delay
     */
    public int getArrivalDelay() {
        return arrival_delay;
    }
    
    /**
     * @param arrival_delay
     *            the arrival_delay to set
     */
    private void setArrivalDelay(int arrival_delay) {
        this.arrival_delay = arrival_delay;
    }
    
    @Override
    public int compareTo(Flight o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    public String getFlightString() {
        return airline + flight_number;
    }
}
