package robo;

import robocode.*;
import java.awt.geom.Point2D;


/**
 * Predicts the future position of the enemy bot, and engages it in combat 
 * using the information from the enemybot and the advanced enemy bot
 * 
 * @author Eric Cheng
 * @version May 14, 2014
 * @author Period: 6
 * @author Assignment: Robo4AdvancedEnemyBot
 * 
 * @author Sources: Eric Cheng
 */
public class PredictiveShooter extends AdvancedRobot
{
    private AdvancedEnemyBot enemy = new AdvancedEnemyBot();


    /**
     * Runs the robot
     */
    public void run()
    {
        setAdjustGunForRobotTurn( true );
        setAdjustRadarForGunTurn( true );
        enemy.reset();
        setTurnRadarRight( 360 );
        while ( true )
        {
            setTurnRight( 5 );
            setTurnRadarRight( 360 );
            setAhead( 20 );
            engage();
            execute();
        }
    }


    /**
     * Finds and tracks the robot
     * 
     * @param e
     *            = enemy robot
     * 
     */
    public void onScannedRobot( ScannedRobotEvent e )
    {
        if ( enemy.none() || e.getName().equals( enemy.getName() )
            || e.getDistance() < enemy.getDistance() - 70 )
        {
            enemy.update( e, this );
        }
    }


    /**
     * Remakes the enemy
     * 
     * @param e
     *            = resets the enemy
     * 
     */
    public void onRobotDeath( RobotDeathEvent e )
    {
        if ( e.getName().equals( enemy.getName() ) )
        {
            enemy.reset();
        }
    }


    /**
     * Engages the robot
     */
    public void engage()
    {
        if ( enemy.none() )
        {
            return;
        }

        double firePower = Math.min( 500 / enemy.getDistance(), 3 );
        double bulletSpeed = 20 - firePower * 3;
        long time = (long)( enemy.getDistance() / bulletSpeed );

        double futureX = enemy.getFutureX( time );
        double futureY = enemy.getFutureY( time );
        double getInfo = absoluteBearing( getX(), getY(), futureX, futureY );
        setTurnGunRight( normalizeBearing( getInfo - getGunHeading() ) );
        // if the gun is cool and we're pointed at the target, shoot!
        if ( getGunHeat() == 0 && Math.abs( getGunTurnRemaining() ) < 10 )
        {
            setFire( 3 );
        }
    }


    /**
     * absolute bearing
     * 
     * @param x1
     *            first position of x
     * @param y1
     *            first position of y
     * @param x2
     *            second position of x
     * @param y2
     *            second position of y
     * @return bearing of robot
     */
    double absoluteBearing( double x1, double y1, double x2, double y2 )
    {
        double xAbsolute = x2 - x1;
        double yAbsolute = y2 - y1;
        double hypotenuse = Point2D.distance( x1, y1, x2, y2 );
        double arcSin = Math.toDegrees( Math.asin( xAbsolute / hypotenuse ) );
        double bearing = 0;

        if ( xAbsolute > 0 && yAbsolute > 0 )
        {
            bearing = arcSin;
        }
        else if ( xAbsolute < 0 && yAbsolute > 0 )
        {
            bearing = 360 + arcSin;
        }
        else if ( xAbsolute > 0 && yAbsolute < 0 )
        {
            bearing = 180 - arcSin;
        }
        else if ( xAbsolute < 0 && yAbsolute < 0 )
        {
            bearing = 180 - arcSin;
        }

        return bearing;
    }


    /**
     * normalizes a bearing to between +180 and -180
     * 
     * @param angle
     *            angle of the robot
     * @return scrub = normalized bearing
     */
    double normalizeBearing( double angle )
    {
        double scrub = angle;
        while ( angle > 180 )
        {
            scrub -= 360;
        }
        while ( angle < -180 )
        {
            scrub += 360;
        }
        return scrub;
    }
}