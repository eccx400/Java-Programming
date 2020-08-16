import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Ex2_ColorCycle extends JFrame implements ActionListener
{
    private JButton bChange; // reference to the button object 
    
    private int clickCount; 
  
    private Color[] color = { Color.red, Color.green, Color.blue, Color.gray }; 
  
  
    // constructor for ButtonFrame 
    public Ex2_ColorCycle() 
    { 
        super( "Color Cycle" ); 
        bChange = new JButton( "Change Color" ); 
        getContentPane().setLayout( new FlowLayout() ); 
        getContentPane().add( bChange ); 
        bChange.addActionListener( this ); 
        getContentPane().setBackground( Color.red ); 
        clickCount = 1; 
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    } 
  
  
    public void actionPerformed( ActionEvent evt ) 
    { 
        getContentPane().setBackground( color[( clickCount++ ) % 4] ); 
        System.out.println( clickCount ); 
        repaint(); // ask the system to paint the screen. 
    } 


    public static void main( String[] args )
    {
        Ex2_ColorCycle frm = new Ex2_ColorCycle();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}


