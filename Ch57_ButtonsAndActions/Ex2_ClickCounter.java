import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class ClickCounterFrame extends JFrame implements ActionListener
{
    private JButton bChange; // reference to the button object 
    private JLabel label;
    

    // constructor for ButtonFrame
    public ClickCounterFrame()
    {
        //Create new JLabel
        label = new JLabel( "Count: ");
        
        // construct a Button
        bChange = new JButton( "Click Me!" );

        // register the ButtonFrame object as the listener for the JButton.
        bChange.addActionListener( this );

        // add the button to the JFrame
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( bChange );
        getContentPane().add( label );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

    // Uses integers to change between red and blue
    private int count = 0;
    public void actionPerformed( ActionEvent evt )
    {
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
            label.setText( "Count: " + ( count + 1 ) );
            count++;
        }
    }
}

public class Ex2_ClickCounter
{
    public static void main( String[] args )
    {
        ClickCounterFrame frm = new ClickCounterFrame();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}

