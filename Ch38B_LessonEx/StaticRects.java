import java.awt.*;
import java.applet.Applet;

import javax.swing.*;

/**
 * This is a rather silly applet that just draws a static picture of a
 * set of nested rectangles. It ASSUMES that the size of the applet, as
 * specified in the <applet> tag, is 300 pixels wide by 160 pixels high.
 * 
 * @author George Peck
 * @author Sources - David J. Eck
 * @version January 28, 2001
 */
public class StaticRects extends JApplet
{
    /**
     * The applet's init() method creates the display panel and adds
     * them to the applet.
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
        /**
         * Draw set of nested black rectangles on a red background. Each
         * nested rectangle is separated by 15 pixels on all sides from
         * the rectangle that encloses it.
         * 
         * @param g  Graphics context
         */
        public void paintComponent( Graphics g )
        {
            super.paintComponent( g );

            // Gap between borders of applet and one of the rectangles.
            int inset;

            // Gap between borders of applet and one of the rectangles.
            int rectWidth;

            // The size of one of the rectangles.
            int rectHeight;

            g.setColor( Color.red );
            g.fillRect( 0, 0, 300, 160 );
            // Fill the entire applet with red.

            g.setColor( Color.black ); // Draw the rectangles in black.

            inset = 0;

            // Set size of the first rect to size of applet
            rectWidth = 299;
            rectHeight = 159;

            while ( rectWidth >= 0 && rectHeight >= 0 )
            {
                g.drawRect( inset, inset, rectWidth, rectHeight );

                // rects are 15 pixels apart
                inset += 15;

                // width decreases by 15 pixels on left and 15 on right
                rectWidth -= 30;

                // height decreases by 15 pixels on top and 15 on bottom
                rectHeight -= 30;
            }
        }
    }
}
