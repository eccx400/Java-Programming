import java.util.* ;
import java.io.* ;

public class RateCalc
{
    public static int calcInsurance( int birthYear ) throws Exception
    {
        final int currentYear = 2014;
        int age = currentYear - birthYear;

        if ( age < 16 )
        {
            throw new Exception("Age is: " + age );
        }
        else
        {
            int drivenYears = age - 16;
            if ( drivenYears < 4 )
            {
                return 1000;
            }
            else
            {
                return 600;
            }
        }
    }

    public static void main ( String[] a ) 
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("Enter birth year:");
        int inData = scan.nextInt();

        try
        {
            System.out.println( "Your insurance is: " + calcInsurance( inData ) );
        }
        catch ( Exception oops )
        {
            System.out.println( oops.getMessage() + " Too young for insurance!" );
        }

    }
}
