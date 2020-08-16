import java.awt.*;

import javax.swing.*;

/**
    This is a method drawTriangle( int CenterX, int CenterY, int side ) that 
    draws a triangle centered at (CenterX, CenterY) if side is small. Otherwise
    ,it draws three triangles.
    
    @author  Eric Cheng
    @version March 12, 2014
    
    @author  Period: 6
    @author  Assignment: Ch74 Exercise 3 - NestedTriangles
    
    @author  Sources: Eric Cheng
*/
class Sierpinski extends JPanel
{
    /**
     * 
     */
    private Graphics graph;

    public Sierpinski()
    {
        setBackground( Color.white );
    }
    
    private void drawTriangle( int centerX, int centerY, int side )
    {
        int leftX = centerX - side / 2; 
        int leftY = centerY + side / 2; 
        if ( side < 25 ) 
        { 
            graph.drawLine( leftX, leftY, leftX + side, leftY ); 
            graph.drawLine( leftX, leftY, leftX + side / 2, leftY - side ); 
            graph.drawLine( leftX + side / 2, leftY - side, leftX + side, leftY ); 
        } 
        else
        { 
            drawTriangle( centerX - side / 4, centerY + side / 4, side / 2 ); 
            drawTriangle( centerX + side / 4, centerY + side / 4, side / 2 ); 
            drawTriangle( centerX, centerY - side / 4, side / 2 ); 
        } 
    }

    public void paintComponent( Graphics gr )
    {
        super.paintComponent( gr );
        graph = gr;
        setBackground( Color.white );
        gr.setColor( Color.blue );

        int width = getSize().width;
        int height = getSize().height;
        int smallSide;
        if ( height < width )
        {
            smallSide = height;
        }
        else
        {
            smallSide = width;
        }
        drawTriangle( width / 2, height / 2, smallSide - 10 );
    }
}

public class NestedTriangles extends JApplet
{
    public void init()
    {
        // This simple init() method just creates a drawing surface
        // belonging to the nested class Display and uses it for
        // the content pane of the applet. (This is one case where
        // it is rather silly to use a JApplet rather than a plain
        // old Applet!)
        setContentPane( new Sierpinski() );
    }
}
