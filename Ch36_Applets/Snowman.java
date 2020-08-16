import javax.swing.JApplet;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.*;

/**
   This is a picture of a snowman by using three stacked circles for the body
    and smaller circles for the buttons and eyes. Draw a horizontal line for
     the horizon.
   We use three different circles along with buttons for eyes and buttons with
   a horizon going behind the snowman

   @author  Eric Cheng
   @version 12/11/2013

   @author  Period - 6
   @author  Assignment - Ch36_Applets

   @author  Sources - Eric Chen
 */
public class Snowman extends JApplet
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
            String str = "";

            Font curFont = applet.getFont();
            FontMetrics curFontMetrics = applet.getFontMetrics( curFont );
            Rectangle2D r2d = curFontMetrics.getStringBounds( str, gr );

            int strWidth = (int)( (Rectangle2D.Float)r2d ).width;
            int strHeight = (int)( (Rectangle2D.Float)r2d ).height;
            gr.setColor( Color.RED );
            gr.drawString( str, ( width - strWidth ) / 2,
                ( height + strHeight ) / 2 );

            gr.setColor( Color.BLACK ); 
            gr.drawString( str, 
                ( width - strWidth ) / 2, 
                ( height + strHeight ) / 2 ); 
            gr.setColor( Color.LIGHT_GRAY ); 
            int rad = width / 8; 
            gr.fillOval( width / 2 - rad, 
                height / 2 - 3 * rad, 
                2 * rad, 
                2 * rad ); 
            gr.fillOval( width / 2 - rad, height / 2 - rad, 2 * rad, 2 * rad ); 
            gr.fillOval( width / 2 - rad, height / 2 + rad, 2 * rad, 2 * rad ); 
            gr.setColor( Color.BLACK ); 
            int space = rad / 2; 
            int rad2 = rad / 8; 
            gr.fillOval( width / 2 - rad2, 
                height / 2 - rad2 - space, 
                2 * rad2, 
                2 * rad2 ); 
            gr.fillOval( width / 2 - rad2, 
                height / 2 - rad2, 
                2 * rad2, 
                2 * rad2 ); 
            gr.fillOval( width / 2 - rad2, 
                height / 2 - rad2 + space, 
                2 * rad2, 
                2 * rad2 ); 
  
            gr.fillOval( width / 2 - rad2, 
                height / 2 + 2 * rad - rad2 - space, 
                2 * rad2, 
                2 * rad2 ); 
            gr.fillOval( width / 2 - rad2, 
                height / 2 + 2 * rad - rad2, 
                2 * rad2, 
                2 * rad2 ); 
            gr.fillOval( width / 2 - rad2, 
                height / 2 + 2 * rad - rad2 + space, 
                2 * rad2, 
                2 * rad2 ); 
            gr.setColor( Color.BLACK ); 
            int rad3 = rad / 6; 
            gr.fillOval( width / 2 - space - rad3, 
                height / 2 - 2 * rad - rad3, 
                2 * rad3, 
                2 * rad3 ); 
            gr.fillOval( width / 2 + space - rad3, 
                height / 2 - 2 * rad - rad3, 
                2 * rad3, 
                2 * rad3 ); 
            gr.setColor( Color.RED ); 
            gr.drawLine( 0, height / 2, width / 2 - rad, height / 2 ); 
            gr.drawLine( width / 2 + rad, height / 2, width - 1, height / 2 ); 
        }
    }
}
