import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;


/**
 * We create a simple holiday card applet using simple graphics for the next
 * holiday. We can play around with applets and create a holiday card.
 * 
 * @author Eric Cheng
 * @version 12/12/2013
 * @author Period - 6
 * @author Assignment - Ch37_AppletEx
 * @author Sources - Eric Cheng
 */
public class HolidayCard extends JApplet
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

            // trees and words
            gr.setColor( Color.lightGray );
            gr.fillRect( 80, 150, 20, 100 );
            gr.setColor( Color.GREEN );
            gr.fillOval( 55, 15, 70, 150 );
            gr.setColor( Color.RED );
            gr.drawString( "Merry Christmas and a happy new year", 150, 270 );
            gr.drawString( "Eric Cheng", 200, 360 );

            // snowman
            gr.setColor( Color.lightGray );
            int rad = width / 8;
            gr.fillOval( 190, 100, 50, 50 );
            gr.fillOval( 190, 150, 50, 50 );
            gr.fillOval( 190, 200, 50, 50 );
            int space = rad / 2;
            int rad2 = rad / 8;
            gr.setColor( Color.BLACK );
            gr.fillOval( 212, 160, 5, 5 );
            gr.fillOval( 212, 170, 5, 5 );
            gr.fillOval( 212, 180, 5, 5 );
            gr.fillOval( 212, 210, 5, 5 );
            gr.fillOval( 212, 220, 5, 5 );
            gr.fillOval( 212, 230, 5, 5 );
            int rad3 = rad / 6;
            gr.setColor( Color.white );
            gr.fillOval( 190, 120, 15, 15 );
            gr.fillOval( 225, 120, 15, 15 );
            gr.setColor( Color.red );
            gr.fillOval( 194, 124, 10, 10 );
            gr.fillOval( 228, 124, 10, 10 );
            gr.setColor( Color.gray );

            class Circle
            {
                int x;

                int y;

                int r;


                public Circle()
                {
                    x = 0;
                    y = 0;
                    r = 0;
                }


                public Circle( int x, int y, int radius )
                {
                    x = x;
                    y = y;
                    this.r = radius;
                }


                void draw( Graphics gr )
                {
                    int drawX = x - r;
                    int drawY = y - r;
                    gr.drawOval( drawX, drawY, 2 * r, 2 * r );
                }


                void setPosition( int newX, int newY )
                {
                    x = newX;
                    y = newY;
                }


                void setRadius( int newRad )
                {
                    r = newRad;
                }
            }

            Circle circ = new Circle();
            Random rand = new Random();
            int count = 1;
            int x = 0;
            int y = 0;
            int r = 0;
            int col = 0;

            while ( count <= 10 )
            {
                x = Math.abs( rand.nextInt() ) % width;
                y = Math.abs( rand.nextInt() ) % height;
                r = ( Math.abs( rand.nextInt() ) % 21 ) + 5;
                while ( x - r <= 0 || x + r >= width - 1 || y - r <= 0
                    || y + r >= height - 1 )
                {
                    x = Math.abs( rand.nextInt() ) % width;
                    y = Math.abs( rand.nextInt() ) % height;
                    r = ( Math.abs( rand.nextInt() ) % 21 ) + 5;
                }
                col = rand.nextInt();
                if ( col > 0 )
                {
                    gr.setColor( Color.PINK );
                }
                else
                {
                    gr.setColor( Color.BLUE );
                }
                circ.setPosition( x, y );
                circ.setRadius( r );
                circ.draw( gr );
                count = count + 1;
            }
        }
    }
}
