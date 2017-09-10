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
            if (mileage[i][1].equals(airline)) {
                mileage[i][0] = (Integer) mileage[i][0] + miles;
                airlineExists = true;
                break;
            }
        }
        if (!airlineExists) {
            mileage[rows][0] = miles;
            mileage[rows][1] = airline;
            mileage[rows][2] = "(" + airline_code + ")";
            rows++;
        }
    }
    
    public String getMilesReport() {
        String milesReport = "";
        for (int i = 0; i < rows; i++) {
            milesReport += "\n\t" + mileage[i][0] + " miles with " + mileage[i][1] + " "
                    + mileage[i][2];
        }
        return milesReport;
    }
}
