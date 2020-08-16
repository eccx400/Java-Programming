import kareltherobot.*;


// We're defining the new terms for karel and using them to set pins

/**
 * We are trying to make the karel j. robot set 10 bowling pins We use new
 * commands that we create in the BetterTurner.java to aid us
 * 
 * @author 5121400
 * @version Aug 30, 2013
 * @author Period: 6
 * @author Assignment: ch3_2PinSetter
 * 
 * @author Sources: Eric Cheng
 */
public class PinSetter extends BetterTurner
{
    /**
     * @param st = street
     * @param av = avenue
     * @param dir = direction
     * @param beeps = beepers
     */
    public PinSetter( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /**
     * Set of programs that we can make to allow the robot to set pins
     */
    public void setPins()
    {
        move(); // moves to pin 1
        setTriangle();
        moveToPin6From3();
        setTriangle();
        moveToPin4From10();
        setTriangle();
        moveToPin5From8();
        putBeeper();
        moveBackHome();
    }


    /**
     * We are setting a triangle (3 pins) using the robot
     */
    private void setTriangle()
    {
        putBeeper();
        turnLeft();
        move();
        turnRight();
        move();
        putBeeper();
        turnRight();
        move();
        move();
        putBeeper();

    }


    /**
     * We are moving from the Pin 3 to Pin 6
     */
    private void moveToPin6From3()
    {
        turnLeft();
        move();
        turnRight();
        move();
        turnLeft();
    }


    /**
     * We are moving from the Pin 10 to Pin 4
     */
    private void moveToPin4From10()
    {
        turnAround();
        move();
        move();
        move();
        move();
        move();
        turnLeft();
        move();
        turnAround();
    }


    /**
     * We are moving from the Pin 8 to Pin 5
     */
    private void moveToPin5From8()
    {
        move();
        turnRight();
        move();
        turnAround();
    }


    /**
     * We are trying to get back to the starting point (1,5)
     */
    private void moveBackHome()
    {
        turnAround();
        move();
        move();
        move();
        turnAround();
    }
}