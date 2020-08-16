import kareltherobot.*;


/**
 * Karel the robot is planting a garden around the + shaped area. We use the
 * usual and BetterTurner commands that to move the robot in a + shape
 * 
 * @author 5121400
 * @version 9/1/2013
 * @author Period - 6
 * @author Assignment - ch3_Olympics
 * @author Sources - Eric Cheng
 */
public class Gardener extends BetterTurner
{
    /**
     * @param st
     *            = street
     * @param av
     *            = avenue
     * @param dir
     *            = direction
     * @param beeps
     *            = beeper
     */
    public Gardener( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /**
     * This is telling the karel robot to plant beepers in a + shape
     */
    public void plantGarden()
    {
        turnLeft();
        move();
        move();
        move();
        putBeeper();
        turnLeft();
        multiTurn();
        turnRight();
        goHome();
    }


    /**
     * We use this method to make the robot plant 1/4 of the garden
     */
    public void moveAndTurn()
    {
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        turnLeft();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
    }


    /**
     * We use this method to make the robot turn around the wall
     */
    public void uTurn()
    {
        turnRight();
        move();
        putBeeper();
        turnRight();
    }


    /**
     * This is a condensed version, where the robot plants all around the +
     */
    public void multiTurn()
    {
        moveAndTurn();
        uTurn();
        moveAndTurn();
        uTurn();
        moveAndTurn();
        uTurn();
        moveAndTurn();
    }


    /**
     * This allows the robot to move back home
     */
    public void goHome()
    {
        move();
        move();
        move();
        move();
        turnLeft();
    }
}