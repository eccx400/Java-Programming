import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random; 

public class Ex4_WinningStreak extends JFrame implements ActionListener
{
 // instance variables 
    private JButton x[]; 
  
    Random randNum = new Random(); // create a Random number object 
  
    int someInt = Math.abs( randNum.nextInt() ) % 3; // someInt gets a number 
                                                     // from 0 to 2 
  
  
    public Ex4_WinningStreak() 
    { 
        super( "Winning Streak" ); 
  
        x = new JButton[3]; 
        x[0] = new JButton( "Crunch" ); 
        x[1] = new JButton( "Smash" ); 
        x[2] = new JButton( "Pow" ); 
        getContentPane().setLayout( new FlowLayout() ); 
        for ( int i = 0; i < 3; i++ )    
        { 
            getContentPane().add( x[i] ); 
            x[i].addActionListener( this ); 
        } 
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        System.out.println(someInt); 
    } 
  
  
    public void actionPerformed( ActionEvent evt ) 
    { 
        if ( evt.getSource() == x[someInt] ) 
        { 
            System.exit( 0 ); 
        } 
        else
        { 
            if ( evt.getSource() == x[0] ) 
            { 
                getContentPane().setBackground( new Color( 255, 189, 136 ) ); 
            } 
            else if ( evt.getSource() == x[1] ) 
            { 
                getContentPane().setBackground( Color.magenta ); 
            } 
            else
            { 
                getContentPane().setBackground( new Color( 227, 37, 107 ) ); 
            } 
        } 
  
        repaint(); // ask the system to paint the screen. 
    } 

    public static void main( String[] args )
    {
        Ex4_WinningStreak frm = new Ex4_WinningStreak();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}


