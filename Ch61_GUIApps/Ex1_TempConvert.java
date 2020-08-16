import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   Modify the temperature conversion program so that it converts Celsius to
    Fahrenheit. Use the formula: fahr = celsius*9/5 + 32

   @author  Eric Cheng
   @version 29 March 2014

   @author  Period - 6
   @author  Assignment - Ex1_TempConvert

   @author  Sources - Eric Cheng
 */
public class Ex1_TempConvert extends JFrame implements ActionListener
{
    private JLabel title = new JLabel( "Convert Fahrenheit to Celsius" );
    private JLabel inLabel = new JLabel( "    Celsius  " );   
    private JLabel outLabel = new JLabel( "          Fahrenheit " ); 
  

    private JTextField inCel = new JTextField( 7 );
    private JTextField outFahr = new JTextField( 7 );

    private int fahrTemp;
    private int celsTemp;

    public Ex1_TempConvert()
    {
        getContentPane().setLayout( new FlowLayout() );

        inCel.addActionListener( this );
        getContentPane().add( title );
        getContentPane().add( inLabel );
        getContentPane().add( outLabel );
        getContentPane().add( inCel );
        getContentPane().add( outFahr );
        outFahr.setEditable( false );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }
    //Switches Celcius to Fahrenheit
    public void convert()
    {
        fahrTemp = ( ( celsTemp * 9 ) / 5 ) + 32; 
    }

    public void actionPerformed( ActionEvent evt )
    {
        String input = inCel.getText(); 
        celsTemp = Integer.parseInt( input ); 
  
        convert(); 
  
        outFahr.setText( fahrTemp + " " ); 
        repaint(); 
    }

    public static void main( String[] args )
    {
        Ex1_TempConvert fahr = new Ex1_TempConvert();

        fahr.setSize( 225, 150 );
        fahr.setVisible( true );
    }
}