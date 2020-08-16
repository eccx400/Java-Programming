import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   An improved ideal weight calculator takes into account the type of (human)
   frame. Add another panel of radio buttons that allow the user to choose a
   small, medium, or large frame. Multiply the result of the above ideal 
   weight calculation by 0.95 for small frame, 1.0 for medium frame, and
   1.05 for large frame.

   @author  Eric Cheng
   @version 6 April 2014

   @author  Period - 6
   @author  Assignment - Ex3_SmallMedLargeFrame

   @author  Sources - Eric Cheng
 */
public class Ex3_SmallMedLargeFrame extends JFrame implements ActionListener
{
    private JRadioButton genderM, genderF;
    private ButtonGroup genderGroup;
    private JPanel genderPanel;

    private JRadioButton heightA, heightB, heightC, heightD, heightE;
    private ButtonGroup heightGroup;
    private JPanel heightPanel;
    
    private JRadioButton small, medium, large;
    private ButtonGroup frame;
    private JPanel framePanel;

    private JTextField resultText;
    private JLabel resultLabl;
    private JPanel resultPanel;
    
    public Ex3_SmallMedLargeFrame()
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

        genderPanel.add( Box.createHorizontalGlue() );
        genderPanel.add( Box.createVerticalGlue());
        
        // height group
        large = new JRadioButton("Large", false);
        large.addActionListener( this );
        large.setActionCommand( "1.05" );
        
        medium = new JRadioButton("Medium", false);
        medium.setActionCommand( "1.00" );
        medium.addActionListener( this );
        
        small = new JRadioButton("Small",true);
        small.addActionListener( this );
        small.setActionCommand( "0.95" );

        
        frame = new ButtonGroup();
        frame.add( small );
        frame.add( medium );
        frame.add( large );
        
        framePanel = new JPanel();
        framePanel.setLayout( new BoxLayout( framePanel, BoxLayout.Y_AXIS));
        framePanel.add( new JLabel("Frame Size") );
        framePanel.add( small );
        framePanel.add( medium );
        framePanel.add( large );
        
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
        
        // result panel
        resultText = new JTextField( 7 );
        resultText.setEditable( false );
        resultText.setText( "137" );
        resultLabl = new JLabel( "Ideal Weight" );
        resultPanel = new JPanel();
        resultPanel.add( resultLabl );
        resultPanel.add( resultText );

        // frame
        setLayout( new BorderLayout() );
        add( genderPanel, BorderLayout.WEST );
        add( heightPanel, BorderLayout.CENTER );
        add( framePanel, BorderLayout.EAST);
        add( resultPanel, BorderLayout.SOUTH );
    }
    public void actionPerformed( ActionEvent evt )
    {
        int height = Integer.parseInt(  heightGroup.getSelection().getActionCommand());
        double bframe = Double.parseDouble( frame.getSelection().getActionCommand() );
        if ( genderGroup.getSelection().getActionCommand().equals( "Male" ))
        {
            Double weight = ((height*height)/28)*bframe;
            resultText.setText( Double.toString( weight ) );
        }
        if ( genderGroup.getSelection().getActionCommand().equals( "Female" ))
        {
            Double weight = ((height*height)/30)*bframe;        
            resultText.setText( Double.toString( weight ) );
        }
        repaint();
    }

    public static void main( String[] args )
    {
        Ex3_SmallMedLargeFrame weightApp = new Ex3_SmallMedLargeFrame();
        weightApp.setSize( 250, 225 );
        weightApp.setVisible( true );
    }
}
