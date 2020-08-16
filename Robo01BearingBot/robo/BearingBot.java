package robo;

import java.awt.Color;

import robocode.*;

/**
 * BearingBot
 * 
 * @author Eric Cheng
 * @version 8 Mai,2014
 * 
 * @author Period - 6
 * @author Assignment - PartsBot
 * 
 * @author Sources - Eric Cheng
 */
public class BearingBot extends Robot
{
    /**
     * run: BearingBot's default behavior
     * 
     * 1. Scans for his enemy (just whip your radar around in the while (true)
     * loop of your run() method)
     */
    public void run()
    {
        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:
        // setColors(Color.red,Color.blue,Color.green);
        while ( true )
        {
            setRadarColor(Color.blue);
            turnRadarRight(360);
            turnRight( 360 );
            ahead( 10 );
            turnRight( 180 );
            ahead( 20 );
            turnRight( 180 );
            ahead( 10 );
        }
    }


    /**
     * onScannedRobot: What to do when you see another robot
     * 
     * 2. Turns toward him (right or left, depending; use the bearing reported
     * by the ScannedRobotEvent object passed to the onScannedRobot() method) 3.
     * Fires at him 4. Lastly, rams into him (Hint: use the getDistance() method
     * of the onScannedRobot() object passed to the onScannedRobot() method. The
     * sample robot "RamFire" further demonstrates the virtues of ramming.)
     * 
     * @param e = not applicable 
     */
    public void onScannedRobot( ScannedRobotEvent e )
    {
        turnRight( e.getBearing() );
        fire( 2 );
        ahead( e.getDistance() );
    }
}
