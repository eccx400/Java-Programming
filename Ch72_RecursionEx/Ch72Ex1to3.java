import java.util.Scanner;


/**
   Chapter 72 - Recursion Examples Exercises 1-3

   @author Eric Cheng
   @version March 3, 2014

   @author Period - 6
   @author Assignment - Ch72Ex1to3

   @author Sources - Eric Cheng
 */
public class Ch72Ex1to3
{
    /**
     * 
     */
    Scanner scan;


    /**
     * 
     */
    public Ch72Ex1to3()
    {
        scan = new Scanner( System.in );
    }

    /**
     * This method/program checks if a given integer is a prime or not
     * @param n - The user enters a number
     * @param d - checks if the int n is divisible by dividing n
     * @return - true or false for a prime number
     */
    private boolean prime( int n, int d )
    {
        if ( d == 1 ) 
        { 
            return true; 
        } 
        else
        { 
            if ( n % d == 0 ) 
            { 
                return false; 
            } 
            else
            { 
                return ( prime( n, d - 1 ) ); 
            } 
        } 
    } 
    

    /**
        This method defines a prime number from the math definition and 
        returns it
        
        @param n - The user gives a prime number
        @return prime number
     */
    public boolean prime( int n )
    {
        return prime( n, n - 1 ); 
    }

    /**
     * This program is an extended version of the rabbit fibonacci sequence,
        but we take into account the death of rabbits with a lifespan of 4 
        months
     * @param n - the amount of rabbits there are
     * @return - number of rabbits
     */
    public int fibDieEvery4( int n )
    {
        if ( n == 1 ) 
        { 
            return 1; 
        } 
  
        else if ( n == 2 ) 
        { 
            return 1; 
        } 
        else if ( n == 3 ) 
        { 
            return 2; 
        } 
        else if ( n == 4 ) 
        { 
            return 3; 
        } 
  
        else
        { 
            return fibDieEvery4( n - 1 ) + fibDieEvery4( n - 2 ) 
                - fibDieEvery4( n - 4 ); 
        } 
    }


    /**
     * This program finds the greatest common denominator of a number
     * @param a - the first number we are comparing
     * @param b - the second number we are comparing
     * @return gcd
     */
    public int gcd( int a, int b )
    {
        if ( a == 0 ) 
        { 
            return b; 
        } 
        else
        { 
            return gcd( b % a, a ); 
        } 
    }

    /**
        Testing method: instantiates a Lesson15Exercises object and then
        invokes each method

        @param args  command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch72Ex1to3 exercise = new Ch72Ex1to3();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Prime Numer" );
            System.out.println( "   (2) Fibonacci- 4 Month Life Span" );
            System.out.println( "   (3) Greatest Common Denominator" );
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
                        System.out.print( "Enter an integer: " );
                        int num = kbd.nextInt();
                        kbd.nextLine();
                        System.out.println( "prime( " + num + " ) = "
                            + exercise.prime( num ) );
                        break;
                    case '2':
                        System.out.print( "Enter the number of months: " );
                        int months = kbd.nextInt();
                        kbd.nextLine();
                        System.out.println( "fibDieEvery4( " + months + " ) = "
                            + exercise.fibDieEvery4( months ) );
                        break;
                    case '3':
                        System.out.print( "Enter the first integer: " );
                        int int1 = kbd.nextInt();
                        System.out.print( "Enter the second integer: " );
                        int int2 = kbd.nextInt();
                        kbd.nextLine();
                        System.out.println( "GCD( " + int1 + ", " +
                            int2 + " ) = " + exercise.gcd( int1, int2 ) );
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
