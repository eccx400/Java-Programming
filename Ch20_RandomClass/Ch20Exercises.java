import java.util.*;


/**
 * Chapter 20 - Random Class Exercises 3, 5, 7 & 8.
 * 
 * @author Eric Cheng
 * @version 11/28/2013
 * 
 * @author Period - 6
 * @author Assignment - Ch20Exercises
 * 
 * @author Sources - Eric Cheng
 */
public class Ch20Exercises
{
    /**
     * 
     */
    Scanner scan;

    Random rand = new Random();


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch20Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     * @param seed
     *            seed to use for random number generator
     */
    public Ch20Exercises( String str, long seed )
    {
        scan = new Scanner( str );
        rand.setSeed( seed );
    }


    /**
     * This is an even more complicated guessing game. In this version, the 
     * full game consists of 10 "rounds," where each round is a game like 
     * exercise 2. After the 10 rounds, the program prints out how many of 
     * the 10 rounds were won and how many were lost:
     * 
     * players who win 7 or fewer rounds are rated as "amateurs,"
     * players who win 8 rounds are rated as "advanced,"
     * players who win 9 rounds are rated as "professionals," and
     * players who win all 10 rounds are rated as "hackers."
     */
    public void furtherImprovedGuessingGame()
    {
        int total = 1;
        int round = 1;
        int turn = 1;
        int won = 0;
        System.out.println( "round " + round + ":" );
        System.out.println( "I am thinking of a number from 1 to 10."
            + " \nYou must " + "guess what it is in three tries."
            + " \nEnter a guess:" );
        int guess = scan.nextInt();
        int ans = rand.nextInt( 10 ) + 1;
        System.out.println( ans );
        while ( guess != ans && turn < 3 )
        {
            if ( Math.abs( ( guess - ans ) ) >= 3 )
            {
                System.out.println( "cold" );
                guess = scan.nextInt();
                turn = turn + 1;
            }
            else if ( Math.abs( guess - ans ) == 2 )
            {
                System.out.println( "warm" );
                guess = scan.nextInt();
                turn = turn + 1;
            }
            else if ( Math.abs( guess - ans ) == 1 )
            {
                System.out.println( "hot" );
                guess = scan.nextInt();
                turn = turn + 1;
            }
            else if ( guess == ans )
            {
                System.out.println( "Right!" );
            }
        }
        if ( guess == ans )
        {
            round = round + 1;
            System.out.println( "You have won " + round + " out of " + total );
        }
        if ( won <= 7 ) 
        { 
            System.out.println( "Your rating : amateur." ); 
        } 
        if ( won == 8 ) 
        { 
            System.out.println( "Your rating : advanced." ); 
        } 
        if ( won == 9 ) 
        { 
            System.out.println( "Your rating : professional." ); 
        } 
        if ( won == 10 ) 
        { 
            System.out.println( "Your rating : hacker." ); 
        } 
    } 
    


    /**
     * This is a program that uses a password generator repeatedly until a
     * randomly generated password matches the password the user entered. The
     * user's password must be five characters or less.
     */
    public void passwordCracker()
    {
        System.out.print( "Enter a secret password-->" );
        String pass = scan.next();
        System.out.println( "Here is your password: " + pass );
        String password = "";
        String guess = "abcdefghijklmnopqrstuvwxyz";
        guess = guess + guess.toUpperCase();
        guess = guess + "1234567890";
        int count = 0;
        while ( !password.equals( pass ) )
        {
            password = "";
            int i = 0;
            while ( i < pass.length() )
            {
                password = password
                    + guess.charAt( rand.nextInt( guess.length() ) );
                i = i + 1;
            }
            count = count + 1;
        }
        System.out.println( "It took " + count + " tries to guess it" );
    }


    /**
     * This program is a two dimensional random walk is where a particle starts
     * out at X=0.0, Y=0.0 then moves by small random increments in both X and
     * Y. Think of it as a confused ant, randomly walking on the 2D plane.
     */
    public void randomWalk2D()
    {
        double x = 0.0; 
        double y = 0.0;
        int iterations; 
        System.out.println( "How  many iterations? " ); 
        iterations = scan.nextInt(); 
        int count = 1; 
        double randomX = 0.0; 
        double randomY = 0.0; 
        while ( count <= iterations ) 
        { 
            randomX = rand.nextGaussian(); 
            x = x + randomX; 
            randomY = rand.nextGaussian(); 
            y = y + randomY; 
            count = count + 1; 
        } 
        double distance = Math.sqrt( ( x * x ) + ( y * y ) ); 
        System.out.println( "After " + iterations + " moves X is at " + x ); 
        System.out.println( "After " + iterations + " moves Y is at " + y ); 
        System.out.println( "distance: " + distance ); 
    }


    /**
     * This is a program that implements a two player game. The computer is the
     * score keeper and the two players are humans. Each round of the game
     * starts with the computer randomly picking a double precision number from
     * 1.0 to slightly less than 100.0. Each player estimates the square root 
     * of the number and enters the estimate. The player who's estimate is
     * closest to correct wins the round. Players alternate who goes first 
     * in each round. Play ends after a specified number of rounds.
     */
    public void squareRootGame()
    {
        int roundLimit;
        int p1score = 0;
        int p2score = 0;
        double g1;
        double g2;
        double randomNumber = rand.nextDouble() * ( 100.0 ) - 1.0;
        String p1;
        String p2;
        System.out.println( "Welcome to the Square Root Game!" );
        System.out.println( "Player 1, sign in--> " );
        p1 = scan.nextLine();
        System.out.println( "Player 2, sign in--> " );
        p2 = scan.nextLine();
        System.out.println( "How many rounds? " );
        roundLimit = scan.nextInt();
        for ( int round = 1; round <= roundLimit; round++ )
        {
            System.out.println( "What is the square root of " + randomNumber );
            System.out.println( p1 + ", your guess: " );
            g1 = scan.nextDouble();

            System.out.println( p2 + ", your guess: " );
            g2 = scan.nextDouble();
            System.out.println( "The correct square root: "
                + Math.sqrt( randomNumber ) );
            System.out.println( p1 + " is "
                + ( Math.abs( Math.sqrt( randomNumber ) ) - g1 ) + " away. " );
            System.out.println( p2 + " is "
                + ( Math.abs( Math.sqrt( randomNumber ) ) - g2 ) + " away. " );
            if ( ( Math.abs( Math.sqrt( randomNumber ) ) - g1 )
                            > ( Math.abs( Math.sqrt( randomNumber ) ) - g2 ) )
            {
                System.out.println( p1 + " wins! " );
                p1score = p1score + 1;
            }
            else if ( ( Math.abs( Math.sqrt( randomNumber ) ) - g1 ) 
                            < ( Math.abs( Math.sqrt( randomNumber ) ) - g2 ) )
            {
                System.out.println( p2 + " wins! " );
                p2score = p2score + 1;
            }
            else if ( ( Math.abs( Math.sqrt( randomNumber ) ) - g1 ) 
                            == ( Math.abs( Math.sqrt( randomNumber ) ) - g2 ) )
            {
                System.out.println( "You cannot use the same number! "
                    + "No points have been addded to either score. " );
            }
        }
        System.out.println( "---- Final Score ----" );
        System.out.println( p1 + ": " + p1score );
        System.out.println( p2 + ": " + p2score );
    }


    /**
     * Testing method: instantiates a Lesson15Exercises object and then invokes
     * each method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch20Exercises exercise = new Ch20Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (3) Further Improved Guessing Game" );
            System.out.println( "   (5) Password Cracker" );
            System.out.println( "   (7) 2D Random Walk" );
            System.out.println( "   (8) Suqare Root Game" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '3':
                        exercise.furtherImprovedGuessingGame();
                        break;
                    case '5':
                        exercise.passwordCracker();
                        break;
                    case '7':
                        exercise.randomWalk2D();
                        break;
                    case '8':
                        exercise.squareRootGame();
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
