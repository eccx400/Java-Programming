import kareltherobot.*;


/**
 * We are letting karel escape the maze. We will utilize infinite loops and
 * while statements.
 * 
 * @author 5121400
 * @version Sep 18, 2013
 * @author Period: 6
 * @author Assignment: ch6_17EscapeBot
 * 
 * @author Sources: Eric Cheng
 */
public class EscapeBot implements Directions
{
    /**
     * Utilize infinite loops to allow karel to complete maze
     * 
     * @param args
     *            command line arguments (not used)
     */
    public static void main( String[] args )
    {

        MazeWalker karel = new MazeWalker( 1, 1, East, 0 );

        while ( !karel.nextToABeeper() )
        {
            karel.followWallRight();
        }
        karel.turnOff();
    }

    /*
     * Creates world with the maze karel needs to run on
     *
    static
    {
        World.reset();
        World.readWorld( "ch6_17.wld" );
        World.setDelay( 1 );
        World.setVisible( true );
    }*/
}
