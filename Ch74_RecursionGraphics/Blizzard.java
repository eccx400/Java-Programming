import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

/**
    Implement the blizzard program: draw a few dozen randomly positioned 
    snowflakes of a few random sizes and a few random colors. The snowplaced
    are placed using the random class
    
    @author  Eric Cheng
    @version March 12, 2014
    
    @author  Period: 6
    @author  Assignment: Ch74 Exercise 2 - Blizzard
    
    @author  Sources: Eric Cheng
*/
class BlizzardPanel extends JPanel implements MouseListener
{
    /**
     * 
     */
    private Graphics graph;
    private Random rand;

    public BlizzardPanel()
    {
        rand = new Random();
        setBackground( Color.white );
        addMouseListener( this );
    }

    private void drawStar( int x, int y, int size )
    {
        int endX; 
        int endY; 
  
        if ( size <= 2 ) 
        { 
            return; 
        } 
  
        // Six lines radiating from (x,y) 
        for ( int index = 0; index < 6; index++ ) 
        { 
            endX = x + (int)( size * Math.cos( ( 2 * Math.PI / 6 ) * index ) ); 
            endY = y - (int)( size * Math.sin( ( 2 * Math.PI / 6 ) * index ) ); 
            graph.drawLine( x, y, endX, endY ); 
            drawStar( endX, endY, size / 3 ); 
        } 
    }

    public void paintComponent( Graphics gr )
    {
        super.paintComponent( gr );
        graph = gr;

        int width = getSize().width;
        int height = getSize().height;
        // setBackground( Color.white );
        gr.setColor( Color.blue );
        gr.drawRect( 0, 0, width - 1, height - 1 );

        // draw a few dozen randomly positioned snowflakes
        // of a few random sizes and a few random colors
        for ( int x = 0; x < 24; x++ ) 
        { 
            graph.setColor( new Color( rand.nextFloat(), 
                rand.nextFloat(), 
                rand.nextFloat() ) ); 
            drawStar( rand.nextInt( width ), 
                rand.nextInt( height ), 
                rand.nextInt( 40 ) ); 
        } 
    }

    public void mousePressed( MouseEvent evt )
    {
        repaint();
    }

    // Empty methods, required by the interface.
    public void mouseReleased( MouseEvent evt ){ }
    public void mouseClicked( MouseEvent evt ){ }
    public void mouseEntered( MouseEvent evt ){ }
    public void mouseExited( MouseEvent evt ){ }
}

public class Blizzard extends JApplet
{
    // This simple init() method just creates a drawing surface
    // belonging to the nested class Display and uses it for
    // the content pane of the JApplet. (This is one case where
    // it is rather silly to use a JApplet rather than a plain
    // old Applet!)
    public void init()
    {
        setContentPane( new BlizzardPanel() );
    }
}
