import java.util.Scanner;


/**
 * Chapter 71 - Recursion in Java Exercise 1
 * 
 * @author Eric Cheng
 * @version 2/26/2014
 * @author Period - 6
 * @author Assignment - Ch71Ex1
 * @author Sources - Eric Cheng
 */
public class Ch71Ex1
{
    /**
     * 
     */
    Scanner scan;


    /**
     * Constructs a Scanner for use by this object.
     */
    public Ch71Ex1()
    {
        scan = new Scanner( System.in );
    }


    /**
     * This program finds the square of a number given the formula
     * square(N) = square( n - 1 ) + ( 2 * n ) - 1
     * 
     * @return = the square of a given number
     * @param n = a read in number that is being squared
     */
    public int square( int n )
    {
        if ( n == 1 )
        {
            return 1;
        }
        else
        {
            return square( n - 1 ) + ( 2 * n ) - 1;
        }
    }


    /**
     * Testing method: instantiates a Ch71Ex1 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch71Ex1 exercise = new Ch71Ex1();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Square Numbers" );
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
                        System.out.print( "Please enter a number to square: " );
                        int num = kbd.nextInt();
                        kbd.nextLine();
                        System.out.println( "square( " + num + " ) = "
                            + exercise.square( num ) );
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
