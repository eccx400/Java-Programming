package robo;

import robocode.*;
import java.awt.Color;


/**
 * A modular bot adhering to the RoboPart Interface.
 * 
 * @author Eric Cheng
 * @version 17 Mai 2014
 * 
 * @author Period - 6
 * @author Assignment - PartsBot
 * 
 * @author Sources - Eric Cheng
 */
public class PartsBot extends AdvancedRobot
{
    private AdvancedEnemyBot enemy = new AdvancedEnemyBot();

    private RobotPart[] parts = new RobotPart[3]; // make three parts

    private final static int RADAR = 0;

    private final static int GUN = 1;

    private final static int TANK = 2;


    /**
     * Initializes the robot
     */
    public void run()
    {
        parts[RADAR] = new Radar();
        parts[GUN] = new Gun();
        parts[TANK] = new Tank();

        // initialize each part
        for ( int i = 0; i < parts.length; i++ )
        {
            // behold, the magic of polymorphism
            parts[i].init();
        }

        // iterate through each part, moving them as we go
        for ( int i = 0; true; i = ( i + 1 ) % parts.length )
        {
            // polymorphism galore!
            parts[i].move();
            if ( i == 0 )
            {
                execute();
            }
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
        Radar radar = (Radar)parts[RADAR];
        if ( radar.shouldTrack( e ) )
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
        Radar radar = (Radar)parts[RADAR];
        if ( radar.wasTracking( e ) )
        {
            enemy.reset();
        }
    }


    /**
     * put normalizeBearing and absoluteBearing methods here
     * 
     * @param angle
     *            = angle
     * 
     * @return angle = normalized bearing
     */
    public double normalizeBearing( double angle )
    {
        while ( angle > 180 )
        {
            angle -= 360;
        }
        while ( angle < -180 )
        {
            angle += 360;
        }
        return angle;
    }


    /**
     * computes the absolute bearing between two points
     * 
     * @param x1
     *            = first x coordinate
     * @param y1
     *            = first y coordinate
     * @param x2
     *            = second x coordinate
     * @param y2
     *            = second y coordinate
     * @return absolute Bearing
     */
    public double absoluteBearing( double x1, double y1, double x2, double y2 )
    {
        return Math.toDegrees( Math.atan2( x2 - x1, y2 - y1 ) );
    }


    // ... declare the RobotPart interface and classes that implement it here
    // They will be _inner_ classes.
    /**
     * Declare an interface called RobotPart. It should have two method stubs:
     * init() and move().
     */
    public interface RobotPart
    {
        /**
         * initial
         */
        public void init();


        /**
         * move
         */
        public void move();
    }

    /**
     * This is a class called Radar that implements the RobotPart interface
     */
    public class Radar implements RobotPart
    {
        /**
         * Initialize
         */
        public void init()
        {
            setAdjustRadarForGunTurn( true );
        }


        /**
         * Turns radar around 360 degrees
         */
        public void move()
        {
            turnRadarRight( 360 );
        }


        /**
         * Scan the area given a certain parameter, and searches for robots
         * within the specific parameter
         * 
         * @param e
         *            = given robot
         * @return = enemy robot
         */
        public boolean shouldTrack( ScannedRobotEvent e )
        {
            // track if we have no enemy, the one we found is significantly
            // closer, or we scanned the one we've been tracking.
            return ( enemy.none() ||
                            e.getDistance() < enemy.getDistance() - 70 ||
                            e.getName().equals( enemy.getName() ) );
        }


        /**
         * Gets Robot name and sets it as enemy
         * 
         * @param e
         *            = enemy robot
         * @return = e.getName().equals( enemy.getName() ), enemy robot name
         */
        public boolean wasTracking( RobotDeathEvent e )
        {
            return e.getName().equals( enemy.getName() );
        }
    }


    /**
     * Engages the robot
     */
    public class Gun implements RobotPart
    {
        /**
         * Initialize
         */
        public void init()
        {
            setAdjustGunForRobotTurn( true );
        }


        /**
         * Engages the robot
         */
        public void move()
        {
            double firePower = Math.min( 500 / enemy.getDistance(), 3 );
            double bulletSpeed = 20 - firePower * 3;
            long time = (long)( enemy.getDistance() / bulletSpeed );

            double futureX = enemy.getFutureX( time );
            double futureY = enemy.getFutureY( time );
            double getInfo =
                absoluteBearing( getX(), getY(), futureX, futureY );
            setTurnGunRight( normalizeBearing( getInfo - getGunHeading() ) );
            // if the gun is cool and we're pointed at the target, shoot!
            if ( getGunHeat() == 0 && Math.abs( getGunTurnRemaining() ) < 10 )
            {
                setFire( 3 );
            }
        }
    }


    /**
     * This is a class called Tank that also implements the RobotPart interface.
     */
    public class Tank implements RobotPart
    {
        /**
         * Initialize
         */
        public void init()
        {
            // initialize tank operation
            setColors( Color.black, Color.white, Color.gray );
        }


        /**
         * Move Robot ahead
         */
        public void move()
        {
            // implement tank movement
            setAhead( 1000 );
        }
    }
}
