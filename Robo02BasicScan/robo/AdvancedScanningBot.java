package robo;

import robocode.*;

/**
 * My first AdvancedRobot
 * 
 * @author Eric Cheng
 * @version 5/9/2014
 * 
 * @author Period - 6
 * @author Assignment - AdvancedScanningBot
 * 
 * @author Sources - Eric Cheng
 */
public class AdvancedScanningBot extends AdvancedRobot 
{
    /**
     * Where all the fun is
     * 
     * @see robocode.Robot#run()
     */
    public void run()
    { 
        setAdjustRadarForRobotTurn(true);
        while ( true ) 
        { 
            turnRadarRight(360);
            ahead( 1000 ); 
            turnRight( 90 ); 
            ahead(500);
            turnRight( 90 ); 
            execute();
        } 
    }

    /**
     * Fire on opponent when scanned
     * 
     * @see robocode.Robot#onScannedRobot(robocode.ScannedRobotEvent)
     * 
     * @param e ScannedRobotEvent
     */
    public void onScannedRobot( ScannedRobotEvent e )
    {
        turnRight( e.getBearing() );
        turnRadarRight(getHeading() - getRadarHeading() + e.getBearing());
        fire( 3 ); 
        ahead( e.getDistance() );
        execute();
    }
}
