import kareltherobot.*;

/**
 * Write the boolean statement to check if the right is clear.
 * We also create the turnRight() statement
 * 
 * @author 5121400
 * @version Sep 18, 2013
 * @author Period: 6
 * @author Assignment: ch6_17EscapeBot
 * 
 * @author Sources: Eric Cheng
 */
public class SmartBot extends Robot
{
    /**
     * @param st = street
     * @param av = avenue
     * @param dir = direction
     * @param numBeepers = Number of Beepers
     */
    public SmartBot( int st, int av, Direction dir, int numBeepers )
    {
        super( st, av, dir, numBeepers );
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
        if ( frontIsClear())
        {
            turnLeft();
            return true;
        }
        else
        {
            turnLeft();
            return false;
        }
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
}
