import kareltherobot.*;

/**
 *  Write a method of runRace and raceStride for karel to run
 *  
 *  @author  Eric Cheng
 *  @version 10/14/2013
 *
 *  @author  Period - 6
 *  @author  Assignment - ch4_2RacerRobot
 *
 *  @author  Sources - Dave Wittry
 */
public abstract class AbstractRacerRobot extends BetterTurner
{
    /**
     * @param st = street
     * @param av = avenue
     * @param dir = direction
     * @param beeps = beeper
     */
    public AbstractRacerRobot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }

    /**
     * karel runs the race
     */
    public void runRace()
    {
        while ( !nextToABeeper() )
        {
            raceStride();
        }
    }

    /**
     * Abstract class, raceStride
     */
    abstract void raceStride();
    
    
    /* (non-Javadoc)
     * @see kareltherobot.UrRobot#run()
     */
    public void run()
    {
        runRace();
    }
}