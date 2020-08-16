import javax.swing.*;
import java.awt.*;
import java.lang.Math;

/**
    This program creates the snowflake method in the lecture, but modified so 
    that the colours will change too
    We will use the graphic features and the methods from the lecture
    
    @author  Eric Cheng
    @version March 12, 2014
    
    @author  Period: 6
    @author  Assignment: Ch74 Exercise 1 - Snowflake
    
    @author  Sources: Eric Cheng
*/
class FlakePanel extends JPanel
{
    /**
     * 
     */
    private Graphics graph;

    public FlakePanel()
    {
        setBackground( Color.white );
    }

    private void drawStar( int x, int y, int size, int colorCount )
    {
        int endX; 
        int endY; 
  
        if ( size <= 2 ) 
            return; 
  
        // Six lines radiating from (x,y) 
        for ( int index = 0; index < 6; index++ ) 
        { 
            endX = x + (int)( size * Math.cos( ( 2 * Math.PI / 6 ) * index ) ); 
            endY = y - (int)( size * Math.sin( ( 2 * Math.PI / 6 ) * index ) ); 
            graph.setColor( colour[colorCount] ); 
            graph.drawLine( x, y, endX, endY ); 
            drawStar( endX, endY, size / 3, ( colorCount + 1 ) % colour.length );
        }
    }
    
    private Color[] colour = { Color.blue, new Color( 176, 224, 230 ), 
        new Color( 135, 206, 250 ) }; 
        

    public void paintComponent( Graphics gr )
    { 
        super.paintComponent( gr ); 
  
        graph = gr; 
        int width = getSize().width; 
        int height = getSize().height; 
        int min; 
  
        // setBackground( Color.white ); 
        gr.setColor( Color.blue ); 
  
        if ( height < width ) 
            min = height; 
        else
            min = width; 
  
        drawStar( width / 2, height / 2, min / 3, 0 ); 
    } 
}

public class SnowFlake extends JApplet
{
    // This simple init() method just creates a drawing surface
    // belonging to the nested class FlakePanel and uses it for
    // the content pane of the JApplet.  (This is one case where
    // it is rather silly to use a JApplet rather than a plain
    // old Applet!)
    public void init()
    {
        setContentPane( new FlakePanel() );
    }
}
