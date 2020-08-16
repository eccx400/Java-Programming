import kareltherobot.*;

/**
 *  We have to use abstract hurdler to run the hurdles
 *  
 *  @author  Eric Cheng
 *  @version 10/14/2013
 *
 *  @author  Period - 6
 *  @author  Assignment - ch4_2RacerRobot
 *
 *  @author  Sources - Dave Wittry
 */
/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Eric's Java
 *  @version Oct 15, 2013
 *  @author  Period: TODO
 *  @author  Assignment: ch4_2RacerRobot
 *
 *  @author  Sources: TODO
 */
public abstract class AbstractHurdlerRobot extends AbstractRacerRobot
{
    /**
     * @param st = street
     * @param av = avenue
     * @param dir = direction
     * @param beeps = beepers
     */
    public AbstractHurdlerRobot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }

    /**
     * Moves to top of hurdle
     */
    public void up() 
    { 
  
        turnLeft(); 
  
        while ( wallOnRight() ) 
        { 
            move(); 
        } 
    } 
  
    /**
     * Move over hurdle
     */
    abstract void over(); 
  
  
    /**
     * All steps to jump over hurdles
     */
    public void raceStride() 
    { 
        moveToHurdleOrBeeper(); 
        if ( !frontIsClear() ) 
        { 
            up(); 
            over(); 
            down(); 
        } 
    } 
  
  
    /**
     * Goes down hurdle
     */
    public void down() 
    { 
  
        while ( frontIsClear() && wallOnRight() ) 
        { 
            move(); 
        } 
        turnLeft(); 
    } 
  
  
    /**
     * Check if right is not clear
     * @return
     */
    public boolean wallOnRight() 
    { 
        turnRight(); 
        if ( !frontIsClear() ) 
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
  
    /**
     * Starting Position
     */
    public void moveToHurdleOrBeeper() 
    { 
        while ( frontIsClear() && !nextToABeeper() ) 
        { 
            move(); 
        } 
  
    } 
}