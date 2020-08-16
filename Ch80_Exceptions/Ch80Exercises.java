import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
   Chapter 80 - Exceptions and Errors Exercises 1-2.

   @author Eric Cheng
   @version 11 April 2014

   @author Period - 6
   @author Assignment - Ch80Exercises

   @author  Sources - Eric Cheng
 */
public class Ch80Exercises
{
    /**
     * 
     */
    Scanner scan;
    /**
     * 
     */
    Scanner inFile;

    /**
     * Constructs a Scanner for input from the console
     * and from a default file
     */
    public Ch80Exercises()
    {
        scan = new Scanner( System.in );
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param kbd  console input for the various methods
     * @param file  simulated file input
     */
    public Ch80Exercises( String kbd, String file )
    {
        scan = new Scanner( kbd );
        inFile = new Scanner( file );
    }

    /**
     *Enhance the DivisionPractice program from the chapter:

    Put in a loop so that the user is repeatedly asked for the numerator and
    the divisor. For each set of data, the program prints out the result, or
    an informative error message if there is a problem (division by zero or
    poor input data).
    The program continues looping, even if there is a problem
    Exit the loop when data entered for the numerator start with characters 
    "q" or "Q". Don't print out an error message in this case.
    Don't ask for the divisor if the user just asked to quit.

     */
    public void divisionPractice ()
    {
        // TODO modify the following code as required

        int num = 0, div = 0;
        boolean nP = false; 
        while ( nP != true ) 
        { 
            try
            { 
                System.out.print( "Enter the numerator: " ); 
                num = scan.nextInt(); 
                System.out.print( "Enter the divisor  : " ); 
                div = scan.nextInt(); 
                System.out.println( num + " / " + div + " is " + ( num / div ) 
                    + " rem " + ( num % div ) ); 
            } 
            catch ( InputMismatchException ex ) 
            { 
                char char1 = scan.nextLine().charAt( 0 ); 
                if ( char1 == 'Q' || char1 == 'q' ) 
                { 
                    nP = true; 
                } 
                else
                { 
                    System.out.println( "You entered bad data." ); 
                    System.out.println( "Run the program again." ); 
                    nP = false; 
                } 
            } 
            catch ( ArithmeticException ex ) 
            { 
                System.out.println( "You can't divide " + num + " by " + div ); 
                scan.nextLine(); 
            } 
        } 
    } 

    /**
     * Write a program that inputs a list of numbers that are arranged into
     * groups of various sizes. The program outputs the sum of the number
     * s in each group. Each group starts with a one-line descriptive phrase.
     * The phrase can be anything that is not a number. The numbers can be 
     * integers or floating point values. Some groups may have no numbers in
     * them. Prompt the user for the name of the input data file.
     */
    public void multiGroupAddition() throws IOException
    {
        // Prompt for and open the input file   
        System.out.print("Please enter the file name: ");
        String fileName = scan.nextLine().trim();
        if (fileName.length() <= 0)
        {
            fileName = "Ex2DataSet1.txt";
        }

        inFile = new Scanner( new File(fileName) );
        int sum = 0; 
        System.out.println( inFile.nextLine() ); 
        while ( inFile.hasNext() ) 
        { 
            String data = inFile.nextLine(); 
            try
            { 
                sum = sum + Integer.parseInt( data ); 
            } 
            catch ( NumberFormatException ex ) 
            { 
                System.out.println( "Sum = " + sum + " \n" ); 
                System.out.println( data ); 
                sum = 0; 
            } 
        } 
        System.out.println( "Sum = " + sum ); 
    }

    /**
     * Testing method: instantiates a Ch24Exercises object and then invokes
     * each method.
     * 
     * @param args command line parameters (not used)
     */
    public static void main( String[] args ) throws IOException
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch80Exercises exercise = new Ch80Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) User-Friendly Division Practice" );
            System.out.println( "   (2) Addition of Multiple Groups" );
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
                        exercise.divisionPractice();
                        break;
                    case '2':
                        exercise.multiGroupAddition();
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
