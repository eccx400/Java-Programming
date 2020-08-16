import kareltherobot.*;


/**
 * A MountainClimber robot climbs a mountain and then plant a flag, represented
 * by a beeper, on the summit; The robot then descends the other side of the
 * mountain. The MountainClimber starts with the flag-beeper in the beeper-bag
 * 
 * @author 5121400
 * @version 8/26/2013
 * @author Period: 6
 * @author Assignment: KJR Chapter 2, Problem 6 - MountainClimber
 * 
 * @author Sources: Eric Cheng
 */
public class MountainClimber extends UrRobot
{
    public MountainClimber( int st, int ave, Direction dir, int beeps )
    {
        super( st, ave, dir, beeps );
    }


    public void climbMountain()
    {
        turnLeft();
        move();
        move();
        turnLeft();
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
        turnLeft();
        move();
        putBeeper();
        move();
        turnLeft();
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
        turnLeft();
        move();
        move();
        turnLeft();
    }
}
