import java.awt.*;

/**
 * An object belonging to the BouncingBall class is a colored circle
 * that is meant to be used with SimpleAnimationApplet.java. The ball is
 * created with a specified color, position, and radius. At the time it
 * is created, a random velocity is chosen for it. The doFrame() method
 * draws the ball and changes its position by adding the velocity to the
 * current position. A setPosition() method is provided for changing the
 * position. The headTowards() method changes the velocity so that the
 * ball is moving in the direction of a specified point.
 * 
 * @author G. Peck
 * @author Sources - David J. Eck
 * @version January 31, 2002
 */
public class BouncingBall extends Circle
{
    // The ball's velocity, given in terms of the amount by which
    // centerX and centerY change in each frame.
    private double velocityX, velocityY;

    /**
     * Constructor for the BouncingBall object.Construct a new bouncing
     * ball object with the specified color, position, and radius. The x
     * and y components of the velocity re random numbers between -10
     * and 10, except that at least one of the components must be
     * greater than 3 in absolute value.
     * 
     * @param color    fill color of the ball
     * @param centerX  x-coordinate of the center of the circle
     * @param centerY  y-coordinate of the center of the circle
     * @param radius   radius of the circle
     */
    public BouncingBall( int centerX, int centerY, int radius, Color color )
    {
        super( centerX, centerY, radius, color );
        do
        {
            velocityX = (int)( 30 * Math.random() - 10 );
            velocityY = (int)( 30 * Math.random() - 10 );
        } while ( Math.abs( velocityY ) <= 3 && Math.abs( velocityX ) <= 3 );
    }

    /**
     * Draw the ball in the given graphics context, g. Then adjust the
     * position Furthermore, if the ball moves is outside the rectangle
     * 0 &lt; x &lt; width, 0 &lt; y &lt; height, adjust the sign of the
     * x or y component of the velocity to make the ball head back into
     * the rectangle. This method is meant to be called once for each
     * frame of the animation.
     * 
     * @param g       graphics context
     * @param width   width of the drawing area
     * @param height  height of the drawing area
     */
    public void doFrame( Graphics g, int width, int height )
    {
        drawFilled( g );
        setPosition( getX() + (int)velocityX, getY() + (int)velocityY );
        if ( getX() - getRadius() < 0 )
        {
            velocityX = Math.abs( velocityX );
        }
        if ( getX() + getRadius() >= width )
        {
            velocityX = -Math.abs( velocityX );
        }
        if ( getY() - getRadius() < 0 )
        {
            velocityY = Math.abs( velocityY );
        }
        if ( getY() + getRadius() >= height )
        {
            velocityY = -Math.abs( velocityY );
        }
    }

    /**
     * Modify the velocity so that the ball is moving in the direction
     * of the point (x, y). The speed of the ball does not change, only
     * its direction of motion. (If the specified point is too close to
     * the current position of the ball, the velocity of the ball does
     * not change.) This method uses some standard vector mathematics
     * 
     * @param x  x-coordinate to move towards
     * @param y  y-coordinate to move towards
     */
    public void headTowards( int x, int y )
    {
        if ( Math.abs( x - getX() ) < 1.0E-10
            && Math.abs( y - getY() ) < 1.0E-10 )
        {
            return;
        }
        double v = Math.sqrt( velocityX * velocityX + velocityY * velocityY );
        double d = Math.sqrt( ( x - getX() ) * ( x - getX() ) + ( y - getY() )
            * ( y - getY() ) );
        velocityX = ( x - getX() ) * v / d;
        velocityY = ( y - getY() ) * v / d;
    }
}
