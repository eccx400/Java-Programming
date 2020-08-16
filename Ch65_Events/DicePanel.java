import java.applet.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.*;

import javax.swing.*;

public class DicePanel extends JPanel implements MouseListener, KeyListener,
FocusListener, MouseMotionListener
{
    /*
       This class displays the dice.  The dice are
       rolled by calling this class's roll() method.
     */
    private static final int DICE_BOX_SIZE = 100;
       
    private int die1;  // The values shown on the dice.
    private int die2;
    
    private boolean focussed;  // True when this application has the input focus.
                               // (The color of the panel's border changes
                               // when this is true.)

    private URL completeURL;   // location of the "click.au" sound file
    private AudioClip audioClip;
               
    DicePanel()
    {
        /*
           Constructor.  To initialize the canvas, set a 
           light blue background color.
         */
        
        // To initialize the panel, register to listen for
        // mouse events on itself, set a light blue background
        // color, and play a clicking sound to give the user
        // more feedback.

        addKeyListener(this);
        addMouseListener(this);
        addFocusListener(this);
        addMouseMotionListener(this);
        
        setBackground( new Color(200, 200, 250) );

        // assemble the URL and load the sound file
        try
        {
            completeURL = new URL(new URL("file:" + System.getProperty("user.dir") + "/"), "click.au");
        }
        catch (MalformedURLException e)
        {
            System.err.println(e.getMessage());
        }
        audioClip = Applet.newAudioClip(completeURL);
        
        roll();
    }
      
    public void paintComponent(Graphics g)
    {
        // Draws the two dice.
        super.paintComponent(g);    
        
        if (focussed)
           g.setColor( Color.red );
        else
           g.setColor( Color.blue );
        repaint();

        // calculate the offset to draw the dice in the center of the
        // panel in the event of a window resize.
        int offsetX = (getWidth() - DICE_BOX_SIZE)/2;
        int offsetY = (getHeight() - DICE_BOX_SIZE)/2;
        
        g.drawRect(offsetX + 0, offsetY + 0, 99, 99);
        g.drawRect(offsetX + 1, offsetY + 1, 97, 97);           
        drawDie(g, die1, offsetX + 10, offsetY + 10);
        drawDie(g, die2, offsetX + 55, offsetY + 55);
    }
    
    
    /*
       Draw a die with upper left corner at (x,y).  The die is
       35 by 35 pixels in size.  The val parameter gives the
       value showing on the die (that is, the number of dots).
     */
    private void drawDie(Graphics g, int val, int x, int y)
    {
        g.setColor(Color.white);
        g.fillRect(x, y, 35, 35);
        g.setColor(Color.black);
        g.drawRect(x, y, 34, 34);
        if (val > 1)                      // upper left dot
            g.fillOval(x+3, y+3, 9, 9);
        if (val > 3)                      // upper right dot
            g.fillOval(x+23, y+3, 9, 9);
        if (val == 6)                     // middle left dot
            g.fillOval(x+3, y+13, 9, 9);
        if (val % 2 == 1)                 // middle dot (for odd-numbered val's)
            g.fillOval(x+13, y+13, 9, 9);
        if (val == 6)                     // middle right dot
            g.fillOval(x+23, y+13, 9, 9);
        if (val > 3)                      // bottom left dot
            g.fillOval(x+3, y+23, 9, 9);
        if (val > 1)                      // bottom right dot
            g.fillOval(x+23, y+23, 9,9);
    }
 
    /*
      Roll the dice by randomizing their values.  Tell the
      system to repaint the panel, to show the new values.
      Also, play a clicking sound to give the user more feedback.
    */
    private void roll()
    {
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
        
        audioClip.play();
        repaint();
    }

    @Override
    public void keyPressed( KeyEvent arg0 )
    {
        requestFocus();
        roll();
        repaint();
        
    }

    @Override
    public void keyReleased( KeyEvent arg0 )
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped( KeyEvent arg0 )
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked( MouseEvent arg0 )
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered( MouseEvent arg0 )
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited( MouseEvent arg0 )
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased( MouseEvent arg0 )
    {
        requestFocus();
        roll();      
        
    }

    @Override
    public void mouseMoved( MouseEvent arg0 )
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void focusGained( FocusEvent arg0 )
    {
        requestFocus();
        focussed = true;
        paintComponent(getGraphics());
        repaint();
        
    }

    @Override
    public void focusLost( FocusEvent arg0 )
    {
        focussed = false;
        repaint();
    }

    @Override
    public void mouseDragged( MouseEvent e )
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed( MouseEvent e )
    {
        // TODO Auto-generated method stub
        
    }
    
    /*
       YOUR EVENT HANDLING CODE GOES HERE
    */
       
} // end class DicePanel