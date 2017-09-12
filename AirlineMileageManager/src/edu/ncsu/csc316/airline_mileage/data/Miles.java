package edu.ncsu.csc316.airline_mileage.data;

/**
 * Creates a miles object that holds information about the miles a customer has
 * flown on each airline
 * 
 * @author Caitlyn Wiley
 *
 */
public class Miles {
    
    private Object[][] mileage;
    private Object[][] tempArray;
    private static final int INIT_SIZE = 10;
    private static final int RESIZE = 2;
    private int rows;
    
    /**
     * Constructs a miles object and initializes its state
     */
    public Miles() {
        mileage = new Object[INIT_SIZE][3];
        rows = 0;
    }
    
    /**
     * Adds a flight to this object. Increments miles for an airline if the
     * airline is already in the array, else it adds a new row with the new
     * airline.
     * 
     * @param airline
     *            the full name of the airline
     * @param airlineCode
     *            the code of the airline
     * @param miles
     *            the miles the flight to be added has flown
     */
    public void addMiles(String airline, String airlineCode, int miles) {
        boolean airlineExists = false;
        for (int i = 0; i < rows; i++) {
            if (mileage[i][1].equals(airline)) {
                mileage[i][0] = (Integer) mileage[i][0] + miles;
                airlineExists = true;
                break;
            }
        }
        if (!airlineExists) {
            if (rows >= mileage.length) {
                growArray();
            }
            mileage[rows][0] = miles;
            mileage[rows][1] = airline;
            mileage[rows][2] = "(" + airlineCode + ")";
            rows++;
        }
    }
    
    private void growArray() {
        Object[][] temp = new Object[mileage.length * RESIZE][3];
        for (int i = 0; i < mileage.length; i++) {
            temp[i] = mileage[i];
        }
        mileage = temp;
    }
    
    private void sort() {
        Object[][] temp = new Object[rows][3];
        int i = 0;
        while (i < rows) {
            temp[i] = mileage[i];
            i++;
        }
        
        mileage = mergeSort(temp);
    }
    
    private Object[][] mergeSort(Object[][] array) {
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
    
    private Object[][] mergeParts(Object[][] left, Object[][] right) {
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
    
    /**
     * Puts the mileage array into a string to print out to the user
     * 
     * @return a string representation of the mileage array
     */
    public String getMilesReport() {
        sort();
        String milesReport = "";
        for (int i = 0; i < rows; i++) {
            milesReport += "\n    " + mileage[i][0] + " miles with " + mileage[i][1] + " "
                    + mileage[i][2];
        }
        return milesReport;
    }
}
