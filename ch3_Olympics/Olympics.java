import kareltherobot.*;


/**
 * Using the methods we created in triathlete, I can let karel run the course
 * The purpose is to create the code shortened to one which encovers everyone
 * 
 * @author 5121400
 * @version 9/3/2013
 * @author Period - 6
 * @author Assignment - ch3_Olympics
 * @author Sources - Eric Cheng
 */
public class Olympics implements Directions
{
    /**
     * Robot start at (4,3) facing East
     * 
     * @param args command line arguments - not used
     */
    public static void main( String args[] )
    {
        Triathlete ironman = new Triathlete( 4, 3, East, 0 );

        ironman.runRace();

        ironman.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "triathlon.wld" );
        World.setDelay( 10 );
        World.setVisible( true );
    }
}
