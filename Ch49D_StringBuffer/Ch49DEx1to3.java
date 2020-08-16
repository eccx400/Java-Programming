import java.io.*;
import java.util.*;


/**
 * Chapter 49D - StringBuffer Exercises 1-3
 * 
 * @author Eric Cheng
 * @version 2/14/2014
 * @author Period - 6
 * @author Assignment - Ch49DEx1to3
 * @author Sources - Eric Cheng
 */
public class Ch49DEx1to3
{
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch49DEx1to3()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch49DEx1to3( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * This program uses the concept of String Buffers and the old Scanner I/O
     * to sort out the asterix in the given email and then replace the asterix
     * with the name of the person. This program uses sentinel loops and the
     * Scanner tool.
     */
    public void junkMailGenerator() throws IOException
    {
        System.out.println( "Please enter the person's name: " );
        String name = scan.nextLine();
        System.out.println( "Please enter the file name: " );
        File file = new File( scan.nextLine() );
        Scanner fileScanner = new Scanner( file );

        StringBuffer sb = new StringBuffer();
        while ( fileScanner.hasNextLine() )
        {
            sb.append( fileScanner.nextLine() );
            sb.append( '\n' );
        }

        // Replace all '*' in sb with the name
        int index = sb.indexOf( "*" );
        while ( index != -1 )
        {
            sb = sb.replace( index, index + 1, name );
            index = sb.indexOf( "*", index + 1 );
        }
        System.out.print( sb.toString() );
    }


    /**
     * This is a program that reads in a sentence from the user and prints it
     * out with each word reversed, but with the words and punctuation
     * in the original order.
     */
    public void wordReverser( StringBuffer line )
    {
        //Create a string buffer
        for ( int j = 0; j < line.length(); j++ )
        {
            StringBuffer string = new StringBuffer();
            int start = j;
            while ( j < line.length()
                && ( ( line.charAt( j ) >= 'A' && line.charAt( j ) <= 'Z' )
                                || ( line.charAt( j ) >= 'a' 
                                    && line.charAt( j ) <= 'z' ) ) )
            {
                string.append( line.charAt( j ) );
                j++;
            }
            
            // Set references between the reversed string (taken from the 
            // string buffer code by using the toString method) and replace
            // the reversed words
            String backwards = string.reverse().toString();
            line.replace( start, j, backwards );
        }
    }


    /**
     * This is a program that prompts the user for an ISBN and then checks if 
     * the ISBN is correct. I will calculate a check character from the first 
     * nine digits and compare it to the last character of the ISBN. If the two
     * do not agree, the ISBN is incorrect.
     * 
     * The last character is calculated from the other 9 digits:
     * Multiply the first digit by 10. Multiply the second digit by 9.
     * Multiply the third digit by 8.. . . Multiply the ninth digit by 2.
     * Add up all these values.Divide the sum by 11.Take the remainder.
     * Subtract the remainder from 11. This is the check digit.
     * If the remainder is 10, use an 'X'
     */
    public boolean verifyISBN( StringBuffer isbn )
    {
        StringBuffer string = new StringBuffer();
        for ( int j = 0; j < isbn.length(); j++ )
        {
            char x = isbn.charAt( j );
            if ( x >= '0' && x <= '9' || x == 'X' )
            {
                string.append( x );
            }
        }
        int sum = 0;
        for ( int j2 = 0; j2 < 9; j2++ )
        {
            sum += ( ( string.charAt( j2 ) - '0' ) * ( 10 - j2 ) );
        }
        int check = 11 - ( sum % 11 );
        char x = ' ';
        if ( check == 10 )
        {
            x = 'X';
        }
        if ( check == ( string.charAt( 9 ) - '0' )
            || ( string.charAt( 9 ) == x ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Testing method: instantiates a Lesson15Exercises object and then invokes
     * each method
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args ) throws IOException
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;
        String lineIn = "";

        Ch49DEx1to3 exercise = new Ch49DEx1to3();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Junk Mail Generator" );
            System.out.println( "   (2) Word Reverser" );
            System.out.println( "   (3) ISBN Verifier" );
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
                        exercise.junkMailGenerator();
                        break;
                    case '2':
                        System.out.print( "Input: " );
                        StringBuffer revLine = new StringBuffer( kbd.nextLine() );
                        exercise.wordReverser( revLine );
                        System.out.println( revLine );
                        break;
                    case '3':
                        System.out.print( "Enter ISBN: " );
                        lineIn = kbd.nextLine();
                        StringBuffer isbn = new StringBuffer( lineIn );
                        boolean isValid = exercise.verifyISBN( isbn );
                        System.out.print( lineIn + " is " );
                        if ( isValid )
                        {
                            System.out.print( "a" );
                        }
                        else
                        {
                            System.out.print( "not a" );
                        }
                        System.out.print( " valid ISBN number." );
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
