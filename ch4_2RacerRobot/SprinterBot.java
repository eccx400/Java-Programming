import kareltherobot.*;


/**
 * Karel the robot sprints the race
 * 
 * @author Eric Cheng
 * @version 10/14/2013
 * 
 * @author Period - 6
 * @author Assignment - ch4_2RacerRobot
 * 
 * @author Sources - Dave Wittry
 */
public class SprinterBot extends AbstractRacerRobot
{
    /**
     * @param st
     *            = street
     * @param av
     *            = avenue
     * @param dir
     *            = direction
     * @param beeps
     *            = beeper
     */
    public SprinterBot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /*
     * (non-Javadoc)
     * 
     * @see AbstractRacerRobot#raceStride()
     */
    public void raceStride()
    {
        move();
    }
}
