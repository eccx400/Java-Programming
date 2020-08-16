import kareltherobot.*;

/**
 *  Karel chases a steeple during the race
 *  
 *  @author  Eric Cheng
 *  @version 10/14/13
 *
 *  @author  Period - 6
 *  @author  Assignment - ch4_2RacerRobot
 *
 *  @author  Sources - Dave Wittry
 */
public class SteepleChaserBot extends AbstractHurdlerRobot
{
    /**
     * @param st = street
     * @param av = avenue
     * @param dir = direction
     * @param beeps = beepers
     */
    public SteepleChaserBot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }

    /* (non-Javadoc)
     * @see AbstractHurdlerRobot#over()
     */
    public void over()
    {
        turnRight();
        move();
 
        while ( wallOnRight() )
 
        {
 
            move();
        }
        turnRight();
        move();
 
    }
}
