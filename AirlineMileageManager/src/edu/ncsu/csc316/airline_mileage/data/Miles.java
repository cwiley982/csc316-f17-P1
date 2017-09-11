package edu.ncsu.csc316.airline_mileage.data;

public class Miles {
    
    private Object[][] mileage;
    private Object[][] tempArray;
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
    
    public void sort() {
        
        /*
         * for (int i = 0; i < rows; i++) { for (int j = i; j > 0; j--) { if
         * ((Integer) mileage[j][0] > (Integer) mileage[j - 1][0]) { Object[]
         * temp = mileage[j - 1]; mileage[j - 1] = mileage[j]; mileage[j] =
         * temp; } } }
         */
        Object[][] temp = new Object[rows][3];
        int i = 0;
        while (mileage[i][0] != null) {
            temp[i] = mileage[i];
            i++;
        }
        
        mileage = mergeSort(temp);
    }
    
    public Object[][] mergeSort(Object[][] array) {
        if (array.length == 1) {
            return array;
        }
        int low = 0;
        int high = array.length - 1;
        int middle = (low + high) / 2;
        int index = 0;
        Object[][] left = new Object[middle + 1][3];
        while (index <= middle) {
            left[index] = array[index];
            index++;
        }
        Object[][] right = new Object[high - middle][3];
        while (index < array.length) {
            right[low] = array[index];
            low++;
            index++;
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return mergeParts(left, right);
    }
    
    public Object[][] mergeParts(Object[][] left, Object[][] right) {
        tempArray = new Object[left.length + right.length][3];
        int leftIndex = 0;
        int rightIndex = 0;
        int indexToAddTo = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if ((Integer) left[leftIndex][0] > (Integer) right[rightIndex][0]) {
                tempArray[indexToAddTo] = left[leftIndex];
                leftIndex++;
            } else if ((Integer) left[leftIndex][0] < (Integer) right[rightIndex][0]) {
                tempArray[indexToAddTo] = right[rightIndex];
                rightIndex++;
            } else { // they're equal, compare airline codes
                if (((String) left[leftIndex][2]).compareTo((String) right[rightIndex][2]) < 0) {
                    // left comes first
                    tempArray[indexToAddTo] = left[leftIndex];
                    leftIndex++;
                } else { // not possible to have same airline code, so this is
                         // when right comes before left
                    tempArray[indexToAddTo] = right[rightIndex];
                    rightIndex++;
                }
            }
            indexToAddTo++;
        }
        
        if (leftIndex == left.length) {
            while (rightIndex < right.length) {
                tempArray[indexToAddTo] = right[rightIndex];
                rightIndex++;
                indexToAddTo++;
            }
        } else if (rightIndex == right.length) {
            while (leftIndex < left.length) {
                tempArray[indexToAddTo] = left[leftIndex];
                leftIndex++;
                indexToAddTo++;
            }
        }

        return tempArray;
    }
    
    public String getMilesReport() {
        sort();
        String milesReport = "";
        for (int i = 0; i < rows; i++) {
            milesReport += "\n\t" + mileage[i][0] + " miles with " + mileage[i][1] + " "
                    + mileage[i][2];
        }
        return milesReport;
    }
}
