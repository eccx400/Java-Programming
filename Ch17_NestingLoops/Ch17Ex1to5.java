import java.util.*;


/**
 * Chapter 17 - Nesting Loops and ifs Exercises 1-5
 * 
 * @author Eric Cheng
 * @version 11/15/2013
 * 
 * @author Period - 6
 * @author Period Assignment - Ch17Ex1to5
 * 
 * @author Sources - Eric Cheng
 */
public class Ch17Ex1to5
{
    /**
     *
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch17Ex1to5()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch17Ex1to5( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * This program calculates the time needed for a person to recover from jet
     * lag according to the different factors of a plane trip
     * 
     * @return days of recovery
     */
    public double jetLagCalc()
    {
        double daysOfRecovery = 0.0;

        System.out.println( "Number of hours traveled:" );
        double hours = scan.nextDouble();
        System.out.println( "Number of time zones crossed:" );
        double zones = scan.nextDouble();
        System.out.println( "Departure time:" );
        double tDepart = scan.nextDouble();
        System.out.println( "Arrival time:" );
        double tArrive = scan.nextDouble();
        double depart = 0.0;
        if ( tDepart >= 8 && tDepart <= 12 )
        {
            depart = 0;
        }
        if ( tDepart >= 12 && tDepart <= 18 )
        {
            depart = 1;
        }
        if ( tDepart >= 18 && tDepart <= 22 )
        {
            depart = 3;
        }
        if ( tDepart >= 22 || tDepart <= 1 )
        {
            depart = 4;
        }
        if ( tDepart >= 1 && tDepart <= 8 )
        {
            depart = 5;
        }
        double arrive = 0.0;
        if ( tArrive >= 8 && tArrive <= 12 )
        {
            arrive = 4;
        }
        if ( tArrive >= 12 && tArrive <= 18 )
        {
            arrive = 2;
        }
        if ( tArrive >= 18 && tArrive <= 22 )
        {
            arrive = 0;
        }
        if ( tArrive >= 22 || tArrive <= 1 )
        {
            arrive = 1;
        }
        if ( tArrive >= 1 && tArrive <= 8 )
        {
            arrive = 3;
        }
        daysOfRecovery = ( ( hours / 2 ) + ( zones - 3 ) + depart + arrive ) 
                        / 10;

        return daysOfRecovery;
    }


    /**
     * This is a program that adds up the squares and adds up the cubes of
     * integers from 1 to N, where N is entered by the user.
     * 
     * @return squares and cubes
     */
    public long[] addUpSquaresAndCubes()
    {
        long sumSquares = 0;
        long sumCubes = 0;

        System.out.println( "Upper Limit:" );
        double uL = scan.nextDouble();
        sumSquares = (long)( ( uL ) * ( uL + 1 ) * ( 2 * ( uL ) + 1 ) / 6 );
        sumCubes = (long)( ( uL ) * ( uL ) * ( uL + 1 ) * ( uL + 1 ) / 4 );
        return new long[] { sumSquares, sumCubes };
    }


    /**
     * This is a program that that computes x^y where x is a floating point
     * number and y is an integer.
     * 
     * @return power of a number
     */
    public double powerOfANumber()
    {
        double pow = 1.0;

        System.out.println( "Enter x" );
        double x = scan.nextDouble();
        System.out.println( "Enter y" );
        double y = scan.nextDouble();
        pow = Math.pow( x, y );
        return pow;

    }


    /**
     * This is a program that writes a wedge of stars. The user enters the
     * initial number of stars, and the program writes out lines of stars. Each
     * line has one few star than the previous line
     */
    public void wedgeOfStars()
    {
        System.out.println( "Initial number of stars: " );
        int numRows = scan.nextInt();
        int row = 1;
        while ( row <= numRows )
        {
            int stars = 0;
            int numStars = numRows - row;
            while ( stars <= numStars )
            {
                System.out.print( "*" );
                stars = stars + 1;
            }
            System.out.println( "" );
            row = row + 1;
        }
    }


    /**
     * This is a program that writes a tree made of stars on the terminal. The
     * height of the tree (the size excluding the base) is input by the user
     */
    public void pineTree()
    {
        int height;
        int spaces;
        int numSpaces = 1;
        int stars = 1;
        int numStars = 1;
        int base = 1;
        System.out.println( "Enter the height of the tree:" );
        height = scan.nextInt();
        spaces = height - 1;
        if ( spaces == 0 )
        {
            System.out.println( " * " );
        }
        else
        {
            while ( spaces >= 0 )
            {
                while ( numSpaces <= spaces )
                {
                    System.out.print( " " );
                    numSpaces = numSpaces + 1;
                }
                while ( numStars <= stars )
                {
                    System.out.print( "*" );
                    numStars = numStars + 1;
                }
                System.out.println();
                numSpaces = 1;
                numStars = 1;
                stars = stars + 2;
                spaces = spaces - 1;
            }
        }
        numSpaces = 1;
        while ( base <= 3 )
        {
            while ( numSpaces <= ( height - 2 ) )
            {
                System.out.print( " " );
                numSpaces++;
            }
            System.out.print( "*" );
            System.out.print( "*" );
            System.out.print( "*" );
            System.out.println();
            numSpaces = 1;
            base = base + 1;
        }
    }


    /**
     * Testing method: instantiates a Ch17Ex1to4 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch17Ex1to5 ex = new Ch17Ex1to5();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Jet Lag Calculator" );
            System.out.println( "   (2) Adding up Squares and Cubes" );
            System.out.println( "   (3) Power of a number" );
            System.out.println( "   (4) Wedge of Stars" );
            System.out.println( "   (5) Pine Tree" );
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
                        double daysOfRecovery = ex.jetLagCalc();
                        System.out.println( "Days of recovery: "
                            + daysOfRecovery );
                        break;
                    case '2':
                        long[] sums = ex.addUpSquaresAndCubes();
                        System.out.println( "Sum of squares: " + sums[0] );
                        System.out.println( "Sum of cubes : " + sums[1] );
                        break;
                    case '3':
                        double pow = ex.powerOfANumber();
                        System.out.println( "powerOfANumber() = " + pow );
                        break;
                    case '4':
                        ex.wedgeOfStars();
                        break;
                    case '5':
                        ex.pineTree();
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
