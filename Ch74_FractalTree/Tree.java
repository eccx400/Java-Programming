import java.awt.Color;
import java.awt.Graphics;

/**
   Imagine you were describing how to draw a tree. You might say:
   Draw a vertical line
   At the top of the line, draw two smaller lines ("branches") in a v shape
   At the ends of each of those two branches, draw two even smaller branches
   Keep repeating the process, drawing smaller and smaller branches until the
   branches are too small to draw
   This process of repeating the same design at a continually decreasing 
   scale is an example of a Fractal. Using fractals to draw trees can give
   some interesting and beautiful patterns.In this assignment we will use
   a recursive branching function to create a fractal tree.

   @author  Eric Cheng
   @version March 16, 2014

   @author  Period - 6
   @author  Assignment - Ch74_FractalTree

   @author  Sources - Eric Cheng
 */
public class Tree
{
    //reminder: start here
    double dFractionLength;
    int nSmallestBranch;
    double dBranchAngle;
    int nStartX, nStartY, nEndX, nEndY;

    /**
        The trunk of the tree needs four values: the X and Y of the starting 
        point and the X and Y of the end point. We will also have three member
        variables that will control:

        how much smaller the branches are
        how small the branches will get
        the angle between the branches.
        Adjusting these parameters will change the appearance of the tree.
    
        @param startX - starting parameters for x
        @param startY - starting parameters for y
        @param endX - ending parameters for x
        @param endY - ending parameters for y
     */
    public Tree(int startX, int startY, int endX, int endY )
    {
        dFractionLength = .8;
        nSmallestBranch = 10;
        dBranchAngle = .2;
        nStartX = 400;
        nStartY = 700;
        nEndX = 400;
        nEndY = 600;
    }
   
    /**
        Set the color of the interface, and starts by drawing the lines of the
        starting coordinates
        @param g - Graphics G
     */
    public void draw( Graphics g )
    {
        //set color
        //Code for each branch
        g.setColor( Color.green ); 
        g.drawLine( nStartX, nStartY, nEndX, nEndY ); 
        Branch( 100, nEndX, nEndY, 3 * Math.PI / 2, g );     }

    /**
       Add a branch method to the Tree class. The branch will first draw two
       smaller branches off the end of the tree. It will then call itself
       recursively to draw two smaller branches off the ends of the
       previous branches. 

        @param dLength - the length of the previous branch (or trunk)
        @param nStartX - the X coordinate of the branch's starting point 
            (which is the same as the end point of the previous branch)
        @param nStartY - the Y coordinate of the branch's starting point
        @param dAngle - the angle of the previous branch (or trunk) in radians
        @param g - Graphics g
     */
    public void Branch( double dLength, int nStartX, int nStartY,
        double dAngle, Graphics g )
    {
        double dAngle1 = dAngle + dBranchAngle; 
        double dAngle2 = dAngle - dBranchAngle; 
       
        dLength *= dFractionLength; 
        
        int nEndX1 = (int)( dLength * Math.cos( dAngle1 ) + nStartX ); 
        int nEndY1 = (int)( dLength * Math.sin( dAngle1 ) + nStartY ); 
        int nEndX2 = (int)( dLength * Math.cos( dAngle2 ) + nStartX ); 
        int nEndY2 = (int)( dLength * Math.sin( dAngle2 ) + nStartY ); 
        g.drawLine( nStartX, nStartY, nEndX1, nEndY1 ); 
        g.drawLine( nStartX, nStartY, nEndX2, nEndY2 ); 
        
        if ( dLength > nSmallestBranch ) 
        { 
            Branch( dLength, nEndX1, nEndY1, dAngle + dBranchAngle, g ); 
            Branch( dLength, nEndX2, nEndY2, dAngle - dBranchAngle, g ); 
        } 
        else
        { 
            return; 
        } 
    } 
}
