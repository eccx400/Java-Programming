import java.util.*;


/**
 * Chapter 14 - Boolean Expressions Programming Exercises 1-4.
 * 
 * @author Eric Cheng
 * @version 11/6/13
 * 
 * @author Period - 6
 * @author Assignment - Ch14Ex1to4
 * 
 * @author Sources - Eric Cheng
 */
public class Ch14Ex1to4
{
    /**
     * 
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch14Ex1to4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch14Ex1to4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * This program has a rule that states:has the following rule: if a customer
     * has more than $1000 dollars in their checking account or more than $1500
     * dollars in their savings account, then there is no service charge for
     * writing checks, or else there is a $0.15 charge
     */
    public void checkCharge()
    {
        double charge;
        System.out.println( "Please insert the check money:" );
        double checkingAccount = scan.nextDouble();
        System.out.println( "Please insert the saving money:" );
        double savingAccount = scan.nextDouble();
        if ( checkingAccount > 1000 || savingAccount > 1500 )
        {
            charge = 0;
            System.out.println( "No service charge. Balance: $" + charge
                + " Have a nice day!" );
        }
        else
        {
            System.out.println( "Service charge: $0.15 per check" );
        }
    }


    /**
     * This is a program the calculates the tire pressure, and it has to make
     * sure that the front tires have the same pressure, and the rear tires must
     * also have the same pressure as each other
     */
    public void tirePressure()
    {
        System.out.println( "Input right front pressure:" );
        double frontRight = scan.nextDouble();
        System.out.println( "Input left front pressure:" );
        double frontLeft = scan.nextDouble();
        System.out.println( "Input right rear pressure:" );
        double rearRight = scan.nextDouble();
        System.out.println( "Input left rear pressure:" );
        double rearLeft = scan.nextDouble();
        if ( frontRight == frontLeft && rearRight == rearLeft )
        {
            System.out.println( "Inflation is OK" );
        }
        else
        {
            System.out.println( "Inflation is BAD" );
        }
    }


    /**
     * In this program, we set a range between the amount of pressure the tires
     * can hold, and in this case, we set them to < 35 and > 45 for all tires.
     * If the tire pressure does not meet the requirements, the monitor will
     * print out " Warning: pressure is out of range "
     */
    public void moreTirePressure()
    {
        boolean goodPressure = true;
        System.out.println( "Input right front pressure:" );
        double frontRight = scan.nextDouble();
        if ( frontRight < 35 || frontRight > 45 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }
        System.out.println( "Input left front pressure:" );
        double frontLeft = scan.nextDouble();
        if ( frontLeft < 35 || frontLeft > 45 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }
        System.out.println( "Input right rear pressure:" );
        double rearRight = scan.nextDouble();
        if ( rearRight < 35 || rearRight > 45 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }
        System.out.println( "Input left rear pressure:" );
        double rearLeft = scan.nextDouble();
        if ( rearLeft < 35 || rearLeft > 45 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }
        if ( frontRight == frontLeft && rearRight == rearLeft && goodPressure )
        {
            System.out.println( "Inflation is OK" );
        }
        else
        {
            System.out.println( "Inflation is BAD" );
        }
    }


    /**
     * In this program, we set a range of the range difference between the front
     * and rear tires to 3 psi, and continue to monitor the inflation scale.
     */
    public void pressureIsBuilding()
    {
        boolean goodPressure = true;
        System.out.println( "Input right front pressure:" );
        double frontRight = scan.nextDouble();
        if ( frontRight < 35 || frontRight > 45 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }
        System.out.println( "Input left front pressure:" );
        double frontLeft = scan.nextDouble();
        if ( frontLeft < 35 || frontLeft > 45 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }
        System.out.println( "Input right rear pressure:" );
        double rearRight = scan.nextDouble();
        if ( rearRight < 35 || rearRight > 45 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }
        System.out.println( "Input left rear pressure:" );
        double rearLeft = scan.nextDouble();
        if ( rearLeft < 35 || rearLeft > 45 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }
        if ( ( frontRight <= frontLeft + 3 || frontLeft <= frontRight + 3 )
            && ( rearRight <= rearLeft + 3 || rearLeft <= rearRight + 3 )
            && ( goodPressure ) )
        {
            System.out.println( "Inflation is OK" );
        }
        else
        {
            System.out.println( "Inflation is BAD" );
        }
    }


    /**
     * Testing method: instantiates a Ch14Ex1to4 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch14Ex1to4 exercise = new Ch14Ex1to4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Check Charge" );
            System.out.println( "   (2) Tire Pressure" );
            System.out.println( "   (3) More Tire Pressure" );
            System.out.println( "   (4) The Pressure is Building" );
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
                        exercise.checkCharge();
                        break;
                    case '2':
                        exercise.tirePressure();
                        break;
                    case '3':
                        exercise.moreTirePressure();
                        break;
                    case '4':
                        exercise.pressureIsBuilding();
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
