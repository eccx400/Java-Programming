import kareltherobot.*;


/**
 * We are trying to get the robot to move in a figure 8 movement. Purpose is to
 * see how efficient the result is to move in a figure 8 position
 * 
 * 
 * @author 5121400
 * @version 8/28/2013
 * @author Period: 6
 * @author Assignment: KJR Chapter 2, Problem 9 - Figure8
 * 
 * @author Sources: Eric Cheng
 */
public class Figure8 extends UrRobot
{
    /**
     * Default constructor for an UrRobot
     * 
     * @param st
     *            street
     * @param ave
     *            avenue
     * @param dir
     *            direction robot is facing
     * @param beeps
     *            number of beepers
     */
    public Figure8( int st, int ave, Direction dir, int beeps )
    {
        super( st, ave, dir, beeps );
    }


    /**
     * I will try to use the methods turnLeft(); and move(); to allow the robot
     * to go in a figure eight motion by separating the figure eight into a
     * larger with a tiny bypass near the middle. This allows for quicker
     * movement and less commands.
     */
    public void doFigure8()
    {
        turnLeft();
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        move();
        move();
        move();
        move();
        turnLeft();
        move();
        move();
        turnLeft();
        move();
        move();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        move();
        move();
        turnLeft();
        move();
        turnLeft();
    }
}
