import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.Image;

/**
 * An instance provides a window that is used to play Mozart's dice game
 */
public class WurfelGUI extends JFrame
{
    /**
     * Each element of trio denotes an mp3 file that is one possible measure of
     * of a Mozart trio.
     */
    public final static int[][] trio = {
      { 72, 6, 59, 25, 81, 41, 89, 13, 36, 5, 46, 79, 30, 95, 19, 66 },
      { 56, 82, 42, 74, 14, 7, 26, 71, 76, 20, 64, 84, 8, 35, 47, 88 },
      { 75, 39, 54, 1, 65, 43, 15, 80, 9, 34, 93, 48, 69, 58, 90, 21 },
      { 40, 73, 16, 68, 29, 55, 2, 61, 22, 67, 49, 77, 57, 87, 33, 10 },
      { 83, 3, 28, 53, 37, 17, 44, 70, 63, 85, 32, 96, 12, 23, 50, 91 },
      { 18, 45, 62, 38, 4, 27, 52, 94, 11, 92, 24, 86, 51, 60, 78, 31 } };

    /**
     * Each element of minuet denotes an mp3 file thatis one possible measure of
     * a Mozart minuet.
     */
    public final static int[][] minuet = {
      { 96, 22, 141, 41, 105, 122, 11, 30, 70, 121, 26, 9, 112, 49, 109, 14 },
      { 32, 6, 128, 63, 146, 46, 134, 81, 117, 39, 126, 56, 174, 18, 116, 83 },
      { 69, 95, 158, 13, 153, 55, 110, 24, 66, 139, 15, 132, 73, 58, 145, 79 },
      { 40, 17, 113, 85, 161, 2, 159, 100, 90, 176, 7, 4, 67, 160, 52, 170 },
      { 148, 74, 163, 45, 80, 97, 36, 107, 25, 143, 64, 125, 76, 136, 1, 93 },
      { 104, 157, 27, 167, 154, 68, 118, 91, 138, 71, 150, 29, 101, 162, 23, 151 },
      { 152, 60, 171, 53, 99, 133, 21, 127, 16, 155, 57, 175, 43, 168, 89, 172 },
      { 119, 84, 114, 50, 140, 86, 169, 94, 120, 88, 48, 166, 51, 115, 72, 111 },
      { 98, 142, 42, 156, 75, 129, 62, 123, 65, 77, 19, 82, 137, 38, 149, 8 },
      { 3, 87, 165, 61, 135, 47, 147, 33, 102, 4, 31, 164, 44, 59, 173, 78 },
      { 54, 130, 10, 103, 28, 37, 106, 5, 35, 20, 108, 92, 12, 124, 44, 131 } };

    /**
     * Listener for mouse events
     */
    public MouseEvents listener = new MouseEvents();

    /** Buttons for the top part of the GUI */
    JButton button1 = new JButton( "GO!" ); // Create a waltz from the first row
    JButton button2 = new JButton( "GO!" ); // Create a random waltz
    JButton button3 = new JButton( "GO!" ); // Create a one-file waltz from the
                                            // last waltz created
    JButton button4 = new JButton( "GO!" ); // Print the last waltz created
    JButton button5 = new JButton( "GO!" ); // Play the last waltz created
    JButton button6 = new JButton( "GO!" ); // Save the one-file waltz
    
    ButtonListener buttonListener = new ButtonListener();

    /**
     * If no waltz has been created: lastWaltzS and lastWaltzD are null. If a
     * waltz has been created: lastWaltzS contains it. If the last waltz has
     * been compressed into a single file: lastWaltzD() contains it.
     * 
     * Whenever a new waltz is stored in lastWaltzS, lastWaltzD should be set to
     * null. Whenever a waltz is to be played, if lastWaltzD is not null, play
     * it; otherwise, if play lastWaltzS is not null, play it.
     */
    private String[] lastWaltzS;
    private double[] lastWaltzD;

    /**
     * Constructor: A window for playing Mozart's dice game.
     */
    public WurfelGUI()
    {
        setTitle( "Mozart's Dice Game -- WuerfelSpiel" );

        // Make all the trio things and add them to the JFrame.
        Box everything = new Box( BoxLayout.Y_AXIS );
        everything.add( makeTitleStuff() );
        everything.add( Box.createVerticalStrut( 3 ) );
        everything.add( makeButtons() );
        everything.add( Box.createVerticalStrut( 3 ) );
        everything.add( makeMinuet() );
        everything.add( Box.createVerticalStrut( 3 ) );
        everything.add( makeTrio() );

        getContentPane().add( everything, BorderLayout.CENTER );

        pack();
        setVisible( true );
    }

    /**
     * Fix the button box and return it
     */
    public Box makeButtons()
    {
        Box buttonBox = new Box( BoxLayout.Y_AXIS );

        Box b1 = makeButtonBox( button1,
        "Create a waltz from the first row of the minuet and trio tables." );
        buttonBox.add( b1 );

        Box b2 = makeButtonBox( button2, "Create a random waltz." );
        buttonBox.add( b2 );

        Box b3 = makeButtonBox( button3,
        "Compress the last waltz into a single file." );
        buttonBox.add( b3 );

        Box b4 = makeButtonBox( button4, "Print the last waltz created." );
        buttonBox.add( b4 );

        Box b5 = makeButtonBox( button5, "Play the last waltz created." );
        buttonBox.add( b5 );

        Box b6 = makeButtonBox( button6, "Save the single-file version." );
        buttonBox.add( b6 );

        buttonBox.setBorder( new LineBorder( Color.green, 2, true ) );
        return buttonBox;
    }

    /**
     * an x-axis Box with button b and label with string s. Also, add
     * buttonListener as a listener for b
     */
    public Box makeButtonBox( JButton b, String s )
    {
        Box box = new Box( BoxLayout.X_AXIS );
        box.add( b );
        JLabel j = new JLabel( s );
        box.add( j );
        box.add( Box.createHorizontalGlue() );
        b.addActionListener( buttonListener );
        return box;
    }

    /**
     * Make title info box and return it
     */
    public Box makeTitleStuff()
    {
        Box titleStuff = new Box( BoxLayout.X_AXIS );

        Box text = new Box( BoxLayout.Y_AXIS );
        JLabel title1 = new JLabel( "Wikipedia will tell you that dice games (WuerfelSpiele) to" );
        JLabel title2 = new JLabel( "generate music were popular in the 18th century. Mozart is" );
        JLabel title3 = new JLabel( "supposed to have developed a game. You can read about it here:" );
        JLabel title4 = new JLabel( "     " );
        JLabel title5 = new JLabel( "     www.asahi-net.or.jp/~rb5h-ngc/e/k516f.htm" );
        JLabel title6 = new JLabel( "     " );
        JLabel title7 = new JLabel( "We got the idea used here from Bob Sedgewick of Princeton." );
        text.add( title1 );
        text.add( title2 );
        text.add( title3 );
        text.add( title4 );
        text.add( title5 );
        text.add( title6 );
        text.add( title7 );
        text.add( Box.createVerticalStrut( 3 ) );

        titleStuff.add( Box.createHorizontalGlue() );
        titleStuff.add( text );
        titleStuff.add( Box.createHorizontalGlue() );

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image im = toolkit.getImage( "mozart.jpg" );
        titleStuff.add( new PanelImage( im ) );
        return titleStuff;
    }

    /**
     * Fix the trio box and return it. The labels have field listener as their
     * mouse listener
     */
    public Box makeTrio()
    {
        Box trioStuff = new Box( BoxLayout.Y_AXIS );
        JLabel trioTitle1 = new JLabel( "Below, each integer represents a trio measure." );
        JLabel trioTitle2 = new JLabel( "Click one to listen to it." );
        JLabel trioTitle3 = new JLabel( "A random 16-measure trio is made from a random measure from" );
        JLabel trioTitle4 = new JLabel( "the first column, a random measure from the second column, etc." );
        trioStuff.add( trioTitle1 );
        trioStuff.add( trioTitle2 );
        trioStuff.add( trioTitle3 );
        trioStuff.add( trioTitle4 );
        trioStuff.add( Box.createVerticalStrut( 3 ) );

        Box trioBox = new Box( BoxLayout.Y_AXIS );
        // inv: rows 0..r-1 of the trio labels have been added to trioBox */
        for ( int r = 0; r != trio.length; r = r + 1 )
        {
            Box b = new Box( BoxLayout.X_AXIS );
            b.add( Box.createHorizontalStrut( 5 ) );

            // inv: cols 0..c-1 of row r of the trio labels have been added to
            // trioBox */
            for ( int c = 0; c != trio[r].length; c = c + 1 )
            {
                MNumber label = new MNumber( r, c, trio[r][c], true );
                b.add( label );
                label.addMouseListener( listener );
            }
            trioBox.add( b );
        }

        trioStuff.add( trioBox );
        trioStuff.add( Box.createVerticalStrut( 10 ) );

        trioStuff.setBorder( new LineBorder( Color.red, 2, true ) );

        return trioStuff;
    }

    /**
     * Fix the minuet box and return it. The labels have field listener as their
     * mouse listener
     */
    public Box makeMinuet()
    {
        Box minuetStuff = new Box( BoxLayout.Y_AXIS );
        JLabel minuetTitle1 = new JLabel( "Below, each integer represents a minuet measure." );
        JLabel minuetTitle2 = new JLabel( "Click one to listen to it." );
        JLabel minuetTitle3 = new JLabel( "A random 16-measure minuet is made from a random measure from" );
        JLabel minuetTitle4 = new JLabel( "the first column, a random measure from the second column, etc." );
        minuetStuff.add( minuetTitle1 );
        minuetStuff.add( minuetTitle2 );
        minuetStuff.add( minuetTitle3 );
        minuetStuff.add( minuetTitle4 );
        minuetStuff.add( Box.createVerticalStrut( 3 ) );

        Box minuetBox = new Box( BoxLayout.Y_AXIS );
        // inv: rows 0..r-1 of the trio labels have been added to trioBox
        for ( int r = 0; r != minuet.length; r = r + 1 )
        {
            Box b = new Box( BoxLayout.X_AXIS );
            b.add( Box.createHorizontalStrut( 5 ) );

            // inv: row r, cols 0..c-1 have been added to trioBox
            for ( int c = 0; c != minuet[r].length; c = c + 1 )
            {
                MNumber label = new MNumber( r, c, minuet[r][c], false );
                b.add( label );
                label.addMouseListener( listener );
            }
            minuetBox.add( b );
        }

        minuetStuff.add( minuetBox );
        minuetStuff.add( Box.createVerticalStrut( 10 ) );

        minuetStuff.setBorder( new LineBorder( Color.blue, 2, true ) );

        return minuetStuff;
    }

    /** An inner class that processes mouse events */
    public class MouseEvents extends MouseInputAdapter
    {
        public void mouseClicked( MouseEvent e )
        {
            Object ob = e.getSource();
            if ( ob instanceof MNumber )
            {
                MNumber mob = (MNumber)ob;
                System.out.println( "Clicked on label " + mob );
                WurfelSpiel.playMeasure( mob );
            }
        }
    }

    /** An instance responds to mouse clicks on the four buttons */
    public class ButtonListener implements ActionListener
    {

        /** Process a click on of the buttons button1--button 6. */
        public void actionPerformed( ActionEvent e )
        {
            Object ob = e.getSource();
            if ( ob == button1 )
            {
                create0();
                return;
            }
            if ( ob == button2 )
            {
                createRandom();
                return;
            }
            if ( ob == button3 )
            {
                compress();
                return;
            }
            if ( ob == button4 )
            {
                printLastWaltz();
                return;
            }

            if ( ob == button5 )
            {
                playLastWaltz();
                return;
            }

            if ( ob == button6 )
            {
                saveLastWaltz();
                return;
            }
        }
    }

    /**
     * Create an array that contains the files from row 0 of the minuet and trio
     * and save it in field lastWaltzS.
     */
    public void create0()
    {
        lastWaltzS = WurfelSpiel.create0Spiel();
        System.out.println( "Waltz created from first row." );
        lastWaltzD = null;
    }

    /** Create an array that contains a random waltz and store it in lastWaltzS. */
    public void createRandom()
    {
        lastWaltzS = WurfelSpiel.createRandomSpiel();
        lastWaltzD = null;
        System.out.println( "Random waltz created." );
    }

    /**
     * Put the last waltz (if there is one) into a single file. If there is no
     * waltz, print a message.
     */
    public void compress()
    {
        if ( lastWaltzS == null )
        {
            System.out.println( "No waltz yet." );
            return;
        }
        if ( lastWaltzD != null )
        {
            System.out.println( "Waltz already compressed." );
            return;
        }
        lastWaltzD = WurfelSpiel.build( lastWaltzS );
        System.out.println( "Compressed waltz constructed." );

    }

    /**
     * If a waltz has been generated, print it; otherwise print the message
     * "No waltz yet."
     */
    public void printLastWaltz()
    {
        if ( lastWaltzS == null )
        {
            System.out.println( "No waltz yet." );
        }
        else
        {
            System.out.println( WurfelSpiel.toString( lastWaltzS ) );
        }
    }

    /**
     * If a waltz has been generated, play it. Print a message indicating action
     * taken. Thus: if lastWaltzD is not null, play it; otherwise, if play
     * lastWaltzS is not null, play it.
     */
    public void playLastWaltz()
    {
        if ( lastWaltzS == null )
        {
            System.out.println( "No waltz yet." );
            return;
        }
        // There is a waltz to play
        if ( lastWaltzD == null )
        {
            System.out.println( "Playing individual measures." );
            WurfelSpiel.play( lastWaltzS );
        }
        else
        {
            System.out.println( "Playing single file." );
            WurfelSpiel.play( lastWaltzD );
        }
    }

    /**
     * If a waltz has been compressed, save it; otherwise print the message
     * "No waltz yet."
     */
    public void saveLastWaltz()
    {
        if ( lastWaltzD == null )
        {
            System.out.println( "Waltz not compressed." );
        }
        else
        {
            StdAudio.save( lastWaltzD, "compressedWaltz.wav" );
        }
    }

    /**
     * An inner class for a JPanel that contains an image
     */
    private class PanelImage extends JPanel
    {
        private Image img;

        /** Constructor: a JPanel with image im */
        public PanelImage( Image img )
        {
            this.img = img;
            setSize( 50, 150 );
            setPreferredSize( new Dimension( 50, 150 ) );
        }

        /** Paint the image in this JPanel */
        public void paint( Graphics g )
        {
            if ( img != null )
            {
                g.drawImage( img, 0, 0, getWidth(), getHeight(), this );
            }
        }
    }
    
    public static void main (String[] args)
    {
        WurfelGUI x = new WurfelGUI();
    }
}