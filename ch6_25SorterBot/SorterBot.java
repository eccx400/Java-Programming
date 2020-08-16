import kareltherobot.*;


/**
 * We will let karel place beepers in ascending order according to its rows. We
 * will use if statements and while loops to allow karel to run until it meets a
 * certain condition.
 * 
 * @author 5121400
 * @version Sep 22, 2013
 * @author Period: 6
 * @author Assignment: ch6_25SorterBot
 * 
 * @author Sources: Eric Cheng
 */
public class SorterBot extends SmartBot
{
    /**
     * @param st
     *            = street
     * @param av
     *            = avenue
     * @param dir
     *            = direction
     * @param numBeepers
     *            = number of Beepers
     */
    public SorterBot( int st, int av, Direction dir, int numBeepers )
    {
        super( st, av, dir, numBeepers );
    }


    /**
     * Karel will sort Beepers in ascending order
     */
    public void sortThemAll()
    {
        initialPosition();
        checkRow();
        pickRow();
        while ( anyBeepersInBeeperBag() )
        {
            initialPosition();
            moveToNextRow();
            placeRow();
            turnAround();
            checkRow();
            pickRow();
        }
    }


    /**
     * Picks a row of beepers
     */
    public void pickRow()
    {
        while ( frontIsClear() )
        {
            if ( nextToABeeper() )
            {
                pickBeeper();
            }
            move();
        }
        if ( nextToABeeper() )
        {
            pickBeeper();
        }
    }


    /**
     * Moves to next row needed to be placed right
     */
    public void moveToNextRow()
    {
        while ( nextToABeeper() )
        {
            move();
        }
        turnAround();
        move();
        turnAround();
        turnLeft();
        while ( nextToABeeper() )
        {
            move();
        }
        turnLeft();
    }


    /**
     * Checks the row to see if done
     */
    public void checkRow()
    {
        while ( !nextToABeeper() )
        {
            move();
        }
        while ( nextToABeeper() )
        {
            move();
        }
        turnAround();
        move();
        turnAround();
        turnLeft();
        move();
        turnLeft();
    }


    /**
     * Moves to initial postition
     */
    public void initialPosition()
    {
        faceWest();
        while ( frontIsClear() )
        {
            move();
        }
        faceSouth();
        while ( frontIsClear() )
        {
            move();
        }
        faceEast();
    }


    /**
     * Places Beepers in a Row
     */
    public void placeRow()
    {
        while ( frontIsClear() )
        {
            if ( anyBeepersInBeeperBag() )
            {
                putBeeper();
            }
            move();
        }
    }
}