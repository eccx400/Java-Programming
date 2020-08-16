import java.io.*;
import java.util.Scanner;


/**
 * Chapter 24 - y Input Techniques Exercises 1-2.
 * 
 * @author Eric Cheng
 * @version 12/5/2013
 * @author Period - 6
 * @author Assignment - Ch24Exercises
 * @author Sources - Eric Cheng
 */
public class Ch24Exercises
{
    /**
     * 
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch24Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch24Exercises( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * This is a program that reads a text file that contains groups of integers
     * that start with the word "next". For each group, the program computes and
     * writes out the sum of integers in that group.
     */
    public void nextGroupSum() throws FileNotFoundException
    {
        int sum = 0;
        int group = 1;
        System.out.println( "File name: " );
        File x = new File( scan.nextLine().trim() );
        Scanner y = new Scanner( x );
        while ( y.hasNext() )
        {
            sum = 0;
            if ( y.next().equals( "next" ) )
            {
                while ( y.hasNextInt() )
                {
                    sum = sum + y.nextInt();
                }
                if ( sum == 0 )
                {
                    System.out.println( "Group " + group 
                        + " contains no data" );
                    group++;
                }
                else
                {
                    System.out.println( "Sum for group " + group 
                        + " is " + sum );
                    group++;
                }
            }
        }
        y.close();
    }


    /**
     * This a program that computes the average change of a value for each of
     * several groups of data. Input is from a file of data. Say that your are
     * conducting an experiment to determine the effect of a high fiber diet on
     * cholesterol levels in humans. You have several groups of human subjects.
     * At the beginning of the experiment the cholesterol level of each d
     * in each group is measured. Now the experiment runs for one month. Each
     * group consumes a chochangeerent amount of fiber each day. At the end of
     *  the month you want to see the change in each group's cholesterol
     * level. The data for the experiment is in a text file like the following.
     * Each line of the file contains a single integer (in character form).
     */
    public void avgGroupChange() throws IOException
    {
        {
            double start = 0;
            double end = 0;
            int input = 0;
            int groups = 0;
            int subjex = 0;
            int group = 0;
            int subject = 0;
            double startavg;
            double endavg;
            double chochange = 0;
            System.out.println( "File: " );
            File file = new File( scan.nextLine() );
            scan = new Scanner( file );
            groups = scan.nextInt();
            subjex = scan.nextInt();
            while ( group < groups )
            {
                subject = subjex;
                while ( subjex > 0 )
                {
                    input = scan.nextInt();
                    start += input;
                    input = scan.nextInt();
                    end += input;
                    subjex -= 1;
                }
                group += 1;
                startavg = start / subject;
                endavg = end / subject;
                System.out.println( "Group " + group + " = " + subject 
                    + "ds" );
                if ( subjex != subject )
                {
                    System.out.println( "Average beginning Cholesterol: "
                        + startavg );
                    System.out.println( "Average End Cholesterol: "
                        + endavg );
                    chochange = endavg - startavg;
                    System.out.println( "Change in cholesterol: " + chochange );
                }
                start = 0;
                end = 0;
                if ( scan.hasNext() )
                {
                    subjex = scan.nextInt();
                }
            }
            System.out.println( "Done with processing." );
        }
    }


    /**
     * Testing method: instantiates a Ch24Exercises object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     * @throws IOException
     */
    public static void main( String[] args ) throws IOException
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch24Exercises exercise = new Ch24Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Sum of Integer Groups" );
            System.out.println( "   (2) Average Group Change" );
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
                        exercise.nextGroupSum();
                        break;
                    case '2':
                        exercise.avgGroupChange();
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
