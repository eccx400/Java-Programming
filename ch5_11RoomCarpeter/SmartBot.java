import kareltherobot.*;


/**
 * Write the boolean statement to check if the area around the robot is clear.
 * We use the public Boolean statements to determine if area is free, and then
 * return back to start. We also use some new commands
 * 
 * @author 5121400
 * @version Sep 12, 2013
 * @author Period: 6
 * @author Assignment: ch5_11RoomCarpeter
 * 
 * @author Sources: Eric Cheng
 */
public class SmartBot extends Robot
{
    /**
     * Default Robot constructor.
     * 
     * @param st
     *            initial street
     * @param av
     *            initial avenue
     * @param dir
     *            direction this robot is facing
     * @param numBeepers
     *            number of beepers this robot has in its beeper bag
     */
    public SmartBot( int st, int av, Direction dir, int numBeepers )
    {
        super( st, av, dir, numBeepers );
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
     * Move this robot back one corner.
     */
    public void backUp()
    {
        turnAround();
        move();
        turnAround();
    }


    /**
     * @return Check if the Left of the robot is clear
     */
    public boolean leftIsClear()
    {
        turnLeft();
        if ( frontIsClear() )
        {
            turnRight();
            return true;
        }
        else
        {
            turnRight();
            return false;
        }
    }


    /**
     * @return Check if the Right of the robot is clear
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
}
