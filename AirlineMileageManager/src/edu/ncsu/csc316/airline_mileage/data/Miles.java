package edu.ncsu.csc316.airline_mileage.data;

public class Miles {
    
    private Object[][] mileage;
    private static final int INIT_SIZE = 10;
    private int rows;
    
    public Miles() {
        mileage = new Object[INIT_SIZE][2];
        rows = 0;
    }
    
    public void addMiles(String airline, int miles) {
        
    }
    
    public String getMilesReport() {
        String milesReport = "";
        for (int i = 0; i < rows; i++) {
            milesReport += "\t" + mileage[i][1] + " miles with " + mileage[i][0] + "\n";
        }
        return milesReport;
    }
}
