import java.awt.*;

/**
   Applet shows a checkerboard pattern in which the even numbered
   rows slide to the left and the odd numbered rows slide to the
   right.  It is ASSUMED that the applet is 160x160 pixels, since
   the individual squares in the board are 20 pixels on a side.
      
   @author  Eric Cheng
   @version 1/14/2014

   @author  Period - 6
   @author  Assignment - Ch41_forGraphics

   @author  Sources - Eric Cheng
 */

public class SlidingCheckerboard extends AnimationBase
{
 public void drawFrame( Graphics g )
 {
     int offset = getFrameNumber() % 40;
     int column;
     int row;
     int x = -40;
     int y = 0;
     for (row = 1; row <= 8; row++) {
         if ( row%2 ==1)
         {
             x = -40 - offset;
         }
         else
         {
             x = -40 + offset;
         }
         for (column = 1; column <= 12; column++) 
         {
             if ((row % 2 == 0 && column % 2 == 0)
                     || (row % 2 == 1 && column % 2 == 1)) 
                 {
                 g.setColor(Color.RED);
                 g.fillRect(x, y, 20, 20);
                 x += 20;
                 }
                 else 
                 {
                 g.setColor(Color.black);
                 g.fillRect(x, y, 20, 20);
                 x += 20;
                 }
             }
        y += 20;
         }
     }
}