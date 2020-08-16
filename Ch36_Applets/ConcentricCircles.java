import javax.swing.JApplet;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;


/**
 * This is an applet that displays a set of three concentric circles of 
 * different colors centered in the the applet's drawing area. 
 * We use the circles with different radius to create concentric circles
 * 
 * @author Eric Cheng
 * @version 12/11/2013
 * @author Period - 6
 * @author Assignment - Ch36_Applets
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
            String str = "";

            Font curFont = applet.getFont();
            FontMetrics curFontMetrics = applet.getFontMetrics( curFont );
            Rectangle2D r2d = curFontMetrics.getStringBounds( str, gr );

            int strWidth = (int)( (Rectangle2D.Float)r2d ).width;
            int strHeight = (int)( (Rectangle2D.Float)r2d ).height;
            gr.setColor( Color.BLACK );
            gr.drawString( str,
                ( width - strWidth ) / 2,
                ( height + strHeight ) / 2 );

            int radius = 80;
            for ( int i = 0; i < 3; i++ )
            {
                if ( i == 0 )
                    gr.setColor( Color.CYAN );
                else if ( i == 1 )
                    gr.setColor( Color.ORANGE );
                else if ( i == 2 )
                    gr.setColor( Color.RED );

                gr.drawOval( width / 2 - radius,
                    height / 2 - radius,
                    2 * radius,
                    2 * radius );

                radius -= 10;
            }
        }
    }
}
