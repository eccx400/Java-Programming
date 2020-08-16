import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This lab is a tweak to the copy name method given in the lecture
   The user must enter the secret word, which must be the same with the
   actual word to pass, else the program will close after 3 tries.
   
   @author  Eric Cheng
   @version March 26, 2014

   @author  Period - 6
   @author  Assignment - Ex1_GuessingGame

   @author  Sources - Eric Cheng
 */
public class Ex1_GuessingGame extends JFrame implements ActionListener
{
    JLabel inLabel = new JLabel( "Please enter the secret word:  " );
    JTextField inText = new JTextField( 15 );

    JLabel outLabel = new JLabel( "Raison ou tort :" );
    JTextField outText = new JTextField( 15 );
    
    //The secret word
    public String secret = "Ouais!";
    
    //The count for wrong words ( >= 3)
    int count = 0;

    public Ex1_GuessingGame() // constructor
    {
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( inLabel );
        getContentPane().add( inText );
        getContentPane().add( outLabel );
        getContentPane().add( outText );

        inText.addActionListener( this );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

    // The application code.
    public void actionPerformed( ActionEvent evt )
    {
        String word = inText.getText();
        if( word.equals(secret))
        {
            outText.setText( "Richtig!" );
        }
        else
        {
            outText.setText( "Falsch!" );
            count++;
        }
        if (count >= 3)
        {
            System.exit(0);
        }
        repaint();
    }

    public static void main( String[] args )
    {
        Ex1_GuessingGame echo = new Ex1_GuessingGame();
        echo.setSize( 300, 100 );
        echo.setVisible( true );
    }
}