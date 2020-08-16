import kareltherobot.*;

/**
 *  Karel jumps over a high hurdle
 *  
 *  @author  Eric Cheng
 *  @version 10/14/13
 *
 *  @author  Period - 6
 *  @author  Assignment - ch4_2RacerRobot
 *
 *  @author  Sources - Dave Wittry
 */
public class HighHurdlerBot extends AbstractHurdlerRobot
{
    /**
     * @param st = street
     * @param av = avenue
     * @param dir = direction
     * @param beeps = beepers
     */
    public HighHurdlerBot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }

    /* (non-Javadoc)
     * @see AbstractHurdlerRobot#over()
     */
    public void over() 
    { 
        moveOver();
        moveOver();
    } 
  
  
    /**
     * moves over
     */
    public void moveOver() 
    { 
        turnRight(); 
        move(); 
    } 
}