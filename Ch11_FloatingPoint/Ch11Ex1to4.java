import java.util.Scanner;


/**
 * We will use the subject of floating points to solve these problems Floating
 * points contains usage of float and double, but we will mainly be using
 * doubles to solve these problems
 * 
 * @author Eric Cheng
 * @version 10/30/2013
 * @author Period - 6
 * @author Assignment - Ch11_FloatingPoint
 * @author Sources - Eric Cheng
 */
public class Ch11Ex1to4
{
    /**
     * 
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch11Ex1to4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch11Ex1to4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * Use the given kilowatts and kilowatt-hours to calulate the annual cost of
     * electricity used
     */
    public void annualCost()
    {
        System.out.println( "Enter cost per kilowatt-hour  in cents" );
        double cost = scan.nextDouble();
        System.out.println( "Enter kilowatt-hours used per year" );
        double time = scan.nextDouble();
        System.out.println( "Annual Cost:" + ( cost * time / 100 ) );
    }


    /**
     * We can use floating points to find the time and distance the brick fell
     * to the ground in feet
     */
    public void fallingBrick()
    {
        System.out.println( "Enter the number of seconds: " );
        double second = scan.nextDouble();
        System.out.println( "The brick fell "
            + ( ( 0.5 ) * ( 32.174 ) * ( second * second ) ) + "feet in"
            + second + "seconds." );
        System.out.println( "Enter the distance: " );
        double distance = scan.nextDouble();
        System.out.println( "The brick fell" + distance + "feet in"
            + Math.sqrt( ( distance / 0.5 ) / ( 32.174 ) ) + "." );

    }


    /**
     * We can find out the log base 2 for all numbers
     */
    public void base2Log()
    {
        System.out.println( "Enter a double: " );
        double x = scan.nextDouble();
        System.out.println( "Base 2 log of 998.65 is " + ( Math.log( x ) )
            / ( Math.log( 2 ) ) );
    }


    /**
     * We can find the harmonic mean and arithmetic mean by using I/O
     */
    public void harmonicMean()
    {
        System.out.println( "Enter X: " );
        double x = scan.nextDouble();
        System.out.println( "Enter Y: " );
        double y = scan.nextDouble();
        System.out.println( "Arithmetic mean:" + ( ( x + y ) ) / 2.0 );
        System.out.println( "Harmonic mean:" + ( 2 / ( 1 / x + 1 / y ) ) );
    }


    /**
     * Testing method: instantiates a Ch11Ex1_4 object and then invokes each
     * method
     * 
     * @param args
     *            command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch11Ex1to4 exercise = new Ch11Ex1to4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "    (1) Annual Cost of Running an Appliance" );
            System.out.println( "    (2) Falling Brick" );
            System.out.println( "    (3) Base 2 Logarithm of a Number" );
            System.out.println( "    (4) Harmonic Mean" );
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
                        exercise.annualCost();
                        break;
                    case '2':
                        exercise.fallingBrick();
                        break;
                    case '3':
                        exercise.base2Log();
                        break;
                    case '4':
                        exercise.harmonicMean();
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
