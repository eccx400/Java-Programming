import javax.swing.*;

import java.awt.*;

/**
 * This program is using the previous marching lines program, adding a small
 * rectangle with a perpendicular "conveyor belt" that runs across as the
 * program is running.
 * To build this code, we use the previous code using the Animation base, but
 * we change the parameters for the new code
 * 
 * @author Eric Cheng
 * @version 1/8/2013
 * 
 * @author Period - 6
 * @author Assignment - Ch38BEx1_MarchingLines1
 * 
 * @author Sources - Eric Cheng
 */
public class Ch38BEx2_MarchingLines2 extends AnimationBase
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
     * For this animation, we add on to the previous program by setting
     * parameters for the second rectangle in the middle, and then setting the
     * frames to run in a perpendicular direction by dividing the height by 4
     * and the width by 2
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
        
        g.fillRect( w / 4, h / 4, w / 2, h / 2);
        g.setColor(Color.RED);
        current = getFrameNumber()% 15 + h / 4;
        while ( current < h / 4 + h / 2 )
        {
            g.drawLine( w / 4, current, w / 4 + w / 2, current );
            current += 15;
        }
    }
}
