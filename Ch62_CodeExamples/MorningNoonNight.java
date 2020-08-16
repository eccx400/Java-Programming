import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
  
  
public class MorningNoonNight extends JFrame implements ActionListener 
{ 
    JLabel[] labels = new JLabel[7]; 
    JTextField[] text = new JTextField[7]; 
  
    JPanel[] panel = new JPanel[7];
    JPanel dataPanel = new JPanel(); 
  
    JButton butMorn = new JButton( "Morning" ); 
    JButton butNoon = new JButton( "Noon" ); 
    JButton butNite = new JButton( "Night" ); 
  
    JPanel MTWPanel = new JPanel(); 
    JPanel RFSPanel = new JPanel(); 
    JPanel SunPanel = new JPanel(); 
    JPanel butPanel = new JPanel(); 
  
  
    public MorningNoonNight() 
    { 
        setTitle( "Morning Noon Night" ); 
  
        for ( int x = 0; x < 7; x++ ) 
        { 
            panel[x] = new JPanel();
            text[x] = new JTextField( 7 );  
        } 
  
        labels[0] = new JLabel( "Monday" ); 
        labels[1] = new JLabel( "Tuesday" ); 
        labels[2] = new JLabel( "Wednesday" ); 
        labels[3] = new JLabel( "Thursday" ); 
        labels[4] = new JLabel( "Friday" ); 
        labels[5] = new JLabel( "Saturday" ); 
        labels[6] = new JLabel( "Sunday" ); 
  
        for ( int x = 0; x < 7; x++ ) 
        { 
            panel[x].add( text[x] ); 
            panel[x].add( labels[x] ); 
        } 
  
        MTWPanel.add( panel[0] ); 
        MTWPanel.add( panel[1] ); 
        MTWPanel.add( panel[2] ); 
  
        RFSPanel.add( panel[3] ); 
        RFSPanel.add( panel[4] ); 
        RFSPanel.add( panel[5] ); 
  
        SunPanel.add( panel[6] ); 
  
        butPanel.add( butMorn ); 
        butPanel.add( butNoon ); 
        butPanel.add( butNite ); 
  
        dataPanel.setLayout( new BoxLayout( dataPanel, BoxLayout.Y_AXIS ) ); 
        dataPanel.add( MTWPanel ); 
        dataPanel.add( RFSPanel ); 
        dataPanel.add( SunPanel ); 
  
        setLayout( new FlowLayout() ); 
        add( dataPanel ); 
        add( butPanel ); 
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    } 
  
    public void actionPerformed( ActionEvent evt ) 
    { 
        repaint(); 
    } 
  
    public static void main( String[] args ) 
    { 
        MorningNoonNight mnn = new MorningNoonNight(); 
  
        mnn.setSize( 500, 225 ); 
        mnn.setResizable( false ); 
        mnn.setVisible( true ); 
    } 
}
