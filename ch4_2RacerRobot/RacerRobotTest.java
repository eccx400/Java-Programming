import kareltherobot.*;

/**
 *  karel uses these to complete the races for sprint, hurdles, high hurdles,
 *  and steeple chaser
 *  
 *  @author  Eric Cheng
 *  @version 10/14/13
 *
 *  @author  Period - 6
 *  @author  Assignment - ch4_2RacerRobot
 *
 *  @author  Sources - Dave Wittry
 */
public class RacerRobotTest implements Directions
{
    /**
     * AbstractRacerRobot sprinterBot = new SprinterBot( 1, 1, East, 0 );
     * AbstractRacerRobot hurdlerBot = new HurdlerBot( 3, 1, East, 0 );
     * AbstractRacerRobot highHurdlerBot = new HighHurdlerBot( 6, 1, East, 0 );
     * AbstractRacerRobot steepleBot = new SteepleChaserBot( 12, 1, East, 0 );
     * 
     * @param args = command-line arguments (not used)
     */
    public static void main( String args[] )
    {
        AbstractRacerRobot sprinterBot = new SprinterBot( 1, 1, East, 0 );
        AbstractRacerRobot hurdlerBot = new HurdlerBot( 3, 1, East, 0 );
        AbstractRacerRobot highHurdlerBot = new HighHurdlerBot( 6, 1, East, 0 );
        AbstractRacerRobot steepleBot = new SteepleChaserBot( 12, 1, East, 0 );

        sprinterBot.runRace();
        hurdlerBot.runRace();
        highHurdlerBot.runRace();
        steepleBot.runRace();
    }

    static
    {
        World.reset();
        World.readWorld( "ch4_2.wld" );
        World.setTrace( false );
        World.setDelay( 1 );
        World.setVisible( true );
    }
}
