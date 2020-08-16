/*
  Shows a pair of dice that are rolled when the user clicks on the
  frame. A clicking sound is played when the dice are rolled.

  This file defines two classes:  A main class, ClickableDice,
  and a canvas class, DicePanel.  The DicePanel class is not public
  and is not meant to be used outside this file.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// These imports required to access the sound file
import java.net.URL;
import java.net.MalformedURLException;
import java.applet.*;

public class ClickableDice extends JFrame
{  
    public ClickableDice()
    {        
        setTitle( "Dice" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        
        //getContentPane().setBackground(Color.blue);
        getContentPane().setLayout(new BorderLayout()); 
        
        DicePanel dice = new DicePanel(); // panel to show the dice.
        
        getContentPane().add(dice, BorderLayout.CENTER);  // Dice go in large, center
                                                           //   area of the application.
     } 
    
    public static void main(String[] args)
    {   
        ClickableDice testApp  = new ClickableDice() ;
        testApp.setSize( 150, 150 );   
        testApp.setVisible( true );        
    }
    
    
}  // end class ClickableDice


