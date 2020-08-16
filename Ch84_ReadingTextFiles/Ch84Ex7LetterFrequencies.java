import java.util.*;
import java.io.*;


/**
 * Chapter 84 - Writing Text Files.
 * 
 * @author Eric Cheng
 * @version 5/2/2014
 * 
 * @author Period - 6
 * @author Assignment - Ch84Ex7LetterFrequencies
 * 
 * @author Sources - Eric Cheng
 */
class Ch84Ex7LetterFrequencies
{
    /**
     *  The source name
     */
    String sourceName;
    
    /**
     * The Destination name
     */
    String destName;

    /**
     * The Buffer Reader Source
     */
    BufferedReader source;

    /**
     * The Buffer Reader Destination
     */
    PrintWriter dest;

    /**
     * A new string
     */
    String line;

    /**
     * A new array of type long and of length 26
     */
    long[] array = new long[26];

    /**
     * New arraylist of strings
     */
    ArrayList<String> keywords = new ArrayList<String>();

    /**
     * integer x is set to 0
     */
    int x = 0;


    /**
     * @param source
     *          The source
     * @param dest
     *          Destination
     */
    Ch84Ex7LetterFrequencies( String source, String dest )
    {
        sourceName = source;
        destName = dest;
    }


    /**
     * Opens source for reading and dest for writing
     * 
     * @return true if files open, else false
     */
    public boolean openFiles()
    {
        // open the source
        try
        {
            source = new BufferedReader( new FileReader( sourceName ) );
        }
        catch ( IOException iox )
        {
            System.out.println( "Problem opening " + sourceName );
            return false;
        }
        // open the destination
        try
        {
            dest = new
            PrintWriter( new BufferedWriter( new FileWriter( destName ) ) );
        }
        catch ( IOException iox )
        {
            System.out.println( "Problem opening " + destName );
            return false;
        }
        return true;
    }


    /**
     * Transfer data from source to dest
     */
    public void copyFiles()
    {
        double total = 0;
        try
        {
            line = source.readLine();
            while ( line != null )
            {
                for ( int i = 0; i < line.length(); i++ )
                {
                    int inx;
                    if ( line.charAt( i ) >= 'A' && line.charAt( i ) <= 'Z' )
                    {
                        inx = (int)line.charAt( i ) - (int)'A';
                        array[inx]++;
                        total++;
                    }
                    else if ( line.charAt( i ) >= 'a'
                        && line.charAt( i ) <= 'z' )
                    {
                        inx = (int)line.charAt( i ) - (int)'a';
                        array[inx]++;
                        total++;
                    }
                }
                line = source.readLine();
            }
            dest.println( "Total alphabetical characters:  " + total );
            dest.println();
            for ( int j = 0; j < 26; j++ )
            {
                dest.printf( "%3s:%10d%10.2f%%%n",
                    (char)( 'A' + j ),
                    array[j],
                    (double)array[j] / (double)total * 100.0 );
            }
        }
        catch ( IOException iox )
        {
            System.out.println( "Problem reading or writing" );
        }

    }


    /**
     * Close the output file
     */
    public void closeFiles()
    {
        // close the source
        try
        {
            source.close();
        }
        catch ( IOException iox )
        {
            System.out.println( "Problem closing " + sourceName );
        }
        // close the destination
        dest.close();
    }


    /**
     * Instantiates a Ch84Ex7LetterFrequencies object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner scan = new Scanner( System.in );

        System.out.print( "Enter Source Filename -->" );
        String srcFileName = scan.nextLine().trim();

        System.out.print( "Enter Destination Filename -->" );
        String destFileName = scan.nextLine().trim();

        Ch84Ex7LetterFrequencies cp = new Ch84Ex7LetterFrequencies( srcFileName,
            destFileName );
        if ( cp.openFiles() )
        {
            cp.copyFiles();
            cp.closeFiles();
        }
    }
}