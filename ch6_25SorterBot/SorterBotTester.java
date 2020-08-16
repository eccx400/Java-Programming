import kareltherobot.*;


/**
 * This is the tester file we use to run Sorterbot.java We use this to set the
 * world and create the robot we use
 * 
 * @author 5121400
 * @version Sep 22, 2013
 * @author Period: 6
 * @author Assignment: ch6_25SorterBot
 * 
 * @author Sources: Eric Cheng
 */
public class SorterBotTester implements Directions
{
    /**
     * Create new robot at street 1, avenue 1, facing East
     * 
     * @param args
     *            = command line arguments (not used)
     */
    public static void main( String args[] )
    {
        SorterBot karel = new SorterBot( 1, 1, East, 0 );

        karel.sortThemAll();
    }

    static
    {
        World.reset();
        World.readWorld( "ch6_25.wld" );
        World.setDelay( 5 );
        World.setVisible( true );
    }
}
