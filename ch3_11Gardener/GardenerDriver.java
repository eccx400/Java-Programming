import kareltherobot.*;

/**
 *  PinSetter Driver.
 *
 *  @author  George Peck
 *  @version Sep 6, 2011
 *  @author  Period: 1-7
 *  @author  Assignment: ch3_11Gardener
 *
 *  @author  Sources: Dave Wittry
 */
public class GardenerDriver implements Directions
{
    /**
     * Test method - creates and invokes a Gardener.
     * @param args  command-line arguments (not used)
     */
    public static void main( String args[] )
    {
        Gardener bot = new Gardener( 2, 2, South, 28 );

        bot.plantGarden();

        bot.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "plus.wld" );
        World.setDelay( 10 );
        World.setVisible( true );
    }
}
