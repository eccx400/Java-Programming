import kareltherobot.*;

/**
   Utility class to extend the movement capabilities of the
   UrRobot base class.

   @author  G. Peck
   @version 8/1/2003

   @author  Period - 1-7
   @author  Assignment - all

   @author  Sources - Joseph Bergin
 */
public class BetterTurner extends UrRobot
{
    /**
     * Default UrRobot constructor
     * 
     * @param st     initial street
     * @param av     initial avenue
     * @param dir    direction this robot is facing
     * @param beeps  number of beepers this robot has in its beeper bag
     */
    public BetterTurner( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }

    /**
     * Turns 90 degrees to the right of this robots current direction.
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * Turns 180 degrees from this robots current direction.
     */
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }
}