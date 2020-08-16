import javax.swing.*;
import java.awt.*;

/**
   Graphs and animates the sine function in red and the cosine function
   in blue, both in the same drawing area. Draws the x and y axis. Also,
   draws "tick" marks along the x axis at PI/4, PI/2, 3*PI/4, and 2*PI.
   Draw axes and tick marks in black.
   
   The drawing area is 600 by 400. (X=0, Y=0) is the top left corner.

   @author  Eric Cheng
   @version January 21, 2014

   @author  Period - 6
   @author  Assignment - Ex4_SinCosWaveAnim

   @author  Sources - Eric Cheng
 */
public class Ex4_SinCosWaveAnim extends AnimationBase
{
    public void init() 
    { 
        setBackground( Color.WHITE ); 
        this.setMillisecondsPerFrame( 100 ); 
    } 
  
  
    public void drawFrame( Graphics gr ) 
    { 
        int w = getWidth(); 
        int h = getHeight(); 
        gr.setColor( Color.white ); 
        gr.fillRect( 0, 0, w, h ); 
        gr.setColor( Color.black ); 
        gr.drawLine( w / 2, 0, w / 2, h ); 
        gr.drawLine( 0, h / 2, w, h / 2 ); 
        double zed = 1.0 / 32.0; 
        int offset = getFrameNumber(); 
          
        gr.setColor( Color.red ); //sine graph 
        for ( double x = 0; x <= 2 * Math.PI; x = x + zed ) 
        { 
            double y = Math.sin( x + ( Math.PI ) - offset ); 
            double nextx = x + zed; 
            double nexty = Math.sin( nextx + ( Math.PI ) - offset ); 
            int initialX = (int)( x * w / ( 2 * Math.PI ) ); 
            int initialY = (int)( -y * h / 2.0 + h / 2.0 ); 
            int endX = (int)( nextx * w / ( 2 * Math.PI ) ); 
            int endY = (int)( -nexty * h / 2.0 + h / 2.0 ); 
            gr.drawLine( initialX, initialY, endX, endY ); 
        } 
  
        gr.setColor( Color.blue );  
        for ( double x = 0.0; x <= 2 * Math.PI; x = x + zed ) 
        { 
            double y = Math.cos( x + ( Math.PI ) - offset ); 
            double nextx = x + zed; 
            double nexty = Math.cos( nextx + ( Math.PI ) - offset ); 
            int initialX = (int)( x * w / ( 2 * Math.PI ) ); 
            int initialY = (int)( -y * h / 2.0 + h / 2.0 ); 
            int endX = (int)( nextx * w / ( 2 * Math.PI ) ); 
            int endY = (int)( -nexty * h / 2.0 + h / 2.0 ); 
            gr.drawLine( initialX, initialY, endX, endY ); 
        } 
  
        gr.setColor( Color.black );
        for ( int zed2 = 0; zed2 <= ( w / 2 ); zed2 += ( w / 8 ) ) 
        { 
            gr.drawLine( ( w / 2 ) + zed2, 
                ( h / 2 ) + 10, 
                ( w / 2 ) + zed2, 
                ( h / 2 ) - 10 ); 
            gr.drawLine( ( w / 2 ) - zed2, 
                ( h / 2 ) + 10, 
                ( w / 2 ) - zed2, 
                ( h / 2 ) - 10 ); 
        } 
    } 
}