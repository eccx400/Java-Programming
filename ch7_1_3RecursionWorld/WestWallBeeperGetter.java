import kareltherobot.*;
import java.awt.Color;


/**
 * We will make the robot pick a Beeper on the left wall using recursion We will
 * call back on getBeeper() in the getBeeper() instruction to make the robot
 * continue
 * 
 * @author 5121400
 * @version Sep 27, 2013
 * @author Period: 6
 * @author Assignment: ch7_1_3RecursionWorld
 * 
 * @author Sources: Eric Cheng
 */
public class WestWallBeeperGetter extends SmartBot
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
    public WestWallBeeperGetter(
        int st,
        int av,
        Direction dir,
        int beeps,
        Color badge )
    {
        super( st, av, dir, beeps, badge );
    }


    /**
     * Robot gets a Beeper on the West wall and back using recursion
     */
    public void getBeeper()
    {
        faceWest();
        if ( !frontIsClear() )
        {
            pickBeeper();
            turnAround();
            return;
        }
        else
        {
            move();
            getBeeper();
            move();
        }
    }
}
