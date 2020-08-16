import kareltherobot.*;

/**
   Tests a RandomWalker robot.

   NO modifications to this driver are necessary

   @author  George Peck
   @version Oct 2, 2006

   @author  Period - 1-7
   @author  Assignment - ch4_1RandomWalker

   @author  Sources - Dave Wittry
 */
public class RandomWalkerDriver implements Directions
{
    public static void main( String args[] )
    {
        RandomWalker bot = new RandomWalker( 1, 5, East, 0 );
        for ( int i = 1; i <= 10; i++ )
        {
            bot.move();
        }

        System.out.println( "The robot is " + bot.distFromOrigin()
            + " units from Origin" );
        System.out.println( "The robot moved " + bot.getNumMoves() + " times" );
        System.out.println( "The robot's current location is " + bot.location() );
    }

    static
    {
        World.reset();
        World.setDelay( 5 );
        World.setTrace( false );
        World.setVisible( true );
    }
}
