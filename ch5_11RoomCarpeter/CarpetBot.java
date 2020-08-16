import kareltherobot.*;


/**
 * We are placing beepers in different rooms that have 3 sides blocked by walls
 * and use if and else to seperate them from the other rooms that do not meet
 * these conditions
 * 
 * @author 5121400
 * @version Sep 12, 2013
 * @author Period: 6
 * @author Assignment: ch5_11RoomCarpeter
 * 
 * @author Sources: Eric Cheng
 */
public class CarpetBot extends SmartBot
{
    /**
     * @param st
     *            = Street
     * @param av
     *            = Avenue
     * @param dir
     *            = Direction
     * @param numBeepers
     *            = Number of Beepers
     */
    public CarpetBot( int st, int av, Direction dir, int numBeepers )
    {
        super( st, av, dir, numBeepers );
    }


    /**
     * We place beepers in underside U shaped rooms using if and else
     */
    public void carpetRooms()
    {
        initialPosition();
        placeBeeper();
        placeBeeper();
        placeBeeper();
        placeBeeper();
        placeBeeper();
        placeBeeper();
        placeBeeper();
        toTheEnd();
    }


    /**
     * Start at initial position to put beepers
     */
    public void initialPosition()
    {
        if ( frontIsClear() )
        {
            move();
        }
        if ( leftIsClear() )
        {
            turnLeft();
            move();
        }
    }

    /**
     * Check the room to see if beeper can be placed
     */
    public void placeBeeper()
    {
        if ( !frontIsClear() && !rightIsClear() && !leftIsClear() )
        {
            putBeeper();
        }
        backUp();
        turnRight();
        move();
        if ( leftIsClear() )
        {
            turnLeft();
            move();
        }
    }
    
    /**
     * Moves karel to the end
     */
    public void toTheEnd()
    {
        turnAround();
        move();
        turnLeft();
        move();
    }
}