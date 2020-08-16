import kareltherobot.*;
import java.awt.Color;

/**
    Utility class to extend the capabilities of the Robot base class.
    
    @author  G. Peck
    @version 09/21/2010
    
    @author  Period - 1-7
    @author  Assignment - all
    
    @author  Sources - Joseph Bergin
*/
public class SmartBot extends Robot
{
    /**
     * Default Robot constructor.
     * 
     * @param st    initial street
     * @param av    initial avenue
     * @param dir   direction this robot is facing
     * @param beeps number of beepers this robot has in its beeper bag
     */
    public SmartBot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }

    /**
     * Default Robot constructor including badge color.
     * 
     * @param st    initial street
     * @param av    initial avenue
     * @param dir   direction this robot is facing
     * @param beeps number of beepers this robot has in its beeper bag
     */
    public SmartBot( int st, int av, Direction dir, int beeps, Color badge )
    {
        super( st, av, dir, beeps, badge );
    }
    
    /**
     * Change this robot's position 90 degrees to the right.
     */
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }

    /**
     * Change this robot's position 90 degrees to the right.
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * Check if the position to the left of the current position is clear.
     * 
     * @return false if there is a wall to the left of the current position,
     *         true otherwise
     */
    public boolean leftIsClear()
    {
        turnLeft();
        if ( frontIsClear() )
        {
            turnRight();
            return true;

        }
        turnRight();
        return false;
    }

    /**
     * Check if the position to the right of the current position is clear.
     * 
     * @return false if there is a wall to the right of the current position,
     *         true otherwise
     */
    public boolean rightIsClear()
    {
        turnRight();
        if ( frontIsClear() )
        {
            turnLeft();
            return true;

        }
        turnLeft();
        return false;
    }
    
    /**
     * Check if the position to the right of the current position is blocked.
     * 
     * @return true if there is a wall to the right of the current position,
     *         false otherwise
     */
    public boolean rightIsBlocked()
    {
       return !rightIsClear();
    }
    
    /**
     * Change robots current orientation to south.
     */
    public void faceSouth()
    {
        if ( !facingSouth() )
        {
           turnLeft();
           faceSouth();
        }
    }

    /**
     * Change robots current orientation to north.
     */
    public void faceNorth()
    {
        if ( !facingNorth() )
        {
           turnLeft();
           faceNorth();
        }
    }

    /**
     * Change robots current orientation to west.
     */
    public void faceWest()
    {
        if ( !facingWest() )
        {
           turnLeft();
           faceWest();
        }
    }
    
    /**
     * Change robots current orientation to east.
     */
    public void faceEast()
    {
        if ( !facingEast() )
        {
           turnLeft();
           faceEast();
        }
    }
}
