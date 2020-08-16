import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
   Modify the Repeater program so that when the user enters text into the
   bottom TextField and hits enter, the text is replaced with an error message
   such as "Enter text in the top field."

   You will need to modify the actionPerformed( ActionEvent evt ) method so
   that it determines which text field has just generated an action. This 
   can be done by using evt.getActionCommand(), which evaluates to the String
   that the user just entered (no matter in which field it was entered.) Now
   use getText() with the top box to see if the string in that field is the
   same as the command in the ActionEvent. If so, copy it to the bottom field.
   If not, write the error message. Be sure to register an ActionListener for
   each JTextField.

   @author  Eric Cheng
   @version March 26, 2014

   @author  Period - 6
   @author  Assignment - Ex2_ErrorMessage

   @author  Sources - Eric Cheng
 */
public class Ex2_ErrorMessage extends JFrame implements ActionListener
{
    JLabel inLabel = new JLabel( "Enter Text Here:  " );
    JTextField inText = new JTextField( 15 );

    JLabel outLabel = new JLabel( "DON'T enter text here :" );
    JTextField outText = new JTextField( 15 );

    public Ex2_ErrorMessage() // constructor
    {
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( inLabel );
        getContentPane().add( inText );
        getContentPane().add( outLabel );
        getContentPane().add( outText );
        
        inText.setActionCommand("input");

        inText.addActionListener( this );
        outText.addActionListener( this );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

    // The application code.
    public void copyText()
    {
        String text = inText.getText();
        outText.setText( text );
    }
    
    // If input in upper bar, OK. If input in lower bar, error message shown.
    public void actionPerformed( ActionEvent evt )
    {
        if(evt.getActionCommand().equals("input"))
        {
            copyText();
        }
        else
        {
            outText.setText("Error! Please re-enter message above");
        }
        repaint();
    }

    public static void main( String[] args )
    {
        Ex2_ErrorMessage echo = new Ex2_ErrorMessage();
        echo.setSize( 300, 100 );
        echo.setVisible( true );
    }
}