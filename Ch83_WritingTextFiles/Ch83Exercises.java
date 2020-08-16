import java.util.*;
import java.io.*;

/**
 * Chapter 83 - Writing Text Files.
 * 
 * @author Eric Cheng
 * @version 4/25/2014
 * 
 * @author Period - 6
 * @author Assignment - Ch83Exercises
 * 
 * @author Sources - Eric Cheng
 */
public class Ch83Exercises
{
    /**
     * 
     */
    Scanner scan;
    Random rand = new Random( 0 );

    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch83Exercises()
    {
        scan = new Scanner( System.in );
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch83Exercises( String str )
    {
        scan = new Scanner( str );
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     * @param seed
     *            seed to use for random number generator
     */
    public Ch83Exercises( String str, long seed )
    {
        scan = new Scanner( str );
        rand.setSeed( seed );
    }

    /**
     * Exercise 1 - Random Integer Data.
     * 
     * Write a program that creates a file containing totalCount random
     * integers (in character format) in the range 0 to highValue-1. Write 
     * perLine integers per line. Separate each integer with one space. End
     * each line with the correct line termination for your computer.
     * The user is prompted for and enters highValue, which should be an 
     * integer larger than zero. Then the user is prompted for and enters
     * perLine, which is an integer greater than zero, and totalCount, which 
     * also is an integer greater than zero. Finally the user is prompted for 
     * and enters the file name.
     * Use a BufferedWriter with a FileWriter for output. 
     * Construct a Random object and use its method nextInt(int Top), 
     * which returns an int in the range 0..Top-1.
     */
    public void randomIntData() 
    { 
        PrintWriter out = null; 
  
        System.out.print( "Enter HighValue-->" ); 
        int highValue = scan.nextInt(); 
  
        System.out.print( "Enter how many per line-->" ); 
        int perLine = scan.nextInt(); 
  
        System.out.print( "Enter how many integers-->" ); 
        int totalCount = scan.nextInt(); 
        scan.nextLine(); 
  
        System.out.print( "Enter Filename-->" ); 
        String fileName = scan.nextLine(); 
        if ( fileName.length() <= 0 ) 
        { 
            fileName = "rdata.dat"; 
        } 
        try
        { 
            out = new PrintWriter( new BufferedWriter( new FileWriter( fileName ) ) ); 
        } 
        catch ( IOException ex ) 
        { 
            System.out.println( "There was a problem writing " + fileName ); 
        } 
        int j = 0; 
        while ( j < totalCount ) 
        { 
            int count = 0; 
            while ( count < perLine && j < totalCount ) 
            { 
                int num = rand.nextInt( highValue ); 
                out.print( num + " " ); 
                count++; 
                System.out.println( j ); 
                j++; 
            } 
            out.println(); 
        } 
        out.close(); 
    } 
  

    /**
     * Exercise 3 - HTML Power of 2 Table.
     * 
     * Write a program that creates a text file that contains a power of two 
     * table in HTML format. The file could be called "twoPowerTable.html". 
     */
    public void powerOf2Table()
    {
        PrintWriter out = null;

        String fileName = "";

        // Get filename
        System.out.print( "Enter Filename-->" );
        fileName = scan.nextLine();
        if ( fileName.length() <= 0 )
        {
            fileName = "twoPowerTable.html";
        }

        try
        { 
            out = new PrintWriter( new BufferedWriter( new FileWriter( fileName ) ) ); 
        } 
        catch ( IOException ex ) 
        { 
            System.out.println( "There was a problem writing " + fileName ); 
        } 
        out.println( "<html>" ); 
        out.println( "<head>" ); 
        out.println( "<title>Powers of Two</title>" ); 
        out.println( "</head>" ); 
        out.println( "<body>" ); 
        out.println( "<table border cellpadding=5>" ); 
        out.println( "<tr><th>Power of 2</th><th>Value</th></tr>" ); 
        for ( int j = 0; j <= 10; j++ ) 
        { 
            out.println( "<tr><td>" + j + "</td><td>" + Math.pow( 2, j ) 
                + "</td></tr>" ); 
        } 
        out.println( "</table>" ); 
        out.println( "</body>" ); 
        out.println( "</html>" ); 
        out.close(); 
    }

    /**
     * Testing method: instantiates a Ch23Exercises object and then invokes each
     * method.
     * 
     * @param args  command line parameters (not used)
     */
    public static void main( String[] args ) throws IOException
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch83Exercises exercise = new Ch83Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Random Integer Data" );
            System.out.println( "   (3) HTML Power of 2 Table" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        exercise.randomIntData();
                        break;
                    case '3':
                        exercise.powerOf2Table();
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
