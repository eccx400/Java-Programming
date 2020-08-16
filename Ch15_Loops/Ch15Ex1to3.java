import java.util.*;

/**
 * Chapter 15 - Loops Exercises 1-3.
 * 
 * @author Eric Cheng
 * @version 11/16/2013
 * @author Period - 6
 * @author Assignment - Ch15Ex1to3
 * @author Sources - Eric Cheng
 */
public class Ch15Ex1to3
{
    /**
     * 
     */
    Scanner scan;

    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch15Ex1to3()
    {
        scan = new Scanner( System.in );
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str  input for the various methods
     */
    public Ch15Ex1to3( String str )
    {
        scan = new Scanner( str );
    }

    /**
     * This is a program that asks the user for a starting value and an 
     * ending value and then writes all the integers (inclusive) between 
     * those two values. 
     */
    public void inclusiveIntegers()
    {
        int start;
        int end;
        System.out.println("Enter Start: ");
        start = scan.nextInt();
        System.out.println("Enter End: ");
        end = scan.nextInt();
        while ( start <= end )
        {
            System.out.println(start);
            start = start + 1;
        }
    }

    /**
     * This is a program that asks the user to enter a word.
     * The program will then repeat word for as many times 
     * as it has characters for the word down the line.
     */
    public void repeatWord()
    {
        String inputString;
        int times;
        int print = 1;
        System.out.println("Enter a word: ");
        inputString = scan.nextLine();
        times = inputString.length();
        while ( print <= times )
        {
            System.out.println( inputString );
            print = print + 1;
        }
    }

    /**
     * This is a program that asks the user to enter two words.
     * The program then prints out both words on one line. The 
     * words will be separated by enought dots so that the 
     * total line length is 30
     */
    public void twoWords()
    {
        String first;
        int length1;
        String second;
        int length2;
        int dots = 1;
        System.out.println( "Enter first word: " );
        first = scan.nextLine();
        length1 = first.length();
        System.out.println("Enter second word: ");
        second = scan.nextLine();
        length2 = second.length(); 
        System.out.print(first);
        while ( length1 + length2 + dots <= 30 )
        {
            System.out.print(".");
            dots = dots + 1;
        }
        System.out.print( second );
    }

    /**
     * Testing method: instantiates a Ch15Ex1to3 object and then invokes
     * each method.
     * 
     * @param args  command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch15Ex1to3 exercise = new Ch15Ex1to3();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Inclusive Integers" );
            System.out.println( "   (2) Repeat Word" );
            System.out.println( "   (3) Two Words" );
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
                        exercise.inclusiveIntegers();
                        break;
                    case '2':
                        exercise.repeatWord();
                        break;
                    case '3':
                        exercise.twoWords();
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
