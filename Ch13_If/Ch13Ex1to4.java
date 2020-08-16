import java.util.*;


/**
 * Chapter 13 - Single-branch if Statements Programming Exercises 1-4
 * 
 * @author Eric Cheng
 * @version 11/5/2013
 * 
 * @author Period - 6
 * @author Assignment - Ch13Ex1to4
 * 
 * @author Sources - Eric Cheng
 */
public class Ch13Ex1to4
{
    /**
     * 
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch13Ex1to4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch13Ex1to4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * This is a program for the Sam and Ella Delicatessen. The program takes
     * deli orders from the Internet, and you can write out the order and the
     * charges for fees.
     */
    public void internetDelicatessen()
    {
        System.out.println( "Enter the item: " );
        String item = scan.nextLine();
        System.out.println( "Enter the price in cents: " );
        double price = scan.nextInt();
        System.out.println( "Overnight delivery (0==no, 1==yes):" );
        double yesno = scan.nextInt();
        double shipping;
        double overnight;
        if ( yesno == 1 )
        {
            overnight = 5.00;
        }
        else
        {
            overnight = 0.00;
        }
        if ( price < 1000 )
        {
            shipping = (int)( 2.00 + overnight );
        }
        else
        {
            shipping = (int)( 3.00 + overnight );
        }
        double total = ( ( price / 100.0 ) + shipping );
        System.out.println( "Invoice: " );
        System.out.println( item + "\t" + (float)( price / 100.0 ) );
        System.out.println( "shipping \t" + (float)shipping );
        System.out.println( "total \t\t" + (float)total );
    }


    /**
     * This program calculates the efficiency of a boiler for a steam engine by
     * factoring in the variables for outside Air temperature and inner Steam
     * Temperature
     */
    public void steamEngineEfficiency()
    {
        double efficiency;
        System.out.println( "Air Temperature: " );
        double tair = scan.nextDouble();
        System.out.println( "Steam Temperature: " );
        double tSteam = scan.nextDouble();
        if ( tSteam < 373 )
        {
            efficiency = 0;
            System.out.println( "Efficiency: " + efficiency );
        }
        else
        {
            efficiency = ( 1 - ( tair / tSteam ) );
            System.out.println( "Efficiency: " + efficiency );
        }
    }


    /**
     * This program allows a microwave oven to calculate how much heating it
     * needs to do for 2 items at a certain amount of time and 3 items at a
     * certain amount of time
     */
    public void microwaveOven()
    {
        System.out.println( "Number of items: " );
        double items = scan.nextDouble();
        System.out.println( "Single-item heating time: " );
        double heating = scan.nextDouble();
        if ( items == 1 )
        {
            System.out.println( "Recommended heating time: " + heating );
        }
        if ( items == 2 )
        {
            System.out.println( "Recommended heating time: " + heating * 1.5 );
        }
        if ( items == 3 )
        {
            System.out.println( "Recommended heating time: " + heating * 2.0 );
        }
        if ( items > 3 )
        {
            System.out.println( "Not recommended" );
        }
    }


    /**
     * This program calculates the strength, health, and luck of a character in
     * a fantasy game, and assigns values for each of them to restrict the
     * amount of points a player can have.
     */
    public void fantasyGame()
    {
        System.out.println( "Welcome to Yertle's Quest" );
        System.out.println( "Enter the name of your character: " );
        String name = scan.nextLine();
        System.out.println( "Enter strength (1-10): " );
        double strength = scan.nextDouble();
        System.out.println( "Enter health (1-10): " );
        double health = scan.nextDouble();
        System.out.println( "Enter luck (1-10): " );
        double luck = scan.nextDouble();
        if ( ( strength + health + luck ) > 15 )
        {
            System.out.println( "You have given your character too many points!"
                + "\nDefault values have been assigned:" );
            System.out.println( name + ", strength: 5, health: 5, luck: 5" );
        }
        else
        {
            System.out.println( name + ", strength: " + strength + ", health: "
                + health + ", luck: " + luck );
        }
        System.out.println( "" );
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

        Ch13Ex1to4 exercise = new Ch13Ex1to4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Internet Delicatessen" );
            System.out.println( "   (2) Steam Engine Efficiency" );
            System.out.println( "   (3) Microwave Oven" );
            System.out.println( "   (4) Fantasy Game" );
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
                        exercise.internetDelicatessen();
                        break;
                    case '2':
                        exercise.steamEngineEfficiency();
                        break;
                    case '3':
                        exercise.microwaveOven();
                        break;
                    case '4':
                        exercise.fantasyGame();
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
