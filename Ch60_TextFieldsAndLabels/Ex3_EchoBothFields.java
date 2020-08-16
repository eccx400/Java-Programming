import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
   Modify the Repeater program so that the user can enter text into either 
   field. The text will be repeated in the other field, replacing whatever
   was there. To do this you will need to use getActionCommand(), as 
   in Exercise 2.

   @author  Eric Cheng
   @version March 26, 2014

   @author  Period - 6
   @author  Assignment - Ex3_EchoBothFields

   @author  Sources - Eric Cheng
 */
public class Ex3_EchoBothFields extends JFrame implements ActionListener
{
    JLabel inLabel = new JLabel( "Enter Text:  " );
    JTextField inText = new JTextField( 15 );

    JLabel outLabel = new JLabel( "Enter Text:" );
    JTextField outText = new JTextField( 15 );

    public Ex3_EchoBothFields() // constructor
    {
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( inLabel );
        getContentPane().add( inText );
        getContentPane().add( outLabel );
        getContentPane().add( outText );
        
        inText.setActionCommand("input");
        outText.setActionCommand("output");

        inText.addActionListener( this );
        outText.addActionListener( this );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }
    
    // String in top = copy to bottom
    // Strong on bottom = copy to top
    public void actionPerformed( ActionEvent evt )
    {
        if(evt.getActionCommand().equals("input"))
        {
            String word = inText.getText();
            outText.setText( word );   
        }
        else
        {
            String word = outText.getText();
            inText.setText( word );        
        }
        repaint();
    }

    public static void main( String[] args )
    {
        Ex3_EchoBothFields echo = new Ex3_EchoBothFields();
        echo.setSize( 300, 100 );
        echo.setVisible( true );
    }
}