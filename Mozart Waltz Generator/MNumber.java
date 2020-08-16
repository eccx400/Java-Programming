import java.awt.*;
import javax.swing.*;

/**
 * A JPanel that contains a JLabel that can be clicked on
 */
public class MNumber extends JPanel
{
    private static int width= 28;  // width of panel
    private static int height= 23; // height of panel
    
    private Rectangle b;   // Containing rectangle of this square
    private int col;   // column number of this square on board
    private int row;   // row number of this square on board
    private int label; // the number in this square
    private boolean isTrio; // true: square is for a trio. false it is for a minuet.
    
    /**
     * Constructor: A square with label n that belongs in column c, row r.
     * Parameter isTrio indicates whether it is a trio or a minuet square
     */
    public MNumber( int c, int r, int n, boolean isTrio )
    {
        super();
        col = c;
        row = r;
        label = n;
        this.isTrio = isTrio;
        setSize( width, height );
        setPreferredSize( new Dimension( width, height ) );
        b = getBounds();
        repaint();
    }
       
    /**
     * = the label in this JPanel
     */
    public int getLabel()
    {
        return label;
    }

    /** = "this square is for a trio". */
    public boolean isTrio()
    {
        return isTrio;
    }

    /**
     * Paint the square, using Graphics g.
     */
    public void paint( Graphics g )
    {
        Color save = g.getColor(); // Save the color, to be reset at end
        if ( isTrio )
        {
            g.setColor( Color.red );
        }
        else
        {
            g.setColor( Color.blue );
        }
        g.drawRect( b.x, b.y, b.width - 1, b.height - 1 );
        g.setColor( Color.black );
        g.drawString( make3( label ), 2, b.height - 6 );
        g.setColor( save );
    }

    /**
     * = n, preceded by blanks if necessary to make it 3 digits.
     * Precondition: 0 <= n < 1000.
     */
    public static String make3( int n )
    {
        if ( n < 10 )
            return "  " + n;
        if ( n < 100 )
            return " " + n;
        return "" + n;
    }

    /**
     * = representation of this object
     */
    public String toString()
    {
        return ( isTrio ? "trio[" : "minuet[" ) + row + ", " + col + "] = "
            + label;
    }
}