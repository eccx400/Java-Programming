import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
  
public class PercentFatPanel extends JFrame implements ActionListener
{
  JLabel heading    = new JLabel("Percent of Calories from Fat");
  JLabel fatLabel   = new JLabel("Enter grams of fat:   ");
  JLabel calLabel   = new JLabel("Enter total calories: ");
  JLabel perLabel   = new JLabel("Percent calories from fat: ");
   
  JTextField inFat  = new JTextField( 7 );
  JTextField inCal  = new JTextField( 7 );
  JTextField outPer = new JTextField( 7 );
   
  JButton    doit   = new JButton("Do It!");
  
  JPanel hedPanel   = new JPanel();
  JPanel fatPanel   = new JPanel();
  JPanel calPanel   = new JPanel();
  JPanel perPanel   = new JPanel();   
  JPanel butPanel   = new JPanel();   
  
  int calories ;  // input: total calories per serving
  int fatGrams ;  // input: grams of fat per serving
  double percent; // result: percent of calories from fat
  
  public PercentFatPanel()  
  { 
    setTitle( "Calories from Fat" );
    outPer.setEditable( false );   
    setLayout( new FlowLayout() ); 
   
    // Add components to Panels
    hedPanel.add( heading );
    fatPanel.add( fatLabel );
    fatPanel.add( inFat );
    calPanel.add( calLabel );
    calPanel.add( inCal );
    perPanel.add( perLabel );
    perPanel.add( outPer );
    butPanel.add( doit );

    // Add Panels to Frame     
    add( hedPanel );
    add( heading );
    add( fatPanel );
    add( calPanel );
    add( perPanel );
    add( doit );
    add( butPanel );
  
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
    doit.addActionListener( this );   
  }
  
  // The application
  public void calcPercent( ) 
  {
    percent = ( (fatGrams * 9.0) / calories ) * 100.0 ;
  }
  
  public void actionPerformed( ActionEvent evt) 
  {
    String userIn ;
    userIn    = inFat.getText()  ;
    fatGrams  = Integer.parseInt( userIn ) ;
  
    userIn    = inCal.getText()  ;
    calories  = Integer.parseInt( userIn ) ; 
    calcPercent() ;
  
    outPer.setText( (percent+"      ").substring(0,6) );
    repaint();                 
  }
  
  public static void main ( String[] args )
  {
    PercentFatPanel fatApp  = new PercentFatPanel() ; 
    fatApp.setSize( 300, 225 );  
    fatApp.setResizable( false );
    fatApp.setVisible( true );        
  }
}