package eric_chengkosuke_kurita;

import robocode.*;

/**
 * Record the state of an enemy bot.
 * 
 * @author Eric Cheng
 * @version 16 Mai 2014
 * 
 * @author Period - 6
 * @author Assignment - EnemyBot
 * 
 * @author Sources - Eric Cheng
 */
public class EnemyBot
{
    private double bearing;

    private double distance;

    private double energy;

    private double heading;

    private double velocity;

    private String name;

    /**
     * Resets everything
     */
    public EnemyBot()
    {
        reset();
    }
    

    /**
     * Gets the robot bearing
     * 
     * @return = Robot Bearing
     */
    public double getBearing()
    {
        return bearing;
    }


    /**
     * Gets the distance between given robots
     * 
     * @return = Robot Distance
     */
    public double getDistance()
    {
        return distance;
    }


    /**
     * Gets and returns Robot Energy
     * 
     * @return = Robot Energy
     */
    public double getEnergy()
    {
        return energy;
    }


    /**
     * Gets and Returns robot heading
     * 
     * @return = Robot Heading
     */
    public double getHeading()
    {
        return heading;
    }


    /**
     * Gets and returns robot velocity
     * 
     * @return = Robot Velocity
     */
    public double getVelocity()
    {
        return velocity;
    }


    /**
     * Gets the name of the robot
     * @return = name of robot
     */
    public String getName()
    {
        return name;
    }


    /**
     * Searches for the latest robot
     * @param srEvt = updates search
     */
    public void update( ScannedRobotEvent srEvt )
    {
        bearing = srEvt.getBearing(); 
        distance = srEvt.getDistance(); 
        energy = srEvt.getEnergy(); 
        heading = srEvt.getHeading(); 
        velocity = srEvt.getVelocity(); 
        name = srEvt.getName(); 
    }


    /**
     * Resets all methods to initial position and stance
     */
    public void reset()
    {
        bearing = 0.0;
        velocity = 0.0;
        energy = 0.0;
        distance = 0.0;
        heading = 0.0;
        name = "";
    }

    /**
     * none
     *
     * @return = name.length() == 0;
     */
    public boolean none()
    {
        return name.length() == 0;
    }
}