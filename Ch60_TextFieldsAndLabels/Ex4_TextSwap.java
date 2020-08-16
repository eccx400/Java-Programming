import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
   Add a JButton to the GUI. Modify the program so that when the button is 
   clicked, the Strings in the two JTextFields are swapped; ie. the top field
   gets what was in the bottom box and the bottom field gets what was in the
   top. The actionPerformed() method will listen for an event from the
   button. When it gets one, it swaps whatever text is in the two fields.

   @author  Eric Cheng
   @version March 26, 2014

   @author  Period - 6
   @author  Assignment - Ex4_TextSwap

   @author  Sources - Eric Cheng
 */
public class Ex4_TextSwap extends JFrame implements ActionListener
{
    //  New swap Jbutton
    JButton changer = new JButton( "Changer!" ); 
    
    JLabel inLabel = new JLabel( "Enter Text: " );
    JTextField inText = new JTextField( 15 );

    JLabel outLabel = new JLabel( "Enter Text: " );
    JTextField outText = new JTextField( 15 );

    public Ex4_TextSwap() // constructor
    {
        getContentPane().setLayout( new FlowLayout() ); 
        getContentPane().add( inLabel ); 
        getContentPane().add( inText ); 
        getContentPane().add( outLabel ); 
        getContentPane().add( outText ); 
        getContentPane().add( changer ); 
        
        changer.setActionCommand( "changer" ); 
        changer.addActionListener( this ); 
        
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE ); 
    }

    // The application code. 
    // Changes the inText and outText for each press of a button.
    public void actionPerformed( ActionEvent evt ) 
    { 
        String in = inText.getText(); 
        String out = outText.getText(); 
        
        outText.setText( in ); 
        inText.setText( out ); 
       
        repaint(); 
    } 

    public static void main( String[] args )
    {
        Ex4_TextSwap echo = new Ex4_TextSwap();
        echo.setSize( 300, 100 );
        echo.setVisible( true );
    }
}