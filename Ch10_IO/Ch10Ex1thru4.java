import java.util.Scanner;


/**
 * We will utilize the concepts on input and output to solve different problems
 * We will use the I/O to solve the problems, according to their structures and
 * equations
 * 
 * @author Eric Cheng
 * @version 10/25/2013
 * @author Period - 6
 * @author Assignment - Ch10_IO
 * @author Sources - Eric Cheng
 */
public class Ch10Ex1thru4
{
    /**
     * 
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch10Ex1thru4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch10Ex1thru4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * We calculate the area of a circle with radius 3
     */
    public void areaOfACircle()
    {
        int radius = 3;
        double area = ( 3 * 3 * Math.PI );
        System.out.println( "Input the radius:" + radius );
        System.out.println( "The radius is:" + radius );
        System.out.println( "The area is:" + area );
    }


    /**
     * We interchange 324 cents into dollars and cents
     */
    public void centsToDollars()
    {
        int cent = 324;
        double dollar = 0.01 * cent;
        System.out.println( "Input the cents:" + cent );
        System.out.println( "That is:" + dollar );
    }


    /**
     * We give the correct change in coins for 163 cents
     */
    public void correctChange()
    {
        System.out.println( "Input the cents: " );
        int cents = scan.nextInt();
        int dollars = cents / 100;
        cents %= 100;
        int quarters = cents / 25;
        cents %= 25;
        int dimes = cents / 10;
        cents %= 10;
        int nickels = cents / 5;
        cents %= 5;
        System.out.print( "Your change is: " + dollars + " dollar, " + quarters
            + " quarters, " + dimes + " dimes, " + nickels + " nickels, and "
            + cents + " cents." );

    }


    /**
     * We find the current of a flow using the Ohm's Law
     */
    public void ohmsLaw()
    {
        double v = 125000000;
        double r = 12000;
        double i = ( v + 0.0 ) / r;
        System.out.println( "The Current is:" + i );
    }


    /**
     * Testing method: instantiates a Lesson10Exercises object and then invokes
     * each method.
     * 
     * @param args
     *            command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch10Ex1thru4 exercise = new Ch10Ex1thru4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "    (1) Area of a Circle" );
            System.out.println( "    (2) Cents to Dollars" );
            System.out.println( "    (3) Correct Change" );
            System.out.println( "    (4) Ohm's Law" );
            System.out.println( "    (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        exercise.areaOfACircle();
                        break;
                    case '2':
                        exercise.centsToDollars();
                        break;
                    case '3':
                        exercise.correctChange();
                        break;
                    case '4':
                        exercise.ohmsLaw();
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
