import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
    Write the application part of the ideal weight calculator that is described
    in this chapter (the first version). Use the approximate formula:

    W = H2 / 30 , for female

    W = H2 / 28 , for male
  
    where W is the ideal weight in pounds, H is the height in inches
    For the height, use the middle of the range for each of the radio 
    button's ranges. Set an action command for each radio button using
    setActionCommand(String) just as for push buttons. Add an action
    listener for each button using addActionListener().

    Pick initial settings of the buttons and when the program starts up
    display the ideal weight for those settings. Each time a new button 
    is clicked calculate and display the new ideal weight. If you are
    actually interested in your ideal weight, search the Web for more
    accurate calculators.

   @author  Eric Cheng
   @version 2 April 2014

   @author  Period - 6
   @author  Assignment - Ex1_IdealWeight

   @author  Sources - Eric Cheng
 */
public class Ex1_IdealWeight extends JFrame implements ActionListener
{
    private JRadioButton genderM, genderF;
    private ButtonGroup genderGroup;
    private JPanel genderPanel;

    private JRadioButton heightA, heightB, heightC, heightD, heightE;
    private ButtonGroup heightGroup;
    private JPanel heightPanel;

    private JTextField resultText;
    private JLabel resultLabl;
    private JPanel resultPanel;
  
    public Ex1_IdealWeight() 
    { 
        setTitle( "Your Ideal Weight" ); 
        setDefaultCloseOperation( EXIT_ON_CLOSE ); 
  
        // gender group 
        genderM = new JRadioButton( "Male", true );
        genderF = new JRadioButton( "Female", false );
        genderM.addActionListener( this );
        genderF.addActionListener( this );      
        genderM.setActionCommand("Male");
        genderF.setActionCommand("Female");
        
        genderGroup = new ButtonGroup();
        genderGroup.add( genderM );
        genderGroup.add( genderF );
        genderPanel = new JPanel();
        genderPanel.setLayout( new BoxLayout( genderPanel, BoxLayout.Y_AXIS ) );
        genderPanel.add( new JLabel( "Your Gender" ) );
        genderPanel.add( genderM );
        genderPanel.add( genderF );
  
        // height group 
        heightA = new JRadioButton( "60 to 64 inches", true );
        heightB = new JRadioButton( "64 to 68 inches", false );
        heightC = new JRadioButton( "68 to 72 inches", false );
        heightD = new JRadioButton( "72 to 76 inches", false );
        heightE = new JRadioButton( "76 to 80 inches", false );
        
        heightA.addActionListener( this );
        heightB.addActionListener( this );
        heightC.addActionListener( this );
        heightD.addActionListener( this );
        heightE.addActionListener( this );
        
        heightA.setActionCommand("62");
        heightB.setActionCommand("66");
        heightC.setActionCommand("70");
        heightD.setActionCommand("74");
        heightE.setActionCommand("78");
  
        // height group
        heightGroup = new ButtonGroup();
        heightGroup.add( heightA );
        heightGroup.add( heightB );
        heightGroup.add( heightC );
        heightGroup.add( heightD );
        heightGroup.add( heightE );

        heightPanel = new JPanel();
        heightPanel.setLayout( new BoxLayout( heightPanel, BoxLayout.Y_AXIS ) );
        heightPanel.add( new JLabel( "Your Height" ) );
        heightPanel.add( heightA );
        heightPanel.add( heightB );
        heightPanel.add( heightC );
        heightPanel.add( heightD );
        heightPanel.add( heightE );
  
        // result panel 
        resultText = new JTextField( 7 ); 
        resultText.setText( "137" );
        resultText.setEditable( false ); 
        resultLabl = new JLabel( "Ideal Weight" ); 
        resultPanel = new JPanel(); 
        resultPanel.add( resultLabl ); 
        resultPanel.add( resultText ); 
  
        // frame 
        setLayout( new BorderLayout() ); 
        add( genderPanel, BorderLayout.WEST ); 
        add( heightPanel, BorderLayout.EAST ); 
        add( resultPanel, BorderLayout.SOUTH ); 
    } 
  
    public void actionPerformed( ActionEvent evt ) 
    {
        int height = Integer.parseInt(  heightGroup.getSelection().getActionCommand());
        if ( genderGroup.getSelection().getActionCommand().equals( "Male" ))
        {
            Integer weight = (height*height)/28;
            resultText.setText( Integer.toString( weight ) );
        }
        if ( genderGroup.getSelection().getActionCommand().equals( "Female" ))
        {
            Integer weight = (height*height)/30;        
            resultText.setText( Integer.toString( weight ) );
        }
        repaint();
    }
    
    public static void main( String[] args )
    {
        Ex1_IdealWeight weightApp = new Ex1_IdealWeight();
        weightApp.setSize( 250, 225 );
        weightApp.setResizable( false );
        weightApp.setVisible( true );
    }
}
