package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class CustomerFileReader {
    
    /*
     * I want to return an ArrayList of Customers, but I need to figure out
     * how to deal with there being multiple instances of the same customer in
     * a file. Need to check to see if the person exists already, if not create
     * a new Customer. If they do exist, need to figure out how to add flights
     * to their list. Maybe pass in the flights ArrayList into this method so
     * I'll have access to the flight objects already created when reading in
     * the flight file.
     */
    public static Object[][] readfile(String filename) throws FileNotFoundException {
        Scanner countLines = new Scanner(new File(filename));
        int lines = 0;
        while (countLines.hasNextLine()) {
            lines++;
            countLines.nextLine();
        }
        countLines.close();
        Object[][] data = new Object[lines][6];
        Scanner scan = new Scanner(new File(filename));
        scan.nextLine(); // skips first line that describes each column
        int currentLine = 0;
        while (scan.hasNextLine()) {
            scan.useDelimiter(",");
            String first = scan.next();
            String last = scan.next();
            scan.useDelimiter("/");
            int month = scan.nextInt();
            int day = scan.nextInt();
            scan.useDelimiter(",");
            int year = scan.nextInt();
            Calendar date = Calendar.getInstance();
            date.set(year, month, day);
            String flight = scan.next();
            String origin = scan.next();
            String dest = scan.next();
            data[currentLine][0] = first;
            data[currentLine][1] = last;
            data[currentLine][2] = date;
            data[currentLine][3] = flight;
            data[currentLine][4] = origin;
            data[currentLine][5] = dest;
            currentLine++;
        }
        scan.close();
        return data;
    }
}
