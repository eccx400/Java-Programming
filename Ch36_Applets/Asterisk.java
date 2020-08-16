import javax.swing.JApplet;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.*;

/**
   This is a large asterisk * in the center of the the applet's drawing area 
   by drawing three lines that intersect in the center.
   To do this, you make three overlapping lines into a * shape

   @author  Eric Cheng
   @version 12/11/2013

   @author  Period - 6
   @author  Assignment - Ch36_Applets

   @author  Sources - Eric Cheng
 */
public class Asterisk extends JApplet
{
    /**
     * The applet's init() method creates the display panel and adds them
     * to the applet.
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
            setBackground(Color.WHITE);

            gr.setColor( Color.BLUE );
            gr.drawRect( 0, 0, width - 1, height - 1 );
            String str = " ";

            Font curFont = applet.getFont();
            FontMetrics curFontMetrics = applet.getFontMetrics( curFont );
            Rectangle2D r2d = curFontMetrics.getStringBounds( str, gr );

            int strWidth = (int)( (Rectangle2D.Float)r2d ).width;
            int strHeight = (int)( (Rectangle2D.Float)r2d ).height;
            gr.setColor( Color.BLACK );
            gr.drawString( str, ( width - strWidth ) / 2, 
                ( height + strHeight ) / 2 );

            int space = width / 4; 
            int extended = 3 * space / 2; 
            int heightratio = (int)( space * ( Math.sqrt( 3 ) / 2 ) ); 
            gr.drawLine( space, height / 2, width - 1 - space, height / 2 ); 
            gr.drawLine( extended, height / 2 - heightratio, width - 1
                - extended, height / 2 + heightratio ); 
            gr.drawLine( extended, height / 2 + heightratio, width - 1
                - extended, height / 2 - heightratio ); 
        }
    }
}
