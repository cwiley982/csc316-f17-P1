package edu.ncsu.csc316.airline_mileage.data;

public class Miles {
    
    private Object[][] mileage;
    private static final int INIT_SIZE = 10;
    private int rows;
    
    public Miles() {
        mileage = new Object[INIT_SIZE][3];
        rows = 0;
    }
    
    public void addMiles(String airline, String airline_code, int miles) {
        boolean airlineExists = false;
        for (int i = 0; i < rows; i++) {
            if (mileage[i][0].equals(airline)) {
                mileage[i][1] = (Integer) mileage[i][1] + miles;
                airlineExists = true;
                break;
            }
        }
        if (!airlineExists) {
            mileage[rows][0] = miles;
            mileage[rows][1] = airline;
            mileage[rows][2] = "(" + airline_code + ")";
        }
    }
    
    public String getMilesReport() {
        String milesReport = "";
        for (int i = 0; i < rows; i++) {
            milesReport += "\t" + mileage[i][1] + " miles with " + mileage[i][0] + " "
                    + mileage[i][2] + "\n";
        }
        return milesReport;
    }
}
