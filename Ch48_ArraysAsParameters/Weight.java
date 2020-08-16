import java.io.*;

/**
 * These exercises create a class, Weight that contains an array of the weight
 * of an individual taken on successive days for one month.
 * 
 * @author Eric Cheng
 * @version 1/28/2014
 * 
 * @author Period - 6
 * @author Assignment - Chapter 48 Arrays as Parameters Exercises 1-3
 * 
 * @author Sources - Eric Cheng
 */
public class Weight 
{ 
    private int[] data; 
  
  
    /** 
     * Constructs a Weight object that contains an array of the weight of an 
     * individual taken on successive days for one month. 
     *  
     * @param init 
     *            array of weights for one month 
     */
    public Weight( int[] init ) 
    { 
        // Construct the array the same length 
        // as that referenced by init. 
        data = new int[init.length]; 
  
        // Copy values from the 
        // input data to data. 
        for ( int j = 0; j < data.length; j++ ) 
        { 
            data[j] = init[j]; 
        } 
    } 
  
  
    /** 
     * Now add an average() method to the class. Use integer math. 
     *  
     * @return average 
     */
    public int average() 
    { 
        int sum = 0; 
        for ( int x : data ) 
        { 
            sum += x; 
        } 
        return sum / data.length; 
    } 
  
  
    /** 
     * Now add another method that computes the average for a range of days.
     * The method signature looks like this: 
     *  
     * @param start 
     *            avg start 
     * @param end 
     *            avg end 
     * @return subavg 
     */
    public int subAverage( int start, int end ) 
    { 
        int sum = 0; 
        for ( int i = start; i <= end; i++ ) 
        { 
            sum += data[i]; 
        } 
        return sum / ( end - start + 1 ); 
    } 
  
  
    /** 
     * Then complete the print() method. If you want, write it so that it 
     * prints seven values per line, except for the last line. 
     */
    public void print() 
    { 
        for ( int j = 0; j < data.length; j++ ) 
        { 
            if ( j % 7 == 0 ) 
            { 
                System.out.println(); 
            } 
            System.out.print( data[j] + " " ); 
        } 
    } 
  
  
    /** 
     * Testing method: instantiates a Weight object and then invokes each 
     * method. 
     *  
     * @param args 
     *            command line parameters (not used) 
     */
    public static void main( String[] args ) 
    { 
        int[] values = { 98, 99, 98, 99, 100, 101, 102, 100, 104, 105, 105, 
            106, 105, 103, 104, 103, 105, 106, 107, 106, 105, 105, 104, 104, 
            103, 102, 102, 101, 100, 102 }; 
  
        Weight june = new Weight( values ); 
        june.print(); 
  
        int avg = june.average(); 
        System.out.println( "average = " + avg ); 
  
        int avg1stHalf = 
            june.subAverage( 0, ( values.length - 1 ) / 2 ); 
        System.out.println( "average of first half of month = " 
            + avg1stHalf ); 
  
        int avg2ndHalf = 
            june.subAverage( values.length / 2, values.length - 1 ); 
        System.out.println( "average of second half of month = " 
            + avg2ndHalf ); 
    } 
} 