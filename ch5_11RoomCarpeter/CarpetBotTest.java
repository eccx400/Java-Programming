import kareltherobot.*;

/**
 *  Test the room carpeting ability of a RoomCarpeter Robot.
 *
 *  @author  5121400
 *  @version September 12,2013
 *
 *  @author  Period - 6
 *  @author  Assignment - ch5_11RoomCarpeter
 *
 *  @author  Sources - Eric Cheng
 */
public class CarpetBotTest implements Directions
{
    /**
     * Test method - creates and invokes a CarpetBot.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main( String args[] )
    {
        CarpetBot karel = new CarpetBot( 1, 1, East, 8 );

        karel.carpetRooms();

        karel.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "ch5_11.wld" );
        World.setDelay( 10 );
        World.setVisible( true );
    }
}
