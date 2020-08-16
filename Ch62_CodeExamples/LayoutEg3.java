import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
  
  
public class LayoutEg3 extends JFrame 
{ 
    JLabel[] array = new JLabel[6]; 
    JTextField[] text = new JTextField[6]; 
    JPanel[] panels = new JPanel[6]; 
  
    // create top and bottom panels that will hold the small panels 
    JPanel pnLeft = new JPanel(); 
    JPanel pnRight = new JPanel(); 
  
  
    public LayoutEg3() 
    { 
        setTitle( "LayoutEg3 Box Alignment" ); 
  
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
  
        // set layout manager for left panel, add three small panels to it 
        pnLeft.setLayout( new BoxLayout( pnLeft, BoxLayout.Y_AXIS ) ); 
        pnLeft.add( panels[0] ); 
        pnLeft.add( panels[1] ); 
        pnLeft.add( panels[2] ); 
  
        // set layout manager for right panel, add three small panels to it 
        pnRight.setLayout( new BoxLayout( pnRight, BoxLayout.Y_AXIS ) ); 
        pnRight.add( panels[3] ); 
        pnRight.add( panels[4] ); 
        pnRight.add( panels[5] ); 
  
        // add left and right panels to the frame 
        setLayout( new FlowLayout() ); 
        add( pnLeft ); 
        add( pnRight ); 
  
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    } 
  
    public static void main( String[] args ) 
    { 
        LayoutEg3 leg = new LayoutEg3(); 
        leg.setSize( 525, 150 ); 
        leg.setVisible( true ); 
    } 
}
