import java.util.*;
import java.io.*;

/**
 * Chapter 23 - File I/O with Scanner and PrintStream Exercises.
 * 
 * @author Eric Cheng
 * @version 12/1/13
 * 
 * @author Period - 6
 * @author Your Period
 * @author Assignment - Ch23Exercises
 * 
 * @author Sources - Eric Cheng
 */
public class Ch23Exercises
{
    /**
     * 
     */
    Scanner scan;

    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch23Exercises()
    {
        scan = new Scanner( System.in );
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str  input for the various methods
     */
    public Ch23Exercises( String str )
    {
        scan = new Scanner( str );
    }

    /**
     * Exercise 1 - Sum of a file of Integers
     * 
     * This a program that adds all the integers in a file of text integers.
     * @throws FileNotFoundException 
     * @return
     */
    public int sumOfIntFile() throws FileNotFoundException
    {
        int sum = 0;
        System.out.print("Input File Name: ");
        String name = scan.next();
        File file = new File( name );
        Scanner s = new Scanner( file );
        
        while ( s.hasNextInt() )
            sum += (s.nextInt());
        
        return sum;
    }

    /**
     * Exercise 2 - Average and Standard Deviation of a file of Doubles
     * 
     * This is a program that computes the average and standard deviation 
     * of the text floating point numbers in a file. Use the following formulas
     * for the average and the standard deviation of N values. The formulas
     * compute the sum, the sum of squares, the average, the average square,
     * the variance, and finally, the standard deviation.
     * 
     * @return
     */
    public double[] avgStdDevOfDoubleFile() throws FileNotFoundException 
    {
        double avg = 0;
        double sd = 0;

        System.out.println( "Name of file:" ); 
        String name = scan.next(); 
        File file = new File( name ); 
        Scanner s = new Scanner( file ); 
          
        double sum = 0;
        double sumsq = 0; 
        int n = 0; 
          
        while (s.hasNext()) 
        { 
            double tmp = s.nextDouble(); 
            sum += tmp; 
            sumsq += tmp*tmp; 
            ++n; 
        } 
        avg = sum / n; 
        double avgsq = sumsq / n; 
        double var = avgsq - avg*avg; 
        sd = Math.sqrt( var ); 

        double[] result = { avg, sd };
        return result;
    }

    /**
     * Exercise 4 - Separate Sums
     * 
     * This is a program that reads in a file of text, perhaps the text of a 
     * novel. The program copies the same text to an output file, except that 
     * all the useless words such as "the", "a", and "an" are removed. 
     * This is done by reading the text file token by token using hasNext() 
     * and next(), but only writing out tokens not on the stop list. 
     * Prompt the user for the names of the input and output files.
     */
    public int[] seperateSums() throws FileNotFoundException 
    {
        int xSum = 0;
        int ySum = 0;

        System.out.println( "Name of file:" ); 
        String name = scan.next(); 
        File file = new File( name ); 
        Scanner s = new Scanner( file ); 
  
        while ( s.hasNext() ) 
        { 
            String Zohan = s.next(); 
            if (Zohan.charAt( 0 ) == 'x') 
                xSum += s.nextInt(); 
            else
                ySum += s.nextInt(); 
        } 
        
        int[] result = { xSum, ySum };
        return result;
    }

    /**
     * Exercise 6 - E-Mail Address Extractor
     * 
     * This is a program that scans a text file for possible e-mail addresses. 
     * Addresses look like this:
     * someone@somewhere.net
     */
    public void emailAddressExtractor() throws FileNotFoundException 
    {
        System.out.print( "Please input the input file name: " ); 
        String fileNameIn = scan.nextLine().trim(); 
        File in = new File( fileNameIn ); 
        Scanner fileIn = new Scanner( in ); 
        File file = new File( "emailOut.txt" ); 
        PrintStream print = new PrintStream( file ); 
        String eMail; 
        int email; 
        int email2; 
        while ( fileIn.hasNext() ) 
        { 
            eMail = fileIn.next(); 
            email = eMail.indexOf( "@" ); 
            email2 = eMail.indexOf( "." ); 
            if ( email >= 1 && email2 >= email + 2 ) 
            { 
                print.println( eMail ); 
            } 
        } 
    }
    
    /**
     * Testing method: instantiates a Ch23Exercises object and then invokes
     * each method.
     * 
     * @param args command line parameters (not used)
     */
    public static void main( String[] args ) throws IOException
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch23Exercises exercise = new Ch23Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Sum of a file of Integers" );
            System.out.println( "   (2) Average and Standard Deviation "
                + "of a file of Doubles" );
            System.out.println( "   (4) Separate Sums" );
            System.out.println( "   (6) E-Mail Address Extractor" );
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
                        System.out.println( "Sum of the file = "
                            + exercise.sumOfIntFile() );
                        break;
                    case '2':
                        double[] avgSD = exercise.avgStdDevOfDoubleFile();
                        System.out.println("Average = " + avgSD[0]);
                        System.out.println("Standard Deviation = " + avgSD[1]);
                        break;
                    case '4':
                        int[] sums = exercise.seperateSums();
                        System.out.println("Sum of x = " + sums[0]);
                        System.out.println("Sum of y = " + sums[1]);
                        break;
                    case '6':
                        exercise.emailAddressExtractor();
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
