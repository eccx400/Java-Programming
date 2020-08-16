import java.awt.*;

/**
   Graphs the sine function in red and the cosine function in blue,
   both in the same drawing area. Draws the x and y axis. Also, draws
   "tick" marks along the x axis at PI/4, PI/2, 3*PI/4, and 2*PI.
   Draw axes and tick marks in black.
   
   The drawing area is 600 by 400. (X=0, Y=0) is the top left corner.

   @author  Eric Cheng
   @version January 21, 2014

   @author  Period - 6
   @author  Assignment - Ex3_SineCosineWave

   @author  Sources - Eric Cheng
 */
public class Ex3_SineCosineWave extends AnimationBase
{
    public void init() 
    { 
        setBackground( Color.WHITE ); 
  
        setMillisecondsPerFrame( 10 ); 
    } 
  
  
    public void drawFrame( Graphics gr ) 
    { 
        int w = getWidth(); 
        int h = getHeight(); 
        gr.drawLine( w / 2, 0, w / 2, h ); 
        gr.drawLine( 0, h / 2, w, h / 2 ); 
        double zed2 = 1.0 / 32.0; 
  
        gr.setColor( Color.red ); 
        for ( double x = 0; x <= 2 * Math.PI; x = x + zed2 ) 
        { 
            double y = Math.sin( x + ( Math.PI ) ); 
            double initialX = x + zed2; 
            double initialY = Math.sin( initialX + ( Math.PI ) ); 
  
            int startX = (int)( x * w / ( 2 * Math.PI ) ); 
            int startY = (int)( -y * h / 2.0 + h / 2.0 ); 
            int endX = (int)( initialX * w / ( 2 * Math.PI ) ); 
            int endY = (int)( -initialY * h / 2.0 + h / 2.0 ); 
  
            gr.drawLine( startX, startY, endX, endY ); 
        } 
  
        gr.setColor( Color.blue ); 
        for ( double x = 0.0; x <= 2 * Math.PI; x = x + zed2 ) 
        { 
            double y = Math.cos( x + ( Math.PI ) ); 
            double initialX = x + zed2; 
            double initialY = Math.cos( initialX + ( Math.PI ) ); 
  
            int startX = (int)( x * w / ( 2 * Math.PI ) ); 
            int startY = (int)( -y * h / 2.0 + h / 2.0 ); 
            int endX = (int)( initialX * w / ( 2 * Math.PI ) ); 
            int endY = (int)( -initialY * h / 2.0 + h / 2.0 ); 
  
            gr.drawLine( startX, startY, endX, endY ); 
        } 
  
        gr.setColor( Color.black ); 
        for ( int zed3 = 0; zed3 <= ( w / 2 ); zed3 += ( w / 8 ) ) 
        { 
            gr.drawLine( ( w / 2 ) + zed3, 
                ( h / 2 ) + 10, 
                ( w / 2 ) + zed3, 
                ( h / 2 ) - 10 ); 
            gr.drawLine( ( w / 2 ) - zed3, 
                ( h / 2 ) + 10, 
                ( w / 2 ) - zed3, 
                ( h / 2 ) - 10 ); 
        } 
    } 
}