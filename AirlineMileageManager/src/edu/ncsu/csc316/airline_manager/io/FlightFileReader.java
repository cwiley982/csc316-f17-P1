package edu.ncsu.csc316.airline_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class FlightFileReader {
    
    public static LinkedList<Flight> readfile(String filename) throws FileNotFoundException {
        LinkedList<Flight> flights = new LinkedList<Flight>();
        Scanner scan = new Scanner(new File(filename));
        scan.nextLine(); // skips first line that describes each column
        while (scan.hasNextLine()) {
            scan.useDelimiter(",");
            int year = scan.nextInt(); // (year month day)
            int month = scan.nextInt();
            int day = scan.nextInt();
            Calendar date = Calendar.getInstance();
            date.set(year, month, day);
            int day_of_week = scan.nextInt();
            String airline = scan.next();
            int flight_num = scan.nextInt();
            String origin = scan.next();
            String dest = scan.next();
            int sched_depart = scan.nextInt();
            int act_depart = scan.nextInt();
            int distance = scan.nextInt();
            int sched_arr = scan.nextInt();
            scan.useDelimiter("\n");
            int arr_delay = scan.nextInt();
            flights.add(new Flight(date, day_of_week, airline, flight_num, origin, dest,
                    sched_depart, act_depart, distance, sched_arr, arr_delay));
        }
        scan.close();
        return flights;
    }
}
