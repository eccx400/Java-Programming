import java.awt.*; 
import java.awt.event.*; 
  
import javax.swing.*; 
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener; 

/**
    Write the ideal weight calculator so that height in inches is entered by
    using a slider. Use the approximate formula:

    W = H2 / 30 , for female

    W = H2 / 28 , for male
    where W is the ideal weight in pounds, H is the height in inches
    Set an action command for each radio button using setActionCommand(String)
    just as for push buttons. Add an action listener for each button using 
    addActionListener(). Add a change listener for the slider using
    addChangeListener(). The ideal weight should be displayed in a text 
    field when the user changes either a radio button or the slider.

    Pick initial settings for the buttons and slider. When the program starts
    up display the ideal weight for those settings.

   @author  Eric Cheng
   @version 8 April 2014

   @author  Period - 6
   @author  Assignment - Ex1_IdealWeightWithSlider

   @author  Sources - Eric Cheng
 */
public class Ex1_IdealWeightWithSlider extends JFrame implements ChangeListener, 
ActionListener 
{
    private JRadioButton genderM, genderF; 
   
    JSlider slider; 

    private ButtonGroup genderGroup; 
  
    private JPanel genderPanel; 
    private JPanel heightPanel; 
   
    private JTextField resultText; 
    private JLabel resultLabl; 
    private JPanel resultPanel; 
  
    private int height; 
    private int gender = 28; 
    private int result; 

    public Ex1_IdealWeightWithSlider() 
    { 
        setTitle( "Your Ideal Weight" ); 
        setDefaultCloseOperation( EXIT_ON_CLOSE ); 
  
        // gender group 
        genderM = new JRadioButton( "Male", true ); 
        genderF = new JRadioButton( "Female", false ); 
        genderM.addActionListener( this ); 
        genderF.addActionListener( this );
        genderM.setActionCommand( "28" );  
        genderF.setActionCommand( "30" ); 
        
        genderGroup = new ButtonGroup();
        genderGroup.add( genderM );
        genderGroup.add( genderF );
        genderPanel = new JPanel();
        genderPanel.setLayout( new BoxLayout( genderPanel, BoxLayout.Y_AXIS ) );
        genderPanel.add( new JLabel( "Your Gender" ) );
        genderPanel.add( genderM );
        genderPanel.add( genderF );
  
        // height group 
        slider = new JSlider( JSlider.VERTICAL, 40, 80, 58 ); 
        slider.setMajorTickSpacing( 10 ); 
        slider.setMinorTickSpacing( 1 ); 
        slider.setPaintTicks( true ); 
        slider.setPaintLabels( true ); 
        slider.setPreferredSize( new Dimension( 300, 250 ) ); 
        slider.addChangeListener( this ); 
        slider.setName( "slider" ); 
  
        heightPanel = new JPanel(); 
        heightPanel.setLayout( new BoxLayout( heightPanel, BoxLayout.Y_AXIS ) ); 
        heightPanel.add( new JLabel( "Your Height in Inches" ) ); 
        heightPanel.add( slider ); 
  
        // result panel 
        resultText = new JTextField( 7 ); 
        resultText.setEditable( false ); 
        resultText.setText( "137" );
        resultPanel = new JPanel(); 
        resultLabl = new JLabel( "Ideal Weight" ); 
        resultPanel.add( resultLabl ); 
        resultPanel.add( resultText ); 
  
        // content pane 
        getContentPane().setLayout( new BorderLayout() ); 
        getContentPane().add( genderPanel, BorderLayout.WEST ); 
        getContentPane().add( heightPanel, BorderLayout.EAST ); 
        getContentPane().add( resultPanel, BorderLayout.SOUTH ); 
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE ); 
  
        // frame 
        setLayout( new FlowLayout() ); 
        add( slider ); 
        add( resultText ); 
    } 

    public static void main( String[] args )
    {
        Ex1_IdealWeightWithSlider weightApp = new Ex1_IdealWeightWithSlider();
        weightApp.setSize( 275, 500 );
        weightApp.setVisible( true );
    }

    public void actionPerformed( ActionEvent evt ) 
    { 
        if ( Integer.parseInt( evt.getActionCommand() ) <= 30 ) 
        { 
            gender = Integer.parseInt( evt.getActionCommand() ); 
        } 
        resultText.setText( "" + Math.round( height * height / gender ) ); 
        repaint();
    }
    
    public void stateChanged( ChangeEvent evt ) 
    { 
        JSlider source = (JSlider)evt.getSource(); 
        height = source.getValue(); 
        resultText.setText( "" + Math.round( height * height / gender ) ); 
    }
} 
