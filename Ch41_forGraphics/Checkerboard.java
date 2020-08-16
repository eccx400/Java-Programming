import java.awt.*;

/**
    This applet draws a red-and-black checkerboard.
    It is assumed that the size of the applet is 160
    by 160 pixels.
       
    @author  Eric Cheng
    @version 1/14/2014
    
    @author  Period - 6
    @author  Assignment - Ch41_forGraphics
    
    @author  Sources - Eric Cheng
*/
public class Checkerboard extends AnimationBase
{
    public void dr`awFrame( Graphics g )
    {
        for(int row = 1; row <= 8;row++)
        {
            for(int column = 1; column <= 8;column++) 
            {
                //Draw rect
                if ( ( ( row % 2 == 0 ) && ( column % 2 == 0 ) )
                    || ((row % 2 == 1) && (column % 2 == 1))) 
                {
                    //red
                    g.setColor(Color.RED);
                } 
                else 
                {
                    //black
                    g.setColor(Color.BLACK);
                }
                
                int xCoord = 100 * (column - 1);
                int yCoord = 100 * (row - 1);
                g.fillRect(xCoord, yCoord, 100, 100);
            }
        }
    }
}

