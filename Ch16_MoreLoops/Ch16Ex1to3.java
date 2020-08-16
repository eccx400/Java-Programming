import java.util.*;


/**
 * Chapter 16 - More About Counting Loops Exercises 1-3.
 * 
 * @author Eric Cheng
 * @version 11/12/13
 * 
 * @author Period - 6
 * @author Assignment - Ch16Ex1_3
 * 
 * @author Sources - Eric CHeng
 */
public class Ch16Ex1to3
{
    /**
     * 
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch16Ex1to3()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch16Ex1to3( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * @return This is a program that adds up integers that the user enters. 
     * First the programs asks how many numbers will be added up, and then you
     * insert the integers to find the sum.
     */
    public int addingUpInts()
    {
        int sum = 0;
        System.out.println( "How many integers will be added: " );
        int integer = scan.nextInt();
        int count = 0;
        while ( count < integer )
        {
            System.out.println( "Enter an integer: " );
            int number = scan.nextInt();
            sum = sum + number;
            count++;
        }
        return sum;
    }


    /**
     * @return This program calculates the inverse sum using the equation of 
     * sum = 1.0/1 + 1.0/2 + 1.0/3 + 1.0/4 + 1.0/5 + .... + 1.0/N, where N is 
     * an integer limit that the user enters.
     */
    public double inverseSum()
    {
        double invSum = 0.0;

        int n;
        System.out.print( "Enter N: " );
        n = scan.nextInt();
        int x = 1;
        while ( x <= n )
        {
            invSum += ( 1.0 / x );
            x++;
        }
        System.out.println( " Inverse Sum is: " + invSum );
        return invSum;
    }


    /**
     * @return This is a program that computes the standard deviation of a set 
     * of floating point numbers that the user enters by giving the number N.
     */
    public double stdDeviation()
    {
        double stdDev = 0.0;

        System.out.println( "Enter number of numbers: " );
        double non = scan.nextInt();
        final double finnon = non;

        double avgsquare = 0;
        double avg = 0;
        double newnum = 0;

        while ( non > 0 )
        {
            System.out.println( "Enter number:" );
            newnum = scan.nextDouble();
            avg = avg + newnum;
            avgsquare = avgsquare + newnum * newnum;
            non = non - 1;
        }

        avg = avg / finnon;
        avgsquare = avgsquare / finnon;
        stdDev = stdDev + Math.sqrt( avgsquare - avg * avg );
        return stdDev;
    }


    /**
     * Testing method: instantiates a Ch16Ex1to3 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch16Ex1to3 exercise = new Ch16Ex1to3();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Adding up Integers" );
            System.out.println( "   (2) Inverse Sum" );
            System.out.println( "   (3) Standard Deviation" );
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
                        int sumOfInts = exercise.addingUpInts();
                        System.out.println( "addingUpInts() = " + sumOfInts );
                        break;
                    case '2':
                        double invSum = exercise.inverseSum();
                        System.out.println( "inverseSum() = " + invSum );
                        break;
                    case '3':
                        double stdDev = exercise.stdDeviation();
                        System.out.println( "stdDeviation() = " + stdDev );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );

        System.out.println( "Goodbye!" );
    }
}
