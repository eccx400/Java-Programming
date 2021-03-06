import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.geom.*;


/**
 * This program creates ten circles that are placed randomly
 * around a certain perimeter. For this program, we use the Circle class to 
 * set the circle, and set circles of different sizes in the given area.
 * 
 * @author Eric Cheng
 * @version 12/15/2013
 * 
 * @author Period - 6
 * @author Assignment - Ch38_MoreAppletEx
 * 
 * @author Sources - Eric Cheng
 */
public class TenCircles extends JApplet
{
    Random rand = new Random();
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
            
            Circle circ = new Circle();
            int count = 0;
            while (count < 10)
            {        
                int rad = rand.nextInt(40) + 10;
                int x = rand.nextInt(width-(2*rad))+rad;
                int y = rand.nextInt(height-(2*rad))+rad;
                circ.setColor(Color.RED);
                circ.setRadius(rad);
                circ.setPosition(x, y);
                circ.draw(gr);
                count++;
            }
        }
    }
}
