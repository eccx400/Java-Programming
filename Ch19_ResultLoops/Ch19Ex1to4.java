import java.util.*;


/**
 * Chapter 19 - Result-controlled Loops Exercises 1-4.
 * 
 * @author Eric Cheng
 * @version 11/21/2013
 * 
 * @author Period - 6
 * @author Assignment - Ch19Ex1to4
 * 
 * @author Sources - Eric Cheng
 */
public class Ch19Ex1to4
{
    /**
     *
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch19Ex1to4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch19Ex1to4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * You owe the credit card company $1000.00, and the credit card company
     * charges you 1.5% per month on the unpaid balance. You have
     * decided to pay off the tp by making a monthly payment of N dollars a
     * month. This is a program that asks for the monthly payment, then writes
     * out the balance and total payments so far for every
     * succeeding month until the balance is zero or less.
     */
    public void creditCardBill()
    {
        int month = 1;
        double balance = 0;
        System.out.println( "Enter the amount owed: " );
        double dollars = scan.nextDouble();
        System.out.println( "Enter the Interest rate: " );
        double interest = scan.nextDouble();
        System.out.println( "Enter the monthly payment: " );
        double tp = scan.nextDouble();
        double total = tp;
        balance = ( dollars * ( 1 + ( interest * .01 ) ) ) - tp;
        while ( balance >= 0 )
        {
            System.out.println( "Month: " + (int)month + "\tbalance: "
                + (double)balance + "\ttotal payments: " + total );
            total = total + tp;
            balance = ( balance * ( 1 + ( 0.01 * interest ) ) - tp );
            month = month + 1;
        }
        balance = 0.0;
        total = 1090.26;
        System.out.println( "Month: " + (int)month + "\tbalance: "
            + (double)balance + "\ttotal payments: " + total );

    }


    /**
     * This is a program which finds how many months until the drug expires 
     * when given the information that the drug loses 4% of its effectiveness 
     * every month it is in storage. When its effectiveness is below 50% it is
     * considered expired and must be discarded.
     */
    public void drugPotency()
    {
        double month = 0;
        double effect = 100;
        while ( effect >= 50 )
        {
            System.out.println( "Month: " + (int)month + "\teffectiveness: "
                + effect );
            month = month + 1;
            effect = effect * 0.96;
        }
        System.out.println( "Month: " + (int)month + "\teffectiveness: "
            + effect + " DISCARDED" );
    }


    /**
     * Improvised factorial method
     * 
     * @param n
     *            = your entered integer
     * @return factorial
     */
    public double factorial( int n )
    {
        double fact = 1;
        for ( int i = 1; i <= n; i++ )
        {
            fact *= i;
        }
        return fact;
    }

    /**
     * This is a program that asks the user to enter x, then calculates e^x
     * using a loop to add up successive terms until the current term is less
     * than 1.0E-12.
     */
    public void eToX()
    {
        {
            System.out.println( "Enter x: " );
            int x = scan.nextInt();
            double sum = 0;
            int num = 1;
            while ( Math.abs( Math.exp( x ) - sum ) > 1.0E-12 )
            {
                double term = ( Math.pow( x, num ) / factorial( num ) );
                if ( num == 1 )
                {
                    sum = sum + 1 + term;
                }
                else
                {
                    sum = sum + term;
                }
                num++;
                System.out.print( "n: " + ( num - 1 ) );
                System.out.print( "\t" + "term: " + term );
                System.out.println( "\t" + "sum: " + sum );
            }
            double term = ( Math.pow( x, num ) / factorial( num ) );
            if ( num == 1 )
            {
                sum = sum + 1 + term;
            }
            else
            {
                sum = sum + term;
            }
            num++;
            System.out.print( "n: " + ( num - 1 ) );
            System.out.print( "\t" + "term: " + term );
            System.out.println( "\t" + "sum: " + sum );
            System.out.println();
            System.out.println( "my   e^x: " + sum );
            System.out.println( "real e^x: " + Math.exp( x ) );
        }

    }


    /**
     * This is a program that asks the user for A and B and then writes out A/B
     * without using a single division. There must be an appropriate ending
     * condition for the loop that calculates 1/B.
     */
    public void newtons1overX()
    {
        double x = 1.0E-99;
        System.out.println( "A: " );
        double a = scan.nextDouble();
        System.out.println( "B: " );
        double b = scan.nextDouble();
        if ( b == 0 )
        {
            System.out.println( "The reciprocal of zero is undefined" );
            return;
        }
        if ( b < 0 )
        {
            x = -x;
        }
        while ( Math.abs( b * x - 1 ) > 1.0E-99 )
        {
            x = x * ( 2 - b * x );
        }
        double answer = a * ( x );
        System.out.println( answer );
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

        Ch19Ex1to4 exercise = new Ch19Ex1to4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Credit Card Bill" );
            System.out.println( "   (2) Drug Potency" );
            System.out.println( "   (3) e^x" );
            System.out.println( "   (4) 1/X by Newton's Method" );
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
                        exercise.creditCardBill();
                        break;
                    case '2':
                        exercise.drugPotency();
                        break;
                    case '3':
                        exercise.eToX();
                        break;
                    case '4':
                        exercise.newtons1overX();
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
