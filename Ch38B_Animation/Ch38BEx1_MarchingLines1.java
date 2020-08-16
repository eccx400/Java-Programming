import javax.swing.*;
import java.awt.*;

/**
 * This program is using the Animation Base system, that creates a
 * "conveyor belt" that runs across the screen
 * To build this code, we use Animation base, and we create the rectangles
 * that we will use as the animation runs across
 * 
 * @author Eric Cheng
 * @version 1/8/2013
 * 
 * @author Period - 6
 * @author Assignment - Ch38BEx1_MarchingLines1
 * 
 * @author Sources - Eric Cheng
 */
public class Ch38BEx1_MarchingLines1 extends AnimationBase
{
    /**
     * This routine is called by the system when the applet is first
     * created.
     */
    public void init()
    {
            setMillisecondsPerFrame( 10 );
    }

    /**
     * This routine is called by the animation framework every time a
     * new frame needs to be drawn.
     * 
     * For this animation, we create the different parameters for the rectangle
     * and then set them to different colors. Then we use the current to allow
     * the rectangle to move across the screen.
     */
    public void drawFrame( Graphics g )
    {
        super.drawFrame( g ); // remove this line
        int w = getWidth();
        int h = getHeight();
        int current = getFrameNumber() % 15;
        
        g.setColor( Color.RED );
        g.fillRect( 0, 0, w, h );
        
        g.setColor( Color.blue );
        while( current < w )
        {
            g.drawLine( current, 0 , current, h);
            current += 15;
        }
    }
}
