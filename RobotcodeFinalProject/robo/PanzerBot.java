package robo;

import robocode.*;
import robocode.util.Utils;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


/**
 * This is the robot for the Robocode Final. In the package, we have the
 * constructor for AdvancedEnemyBot and Enemybot, and for this robot we
 * utilized the ideas of different targeting and radar locking to find the 
 * enemy and kill it.
 * 
 * @author Eric Cheng / Kosuke Kurita
 * @version 17 Mai 2014
 * 
 * @date Period - 6
 * @author Assignment - PartsBot
 * 
 * @sources Sources - Circular Targeting:http://robowiki.net/wiki/Circular_Targeting
 *                   Linear Targeting:http://robowiki.net/wiki/Linear_Targeting
 *                   SuperRamBot.j/Users/Eric/Dropbox/workspace/robotcodefinalproject/robo/PanzerBot.javaava:http://robowiki.net/wiki/SuperRamFire by Crazy Bassoonist. 
 *                   Width Lock: http://robowiki.net/wiki/One_on_One_Radar
 */
public class PanzerBot extends AdvancedRobot
{
    private AdvancedEnemyBot enemy = new AdvancedEnemyBot();

    private RobotPart[] parts = new RobotPart[3]; // make three parts

    private final static int RADAR = 0;

    private final static int GUN = 1;

    private final static int TANK = 2;
    
    private int moveDirection = 1;

    public int direction = 1;

    public int tooCloseToWall = 0;

    double eEnergy;

    double energy;

    private int wallMargin = 85;

    double bullet_Power = 2.3;

    double bullet_Damage = bullet_Power * 4;

    double bullet_Speed = 20 - bullet_Power * 3;

    public CustomEvent e;

    static double oldEnemyHeading;


    /**
     * allows the robot to run.
     * 
     * @see robocode.Robot#run()
     */
    public void run()
    {
        // the three constructors of the three classes.
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
                execute();
        }

    }


    /**
     * This part explains that if the robot scans another robot, the robot radar
     * will update
     * 
     * @param e
     *            the scanned-robot event set by the game
     * @see robocode.Robot#onScannedRobot(robocode.ScannedRobotEvent)
     */
    public void onScannedRobot( ScannedRobotEvent e )
    {
        Radar radar = (Radar)parts[RADAR];
        if ( radar.shouldTrack( e ) )
            enemy.update( e, this );
    }


    /**
     * If the other robot dies, the radar resets so that it can find another
     * robot. (non-Javadoc)
     * 
     * @param e
     *            the event for enemy robot death
     * @see robocode.Robot#onRobotDeath(robocode.RobotDeathEvent)
     */
    public void onRobotDeath( RobotDeathEvent e )
    {
        Radar radar = (Radar)parts[RADAR];
        if ( radar.wasTracking( e ) )
            enemy.reset();
    }


    /**
     * if you are hit by a bullet, lower the health by bullet_Damage
     * 
     * @see robocode.Robot#onBulletHit(robocode.BulletHitEvent)
     */
    public void onBulletHit( BulletHitEvent e )
    {
        eEnergy -= bullet_Damage;
    }


    /**
     * Occurs when the robot is hit by a bullet. Move away from where the robot
     * was last shot whenever the robot gets hit by a bullet.
     * 
     * @param event
     *            the hit-by-bullet event set by the game
     */
    public void onHitByBullet( HitByBulletEvent event )
    {
        direction = -direction;
    }


    /**
     * (non-Javadoc) if you hit a wall, go in the reverse direction @ e the
     * hit-wall event set by the game
     * 
     * @see robocode.Robot#onHitWall(robocode.HitWallEvent)
     */
    public void onHitWall( HitWallEvent e )
    {
        direction = -direction;
    }


    /**
     * (non-Javadoc)
     * 
     * @see robocode.AdvancedRobot#onCustomEvent(robocode.CustomEvent)
     */
    /**
     * Occurs when the robot collides with another robot. Move backwards from
     * any robot whenever our robot hits another robot because if the robot moves
     * forward, the robot will just keep ramming into it.
     * 
     * @param event
     *            the hit-robot event set by the game
     */
    public void onHitRobot( HitRobotEvent event )
    {
        setBack( 500 );
    }


    /**
     * If we're too close to the wall, we switch directions and move away
     * 
     * @param e
     */
    public void onCustomEvent( CustomEvent e )
    {
        if ( e.getCondition().getName().equals( "too_close_to_walls" ) )
        {
            if ( tooCloseToWall <= 0 )
            {
                // if we weren't already dealing with the walls, we are now
                tooCloseToWall += wallMargin;
                moveDirection *= -1; setAhead(10000 * moveDirection);
                setMaxVelocity( 0 ); // stop!!!
            }
        }
    }


    /**
     * This method normalizes the bearing so that the robot can turn the least
     * number of degrees (between -180 and 180) instead of all the way around.
     * 
     * @param angle
     * @return angle
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
     *            : first x coordinate
     * @param y1
     *            : first y coordinate
     * @param x2
     *            : second x coordinate
     * @param y2
     *            : second y coordinate
     * @return bearing
     */
    public double absoluteBearing( double x1, double y1, double x2, double y2 )
    {
        return Math.toDegrees( Math.atan2( x2 - x1, y2 - y1 ) );
    }


    /**
     * computes the absolute bearing between two points
     * 
     * @param x1
     *            : first x coordinate
     * @param y1
     *            : first y coordinate
     * @param x2
     *            : second x coordinate
     * @param y2
     *            : second y coordinate
     * @return bearing
     */
    /**
     * Declares RobotPart interface and inner classes
     * 
     */
    public interface RobotPart
    {

        // will be the initialization method
        public void init();


        // this is the movement method
        public void move();
    }


    /**
     * Implements Radar methods of what to do when initialized and what to do
     * when
     * 
     * @author Sources: - Width Lock Radar
     *         http://robowiki.net/wiki/One_on_One_Radar#Perfect_Radar_Locks
     */
    public class Radar implements RobotPart
    {
        /**
         * This part initializes the radar.
         * 
         * 
         * @see skrc.PanzerBot.RobotPart#init()
         */
        public void init()
        {
            setAdjustRadarForGunTurn( true );
            setAdjustRadarForRobotTurn( true );
        }


        /**
         * This part moves the radar by using the Width lock sample from
         * robowiki
         * 
         * @see skrc.Panzerbot.RobotPart#move()
         * @source http://robowiki.net/wiki/One_on_One_Radar
         */
        public void move()
        {
            // Continually searches for enemies
            if ( enemy.none() )
            {
                setTurnRadarRight( 200000 );
            }
            else
            {
                // Absolute angle towards target
                double angleToEnemy = getHeadingRadians()
                    + Math.toRadians( enemy.getBearing() );

                // Distance we want to scan from middle of enemy to either side
                // The 36.0 is how many units from the center of the enemy
                // robot it scans.
                double extraTurn = Math.min( Math.atan( 36.0 / enemy.getDistance() ),
                    Rules.RADAR_TURN_RATE_RADIANS );

                // Subtract current radar heading to get the turn required to
                // face the enemy, be sure it is normalized
                double radarTurn = Utils.normalRelativeAngle( angleToEnemy
                    - getRadarHeadingRadians() );

                // Turnrey Operator expanded. Original: radarTurn
                // += (radarTurn < 0 ? -extraTurn : extraTurn);
                if ( radarTurn < 0 )
                {
                    radarTurn -= extraTurn;
                }
                else
                {
                    radarTurn += extraTurn;
                }
                // Turn the radar
                setTurnRadarRightRadians( radarTurn );
            }
        }


        /**
         * This method tracks to see if there are enemies.
         * 
         * @param e
         *            Scanned Robot Event
         * @return enemy tracking robot
         */
        public boolean shouldTrack( ScannedRobotEvent e )
        {

            return ( enemy.none() || e.getDistance() < enemy.getDistance() - 70 || e.getName()
                .equals( enemy.getName() ) );
        }


        /**
         * Finds robot to track
         * 
         * @param e
         *            RobotDeath Event
         * @return enemy name
         */
        public boolean wasTracking( RobotDeathEvent e )
        {
            return e.getName().equals( enemy.getName() );
        }
    }


    /**
     * Implements Gun aspect of Parts Bot class.
     * 
     * @author Sources: - Uses circular Targeting
     *         http://robowiki.net/wiki/Circular_Targeting
     */
    /**
     *  This uses the Linear targeting, where the robots are targeted by the 
     *  radars and bullets are shot towards that place
     *
     *  @author  Eric Cheng / Kosuke Kurita
     *  @version May 30, 2014
     *  @author  Period: 6
     *  @author  Assignment: RobotcodeFinalProject
     *
     *  @author  Sources: http://robowiki.net/wiki/Linear_Targeting
     */
    public class Gun implements RobotPart
    {
        /**
         * This part initializes the gun. (non-Javadoc)
         * 
         * @see skrc.Panzerbot.RobotPart#init()
         */
        public void init()
        {

            setAdjustGunForRobotTurn( true );
        }


        /**
         * This basically sets up the linear targeting against other robots (non-Javadoc)
         * 
         * @see skrc.Panzerbot.RobotPart#init()
         * @source http://robowiki.net/wiki/Linear_Targeting
         */
        public void move()
        {

            double absBearing = Math.toRadians( enemy.getBearing() )
                + getHeadingRadians();

            double enemyHeading = Math.toRadians( enemy.getHeading() );

            double enemyHeadingChange = enemyHeading - oldEnemyHeading;

            oldEnemyHeading = enemyHeading;

            double predictedX = getX() + enemy.getDistance()
                * Math.sin( absBearing );

            double predictedY = getY() + enemy.getDistance()
                * Math.cos( absBearing );

            double deltaTime = 0;

            while ( ( ++deltaTime ) * bullet_Speed < Point2D.Double.distance( getX(),
                getY(),
                predictedX,
                predictedY ) )
            {

                predictedX += Math.sin( enemyHeading ) * enemy.getVelocity();

                predictedY += Math.cos( enemyHeading ) * enemy.getVelocity();

                enemyHeading += enemyHeadingChange;

                predictedX = Math.max( Math.min( predictedX,
                    getBattleFieldWidth() - 18 ), 18 );
                predictedY = Math.max( Math.min( predictedY,
                    getBattleFieldHeight() - 18 ), 18 );

            }

            double aim = Utils.normalAbsoluteAngle( Math.atan2( predictedX
                - getX(), predictedY - getY() ) );

            setTurnGunRightRadians( Utils.normalRelativeAngle( aim
                - getGunHeadingRadians() ) );
            setFire( bullet_Power );
        }
    }


    /**
     * This class handles the tanks function.
     * 
     * @author Sources: This code is from http://robowiki.net/wiki/SuperRamFire
     *         by Crazy Bassoonist.
     */
    /**
     *  We utilized the Super ram fire, and this allowed the robot to move
     *  around the circular targeting and attack the enemy.
     *
     *  @author  Eric Cheng / Kosuke Kurita
     *  @version May 30, 2014
     *  @author  Period: 6
     *  @author  Assignment: RobotcodeFinalProject
     *
     *  @author  Sources: http://robowiki.net/wiki/SuperRamFire by Crazy Bassoonist.
     *                    RunToCenter.bot
     */
    public class Tank implements RobotPart
    {
        /**
         * (non-Javadoc) initializes the tank to colors.
         * 
         * @see skrc.Panzerbot.RobotPart#init()
         */
        public void init()
        {
            setColors( Color.black, Color.gray, Color.white );
        }


        /**
         * (non-Javadoc) move method for the RAM bot using the RunToCenter bot
         * and the super ram bot to attack the enemy
         * 
         * @see skrc.Panzerbot.RobotPart#move()
         * @author  Sources: http://robowiki.net/wiki/SuperRamFire by Crazy Bassoonist. 
         */
        public void move()
        {
            // implement tank movement       
         // get the coordinate points of the center of the battlefield
            double xmid = getBattleFieldWidth() / 2;
            double ymid = getBattleFieldHeight() / 2;
            // get the absolute bearing between my robot and the center
            double absBearingToCenter = absoluteBearing( getX(),
                getY(),
                xmid,
                ymid );
            // calculate how much I need to turn to get there
            double turns = absBearingToCenter - getHeading();
            // normalize the turn for more efficient movement
            setTurnRight( normalizeBearing( turns ) );

            // (Point2D is a useful class)
            double distanceToCenter = Point2D.distance( getX(),
                getY(),
                xmid,
                ymid );
            setAhead( distanceToCenter );
            
            Rectangle2D fieldRect = new Rectangle2D.Double( 18,
                18,
                getBattleFieldWidth() - 36,
                getBattleFieldHeight() - 36 );
            double getFieldX = getBattleFieldWidth() * 6.8 / 10;
            double getFieldY = getBattleFieldHeight() * 6.8 / 10;
            double getX = getBattleFieldWidth();
            double getY = getBattleFieldHeight();

            // Set absolute bearing in radians
            double absBearing = Math.toRadians( enemy.getBearing() )
                + getHeadingRadians();

            // This makes the amount we want to turn be perpendicular to the
            // enemy.
            double turn = absBearing + Math.PI / 2;

            // This formula is used because the 1/e.getDistance() means that as
            // we get closer to the enemy, we will turn to them more sharply.
            // We want to do this because it reduces our chances of being
            // defeated before we reach the enemy robot.
            turn -= Math.max( 0.5, ( 1 / enemy.getDistance() ) * 100 )
                * direction;

            setTurnRightRadians( Utils.normalRelativeAngle( turn
                - getHeadingRadians() ) );

            // This block of code detects when an opponents energy drops.
            if ( eEnergy > ( eEnergy = enemy.getEnergy() ) )
            {
                if ( Math.random() > 200 / enemy.getDistance() )
                {
                    direction = -direction;
                }

            }

            setMaxVelocity( 400 / getTurnRemaining() );

            setAhead( 100 * direction );

            // DO NOT RAM! Set within different variables, how the robot would
            // react to each given Robot Energy level
            if ( enemy.getDistance() < 200 && enemy.getEnergy() >= 90.0 )
            {
                setMaxVelocity( 400 / getTurnRemaining() );
                setBack( 150 * direction );
                bullet_Power = 3;
            }
            else if ( enemy.getDistance() < 200 && enemy.getEnergy() >= 80.0
                && enemy.getEnergy() <= 90.0 )
            {
                setMaxVelocity( 400 / getTurnRemaining() );
                setBack( 150 * direction );;
                bullet_Power = 2.4;
            }
            else if ( enemy.getDistance() < 200 && enemy.getEnergy() >= 70.0
                && enemy.getEnergy() <= 80.0 && getX <= getFieldX
                && getY <= getFieldY )
            {
                setMaxVelocity( 400 / getTurnRemaining() );
                setBack( 50 * direction );
                bullet_Power = 2.3;
            }
            else if ( enemy.getDistance() < 200 && enemy.getEnergy() >= 60.0
                && enemy.getEnergy() <= 70.0 )
            {
                setMaxVelocity( 400 / getTurnRemaining() );
                setBack( 50 * direction );
                bullet_Power = 3;
            }
            else if ( enemy.getDistance() < 200 && enemy.getEnergy() >= 50.0
                && enemy.getEnergy() <= 60.0 )
            {
                setMaxVelocity( 400 / getTurnRemaining() );
                setBack( 50 * direction );
                bullet_Power = 3;
            }
            else if ( enemy.getDistance() < 400 && enemy.getEnergy() >= 40.0
                && enemy.getEnergy() <= 50.0 )
            {
                setMaxVelocity( 400 / getTurnRemaining() );
                setBack( 150 * direction );
                bullet_Power = 3;
            }
            else if ( enemy.getDistance() < 500 && enemy.getEnergy() >= 30.0
                && enemy.getEnergy() <= 40.0 )
            {
                setMaxVelocity( 400 / getTurnRemaining() );
                setBack( 50 * direction );
                bullet_Power = 3;
            }
            else if ( enemy.getDistance() < 500 && enemy.getEnergy() >= 20.0
                && enemy.getEnergy() <= 30.0 && getX <= getFieldX
                && getY <= getFieldY )
            {
                setMaxVelocity( 400 / getTurnRemaining() );
                setBack( 200 * direction );
                bullet_Power = 2.6;
            }

            else if ( enemy.getDistance() < 800 && enemy.getEnergy() >= 10.0
                && enemy.getEnergy() <= 20.0 )
            {
                setMaxVelocity( 40 / getTurnRemaining() );
                setAhead( 1800 * direction );
                bullet_Power = 3;
            }

            else if ( enemy.getDistance() < 300 && enemy.getEnergy() >= 0.0
                && enemy.getEnergy() <= 10.0 )
            {
                setMaxVelocity( 400 / getTurnRemaining() );
                setAhead( 2000 * direction );
                bullet_Power = 3;
            }
            if ( tooCloseToWall > 1 )
            {
                // if we weren't already dealing with the walls, we are now
                tooCloseToWall += wallMargin;
                moveDirection *= -1; setAhead(10000 * moveDirection);
                setMaxVelocity( 0 ); // stop!!!
            }
        }
    }
}
