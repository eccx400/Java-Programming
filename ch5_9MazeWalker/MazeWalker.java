import kareltherobot.*;
import kareltherobot.Directions.Direction;


/**
 * We are controlling 4 different robots by using if statements It uses
 * different boolean statements and checking for wall positions to determine the
 * walls
 * 
 * @author 5121400
 * @version Sep 11, 2013
 * @author Period: 6
 * @author Assignment: ch5_9MazeWalker
 * 
 * @author Sources: Eric Cheng
 */
public class MazeWalker extends SmartBot
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
    public MazeWalker( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /**
     * precondition: there is a wall directly to the right of this robot
     * postcondition: moves along the wall one step keeping its position so that
     * the wall remains on its right
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
        if ( frontIsClear() )
        {
            turnOff();
        }
        else
        {
            turnLeft();
        }
    }
}