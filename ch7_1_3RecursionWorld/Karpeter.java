import kareltherobot.*;
import java.awt.Color;


/**
 * We will make karel go around in a loop once inside the given hallway We will
 * use the recusions to allow the robot to repeat steps for a certain integer
 * 
 * @author 5121400
 * @version Sep 27, 2013
 * @author Period: 6
 * @author Assignment: ch7_1_3RecursionWorld
 * 
 * @author Sources: Eric Cheng
 */
public class Karpeter extends SmartBot
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
    public Karpeter( int st, int av, Direction dir, int beeps, Color badge )
    {
        super( st, av, dir, beeps, badge );
    }


    /**
     * This carpets the hallway one time around
     * 
     * @return
     */
    public int carpetHallway()
    {
        if ( nextToABeeper() )
        {
            return 0;
        }
        else
        {
            putBeeper();
            move();
            if ( !frontIsClear() )
            {
                turnRight();
            }
        }
        return carpetHallway() + 1;
    }
}