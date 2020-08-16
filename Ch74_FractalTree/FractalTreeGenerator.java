import java.applet.Applet;
import java.awt.*;

import javax.swing.*;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
   Fractal Tree Generator

   @author  George Peck
   @version Mar 28, 2007

   Period - 1-7
   Assignment - Ch74_FractalTreeSoln

   Sources - Art Simon
             Lowell High School
             San Francisco
 */
public class FractalTreeGenerator extends JApplet implements AdjustmentListener
{
    /**
     * 
     */
    Tree joyce;
    Scrollbar branchAngle, fractionLength, smallestBranch;
    Graphics offscreen;
    Image image;

    public void init()
    {
        TreePanel displayPanel = new TreePanel();

        JPanel content = new JPanel();
        content.setLayout( new BorderLayout() );
        content.add( displayPanel, BorderLayout.CENTER );
        setContentPane( content );

        image = createImage( 800, 800 );
        offscreen = image.getGraphics();
        displayPanel.setLayout( null );
        joyce = new Tree( 400, 700, 400, 600 );
        setBackground( Color.black );

        branchAngle = new Scrollbar( 0, 20, 10, 0, 200 );
        fractionLength = new Scrollbar( 0, 80, 5, 50, 92 );
        smallestBranch = new Scrollbar( 0, 10, 1, 5, 20 );

        displayPanel.add(branchAngle);
        displayPanel.add(fractionLength);
        displayPanel.add(smallestBranch);

        branchAngle.addAdjustmentListener( this );
        branchAngle.setBounds( 20, 30, 170, 20 );
        fractionLength.addAdjustmentListener( this );
        fractionLength.setBounds( 20, 80, 170, 20 );
        smallestBranch.addAdjustmentListener( this );
        smallestBranch.setBounds( 20, 130, 170, 20 );
        setSize(1000, 800);
    }

    public class TreePanel extends JPanel
    {
        public void paintComponent( Graphics g )
        {
            super.paintComponent( g );

            Container applet = getContentPane();
            int width = applet.getWidth();
            int height = applet.getHeight();

            offscreen.setColor( Color.black );
            offscreen.fillRect( 0, 0, width, height );
            joyce.draw( offscreen );
            offscreen.drawString( ( new StringBuilder() ).append( "Branch Angle +/- " )
                .append( (int)Math.toDegrees( joyce.dBranchAngle ) )
                .append( " degrees" ).toString(), 20, 20 );
            offscreen.drawString( ( new StringBuilder() ).append( "Each branch is " )
                .append( joyce.dFractionLength )
                .append( " as big as the previous branch" ).toString(), 20, 70 );
            offscreen.drawString( ( new StringBuilder() ).append( "Size of the smallest branches is " )
                .append( joyce.nSmallestBranch ).toString(), 20, 120 );
            g.drawImage( image, 0, 0, this );
        }
    }

    public void adjustmentValueChanged( AdjustmentEvent adjustmentevent )
    {
        if ( adjustmentevent.getSource().equals( branchAngle ) )
            joyce.dBranchAngle = adjustmentevent.getValue() / 100.0;
        else if ( adjustmentevent.getSource().equals( fractionLength ) )
            joyce.dFractionLength = adjustmentevent.getValue() / 100.0;
        else
            joyce.nSmallestBranch = adjustmentevent.getValue();
        repaint();
    }
}
