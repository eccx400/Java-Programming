import kareltherobot.*;


/**
 * We create new methods to aid us in allowing karel to face the course We
 * create new methods using construction methods to make it more efficient
 * 
 * @author 5121400
 * @version 9/3/2013
 * @author Period - 6
 * @author Assignment - ch3_Olympics
 * @author Sources - Eric Cheng
 */
public class Triathlete extends BetterTurner
{
    /**
     * @param st
     *            = Street
     * @param av
     *            = Avenue
     * @param dir
     *            = Direction
     * @param beeps
     *            = Beepers
     */
    public Triathlete( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }

    /**
     * This allow karel to run the race
     */
    public void runRace()
    {
        move();
        pickAll();
        turnLeft();
        move();
        turnRight();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        move();
        climbstairs();
        putAllBeepers();
        turnAround();
        moveMile();
        moveSeven();
        turnLeft();
        move();
        move();
        move();
        move();
        turnLeft();
    }


    /**
     * Pick up all seven beepers as the robot moves
     */
    public void pickAll()
    {
        pickBeeper();
        move();
        pickBeeper();
        move();
        pickBeeper();
        move();
        pickBeeper();
        move();
        pickBeeper();
        move();
        pickBeeper();
        move();
        pickBeeper();
        move();
    }


    /**
     * Climb a four step stair
     */
    public void climbstairs()
    {
        turnLeft();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        turnRight();
        move();
    }


    /**
     * Place down all seven beepers
     */
    public void putAllBeepers()
    {
        putBeeper();
        putBeeper();
        putBeeper();
        putBeeper();
        putBeeper();
        putBeeper();
        putBeeper();
    }


    /**
     * Make the robot move eight grids.
     */
    public void moveMile()
    {
        move();
        move();
        move();
        move();
        move();
        move();
        move();
        move();
    }


    /**
     * Make the robot move seven grids
     */
    public void moveSeven()
    {
        move();
        move();
        move();
        move();
        move();
        move();
        move();
    }
}