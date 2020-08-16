import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex1_FourButtons extends JFrame implements ActionListener
{
    // references to button objects
    JButton redButton;
    JButton grnButton;
    JButton blueButton;
    JButton yellowButton;

    // constructor for FourButtons
    public Ex1_FourButtons()
    {
        super( "Four Buttons" );
        redButton = new JButton( "Rouge (Red)" );
        grnButton = new JButton( "Vert (Green)" );
        blueButton = new JButton( "Bleu (Blue)");
        yellowButton = new JButton( "Jaune (Yellow)");

        redButton.setActionCommand( "red" ); // set the  command 
        grnButton.setActionCommand( "green" ); // set the  command   
        blueButton.setActionCommand( "blue" ); // set the  command   
        yellowButton.setActionCommand( "yellow" ); // set the  command   

        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( redButton );
        getContentPane().add( grnButton );
        getContentPane().add( blueButton );
        getContentPane().add( yellowButton );

        // register the buttonDemo frame
        // as the listener for both Buttons.
        redButton.addActionListener( this );
        grnButton.addActionListener( this );
        blueButton.addActionListener( this );
        yellowButton.addActionListener( this );

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

    public void actionPerformed( ActionEvent evt )
    {
        // check which command has been sent
        if ( evt.getActionCommand().equals( "red" ) )
            getContentPane().setBackground( Color.red );
        else if ( evt.getActionCommand().equals( "green" ) )
            getContentPane().setBackground( Color.green );
        else if ( evt.getActionCommand().equals( "blue" ) )
            getContentPane().setBackground( Color.blue );
        else if ( evt.getActionCommand().equals( "yellow" ) )
            getContentPane().setBackground( Color.yellow );

        repaint(); // ask the system to paint the screen.
    }

    public static void main( String[] args )
    {
        Ex1_FourButtons demo = new Ex1_FourButtons();

        demo.setSize( 275, 200 );
        demo.setVisible( true );
    }

}