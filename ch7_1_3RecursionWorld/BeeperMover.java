import kareltherobot.*;
import java.awt.Color;


/**
 * We are trying to take the beepers in one row and transfer them to another We
 * can simplify this by using boolean commands and recursion to make the robot
 * repeat its steps over and over until it meets a certain condition.
 * 
 * @author 5121400
 * @version Sep 27, 2013
 * @author Period: 6
 * @author Assignment: ch7_1_3RecursionWorld
 * 
 * @author Sources: Eric Cheng
 */
public class BeeperMover extends SmartBot
{
    /**
     * @param st
     *            = street
     * @param av
     *            = avenue
     * @param dir
     *            = direction
     * @param beeps
     *            = beepers
     * @param badge
     *            = badge
     */
    public BeeperMover( int st, int av, Direction dir, int beeps, Color badge )
    {
        super( st, av, dir, 0, badge );
    }


    /**
     * This is the main method to move the beepers north according to the amount
     * of beepers there is
     */
    public void moveBeepersNorth()
    {
        findStart();
        pickAndTranslateSelfToTheNorth();
        turnAround();
        move();
        faceWest();
        dropRow();
    }


    /**
     * Goes to starting position until it reaches start point
     */
    private void findStart()
    {
        if ( !nextToABeeper() )
        {
            move();
            findStart();
            return;
        }
        else
        {
            move();
            turnAround();
            move();
            turnAround();
        }
    }


    /**
     * When there are any beepers in the front of karel, it will pick them up
     * and transfer it to the north
     */
    private void pickAndTranslateSelfToTheNorth()
    {
        if ( nextToABeeper() )
        {
            pickBeeper();
            if ( anyBeepersInFront() )
            {
                move();
            }
            pickAndTranslateSelfToTheNorth();
        }
        faceNorth();
        move();
    }


    /**
     * Drops one row of beepers until beeper bag is empty
     */
    private void dropRow()
    {
        faceWest();
        if ( anyBeepersInBeeperBag() )
        {
            putBeeper();
            move();
            dropRow();
        }
    }


    /**
     * Looks to see if there are any beepers in front of robot
     * 
     * @return
     */
    public boolean anyBeepersInFront()
    {
        move();
        if ( nextToABeeper() )
        {
            turnAround();
            move();
            turnAround();
            return true;
        }
        else
        {
            turnAround();
            move();
            turnAround();
            return false;
        }
    }
}
