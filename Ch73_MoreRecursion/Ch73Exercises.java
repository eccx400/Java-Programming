import java.util.Scanner;

/**
 * Chapter 73 - More Recursion Exercises 1, 3, 4, 6, 7, 8
 * 
 * @author Eric Cheng
 * @version March 5, 2014
 * @author Period - 6
 * @author Assignment: Ch73_MoreRecursion
 * @author Sources - Eric Cheng
 */
public class Ch73Exercises
{
    /**
     * 
     */
    Scanner scan;

    public Ch73Exercises()
    {
        scan = new Scanner( System.in );
    }
    /**
     * 
     * TODO Write your method description here.
     * @param n The user enters a number
     * @return the square of a given integer
     */
    public int square( int n ) 
    { 
        if ( n == 1 ) 
        { 
            return 1; 
        } 
        else
        { 
            return square( n - 1 ) + 2 * n - 1; 
        } 
    } 
    
    /**
     * This program gives the cube of a number using the square of a number and
     * recursion.
     */
    public int cube( int n )
    {
        if ( n == 1 ) 
        { 
            return 1; 
        } 
        else
        { 
            return ( cube( n - 1 ) + 3 * ( square( n ) ) - 3 * n + 1 ); 
        } 
    }

    /**
     * Returns the sum of all elements in array.
     * @return - the sum of all elements in the array
     * @param - a given array of integers
     */
    public int sum( int[] array )
    {
        return sum(array, 0);
    }
    
    /**
     * Returns the sum of all elements in array, starting at index.
     * @return The sum of all the elements in a given array
     * @param array - a given integer array
     * @param index - the index value of an array
     */
    public int sum(int[] array, int index)
    {
        if (index == array.length)
        {
          return 0;  
        }
        else
        {
          return array[index] + sum(array, index + 1);
        }         
    }

    /**
     * Consider this definition of the sum of the elements in an integer array: 
     * sum( array, index ) = 0, if index == array.length sum( array, index ) = 
     * array[index] + sum( array, index+1), if index < array.length Write a Java 
     * method that implements this definition and a program to test it. The 
     * method should look something like: int sum ( int[] array, int index ) { . 
     * . . } The testing program will call sum( testArray, 0 ). 
     * @param array - a given array of integers
     * @return maximum value of a given array
     */
    public int max( int[] array )
    {
        return max(array, 0);
    }
    /** 
     * calculates the maximum of an array recursively 
     *  
     * @param array 
     *            array 
     * @param index 
     *            index 
     * @return maximum value of an array 
     */
    public int max( int[] array , int index)
    {
        if(index == array.length - 1)
        {
            return array[index];
        }
        else
        {
            int max_rest = max(array, index + 1);
            if (max_rest > array[index]) 
            {
                return max_rest;
            }
            else
            {
                return array[index];
            }
        }
    }

    /** 
     * This method compares 2 strings, ignoring upper/lower case 
     *  
     * @param strA 
     *            string A 
     * @param strB 
     *            string B 
     * @return returns true if both strings are equal 
     */
    public boolean equalsIgnoreCase( String strA, String strB )
    {
        if ( strA.length() == 0 && strB.length() == 0 ) 
        { 
            return true; 
        } 
        else if ( strA.length() == 0 && strB.length() != 0 ) 
        { 
            return false; 
        } 
        else if ( strA.length() != 0 && strB.length() == 0 ) 
        { 
            return false; 
        } 
        else if ( strA.toLowerCase().charAt( 0 ) != strB.toLowerCase() 
            .charAt( 0 ) ) 
        { 
            return false; 
        } 
        else
        { 
            return equalsIgnoreCase( strA.substring( 1 ), strB.substring( 1 ) ); 
        } 
    } 

    /**
     * Write a complete program that tests the equals() method at the end of the 
     * chapter. Prompt the user for the two strings to be tested. Make equals() 
     * a static method in the class that holds main(). Another implementation: 
     * define a class called myString that contains a reference to a String and 
     * the method equals(). Your main() will create two myString objects and use 
     * their equals() methods. 
     */
    public boolean equalsIgnoreVowels( String strA, String strB )
    {
        if ( strA.length() == 0 && strB.length() == 0 ) // base case 
        { 
            return true; 
        } 
        else if ( strA.length() == 0 && strB.length() != 0 ) 
        { 
            return equalsIgnoreVowels( strA, strB.substring( 1 ) ); 
        } 
        else if ( strB.length() == 0 && strA.length() != 0 ) 
        { 
            return equalsIgnoreVowels( strA.substring( 1 ), strB ); 
        } 
        else if ( vowel( strA.charAt( 0 ) ) ) 
        { 
            return equalsIgnoreVowels( strA.substring( 1 ), strB ); 
        } 
        else if ( vowel( strB.charAt( 0 ) ) ) 
        { 
            return equalsIgnoreVowels( strA, strB.substring( 1 ) ); 
        } 
        else if ( strA.charAt( 0 ) != strB.charAt( 0 ) ) 
        { 
            return false; 
        } 
        else
        { 
            return equalsIgnoreVowels( strA.substring( 1 ), strB.substring( 1 ) ); 
        } 
    } 
    
    /**
     * The method sees if the given character is a vowel
     * @return - If it is an A, E, I, O, U
     * @param - A given character
     */
    private boolean vowel( char x ) 
    { 
        x = Character.toLowerCase( x ); 
        return ( x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' ); 
    } 

    /**
     * A palindrome is a string that is the same when reversed. For example, 
     * "abba" is a palindrome
     * @return - True or false if the given string is a palindrome
     * @param - A given string value
     */
    public boolean palindrome( String str )
    {
        if ( str.length() == 0 ) 
        { 
            return true; 
        } 
        else if ( str.length() == 1 ) 
        { 
            return true; 
        } 
        else if ( str.charAt( 0 ) != str.charAt( str.length() - 1 ) ) 
        { 
            return false; 
        } 
        else
        { 
            return palindrome( str.substring( 1, str.length() - 1 ) ); 
        } 
    } 

    /**
     * Testing method: instantiates a Lesson15Exercises object and then invokes
     * each method
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        int[] testArray = { 3, 2, 5, 1, 4, 4, 8, 13, 9, 1,
            0, 2, 0, 2, 6, 3, -1, -8 };
        boolean done = false;
        String word1 = "";
        String word2 = "";

        Ch73Exercises ex = new Ch73Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Cube Numbers" );
            System.out.println( "   (3) Sum of Elements in an Integer Array" );
            System.out.println( "   (4) Maximum Element in an Integer Array" );
            System.out.println( "   (6) equalsIgnoreCase" );
            System.out.println( "   (7) equalsIgnoreVowels" );
            System.out.println( "   (8) palindrome" );
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
                        System.out.print( "Enter an integer: " );
                        int num = kbd.nextInt();
                        kbd.nextLine();
                        System.out.println( "cube( " + num + " ) = "
                            + ex.cube( num ) );
                        break;
                    case '3':
                        int arraySum = ex.sum( testArray );
                        System.out.println( "sum = " + arraySum );
                        break;
                    case '4':
                        int maxVal = ex.max( testArray );
                        System.out.println( "max = " + maxVal );
                        break;
                    case '6':
                        System.out.print( "Please enter the first word: " );
                        word1 = kbd.nextLine();
                        System.out.print( "Please enter the second word: " );
                        word2 = kbd.nextLine();
                        System.out.println( "equalsIgnoreCase( " + word1 + ", "
                            + word2 + " ) = "
                            + ex.equalsIgnoreCase( word1, word2 ) );
                        break;
                    case '7':
                        System.out.print( "Please enter the first word: " );
                        word1 = kbd.nextLine();
                        System.out.print( "Please enter the second word: " );
                        word2 = kbd.nextLine();
                        System.out.println( "equalsIgnoreVowels( " + word1
                            + ", " + word2 + " ) = "
                            + ex.equalsIgnoreVowels( word1, word2 ) );
                        break;
                    case '8':
                        System.out.print( "Please enter a word: " );
                        word1 = kbd.nextLine().toLowerCase().trim();
                        System.out.println( "palindrome( " + word1 + " ) = "
                            + ex.palindrome( word1 ) );
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
