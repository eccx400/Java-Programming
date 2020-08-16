import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class ToggleColorButtonFrame extends JFrame implements ActionListener
{
    private JButton bChange; // reference to the button object


    // constructor for ButtonFrame
    public ToggleColorButtonFrame()
    {
        // construct a Button
        bChange = new JButton( "Click Me!" );
        getContentPane().setBackground( Color.blue );

        // register the ButtonFrame object as the listener for the JButton.
        bChange.addActionListener( this );

        // add the button to the JFrame
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( bChange );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

        //Use the properties of odd and even numbers to change between red and blue
        //on each click.     
        private int count = 0;  
        public void actionPerformed( ActionEvent evt )     
        {    
            if ( count % 2 == 0 )    
            {    
                getContentPane().setBackground( Color.red ); 
            } 
            else     
            {      
                getContentPane().setBackground( Color.blue );     
            }      
            repaint(); // ask the system to paint the screen.     
            count++;  
        } 
    }


public class Ex1_ToggleColorButton
{
    public static void main( String[] args )
    {
        ToggleColorButtonFrame frm = new ToggleColorButtonFrame();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}
