import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
    Finish the graphical interface code that uses glue to separate the two
    button panels. Experiment with adding more glue, perhaps to the left 
    and right of the button panels, between the buttons, and between the 
    button box and the result panel. Resize the display of the frame to see 
    the effect of glue. Add the application code from exercise 1.
   
    @author  Eric Cheng
    @version 6 April 2014

    @author  Period - 6
    @author  Assignment - Ex2_IdealWeightWithGlue
   
    @author  Sources - Eric Cheng
 */
public class Ex2_IdealWeightWithGlue extends JFrame implements ActionListener 
{
    private JRadioButton genderM, genderF;
    private ButtonGroup genderGroup;
    private JPanel genderPanel;
    
    private Box buttonBox; 
    private Box heightBox;
    private Box genderBox; 

    private JRadioButton heightA, heightB, heightC, heightD, heightE;
    private ButtonGroup heightGroup;
    private JPanel heightPanel;

    private JTextField resultText;
    private JLabel resultLabl;
    private JPanel resultPanel;
    
    public Ex2_IdealWeightWithGlue() 
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
        
        genderBox = new Box( BoxLayout.Y_AXIS ); 
        genderBox.add( Box.createHorizontalGlue() ); 
        genderBox.add( new JLabel( "Your Gender" ) ); 
        genderBox.add( Box.createRigidArea( new Dimension( 1, 8 ) ) ); 
        genderBox.add( genderM ); 
        genderBox.add( genderF ); 
        genderBox.add( Box.createRigidArea( new Dimension( 1, 73 ) ) ); 
    
        genderPanel.add( Box.createHorizontalGlue() );
        genderPanel.add( Box.createVerticalGlue());
    
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
    
        heightPanel.add( Box.createHorizontalGlue() );
        heightPanel.add( Box.createVerticalGlue());
        
        heightBox = new Box( BoxLayout.Y_AXIS ); 
        heightBox.add( Box.createHorizontalGlue() ); 
        heightBox.add( new JLabel( "Your Height" ) ); 
        heightBox.add( Box.createRigidArea( new Dimension( 1, 8 ) ) ); 
        heightBox.add( heightA ); 
        heightBox.add( heightB ); 
        heightBox.add( heightC ); 
        heightBox.add( heightD ); 
        heightBox.add( heightE ); 
        heightBox.add( Box.createHorizontalGlue() );
    
    // button Box 
    buttonBox = new Box( BoxLayout.X_AXIS ); 
    buttonBox.add( Box.createHorizontalGlue() ); 
    buttonBox.add( genderBox ); 
    buttonBox.add( Box.createHorizontalGlue() ); 
    buttonBox.add( heightBox ); 
    buttonBox.add( Box.createHorizontalGlue() ); 
    buttonBox.add( Box.createVerticalGlue() ); 

    // result panel 
    resultText = new JTextField( 7 ); 
    resultText.setText( "137" );
    resultText.setEditable( false ); 
    resultLabl = new JLabel( "Ideal Weight" ); 
    resultPanel = new JPanel(); 
    resultPanel.add( resultLabl ); 
    resultPanel.add( resultText ); 
    
    // frame 
    setLayout( new BoxLayout( getContentPane(), BoxLayout.Y_AXIS ) ); 
    add( buttonBox ); 
    add( resultPanel ); 
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
        Ex2_IdealWeightWithGlue weightApp = new Ex2_IdealWeightWithGlue();
        weightApp.setSize( 250, 225 );
        weightApp.setResizable( true );
        weightApp.setVisible( true );
    }
}

    /**
     * @Override
     *
    public void actionPerformed( ActionEvent arg0 )
        {
            // TODO Auto-generated method stub  
        }
    */
