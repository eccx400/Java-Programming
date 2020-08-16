import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;


/**
 * Draw 10 concentric circles in the center of the applet.
 * We use this the circle, the x y values and the radius of the circle, and 
 * we change them so they are  concentric
 * 
 * @author Eric Cheng
 * @version 12/12/2013
 * @author Period - 6
 * @author Assignment - Ch37_AppletEx
 * @author Sources - Eric Cheng
 */
public class ConcentricCircles extends JApplet
{
    /**
     * The applet's init() method creates the display panel and adds them to the
     * applet.
     */
    public void init()
    {
        Display displayPanel = new Display();

        JPanel content = new JPanel();
        content.setLayout( new BorderLayout() );
        content.add( displayPanel, BorderLayout.CENTER );
        setContentPane( content );
    }


    // Defines the display panel.
    public class Display extends JPanel
    {
        public void paintComponent( Graphics gr )
        {
            super.paintComponent( gr );

            Container applet = getContentPane();
            int width = applet.getWidth();
            int height = applet.getHeight();
            setBackground( Color.WHITE );

            gr.setColor( Color.BLUE );
            gr.drawRect( 0, 0, width - 1, height - 1 );
            String str = " ";

            Font curFont = applet.getFont();
            FontMetrics curFontMetrics = applet.getFontMetrics( curFont );
            Rectangle2D r2d = curFontMetrics.getStringBounds( str, gr );

            int strWidth = (int)( (Rectangle2D.Float)r2d ).width;
            int strHeight = (int)( (Rectangle2D.Float)r2d ).height;
            gr.setColor( Color.BLACK );
            gr.drawString( str,
                ( width - strWidth ) / 2,
                ( height + strHeight ) / 2 );

            int rad;
            int change;
            int x = 0;
            int y = 0;
            if ( width < height )
            {
                rad = width / 2;
                change = width / 20;
                y = height / 2 - rad;
            }
            else
            {
                rad = height / 2;
                change = height / 20;
                x = width / 2 - rad;
            }
            int count = 1;
            while ( count <= 10 )
            {
                gr.drawOval( x, y, 2 * rad, 2 * rad );
                x = x + change;
                y = y + change;
                count = count + 1;
                rad = rad - change;
            }
        }
    }
}
