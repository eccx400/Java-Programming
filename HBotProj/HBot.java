import kareltherobot.*;

/**
 *  Draws an 'H' on a blank 10 x 10 world by placing beepers.
 *
 *  @author  5121400
 *  @version 8/23/2013
 *  @author  Period: 6
 *  @author  Assignment: HBotProj
 *
 *  @author  Sources: Eric Cheng
 */
public class HBot extends UrRobot
{
    public HBot( int street, int avenue, Direction direction, int beepers )
    {
       super( street, avenue, direction, beepers );
    }

    public void drawH()
    {
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        move();
        putBeeper();
        move();
        putBeeper();
        turnLeft();
        move();
        putBeeper();
        turnLeft();
        turnLeft();
        move();
        move();
        putBeeper();
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        move();
        move();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
    }
}
