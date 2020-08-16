import java.util.*;


/**
 * Chapter 12 - Decision Making Programming Exercises 1-9.
 * 
 * @author Eric Cheng
 * @version 10/31/2013
 * 
 * @author Period - 6
 * @author Assignment - Ch12Ex1to9
 * 
 * @author Sources - Eric Cheng
 */
public class Ch12Ex1to9
{
    /**
     * 
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch12Ex1to9()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch12Ex1to9( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * This is a program that asks for the amount of purchases, then calculates
     * the discounted price after a 10% discount
     */
    public void discountPrices()
    {
        System.out.println( "Enter amount of purchase: " );
        int amount = scan.nextInt();
        if ( amount > 10 && amount != 1000 )
        {
            System.out.println( "Discounted price: "
                + (int)( amount * ( 0.9 ) ) );
        }
        else
        {
            System.out.println( "Discounted price: " + (int)amount );
        }
    }


    /**
     * The program finds a correct order must have at least as many nuts as
     * bolts and at least twice as many washers as blots
     */
    public void orderChecker()
    {
        final int boltPrice = 5;
        final int nutPrice = 3;
        final int washerPrice = 1;
        System.out.println( "Number of bolts: " );
        double bolts = scan.nextDouble();
        System.out.println( "Number of nuts: " );
        double nuts = scan.nextDouble();
        System.out.println( "Number of washers: " );
        double washers = scan.nextDouble();
        if ( nuts < bolts )
        {
            System.out.println( "Check the Order: too few nuts" );
            if ( ( washers ) < bolts * 2 )
            {
                System.out.println( "check the Order: too few washers" );
            }
        }
        else
        {
            if ( ( washers ) < bolts * 2 )
            {
                System.out.println( "check the Order: too few washers" );
            }
            else
            {
                System.out.println( "Order is Ok" );
            }
        }
        int cost = (int)( ( boltPrice * bolts ) + ( nutPrice * nuts )
                 + ( washerPrice * washers ) );
        System.out.println( "Total cost: " + cost );
    }


    /**
     * This program calculates the gas a driver has, and calculates if there
     * needs to be a gas change
     */
    public void lastChanceGas()
    {
        System.out.println( "Tank capacity: " );
        double capacity = scan.nextDouble();
        System.out.println( "Gauge reading: " );
        double gauge = scan.nextDouble();
        System.out.println( "Miles per gallon: " );
        double mpg = scan.nextDouble();
        if ( ( capacity * ( gauge / 100.0 ) * mpg ) < 200 )
        {
            System.out.println( "Get Gas!" );
        }
        else
        {
            System.out.println( "Safe to Proceed" );
        }
    }


    /**
     * This calculates which package of ground beef seems to be more reasonable
     * in pricing
     */
    public void groundBeefValueCalc()
    {
        System.out.println( "Price per pound package A: " );
        double ppA = scan.nextDouble();
        System.out.println( "Percent lean package A: " );
        double plA = scan.nextDouble();
        System.out.println( "Price per pound package B: " );
        double ppB = scan.nextDouble();
        System.out.println( "Percent lean package B: " );
        double plB = scan.nextDouble();
        double cppA = ( ppA / plA ) * 100.0;
        double cppB = ( ppB / plB ) * 100.0;
        if ( cppA != cppB )
        {
            System.out.println( "Package A cost per pound of lean: " + cppA );
            System.out.println( "Package B cost per pound of lean: " + cppB );
        }
        if ( cppA < cppB )
        {
            System.out.println( "Package A is the best value" );
        }
        else
        {
            System.out.println( "Package B is the best value" );
        }
    }


    /**
     * The program is to correctly write out the users age in years using the
     * given information on the subject's birthday.
     */
    public void y2KProblemDetector()
    {
        System.out.println( "Year of birth: " );
        double year = scan.nextDouble();
        System.out.println( "Current year: " );
        double current = scan.nextDouble();
        if ( current < year )
        {
            System.out.println( "Your age: " 
                + (int)( ( current + 100 ) - year ) );
        }
        else
        {
            System.out.println( "Your age: " + (int)( current - year ) );
        }
    }


    /**
     * This is a program that calculates the wind chill index (WCI)using wind
     * speed and temperature
     */
    public void windChillIndex()
    {
        System.out.println( "Wind speed in miles per hour: " );
        double v = scan.nextDouble();
        System.out.println( "Temperature in fahrenheit: " );
        double t = scan.nextDouble();
        if ( v >= 0 && v <= 4 )
        {
            System.out.println( "Wind chill index: " + t );
        }
        else if ( v >= 45 )
        {
            System.out.println( "Wind chill index: " + ( ( 1.6 * t ) - 55 ) );
        }
        else
        {
            System.out.println( "Wind chill index: "
                + ( 91.4 + ( 91.4 - t )
                    * ( 0.0203 * v - 0.304 * ( Math.sqrt( v ) ) - 0.474 ) ) );
        }
    }


    /**
     * This program calculates the age of a person in seconds
     */
    public void yourAgeInSeconds()
    {
        int year;
        int month;
        int day;
        int second;
        int day2;
        int second2;
        int second3;
        System.out.println( "Current Age" );
        System.out.println( "Years: " );
        year = scan.nextInt();
        System.out.println( "Months: " );
        month = scan.nextInt();
        System.out.println( "Days: " );
        day = scan.nextInt();
        second = year * 365 * 24 * 3600;
        day2 = 0;
        if ( month == 0 )
        {
            day2 = 0;
        }
        if ( month == 1 )
        {
            day2 = 31;
        }
        if ( month == 2 )
        {
            day2 = 31 + 28;
        }
        if ( month == 3 )
        {
            day2 = 31 + 28 + 31;
        }
        if ( month == 4 )
        {
            day2 = 31 + 28 + 31 + 30;
        }
        if ( month == 5 )
        {
            day2 = 31 + 28 + 31 + 30 + 31;
        }
        if ( month == 6 )
        {
            day2 = 31 + 28 + 31 + 30 + 31 + 30;
        }
        if ( month == 7 )
        {
            day2 = 31 + 28 + 31 + 30 + 31 + 30 + 31;
        }
        if ( month == 8 )
        {
            day2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
        }
        if ( month == 9 )
        {
            day2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
        }
        if ( month == 10 )
        {
            day2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
        }
        if ( month == 11 )
        {
            day2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
        }
        if ( month == 12 )
        {
            day2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31;
        }
        second2 = day2 * 24 * 3600;
        second3 = day * 24 * 3600;
        System.out.println( "Your age in seconds: "
            + ( second + second2 + second3 ) );
    }


    /**
     * This is a program that determines the price of a movie ticket
     */
    public void matineeMovieTickets()
    {
        System.out.println( "Age: " );
        double age = scan.nextDouble();
        System.out.println( "Time: " );
        double time = scan.nextDouble();
        if ( time < 1700 && age <= 13 )
        {
            System.out.println( "Ticket Price: $2.00." );
        }
        else if ( time < 1700 && age > 13 )
        {
            System.out.println( "Ticket Price: $5.00." );
        }
        if ( time >= 1700 && age <= 13 )
        {
            System.out.println( "Ticket Price: $4.00." );
        }
        else if ( time >= 1700 && age > 13 )
        {
            System.out.println( "Ticket Price: $8.00." );
        }
    }


    /**
     * This is a program that calculates if the person buying the ticket is a
     * child
     */
    public void midnightMadness()
    {
        System.out.println( "Age: " );
        double age = scan.nextDouble();
        System.out.println( "Time: " );
        double time = scan.nextDouble();
        if ( age == 12 && time == 1700 )
        {
            System.out.println( "Ticket Price: $4.00 " );
        }
        if ( time >= 2200 && age <= 13 )
        {
            System.out.println( "Too Young" );
        }
        else
        {
            if ( time >= 2200 && age > 13 )
            {
                System.out.println( "Ticket Price: $4.00." );
            }
            if ( time < 1700 && age <= 13 )
            {
                System.out.println( "Ticket Price: $2.00." );
            }
            if ( time < 2200 && time >= 1700 && age > 13 )
            {
                System.out.println( "Ticket Price: $8.00." );
            }
        }
    }


    /**
     * Testing method: instantiates a Lesson15Exercises object and then invokes
     * each method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch12Ex1to9 exercise = new Ch12Ex1to9();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "    (1) Discount Prices" );
            System.out.println( "    (2) Order Checker" );
            System.out.println( "    (3) Last Chance Gas" );
            System.out.println( "    (4) Ground Beef Value Calculator" );
            System.out.println( "    (5) Y2K Problem Detector" );
            System.out.println( "    (6) Wind Chill Index" );
            System.out.println( "    (7) Your Age in Seconds" );
            System.out.println( "    (8) Matinee Movie Tickets" );
            System.out.println( "    (9) Midnight Madness" );
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
                        exercise.discountPrices();
                        break;
                    case '2':
                        exercise.orderChecker();
                        break;
                    case '3':
                        exercise.lastChanceGas();
                        break;
                    case '4':
                        exercise.groundBeefValueCalc();
                        break;
                    case '5':
                        exercise.y2KProblemDetector();
                        break;
                    case '6':
                        exercise.windChillIndex();
                        break;
                    case '7':
                        exercise.yourAgeInSeconds();
                        break;
                    case '8':
                        exercise.matineeMovieTickets();
                        break;
                    case '9':
                        exercise.midnightMadness();
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
