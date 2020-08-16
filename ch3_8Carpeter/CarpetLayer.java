import kareltherobot.*;


/**
 * We are trying to get Karel to peform the carpet laying test 
 * We will create the world and modularize the program so Karel so it can run.
 * 
 * @author 5121400
 * @version Sep 9, 2013
 * @author Period: 6
 * @author Assignment: ch3_8Carpeter
 * 
 * @author Sources: Eric Cheng
 */
public class CarpetLayer extends BetterTurner
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
    public CarpetLayer( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /**
     * A method to move 7 blocks and placing a Beeper on each one and turn left
     */
    public void movePlantSevenLeft()
    {
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        turnLeft();
    }

    /**
     * Method to lay Carpets around by repeating each corner four times
     */
    public void moveFourPlantSevenLeft()
    {
        movePlantSevenLeft();
        movePlantSevenLeft();
        movePlantSevenLeft();
        movePlantSevenLeft();
    }
    /**
     * A modularized method to lay Carpets around the square
     */
    public void layCarpet()
    {
        moveFourPlantSevenLeft();
    }
}
