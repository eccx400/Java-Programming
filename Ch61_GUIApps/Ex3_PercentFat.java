import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

/**
  Modify the calories from fat calculator so that it does not crash when the
  user enters text that cannot be converted to a double. You might have to
  look ahead to chapters 80 and 81 for this, or look at the modification
  done with the temperature converter and try to do something similar.

   @author Eric Cheng
   @version 29 March 2014

   @author  TPeriod - 6
   @author  TAssignment - Ex2_TwoWayConvert

   @author  TSources - Eric Cheng
 */
public class Ex3_PercentFat extends JFrame implements ActionListener
{
    private JLabel heading = new JLabel( "Percent of Calories from Fat" );
    private JLabel fatLabel = new JLabel( "Enter grams of fat:   " );
    private JLabel calLabel = new JLabel( "Enter total calories: " );
    private JLabel perLabel = new JLabel( "Percent calories from fat: " );

    private JTextField inFat = new JTextField( 7 );
    private JTextField inCal = new JTextField( 7 );
    private JTextField outPer = new JTextField( 7 );

    private JButton faire = new JButton( "Le-fait!" );

    private double calories; // input: total calories per serving
    private double fatGrams; // input: grams of fat per serving
    private double percent; // result: percent of calories from fat

    public Ex3_PercentFat()
    {
        setTitle( "Calories from Fat" );
        setLayout( new FlowLayout() );

        add( heading );
        add( fatLabel );
        add( inFat );
        add( calLabel );
        add( inCal );
        add( perLabel );
        add( outPer );
        
        outPer.setEditable( false );

        add( faire );
        faire.addActionListener( this );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    // The application
    public void calcPercent()
    {
        percent = ( ( fatGrams * 9 ) / calories ) * 100;
    }

    public void actionPerformed( ActionEvent evt )
    {
        String input;
        input = inFat.getText();
        fatGrams = Double.parseDouble( input );

        input = inCal.getText();
        calories = Double.parseDouble( input );

        calcPercent();

        // Convert percent to a string and write it to the output field
        outPer.setText( new DecimalFormat( "#0.0##" ).format( percent ) );
        repaint();
    }

    public static void main( String[] args )
    {
        Ex3_PercentFat fatApp = new Ex3_PercentFat();
        fatApp.setSize( 280, 200 );
        fatApp.setVisible( true );
    }
}
