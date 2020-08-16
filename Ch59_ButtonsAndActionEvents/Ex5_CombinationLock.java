import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Ex5_CombinationLock extends JFrame implements ActionListener
{
    public String secretNumber = "123"; 
    
    public String string = ""; 
  
    // instance variables 
    JButton[] array = new JButton[10]; 
  

    // constructor for ButtonFrame 
    public Ex5_CombinationLock() 
    { 
        super( "Combination Lock" ); 
        getContentPane().setLayout( new FlowLayout() ); 
        
        for ( int i = 0; i < array.length; i++ ) 
        { 
            array[i] = new JButton( "" + i ); 
            array[i].setActionCommand( "" + i ); 
            getContentPane().add( array[i] ); 
            array[i].addActionListener( this ); 
        } 
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    } 
  
    // Check to see if the number is correct
    public void actionPerformed( ActionEvent evt ) 
    { 
        string += evt.getActionCommand(); 
        if ( secretNumber.length() == string.length() ) 
        { 
            if ( string.equals( secretNumber ) ) 
            { 
                getContentPane().setBackground( Color.green ); 
            } 
            else
            { 
                getContentPane().setBackground( Color.red ); 
            } 
            string = ""; 
        } 
        repaint(); // ask the system to paint the screen. 
    } 
  
    public static void main( String[] args )
    {
        Ex5_CombinationLock frm = new Ex5_CombinationLock();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}


