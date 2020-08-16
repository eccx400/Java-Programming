import kareltherobot.*;

/**
 * We are making Karel place carpets around a square floor.
 * We will create the world and modularize the program so Karel so it can run.
 * 
 * 
 * @author 5121400
 * @version Sep 9, 2013
 * @author Period: 6
 * @author Assignment: ch3_8Carpeter
 * 
 * @author Sources: Eric Cheng
 */
public class CarpeterTest implements Directions
{
    /**
     * Robot start at (9,2) Facing South
     * 
     * @param args command line arguments - not used
     *            
     */
    public static void main( String args[] )
    {
        CarpetLayer bot = new CarpetLayer( 9, 2, South, 28 );
        bot.layCarpet();
        bot.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "carpeter.wld" );
        World.setDelay( 10 );
        World.setVisible( true );
    }
}
