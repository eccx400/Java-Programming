package robo;
 
import robocode.*;
import robocode.util.Utils;
 
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
 
 
/**
 *
 * Write an interface called RobotPart and three classes that implement it
 * called Radar, Gun, and Tank.
 * 
 * All of these interfaces / implementing classes will be written inside an
 * AdvancedRobot called PartsBot, making them all inner classes.
 * 
 * @author 5111703
 * @version May 16, 2013
 * @author Period: 5
 * @author Assignment: Robo5PartsBot
 * 
 * @author Sources: -SuperRamFire --Robowiki.net
 */
/**
 * Constructor for advancedEnemyBot.
 * Constructs the interface.
 * Assigns the array value for RADAR.
 * Assigns the array value for GUN.
 * Assigns the array value for TANK.
 * Allows the robot to run.
 * 
 * @author Somya Khare
 * Ryan Chien
 * 
 * This robot uses width lock radar, circular targeting, and superramfire from robowiki.net (links are below.)
 *
 */
public class SBot extends AdvancedRobot
{
    private AdvancedEnemyBot enemy = new AdvancedEnemyBot();
 
    private RobotPart[] parts = new RobotPart[3]; // make three parts
 
    private final static int RADAR = 0;
 
    private final static int GUN = 1;
 
    private final static int TANK = 2;
     
    int dir = 1;
     
    double energy;
     
    static int enemyFireCount = 0;
     
    int tooCloseToWall =0;
     
    int wallMargin = 80;
     
    byte moveDirection = 1;
     
    final static double BULLET_POWER=3;//Our bulletpower.
     
    final static double BULLET_DAMAGE=BULLET_POWER*4;//Formula for bullet damage.
     
    final static double BULLET_SPEED=20-3*BULLET_POWER;//Formula for bullet speed.
  
    static double oldEnemyHeading;
     
    static double enemyEnergy;
  
    public int sameDirectionCounter = 0;
 
    /* How long we should continue to move in the current direction */
    public long moveTime = 1;
 
    /*
     * The speed of the last bullet that hit us, used in determining how far to
     * move before deciding to change direction again.
     */
    public static double lastBulletSpeed = 15.0;
 
    public double wallStick = 120;
 
    /**
     * allows the robot to run. 
     * 
     * @see robocode.Robot#run()
     */
    public void run()
    {
        //the three constructors of the three classes.
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
 
 
    /**This part explains that if the robot scans another robot, the robot radar will update
     * 
     * @param e the scanned-robot event set by the game
     * @see robocode.Robot#onScannedRobot(robocode.ScannedRobotEvent)
     */
    public void onScannedRobot( ScannedRobotEvent e )
    {
        Radar radar = (Radar)parts[RADAR];
        if ( radar.shouldTrack( e ) )
            enemy.update( e, this );
    }
 
 
    /** If the other robot dies, the radar resets so that it can find another robot. 
     * (non-Javadoc)
     * @param e the event for enemy robot death 
     * @see robocode.Robot#onRobotDeath(robocode.RobotDeathEvent)
     */
    public void onRobotDeath( RobotDeathEvent e )
    {
        Radar radar = (Radar)parts[RADAR];
        if ( radar.wasTracking( e ) )
            enemy.reset();
    }
     
    /**
     * Occurs when the robot is hit by a bullet. Move away from where the robot
     * was last shot whenever the robot gets hit by a bullet.
     * 
     * @param event the hit-by-bullet event set by the game
     */
    public void onHitByBullet( HitByBulletEvent event )
    {
        dir = -dir;
    }
    /** if you are hit by a bullet, FIX FIX FIX FIX FIX 
     * (non-Javadoc)
     * @see robocode.Robot#onBulletHit(robocode.BulletHitEvent)
     */
    public void onBulletHit(BulletHitEvent e) 
    {
        enemyEnergy-=BULLET_DAMAGE;
        }
     
    /** (non-Javadoc)
     * if you hit a wall, go in the reverse direction 
     * @ e the hit-wall event set by the game
     * @see robocode.Robot#onHitWall(robocode.HitWallEvent)
     */
    public void onHitWall(HitWallEvent e)
    {
        dir=-dir;
    }
     
    /** (non-Javadoc)
     * @see robocode.AdvancedRobot#onCustomEvent(robocode.CustomEvent)
     */
    /**
     * Occurs when the robot collides with another robot. Move backwards from
     * any robot whenever our robot hits another robot because if we move
     * forward, we'll just keep ramming into it.
     * 
     * @param event the hit-robot event set by the game
     */
    public void onHitRobot( HitRobotEvent event )
    {
        setBack( 100 );
    }
     
    /**
     * If we're too close to the wall, we switch directions and move away
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
             /*
              * -- don't do it this way // switch directions and move away
             moveDirection *= -1; setAhead(10000 * moveDirection);
              */
             setMaxVelocity( 0 ); // stop!!!
          }
       }
    }
 
    
    /**
     * This method normalizes the bearing so that the robot can turn the least number of degrees (between -180 and 180) instead of all the way around. 
     * @param angle
     * @return
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
     * @author 5111703
     * @version May 16, 2013
     * @author Period: 5
     * @author Assignment: Robo5PartsBot
     * 
     * @author Sources: -
     */
    public interface RobotPart
    {
     
    //will be the initialization method
        public void init();
 
//this is the movement method
        public void move();
    }
 
 
    /**
     * Implements Radar methods of what to do when initialized and what to do when 
     * 
     * @author 5111703
     * @version May 16, 2013
     * @author Period: 5
     * @author Assignment: Robo5PartsBot
     * 
     * @author Sources: - Width Lock Radar 
     * http://robowiki.net/wiki/One_on_One_Radar#Perfect_Radar_Locks
     */
    public class Radar implements RobotPart
    {
        /** This part initializes the radar. 
         * 
         * 
         * @see skrc.SBot.RobotPart#init()
         */
        public void init()
        {
             
         
            setAdjustRadarForGunTurn( true );
             
           
 
         
 
            setAdjustRadarForRobotTurn(true);
        }
 
 
        /**This part moves the radar. 
         * (non-Javadoc)
         * 
         * @see skrc.SBot.RobotPart#move()
         */
        public void move()
        {
            if ( enemy.none() )
            {
          
               setTurnRadarRight( 360000 );
            }
            else
            {
                 
 
                double angleToEnemy = getHeadingRadians() + Math.toRadians(enemy.getBearing());
                 
 
                double radarTurn = Utils.normalRelativeAngle( angleToEnemy - getRadarHeadingRadians() );
              
       
                 
                double extraTurn = Math.min( Math.atan( 36.0 / enemy.getDistance() ), Rules.RADAR_TURN_RATE_RADIANS );
              
 
                if (radarTurn <0)
                {
                    radarTurn -= extraTurn;
                }
                else
                {
                    radarTurn += extraTurn;
                }
                //Turn the radar
                setTurnRadarRightRadians(radarTurn);
            }
        }
 
 
        /**
         *This method tracks to see if there are enemies. 
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
     * @author 5111703
     * @version May 16, 2013
     * @author Period: 5
     * @author Assignment: Robo5PartsBot
     * 
     * @author Sources: - Uses circular Targeting http://robowiki.net/wiki/Circular_Targeting
     */
    public class Gun implements RobotPart
    {
        /** This part initializes the gun. 
         * (non-Javadoc)
         * 
         * @see skrc.SBot.RobotPart#init()
         */
        public void init()
        {
 
            setAdjustGunForRobotTurn( true );
        }
 
 
        /**
         * (non-Javadoc)
         * 
         * @see skrc.SBot.RobotPart#move()
         */
        public void move2()
        {
            double firePower = Math.min( 500 / enemy.getDistance(), 3 );
 
            double bulletSpeed = 20 - firePower * 3;
 
            long time = (long)( enemy.getDistance() / bulletSpeed );
 
            double futureX = enemy.getFutureX( time );
            double futureY = enemy.getFutureY( time );
            double absDeg = absoluteBearing( getX(), getY(), futureX, futureY );
 
 
            setTurnGunRight( normalizeBearing( absDeg - getGunHeading() ) );
 
 
            if ( getGunHeat() == 0 && Math.abs( getGunTurnRemaining() ) < 10 )
            {
                setFire( firePower );
            }
        }
         
        public void move() 
        {
 
            double absBearing=Math.toRadians(enemy.getBearing())+getHeadingRadians();
  
            double enemyHeading = Math.toRadians(enemy.getHeading());
 
            double enemyHeadingChange = enemyHeading - oldEnemyHeading;
 
            oldEnemyHeading = enemyHeading;
             
 
            double deltaTime = 0;
    
 
            double predictedX = getX()+enemy.getDistance()*Math.sin(absBearing);
 
            double predictedY = getY()+enemy.getDistance()*Math.cos(absBearing);
 
            while((++deltaTime) * BULLET_SPEED <  Point2D.Double.distance(getX(), getY(), predictedX, predictedY))
            { 
 
                predictedX += Math.sin(enemyHeading) * enemy.getVelocity();
 
                predictedY += Math.cos(enemyHeading) * enemy.getVelocity();
      
      
 
                enemyHeading += enemyHeadingChange;
 
                predictedX=Math.max(Math.min(predictedX,getBattleFieldWidth()-18),18);
                predictedY=Math.max(Math.min(predictedY,getBattleFieldHeight()-18),18);
      
            }
 
            double aim = Utils.normalAbsoluteAngle(Math.atan2(  predictedX - getX(), predictedY - getY()));
  
            setTurnGunRightRadians(Utils.normalRelativeAngle(aim - getGunHeadingRadians()));
            setFire(BULLET_POWER);;
        }
    }
     
    /**
     *  This class handles the tanks function
     *
     *  @author  5111703
     *  @version May 30, 2013
     *  @author  Period: 5
     *  @author  Assignment: SBot
     *
     *  @author  Sources: This code is from http://robowiki.net/wiki/SuperRamFire by Crazy Bassoonist. 
     */
    public class Tank implements RobotPart
    {      
        /**
         * (non-Javadoc)
         * initializes the tank to colors. 
         * @see skrc.SBot.RobotPart#init()
         */
        public void init()
        {
            setColors( Color.blue, Color.magenta, Color.cyan );
        }
 
 
        /**
         * (non-Javadoc)
         * move method for the RAM bot
         * @see skrc.SBot.RobotPart#move()
         */
        public void move()
        {  
            double absBearing=Math.toRadians(enemy.getBearing())+getHeadingRadians();
             
    
 
            double turn=absBearing+Math.PI/2;
 
 
            turn-=Math.max(0.5,(1/enemy.getDistance())*100)*dir;
      
 
            setTurnRightRadians(Utils.normalRelativeAngle(turn-getHeadingRadians()));
      
            //This block of code detects when an opponents energy drops.
            if(enemyEnergy>(enemyEnergy=enemy.getEnergy()))
            {
                if(Math.random()>200/enemy.getDistance())
                {
                    dir=-dir;
                }
                 
                 
            }
      
            setMaxVelocity(400/getTurnRemaining());
      
            setAhead(100*dir);             
        }
         
    } 
}