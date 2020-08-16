import java.util.*;


/**
 * Chapter 18 - Sentinel Controlled Loops Exercises 1-5.
 * 
 * @author Eric Cheng
 * @version 11/17/2013
 * 
 * @author Period - 6
 * @author Your Period
 * @author Assignment - Ch18Ex1to5
 * 
 * @author Sources - Eric Cheng
 */
public class Ch18Ex1to5
{
    /**
     *
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch18Ex1to5()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch18Ex1to5( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * This is a program that calculates miles per gallon for a list of cars. It
     * uses the odometer reading and gallons of gas to calculate the mpg.
     */
    public void milesPerGallon()
    {
        System.out.println( "Miles Per Gallon Program" );
        System.out.println( "Initial Miles: " );
        double initial = scan.nextDouble();
        while ( initial > 0 )
        {
            System.out.println( "Final Miles: " );
            double fin = scan.nextDouble();
            System.out.println( "Gallons: " );
            double gal = scan.nextDouble();
            double mpg = ( fin - initial ) / gal;
            System.out.println( "Miles per Gallon: " + mpg );
            System.out.println( "Initial Miles: " );
            initial = scan.nextDouble();
        }
        System.out.println( "bye" );
    }


    /**
     * This is a program that asks the user for the low and high integer in a
     * range of integers. The program then asks the user for integers to be
     * added up. The program computes two sums:The sum of integers that are in
     * the range (inclusive),and the sum of integers that are outside of the
     * range.The user signals the end of input with a 0.
     */
    public void inRangeAdder()
    {
        System.out.println( "In-Range Adder" );
        System.out.println( "" );
        System.out.println( "Low end of range: " );
        double low = scan.nextDouble();
        System.out.println( "High end of range: " );
        double high = scan.nextDouble();
        System.out.println( "Enter data: " );
        int current = scan.nextInt();
        int sum1 = 0;
        int sum2 = 0;
        while ( current != 0 )
        {
            if ( current <= high && current >= low )
            {
                sum1 = sum1 + current;
            }
            else
            {
                sum2 = sum2 + current;
            }
            System.out.println( "Sum of in range values:" );
            current = scan.nextInt();
        }
        System.out.println( "Sum of in range values: " + sum1 );
        System.out.println( "Sum of out of range values: " + sum2 );
    }


    /**
     * A mail order company charges $3.00 for handling, free shipping for orders
     * 10 pounds or less, plus $0.25 for each pound over 10. This is a program
     * that repeatedly asks the user for the weight of an order, then writes out
     * the shipping charge. The program stops when a weight of zero or less is
     * entered.
     */
    public void shippingCostCalc()
    {
        System.out.print( "Weight of Order: " );
        int weight = scan.nextInt();
        double cost = 0;
        while ( weight != 0 )
        {
            if ( weight > 10 )
            {
                cost = 3 + ( 0.25 * ( weight - 10 ) );
            }
            else
            {
                cost = 3;
            }
            System.out.println( "Shipping cost: $" + cost );
            System.out.print( "\nWeight of Order: " );
            weight = scan.nextInt();
        }
        System.out.println( "\nbye" );
    }


    /**
     * This is a program calculates and writes out the height, the width, and
     * the area of the rectangle. The two corners entered for each rectangle
     * must be diagonally opposite (upper left and lower right, or upper right
     * and lower left), but which choice is made for each rectangle is up to the
     * user. The user can enter the corners in any order. Height and width are
     * always positive
     */
    public void areaOfRectangle()
    {
        System.out.println( "First corner X coordinate:" );
        int x1 = scan.nextInt();
        System.out.println( "First corner Y coordinate:" );
        int y1 = scan.nextInt();
        System.out.println( "Second corner X coordinate:" );
        int x2 = scan.nextInt();
        System.out.println( "Second corner Y coordinate:" );
        int y2 = scan.nextInt();
        int width = Math.abs( x1 - x2 );
        int height = Math.abs( y1 - y2 );
        int area = height * width;

        while ( width != 0 || height != 0 )
        {
            System.out.println( "Width:  " + width + "  Height:  " + height
                + "  Area:  " + area );
            System.out.println( '\n' + "First corner X coordinate:" );
            x1 = scan.nextInt();
            System.out.println( "First corner Y coordinate:" );
            y1 = scan.nextInt();
            System.out.println( "Second corner X coordinate:" );
            x2 = scan.nextInt();
            System.out.println( "Second corner Y coordinate:" );
            y2 = scan.nextInt();
            width = Math.abs( x1 - x2 );
            height = Math.abs( y1 - y2 );
            area = height * width;
        }
        if ( width == 0 || height == 0 )
        {
            System.out.println( "Width:  0" + "  Height:  0" + "  Area:  0" );
            System.out.println( '\n' + "finished" );
        }
    }


    /**
     * This is a program that simulates the "login" process of a computer. A
     * loop continuously asks the user for their user name and password. Assume
     * that each is a single word. If the user name and password match one of
     * the correct pairs, allow the user to log on (actually: just print a
     * simulated message). A logged-on user has a priority from 1 (low) to 5
     * (high). Otherwise print a failure message. If the user name is "quit"
     * with a password "exit", exit the loop and print a final message.
     */
    public void loginSimulator()
    {
        int priority = 1;
        while ( priority >= 1 || priority <= 5)  
        {
            System.out.print( "User Name: " );
            String user = scan.next();
            System.out.print( "Password: " );
            String pass = scan.next();
            if ( user.equals( "joy" ) && pass.equals( "sun" ) )
            {
                System.out.println( "You have logged in with priority 4." );
            }
            else if ( user.equals( "gates" ) && pass.equals( "monopoly" ) )
            {
                System.out.println( "You have logged in with priority 1." );
            }
            else if ( user.equals( "jobs" ) && pass.equals( "apple" ) )
            {
                System.out.println( "You have logged in with priority 3." );
            }
            else if ( user.equals( "root" ) && pass.equals( "secret" ) )
            {
                System.out.println( "You have logged in with priority 5." );
            }            
            else if ( user.equals( "quit" ) && pass.equals( "exit" ) )
            {
                System.out.println( "System shutting down.\n Bye" );
                return;
            }
            else 
            {  
                System.out.println( "Logon failed" );
            }
        }
        System.out.println( "System shutting down.\n Bye" );
    }


    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch18Ex1to5 exercise = new Ch18Ex1to5();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Miles per Gallon" );
            System.out.println( "   (2) In-range Adder" );
            System.out.println( "   (3) Shipping Cost Calculator" );
            System.out.println( "   (4) Area of Rectangles" );
            System.out.println( "   (5) Login simulator" );
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
                        exercise.milesPerGallon();
                        break;
                    case '2':
                        exercise.inRangeAdder();
                        break;
                    case '3':
                        exercise.shippingCostCalc();
                        break;
                    case '4':
                        exercise.areaOfRectangle();
                        break;
                    case '5':
                        exercise.loginSimulator();
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
