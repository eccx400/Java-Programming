import java.util.*;
import java.io.*;


/**
 * Chapter 84 - Writing Text Files.
 * 
 * @author Eric Cheng
 * @version 5/2/2014
 * 
 * @author Period - 6
 * @author Assignment - Ch84Ex5Highlighter
 * 
 * @author Sources - Eric Cheng
 */
class Ch84Ex5Highlighter
{
    /**
     * The source name
     */
    String sourceName;

    /**
     * The Destination Name
     */
    String destName;

    /**
     * A buffer reader Source
     */
    BufferedReader source;

    /**
     * A buffer reader Keyword
     */
    BufferedReader keyword;

    /**
     * The print writer for Destination
     */
    PrintWriter dest;

    /**
     * A new string labeled "line"
     */
    String line;

    /**
     * New arraylist of strings
     */
    ArrayList<String> key = new ArrayList<String>();


    /**
     * @param source
     *            The source
     * @param dest
     *            Destination
     */
    Ch84Ex5Highlighter( String source, String dest )
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
            keyword = new
            BufferedReader( new FileReader( "JavaKeywords.txt" ) );
            line = keyword.readLine();
            source = new
            BufferedReader( new FileReader( sourceName ) );
            while ( line != null )
            {
                key.add( line );
                line = keyword.readLine();
            }
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
     * HTML head
     */
    public void getHead()
    {
        dest.println( "<html>" );
        dest.println( "<head>" );
        dest.println( "<title>titleVar</title>" );
        dest.println( "</head>" );
        dest.println( "<body>" );
        dest.println( "<pre>" );
    }

    /**
     * HTML tail
     */
    public void getTail()
    {
        dest.println( "</pre>" );
        dest.println( "</body>" );
        dest.println( "</html>" );
    }


    /**
     * Transfer data from source to dest
     */
    public void copyFiles()
    {
        try
        {
            getHead();
            line = source.readLine();
            while ( line != null )
            {
                line = highlightKeywords( line );
                System.out.println( line );
                dest.println( line );
                line = source.readLine();
            }
            getTail();
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
     * This method is used to read in the given string and see if it contains
     * the given java keywords. Then we can use it to replace with the html
     * setup
     * 
     * @param str
     *            Empty String
     * @return The html string
     */
    public String highlightKeywords( String str )
    {
        String result = "";
        StringTokenizer tokenizer = new StringTokenizer( str,
            " \t\"\\.,;:{}[]&!'?<>",
            true ); 
        while ( tokenizer.hasMoreTokens() )
        {
            String token;
            token = tokenizer.nextToken();
            if ( token.length() == 1 )
            {
                if ( token.equals( "<" ) )
                {
                    token = "&lt;";
                }
                else if ( token.equals( "&" ) )
                {
                    token = "&amp;";
                }
            }
            else if ( key.contains( token ) )
            {
                token = "<b>" + token + "</b>";
            }
            result = result + token;
        }
        return result;
    }


    /**
     * Instantiates a Ch84Ex5Highlighter object and then invokes each method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        String srcFileName = "";
        String destFileName = "";

        Scanner scan = new Scanner( System.in );

        System.out.print( "Enter Source Filename -->" );
        srcFileName = scan.nextLine().trim();

        System.out.print( "Enter Destination Filename -->" );
        destFileName = scan.nextLine().trim();

        Ch84Ex5Highlighter cp = new Ch84Ex5Highlighter( srcFileName,
            destFileName );
        if ( cp.openFiles() )
        {
            cp.copyFiles();
            cp.closeFiles();
        }
    }

}