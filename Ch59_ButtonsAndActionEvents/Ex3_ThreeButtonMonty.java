import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Ex3_ThreeButtonMonty extends JFrame implements ActionListener
{
    private JButton x[]; 
    
    Random rand = new Random(); // create a Random number object 
  
    // someInt gets a number from 0 to 2 
    int someInt = Math.abs( rand.nextInt() ) % 3;
 

    // constructor for ButtonFrame
    public Ex3_ThreeButtonMonty()
    {
        super("Three Button Monty");

        x = new JButton[3]; 
        x[0] = new JButton( "Button 1" ); 
        x[1] = new JButton( "Button 2" ); 
        x[2] = new JButton( "Button 3" ); 
        getContentPane().setLayout( new FlowLayout() ); 
        for ( int i = 0; i < 3; i++ ) 
        { 
            getContentPane().add( x[i] ); 
            x[i].addActionListener( this ); 
        } 
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    } 

    public void actionPerformed( ActionEvent evt )
    {
        if( evt.getSource() == x[someInt])
        {
            if (someInt == 0) {
                getContentPane().setBackground( new Color( 255, 289, 136));
            }
            else if (someInt == 1)
            {
                getContentPane().setBackground( Color.magenta);
            }
            else
            {
                getContentPane().setBackground( new Color( 227, 37, 107));
            }
        }
        else
        {
            System.exit(0);
        }
        repaint(); // ask the system to paint the screen.
    }

    public static void main( String[] args )
    {
        Ex3_ThreeButtonMonty frm = new Ex3_ThreeButtonMonty();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}


