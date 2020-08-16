import java.awt.FlowLayout; 
  
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 
  
  
public class LayoutEg1 extends JFrame 
{ 
    JLabel lData1 = new JLabel( "Data Item 1" ); 
    JTextField txData1 = new JTextField( 7 ); 
    JPanel panel1 = new JPanel(); 
  
    JLabel lData2 = new JLabel( "Data Item 2" ); 
    JTextField txData2 = new JTextField( 7 ); 
    JPanel panel2 = new JPanel(); 
  
    JLabel lData3 = new JLabel( "Data Item 3" ); 
    JTextField txData3 = new JTextField( 7 ); 
    JPanel panel3 = new JPanel(); 
  
  
    public LayoutEg1() 
    { 
        panel1.add( lData1 ); 
        panel1.add( txData1 ); 
        panel2.add( lData2 ); 
        panel2.add( txData2 ); 
        panel3.add( lData3 ); 
        panel3.add( txData3 ); 
  
        setLayout( new FlowLayout() ); 
        add( panel1 ); 
        add( panel2 ); 
        add( panel3 ); 
  
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    } 
}
