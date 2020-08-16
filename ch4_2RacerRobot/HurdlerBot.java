import kareltherobot.*;

/**
 *  Karel will jump over the hurdles
 *  
 *  @author  Eric Cheng
 *  @version 10/10/2013
 *
 *  @author  Period - 6
 *  @author  Assignment - ch4_2RacerRobot
 *
 *  @author  Sources - Dave Wittry
 */
public class HurdlerBot extends AbstractHurdlerRobot
{
    public HurdlerBot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }
    
    /* (non-Javadoc)
     * @see AbstractHurdlerRobot#over()
     */
    public void over() 
    { 
        turnRight(); 
        move(); 
        turnRight(); 
        move(); 
    } 
  
  
    /* (non-Javadoc)
     * @see AbstractHurdlerRobot#up()
     */
    public void up() 
    { 
  
        turnLeft(); 
  
        while ( wallOnRight() ) 
        { 
            move(); 
        } 
    } 
  
  
    /* (non-Javadoc)
     * @see AbstractHurdlerRobot#down()
     */
    public void down() 
    { 
  
        while ( frontIsClear() && wallOnRight() ) 
        { 
            move(); 
        } 
        turnLeft(); 
    } 
}