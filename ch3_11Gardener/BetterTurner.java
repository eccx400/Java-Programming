import kareltherobot.*;


/**
 * Utility class. Extend this class to provide turnRight and turnAround
 * behavior.
 * 
 * @author George Peck
 * @version Sep 6, 2011
 * @author Period: 1-7
 * @author Assignment: ch3_2PinSetter
 * 
 * @author Sources: none
 */
public class BetterTurner extends UrRobot
{
    /**
     * Default constructor for a BetterTurner. Invokes the constructor of the
     * the UrRobot superclass
     * 
     * @param st
     *            intial street on which this robot is to be located
     * @param av
     *            intial avenue on which this robot is to be located
     * @param dir
     *            initial direction for this robot to face
     * @param beeps
     *            number of beepers in this robot's beeper bag
     */
    public BetterTurner( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /**
     * Changes robot direction -90 degrees.
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }


    /**
     * Changes robot direction 180 degrees.
     */
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }
}