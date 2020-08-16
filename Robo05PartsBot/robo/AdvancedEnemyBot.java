package robo;

import robocode.*;

/**
 * Record the advanced state of an enemy bot.
 * 
 * @author Eric Cheng
 * @version 16 Mai, 2014
 * 
 * @author Period - 6
 * @author Assignment - AdvancedEnemyBot
 * 
 * @author Sources - Eric Cheng
 */
public class AdvancedEnemyBot extends EnemyBot
{
    private double x;
    private double y;

    /**
     *  resets robot
     */
    public AdvancedEnemyBot()
    {
        reset();
    }

    /** 
     * Gets the x coordinate
     *  
     * @return = x coordinate
     */
    public double getX()
    {
        return x;
    }


    /** 
     * Gets the y coordinate
     *  
     * @return = y coordinate
     */
    public double getY()
    {
        return y;
    }


    /**
     * Update the search for the given robot
     * @param e = enemy bot
     * @param robot = main robot
     */
    public void update( ScannedRobotEvent e, Robot robot )
    {
        super.update( e );
        double absBearingDeg = ( robot.getHeading() + e.getBearing() );
        if ( absBearingDeg < 0 )
        {
            absBearingDeg += 360;
        }
        x = robot.getX() + Math.sin( Math.toRadians( absBearingDeg ) )
            * e.getDistance();
        y = robot.getY() + Math.cos( Math.toRadians( absBearingDeg ) )
            * e.getDistance();
    }


    /**
     * Using the trig identities and the information about the sin values of a 
     * right triangle, one can predict the course of a robot as it moves along
     * the wall
     * @param zed = zed
     * @return Future x coordinate
     */
    public double getFutureX( long zed )
    {
        return x + Math.sin( Math.toRadians( getHeading() ) ) * getVelocity()
            * zed;
    }


    /**
     * Using the trig identities and the information about the sin values of a 
     * right triangle, one can predict the course of a robot as it moves along
     * the wall
     * @param zed = zed
     * @return Future y coordinate
     */
    public double getFutureY( long zed )
    {
        return y + Math.cos( Math.toRadians( getHeading() ) ) * getVelocity()
            * zed;
    }


    /** 
     * Resets to initial values
     */
    public void reset()
    {
        super.reset();
        x = 0.0;
        y = 0.0;
    }
}