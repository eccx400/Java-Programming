import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Ex6_ExpandAndShrink extends JFrame implements ActionListener
{
    private JButton bigger;
    private JButton smaller;

    private static double SIZE_FACTOR = 0.1;
    private Dimension frameSize;

    // constructor for TwoButtons
    public Ex6_ExpandAndShrink()
    {
        super( "Expand and Shrink Buttons" ); 
        
        getContentPane().setLayout( new FlowLayout() ); 
        bigger = new JButton( "Expand" ); 
        smaller = new JButton( "Shrink" ); 
  
        bigger.setActionCommand( "Expand" ); 
        smaller.setActionCommand( "Shrink" ); 
  
        getContentPane().add( bigger ); 
        getContentPane().add( smaller ); 
  
        bigger.addActionListener( this ); 
        smaller.addActionListener( this ); 
  
    } 
  
    //Expand = 1.1x
    //Shrink = 0.9x
    public void actionPerformed( ActionEvent evt ) 
    { 
        if ( evt.getActionCommand().equals( "Expand" ) ) 
        { 
            setSize( (int)( getWidth() * 1.1 ), (int)( getHeight() * 1.1 ) ); 
            getContentPane().setBackground( Color.green ); 
        } 
        else
        { 
            setSize( (int)( getWidth() * 0.9 ), (int)( getHeight() * 0.9 ) ); 
            getContentPane().setBackground( Color.red ); 
        } 
        repaint(); 
    } 

    public static void main( String[] args )
    {
        Ex6_ExpandAndShrink frm = new Ex6_ExpandAndShrink();

        frm.setSize( 200, 150 ); 
        frm.setVisible( true );
    }
}
