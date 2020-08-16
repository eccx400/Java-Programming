package robo;

import robocode.*;


/**
 * BearingBot
 * 
 * @author Eric Cheng
 * @version 5/8/2014
 * 
 * @author Period - 6
 * @author Assignment - PartsBot
 * 
 * @author Sources - Eric Cheng
 */
public class MyFirstRobot extends Robot
{
    /**
     * Where all the fun is
     * 
     * @see robocode.Robot#run()
     */
    public void run()
    {
        while ( true )
        {
            ahead( 100 ); // move ahead 100
            turnRight( 180 ); // turn right 180
            ahead( 200 ); // move ahead 200
            turnLeft( 180 ); // turn around
            ahead( 100 ); // move ahead 100
            turnRight( 90 ); // turn around
            ahead( 100 ); // move ahead 100
            turnRight( 180 ); // turn right 180
            ahead( 200 ); // move ahead 200
            turnLeft( 180 ); // turn around
            ahead( 100 ); // move ahead 100
            turnLeft( 90 ); // turn left 90
        }
    }


    /**
     * Fire on opponent when scanned
     * 
     * @see robocode.Robot#onScannedRobot(robocode.ScannedRobotEvent)
     * 
     * @param e
     *            ScannedRobotEvent
     */
    public void onScannedRobot( ScannedRobotEvent e )
    {
        fire( 2 ); // FIREEEE
    }

}
