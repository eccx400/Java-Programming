import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   Add two buttons to the temperature conversion program. Clicking one button
   converts Fahrenheit to Celsius, clicking the other converts Celsius to 
   Fahrenheit. Set to "noneditable" whichever text field is to contain the
   result of the conversion. Add a "clear" button that clears the text in
   both text fields.

   @author  Eric Cheng
   @version 29 March 2014

   @author  Period - 6
   @author  Assignment - Ex2_TwoWayConvert

   @author  Sources - Eric Cheng
 */
public class Ex2_TwoWayConvert extends JFrame implements ActionListener
{
    private JLabel title = new JLabel( "Convert Fahrenheit to Celsius" );
    private JLabel inLabel = new JLabel( "Fahrenheit    " );
    private JLabel outLabel = new JLabel( "Celsius " );

    private JTextField inFahr = new JTextField( 7 );
    private JTextField outCel = new JTextField( 7 );

    private int fahrTemp;
    private int celsTemp;

    private JButton fToC = new JButton( "Fahrenheit to Celcius" ); 
    private JButton cToF = new JButton( "Celcius to Fahrenheit" ); 
    private JButton clear = new JButton( "Clear" ); 
    
    boolean f = true; 
  
    String fc = "Fahrenheit    ";   
    String cf = "Celsius "; 
    
    public Ex2_TwoWayConvert()
    {
        getContentPane().setLayout( new FlowLayout() );

        inFahr.addActionListener( this );
        getContentPane().add( title );
        getContentPane().add( inLabel );
        getContentPane().add( outLabel );
        getContentPane().add( inFahr );
        getContentPane().add( outCel );
        outCel.setEditable( false );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

    public void convert()
    {
        celsTemp = ( ( fahrTemp - 32 ) * 5 ) / 9;
    }

    public void actionPerformed( ActionEvent evt )
    {
        String input = inFahr.getText();
        fahrTemp = Integer.parseInt( input );

        convert();

        outCel.setText( celsTemp + " " );
        repaint();
    }

    public static void main( String[] args )
    {
        Ex2_TwoWayConvert fahr = new Ex2_TwoWayConvert();

        fahr.setSize( 225, 150 );
        fahr.setVisible( true );
    }
}