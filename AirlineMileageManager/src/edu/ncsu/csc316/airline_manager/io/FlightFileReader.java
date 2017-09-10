package edu.ncsu.csc316.airline_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.util.LinkedList;

public class FlightFileReader {
    
    public static LinkedList<Flight> readfile(String filename, String[][] airlineArray)
            throws FileNotFoundException {
        LinkedList<Flight> flights = new LinkedList<Flight>();
        Scanner scan = new Scanner(new File(filename));
        scan.nextLine(); // skips first line that describes each column
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            int year = lineScan.nextInt();
            int month = lineScan.nextInt();
            int day = lineScan.nextInt();
            String dateString = month + "/" + day + "/" + year;
            Calendar date = Calendar.getInstance();
            date.set(year, month, day);
            int day_of_week = lineScan.nextInt();
            String airline_code = lineScan.next();
            int flight_num = lineScan.nextInt();
            String origin = lineScan.next();
            String dest = lineScan.next();
            int sched_depart = lineScan.nextInt();
            int act_depart = lineScan.nextInt();
            int distance = lineScan.nextInt();
            int sched_arr = lineScan.nextInt();
            int arr_delay = lineScan.nextInt();
            String airline = getAirline(airline_code, airlineArray);
            flights.add(new Flight(dateString, day_of_week, airline_code, airline, flight_num,
                    origin, dest,
                    sched_depart, act_depart, distance, sched_arr, arr_delay));
            lineScan.close();
        }
        scan.close();
        return flights;
    }
    
    private static String getAirline(String airline_code, String[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (airline_code.equals(array[i][0])) {
                return array[i][1];
            }
        }
        return null;
    }
}
