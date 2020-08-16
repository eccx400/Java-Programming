import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;

/**
 * This program draws a house using the graphics program
 * 
 * @author Eric Cheng
 * @version March 17, 2014
 * 
 * @author Period - 6
 * @author Assignment - Ch56 Ex1_ThisOldHouse
 * @author Sources - Eric Cheng
 */
public class Ex1_ThisOldHouse extends JFrame
{
    /**
     * Creates the display panel and adds it
     * to the JFrame.
     */
    public Ex1_ThisOldHouse()
    {
        Display displayPanel = new Display();

        JPanel content = new JPanel();
        content.setLayout( new BorderLayout() );
        content.add( displayPanel, BorderLayout.CENTER );
        setContentPane( content );
        setTitle( "JFrame House" );
    }

    /**
     * Defines the display panel.
     */
    private class Display extends JPanel
    {
        public void paintComponent( Graphics gr )
        {
            super.paintComponent( gr );

            int width = getContentPane().getWidth();
            int height = getContentPane().getHeight();
            setBackground(Color.WHITE);

            gr.setColor( Color.BLUE ); 
            gr.drawRect( 0, 0, width - 1, height - 1 ); 
            String str = " "; 
            
            Font curFont = gr.getFont();
            FontMetrics curFontMetrics = gr.getFontMetrics( curFont );
            Rectangle2D r2d = curFontMetrics.getStringBounds( str, gr );

            int strWidth = (int)( (Rectangle2D.Float)r2d ).width;
            int strHeight = (int)( (Rectangle2D.Float)r2d ).height;
            gr.setColor( Color.RED );
            gr.drawString( str, ( width - strWidth ) / 2, ( height + strHeight ) / 2 );

            gr.drawLine( 0, 5 * height / 8, width / 8, 5 * height / 8 ); 
            gr.drawLine( 7 * width / 8, 5 * height / 8, width - 1, 
                5 * height / 8 ); 
            gr.drawRect( width / 8, 3 * height / 8, 3 * width / 4,
                3 * height / 8 ); 
            gr.drawLine( width / 8, 3 * height / 8, width / 2, height / 8 ); 
            gr.drawLine( width / 2, height / 8, 7 * width / 8, 3 * height / 8 ); 
            gr.drawRect( width / 4, height / 2, width / 8, height / 8 ); 
            gr.drawOval( 7 * width / 16, 5 * height / 8, width / 32,
                height / 32 ); 
            gr.drawRect( 5 * width / 8, height / 2, width / 8, height / 8 ); 
            gr.drawRect( 7 * width / 16, height / 2, width / 8, height / 4 ); 
            gr.drawLine( width / 4, 7 * height / 24, width / 4, 3 * height / 16 ); 
            gr.drawLine( width / 4, 3 * height / 16, 5 * width / 16, 
                3 * height / 16 ); 
            gr.drawLine( 5 * width / 16,   height / 4, 5 * width / 16, 
                3 * height / 16 ); 
        }
    }
    
    /**
     * Creates, sizes and enables the display of this JFrame.
     * 
     * @param args  command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        Ex1_ThisOldHouse frm = new Ex1_ThisOldHouse();

        frm.setSize( 400, 300 );
        frm.setLocation( 100, 100 );
        frm.setVisible( true );
    }
}
