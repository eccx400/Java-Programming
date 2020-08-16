import kareltherobot.*;
import kareltherobot.Directions.Direction;


/**
 * This is the duplicate of the Mazewalker.java for the other test.
 * We will utilize this command to allow Karel to keep right and complete
 * maze
 * 
 * @author 5121400
 * @version Sep 18, 2013
 * @author Period: 6
 * @author Assignment: ch6_17EscapeBot
 * 
 * @author Sources: Eric Cheng
 */
public class MazeWalker extends SmartBot
{
    /**
     * @param st = street
     * @param av = avenue
     * @param dir = direction
     * @param beeps = beepers
     */
    public MazeWalker( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /**
     * Follow the wall on the right of the robot
     */
    public void followWallRight()

    {
        if ( frontIsClear() )
        {
            move();
        }
        if ( rightIsClear() )
        {
            turnRight();
            move();
        }
        if ( rightIsClear() )
        {
            turnRight();
            move();
        }
        if ( !frontIsClear() )
        {
            turnLeft();
        }
    }
}