import kareltherobot.*;


/**
 * We are trying to use comments to explain what the new terms we created means,
 * what are they composed of, and how we are going to use it
 * 
 * @author 5121400
 * @version Aug 28, 2013
 * @author Period: 6
 * @author Assignment: ch3_2PinSetter
 * 
 * @author Sources: Eric Cheng
 */
public class BetterTurner extends UrRobot
{

    /**
     * @param st = street
     * @param av = avenue
     * @param dir = direction
     * @param beeps = beeper
     */
    public BetterTurner( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /**
     * To turn right(or rotate the robot 90 degrees to the right), we package
     * the command turnRight() into 3 turnLeft(); commands
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }


    /**
     * When you want the robot to go back and rotate back to the opposite way,
     * you use two turnLeft(); commands to make the robot face away from the 
     * way it was going
     */
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }
}