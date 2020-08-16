import kareltherobot.*;


/**
 * Test the followWallRight ability of a MazeWalker Robot
 * 
 * @author 5121400
 * @version 9/11/2013
 * 
 * @author Period - 6
 * @author Assignment - ch5_9MazeWalker
 * 
 * @author Sources - Eric Cheng
 */
public class MazeWalkerTest implements Directions
{
    /**
     * Test method to check all four conditions of the followWallRight behavior
     * of a MazeWalker object.
     * 
     * @param args
     *            command line arguments (not used)
     */
    public static void main( String args[] )
    {
        MazeWalker karel = null;

        karel = new MazeWalker( 2, 2, North, 0 );
        karel.followWallRight();

        karel = new MazeWalker( 2, 7, North, 0 );
        karel.followWallRight();

        karel = new MazeWalker( 7, 2, North, 0 );
        karel.followWallRight();

        karel = new MazeWalker( 7, 7, North, 0 );
        karel.followWallRight();

        karel.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "righttest.wld" );
        World.setDelay( 10 );
        World.setVisible( true );
    }
}
