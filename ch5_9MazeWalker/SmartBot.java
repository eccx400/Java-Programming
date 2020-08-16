import kareltherobot.*;


/**
 * Write the boolean statement to check if the right is clear of obstacles We
 * use the public Boolean statements to determine if the right is free of walls
 * and then return back to start
 * 
 * @author 5121400
 * @version Sep 11, 2013
 * @author Period: 6
 * @author Assignment: ch5_9MazeWalker
 * 
 * @author Sources: Eric Cheng
 */
public class SmartBot extends Robot
{
    /**
     * @param st = street
     * @param av = avenue
     * @param dir = direction
     * @param numBeepers = number of beepers
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
        if ( frontIsClear() )
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
     * Change this robot's postion 90 degrees to the right.
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
