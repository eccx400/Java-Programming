import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
    
public class LayoutEg2 extends JFrame 
{ 
    JLabel[] array = new JLabel[6];  
    JTextField[] text = new JTextField[6]; 
    JPanel[] panels = new JPanel[6]; 
  
    // create top and bottom panels that will hold the small panels 
    JPanel pnTop = new JPanel(); 
    JPanel pnBot = new JPanel(); 
  
  
    public LayoutEg2() 
    { 
        setTitle( "LayoutEg2" ); 
  
        for ( int count = 0; count < 6; count++ ) 
        { 
            array[count] = new JLabel( "Data Item " + ( count + 1 ) ); 
            text[count] = new JTextField( 7 ); 
            panels[count] = new JPanel(); 
        } 
  
        for ( int count = 0; count < 6; count++ ) 
        { 
            panels[count].add( array[count] ); 
            panels[count].add( text[count] ); 
        } 
  
        // add the pair panels to the top and bottom panels 
        pnTop.add( panels[0] ); 
        pnTop.add( panels[1] ); 
        pnTop.add( panels[2] ); 
  
        pnBot.add( panels[3] ); 
        pnBot.add( panels[4] ); 
        pnBot.add( panels[5] ); 
  
        // add the top and bottom panels to the frame 
        setLayout( new FlowLayout() ); 
        add( pnTop ); 
        add( pnBot); 
  
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    } 
  
  
    public static void main( String[] args ) 
    { 
        LayoutEg2 leg = new LayoutEg2(); 
        leg.setSize( 525, 150 ); 
        leg.setVisible( true ); 
    } 
} 
