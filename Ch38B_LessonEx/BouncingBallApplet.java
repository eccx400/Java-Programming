import java.awt.*;

/**
 * This applet shows a red ball bounding around on a black backgound. It
 * is based on the animation framework from SimpleAnimationApplet.java.
 * It also requires the class BoundingBall, which is defined in the file
 * BouncingBall.java.
 * 
 * @author   George Peck
 * @author   Sources - David J. Eck
 * @version  January 31, 2002
 */
public class BouncingBallApplet extends AnimationBase
{
    BouncingBall redBall;

    /**
     * This routine is called by the system when the applet is first
     * created. In this applet, it creates the red ball and calls
     * setMillisecondsPerFrame to set the speed of the animation.
     */
    public void init()
    {
        int w = getWidth();  // Applet width, to be used for
                             // positioning the ball.
        int h = getHeight(); // Applet height, to be used for
                             // positioning the ball.
        
        // if run from the AppleViewer getWidth() && getHeight()
        // return 0 so set w and h to default AppletViewer values
        if (w == 0 || h == 0)
        {
            w = h = 200;
        }

        redBall = new BouncingBall( w / 2, h / 2, 15, Color.red );

        // This routine is defined in AnimationBase. It says
        // that I want each frame to take 50 milliseconds (1/20 second).
        // This is about twice as fast as the default rate. (Note that
        // there is no guarantee that the computer can actally draw
        // frames at the rate you request.)
        setMillisecondsPerFrame( 20 );
    }

    /**
     * This routine is called by the animation framework every time a
     * new frame needs to be drawn. For this animation, this routine
     * draws a black background, then calls the ball's doFrame method,
     * which draws the ball and updates its state for the next frame.
     */
    public void drawFrame( Graphics g )
    {
        // find out the size of the drawing area
        int width = getWidth();
        int height = getHeight();

        // Fill the applet with a black background.
        g.setColor( Color.black );
        g.fillRect( 0, 0, width, height );

        redBall.doFrame( g, width, height );
    } // end drawFrame()
}
