import java.util.*;
import java.io.*;


/**
 * Chapter 49C - Two-Dimensional Arrays Exercises 1-8
 * 
 * @author Eric Cheng
 * @version 2/12/2014
 * @author Period - 6
 * @author Assignment - Ch49C_2DArrays
 * @author Sources - Eric Cheng
 */
public class Ch49C_2DArrays
{
    Scanner scan;


    public Ch49C_2DArrays()
    {
        scan = new Scanner( System.in );
    }


    /**
     * This program finds the sum of all elements in the 2D array, using the
     * lengths of each of them
     */
    public int sumOfAllArrayElements( int[][] data )
    {
        // declare the sum
        int sum = 0;

        // compute the sum
        for ( int row = 0; row < data.length; row++ )
        {
            for ( int col = 0; col < data[row].length; col++ )
            {
                sum = sum + data[row][col];
            }
        }

        // write out the sum
        System.out.println( "The sum of all array elements is: " + sum );

        return sum;
    }


    /**
     * This program computes the sum of the elements in each row of the 2D
     * array.
     */
    public int[] sumOfEachRow( int[][] data )
    {
        // declare the row sum array
        int[] rowSums = new int[data.length];

        // compute the sums for each row
        for ( int row = 0; row < data.length; row++ )
        {
            // initialize the sum

            // compute the sum for this row
            for ( int col = 0; col < data[row].length; col++ )
            {
                rowSums[row] += data[row][col];
            }

            System.out.println( rowSums[row] );
        }

        return rowSums;
    }


    /**
     * The program now runs so that it computes and prints the sum of each
     * column of the array, as opposed the the sum of the rows in the previous
     * program.
     */
    public int[] sumOfEachColumn( int[][] data )
    {
        int muchLong = 0;
        int longRow;
        for ( int row = 0; row < data.length; row++ )
        {
            longRow = 0;
            for ( int col = 0; col < data[row].length; col++ )
            {
                longRow++;
            }
            if ( longRow > muchLong )
            {
                muchLong = longRow;
            }
        }

        int[] colSums = new int[muchLong];

        for ( int row = 0; row < data.length; row++ )
        {
            for ( int col = 0; col < data[row].length; col++ )
            {
                colSums[col] += data[row][col];
            }
        }

        for ( int count = 0; count < colSums.length; count++ )
        {
            System.out.println( colSums[count] );
        }
        return colSums;
    }


    /**
     * Complete the following program so that it computes the maximum and
     * minimun of the elements in the array. Write the program so that it works
     * even if the dimensions of the rows and columns are changed. In other
     * words, use length rather than hard-coded numbers.)
     */
    public int[] maxAndMinElements( int[][] data )
    {
        int max = data[0][0];
        int min = data[0][0];

        for ( int row = 0; row < data.length; row++ )
        {
            for ( int col = 0; col < data[row].length; col++ )
            {
                if ( data[row][col] > max )
                {
                    max = data[row][col];
                }
                else if ( data[row][col] < min )
                {
                    min = data[row][col];
                }
            }
        }

        int[] result = { max, min };
        for ( int count = 0; count < result.length; count++ )
        {
            System.out.println( result[count] );
        }

        return result;
    }


    /**
     * This program is used so that it computes and prints the largest element
     * in each row of the 2D array.
     */
    public int[] largestElements( int[][] data )
    {
        // declare the largest in row array
        int[] largestInRow = new int[data.length];

        for ( int count = 0; count < data.length; count++ )
        {
            largestInRow[count] = data[count][0];
            for ( int countcol = 0; countcol < data[count].length; countcol++ )
            {
                if ( data[count][countcol] > largestInRow[count] )
                {
                    largestInRow[count] = data[count][countcol];
                }
            }
        }

        for ( int count = 0; count < largestInRow.length; count++ )
        {
            System.out.println( largestInRow[count] );
        }
        return largestInRow;
    }


    /**
     * This is a program that reverses the order of the elements in each row of
     * the 2D array, then prints out the resulting 2D array.
     */
    public void reversalOfElementsInEachRow( int[][] data )
    {
        int reverse;

        for ( int row = 0; row < data.length; row++ )
        {
            for ( int col = 0; col < data[row].length / 2; col++ )
            {
                reverse = data[row][col];
                data[row][col] = data[row][data[row].length - 1 - col];
                data[row][data[row].length - 1 - col] = reverse;
            }
        }
        for ( int row = 0; row < data.length; row++ )
        {
            for ( int col = 0; col < data[row].length; col++ )
            {
                System.out.print( data[row][col] + " " );
            }
            System.out.println();
        }
    }


    /**
     * A gray-level image is sometimes stored as a list of int values. The
     * values represent the intensity of light at discrete positions in the
     * image.
     * 
     * An image may be smoothed by replacing each element with the average of
     * the element's neighboring elements.
     * 
     * Say that the original values are in the 2D array "image". Compute the
     * smoothed array by doing this: Each value smooth[r][c] is the average of
     * nine values:
     * 
     * 
     * image[r-1][c-1], image[r-1][c ], image[r-1][c+1], image[r ][c-1], image
     * [r][c ], image[r ][c+1], image[r+1][c-1], image[r+1][c ], image[r+1]
     * [c+1]. Assume that the image is rectangular, that is, all rows have the
     * same number of locations. Use integer arithmetic for this so that the
     * values in smooth are integers.
     */
    public int[][] imageSmootherEasy( int[][] image )
    {
        int[][] smooth = new int[image.length][image[0].length];

        int sum;
        for ( int row = 1; row < image.length - 1; row++ )
        {
            sum = 0;
            int col;
            for ( col = 1; col < image[row].length - 1; col++ )
            {
                sum = image[row - 1][col - 1] + image[row - 1][col + 1]
                    + image[row][col - 1] + image[row - 1][col]
                    + image[row][col] + image[row + 1][col]
                    + image[row][col + 1] + image[row + 1][col + 1]
                    + image[row + 1][col - 1];
                smooth[row][col] = sum / 9;
            }
        }

        for ( int row = 0; row < image.length; row++ )
        {
            for ( int col = 0; col < image[row].length; col++ )
            {
                System.out.print( image[row][col] + " " );
            }
            System.out.println();
        }

        for ( int row = 0; row < smooth.length; row++ )
        {
            for ( int col = 0; col < smooth[row].length; col++ )
            {
                System.out.print( smooth[row][col] + " " );
            }
            System.out.println();
        }

        return smooth;
    }


    /**
     * Alternate (Hard): Copy the original image into the center of an enlarged
     * array that has two more columns and two more rows than the original.
     * Create another enlarged array to hold a temporary smoothed version of the
     * enlarged array. Now, apply the Easy solution to the enlarged array with
     * the other enlarged array as the result. Next, copy the center of the
     * result to the final smooth image.
     */
    public int[][] imageSmootherHard( int[][] image )
    {
        // assume a rectangular image
        int[][] smooth = new int[image.length][image[0].length];

        int sum;
        int count;
        for ( int row = 0; row < image.length; row++ )
        {
            int col;
            for ( col = 0; col < image[row].length; col++ )
            {
                sum = 0;
                count = 0;
                if ( row - 1 >= 0 && col - 1 >= 0 )
                {
                    sum += image[row - 1][col - 1];
                    count = count + 1;
                }
                if ( row - 1 >= 0 && col + 1 < image[row].length )
                {
                    sum += image[row - 1][col + 1];
                    count = count + 1;
                }
                if ( col - 1 >= 0 )
                {
                    sum += image[row][col - 1];
                    count = count + 1;
                }
                if ( row - 1 >= 0 )
                {
                    sum += image[row - 1][col];
                    count = count + 1;
                }
                if ( row + 1 < image.length )
                {
                    sum += image[row + 1][col];
                    count = count + 1;
                }
                if ( row + 1 < image.length && col + 1 < image[row].length )
                {
                    sum += image[row + 1][col + 1];
                    count = count + 1;
                }
                if ( col + 1 < image[row].length )
                {
                    sum += image[row][col + 1];
                    count = count + 1;
                }
                if ( row + 1 < image.length && col - 1 >= 0 )
                {
                    sum += image[row + 1][col - 1];
                    count = count + 1;
                }
                sum += image[row][col];
                count = count + 1;
                smooth[row][col] = sum / 9;
            }
        }

        for ( int row = 0; row < image.length; row++ )
        {
            for ( int col = 0; col < image[row].length; col++ )
            {
                System.out.print( image[row][col] + " " );
            }
            System.out.println();
        }

        System.out.println();

        for ( int row = 0; row < smooth.length; row++ )
        {
            for ( int col = 0; col < smooth[row].length; col++ )
            {
                System.out.print( smooth[row][col] + " " );
            }
            System.out.println();
        }

        return smooth;
    }


    /**
     * Testing method: instantiates a Lesson49C Exercises object and then
     * invokes each method
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch49C_2DArrays exercise = new Ch49C_2DArrays();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Sum of All Array Elements" );
            System.out.println( "   (2) Sum of Each Row" );
            System.out.println( "   (3) Sum of Each Column" );
            System.out.println( "   (4) Maximum and Minimum Elements" );
            System.out.println( "   (5) Largest Elements" );
            System.out.println( "   (6) Reversal of Elements in Each Row" );
            System.out.println( "   (7) Image Smoother (Easy)" );
            System.out.println( "   (8) Image Smoother (Hard)" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        int[][] dataEx1 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        int sum = exercise.sumOfAllArrayElements( dataEx1 );
                        break;
                    case '2':
                        int[][] dataEx2 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        int[] rowSums = exercise.sumOfEachRow( dataEx2 );
                        break;
                    case '3':
                        int[][] dataEx3 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        int[] colSums = exercise.sumOfEachColumn( dataEx3 );
                        break;
                    case '4':
                        int[][] dataEx4 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        int[] maxMin = exercise.maxAndMinElements( dataEx4 );
                        break;
                    case '5':
                        int[][] dataEx5 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        int[] largestInRow = exercise.largestElements( dataEx5 );
                        break;
                    case '6':
                        int[][] dataEx6 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        exercise.reversalOfElementsInEachRow( dataEx6 );
                        break;
                    case '7':
                        int[][] imageEx7 = {
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
                        int[][] easySmooth = exercise.imageSmootherEasy( imageEx7 );
                        break;
                    case '8':
                        int[][] imageEx8 = {
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
                        int[][] hardSmooth = exercise.imageSmootherHard( imageEx8 );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                            done = true;
                        else
                            System.out.print( "Invalid Choice" );
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
